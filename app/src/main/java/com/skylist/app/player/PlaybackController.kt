package com.skylist.app.player

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import com.google.common.util.concurrent.MoreExecutors
import com.skylist.app.data.Song

class PlaybackController(context: Context) {
    private var controller: MediaController? = null

    init {
        val token = SessionToken(context, android.content.ComponentName(context, SkyListPlaybackService::class.java))
        MediaController.Builder(context, token).buildAsync().addListener({
            controller = MediaController.Builder(context, token).buildAsync().get()
        }, MoreExecutors.directExecutor())
    }

    fun setQueue(songs: List<Song>, startIndex: Int = 0) {
        controller?.setMediaItems(songs.map { MediaItem.fromUri(it.uri) }, startIndex, 0L)
        controller?.prepare()
    }

    fun play() = controller?.play()
    fun pause() = controller?.pause()
    fun seekTo(positionMs: Long) = controller?.seekTo(positionMs)
    fun skipNext() = controller?.seekToNext()
    fun skipPrevious() = controller?.seekToPrevious()
    fun setShuffle(enabled: Boolean) = controller?.setShuffleModeEnabled(enabled)
    fun cycleRepeatMode() {
        val next = when (controller?.repeatMode) {
            Player.REPEAT_MODE_OFF -> Player.REPEAT_MODE_ALL
            Player.REPEAT_MODE_ALL -> Player.REPEAT_MODE_ONE
            else -> Player.REPEAT_MODE_OFF
        }
        controller?.repeatMode = next
    }
}
