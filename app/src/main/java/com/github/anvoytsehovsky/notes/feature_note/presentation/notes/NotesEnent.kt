package com.github.anvoytsehovsky.notes.feature_note.presentation.notes

import com.github.anvoytsehovsky.notes.feature_note.domain.model.Note
import com.github.anvoytsehovsky.notes.feature_note.domain.util.NoteOrder

sealed class NotesEnent {
    data class Order(val noteOrder: NoteOrder) : NotesEnent()
    data class DeleteNote(val note: Note): NotesEnent()
    object RestoreNote: NotesEnent()
    object ToggleOrderSection: NotesEnent()
}
