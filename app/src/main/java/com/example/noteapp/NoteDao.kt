package com.example.noteapp

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note:note)

    @Delete
    fun delete(note: note)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<note>>
}