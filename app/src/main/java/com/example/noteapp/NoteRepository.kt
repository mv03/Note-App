package com.example.noteapp

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes:LiveData<List<note>> =noteDao.getAllNotes()

    suspend fun insert(note: note){
        noteDao.insert(note)
    }
    suspend fun delete(note: note){
        noteDao.delete(note)
    }
}