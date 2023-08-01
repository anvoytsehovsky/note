package com.github.anvoytsehovsky.notes.feature_note.presentation.notes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun NoteScreen(
    navController: NavController,
    viewModel: NotesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
//    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
}