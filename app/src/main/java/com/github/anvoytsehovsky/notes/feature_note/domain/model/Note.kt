package com.github.anvoytsehovsky.notes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.anvoytsehovsky.notes.ui.theme.*

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColor = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)