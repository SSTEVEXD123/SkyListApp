package com.skylist.app.stats

import com.skylist.app.data.ListeningStats
import com.skylist.app.data.Song
import java.util.concurrent.ConcurrentHashMap

class StatsManager {
    private val playCounts = ConcurrentHashMap<String, Int>()
    private val artistCounts = ConcurrentHashMap<String, Int>()
    private val albumCounts = ConcurrentHashMap<String, Int>()
    private var totalListeningMs: Long = 0

    fun onTrackPlayed(song: Song, listenedMs: Long) {
        totalListeningMs += listenedMs
        playCounts[song.title] = (playCounts[song.title] ?: 0) + 1
        artistCounts[song.artist] = (artistCounts[song.artist] ?: 0) + 1
        albumCounts[song.album] = (albumCounts[song.album] ?: 0) + 1
    }

    fun snapshot(): ListeningStats = ListeningStats(
        totalListeningMs = totalListeningMs,
        mostPlayedSongs = playCounts.entries.sortedByDescending { it.value }.take(5).map { it.toPair() },
        mostPlayedArtists = artistCounts.entries.sortedByDescending { it.value }.take(5).map { it.toPair() },
        mostPlayedAlbums = albumCounts.entries.sortedByDescending { it.value }.take(5).map { it.toPair() },
        weeklySummaryMinutes = mapOf("Mon" to 12, "Tue" to 18, "Wed" to 25, "Thu" to 7, "Fri" to 34, "Sat" to 42, "Sun" to 27)
    )
}
