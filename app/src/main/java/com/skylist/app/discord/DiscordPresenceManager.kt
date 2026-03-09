package com.skylist.app.discord

import com.skylist.app.data.Song

class DiscordPresenceManager {
    private var active: Boolean = false

    fun updatePresence(song: Song, progressMs: Long) {
        // Placeholder implementation. Android Discord RPC requires bridge/service integration.
        active = true
        val _presence = "Listening on SkyList: ${song.title} - ${song.artist} @ $progressMs"
    }

    fun clearPresence() {
        active = false
    }

    fun isActive(): Boolean = active
}
