package com.skylist.app.sync

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.UUID

data class PlaybackSyncEvent(
    val type: String = "",
    val positionMs: Long = 0L,
    val trackUri: String = "",
    val timestamp: Long = System.currentTimeMillis()
)

class ListenTogetherManager(
    private val db: DatabaseReference = FirebaseDatabase.getInstance().reference.child("rooms")
) {
    fun createRoom(hostId: String): String {
        val code = UUID.randomUUID().toString().take(6).uppercase()
        db.child(code).child("host").setValue(hostId)
        return code
    }

    fun joinRoom(code: String, userId: String) {
        db.child(code).child("members").child(userId).setValue(true)
    }

    fun syncEvent(code: String, event: PlaybackSyncEvent) {
        db.child(code).child("events").push().setValue(event)
    }
}
