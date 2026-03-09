package com.skylist.app.data

data class Song(
    val id: Long,
    val title: String,
    val artist: String,
    val album: String,
    val uri: String,
    val durationMs: Long,
    val artUri: String? = null
)

data class LyricLine(val timestampMs: Long, val text: String)

data class ListeningRoom(val roomCode: String, val hostId: String)

data class ListeningStats(
    val totalListeningMs: Long,
    val mostPlayedSongs: List<Pair<String, Int>>,
    val mostPlayedArtists: List<Pair<String, Int>>,
    val mostPlayedAlbums: List<Pair<String, Int>>,
    val weeklySummaryMinutes: Map<String, Int>
)
