package com.github.anvoytsehovsky.notes.di

import android.app.Application
import androidx.room.Room
import com.github.anvoytsehovsky.notes.feature_note.data.data_source.NoteDatabase
import com.github.anvoytsehovsky.notes.feature_note.data.repository.NoteRepositoryImpl
import com.github.anvoytsehovsky.notes.feature_note.domain.repository.NoteRepository
import com.github.anvoytsehovsky.notes.feature_note.domain.use_case.AddNoteUseCase
import com.github.anvoytsehovsky.notes.feature_note.domain.use_case.DeleteNoteUseCase
import com.github.anvoytsehovsky.notes.feature_note.domain.use_case.GetNotesUseCase
import com.github.anvoytsehovsky.notes.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providerNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providerNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            addNote = AddNoteUseCase(repository)
        )
    }
}