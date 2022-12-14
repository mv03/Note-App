package com.example.noteapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository:NoteRepository
    val allNotes:LiveData<List<note>>

    init{
       val dao=NoteDatabase.getDatabase(application).getNoteDao()
        repository=NoteRepository(dao)
        allNotes=repository.allNotes
    }
    fun deleteNote(note: note)=viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }
    fun insertNote(note: note)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }



}