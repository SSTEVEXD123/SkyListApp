package com.skylist.app.lyrics

import com.skylist.app.data.LyricLine

class LyricsManager {
    fun parseLrc(lrcText: String): List<LyricLine> {
        val regex = Regex("\\[(\\d{2}):(\\d{2})\\.(\\d{2,3})]\\s*(.*)")
        return lrcText.lineSequence().mapNotNull { line ->
            val match = regex.matchEntire(line.trim()) ?: return@mapNotNull null
            val minutes = match.groupValues[1].toLong()
            val seconds = match.groupValues[2].toLong()
            val fraction = match.groupValues[3].padEnd(3, '0').take(3).toLong()
            LyricLine(minutes * 60_000 + seconds * 1_000 + fraction, match.groupValues[4])
        }.sortedBy { it.timestampMs }.toList()
    }

    fun currentLineIndex(positionMs: Long, lines: List<LyricLine>): Int {
        return lines.indexOfLast { it.timestampMs <= positionMs }.coerceAtLeast(0)
    }

    fun manualSearch(query: String, source: Map<String, String>): String? {
        return source.entries.firstOrNull { it.key.contains(query, ignoreCase = true) }?.value
    }
}
