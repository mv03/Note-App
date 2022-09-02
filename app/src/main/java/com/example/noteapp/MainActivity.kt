package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), INoteRVAdapter {

    lateinit var viewModel: NoteViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=NotesRVAdapter(this,this)
        recyclerView.adapter=adapter

        viewModel=ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {List ->
            List?.let{
                adapter.updateList(it)
            }

        })

    }

    override fun onItemClicked(note: note) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"${note.text} Deleted",Toast.LENGTH_LONG).show()
    }

    fun SubmitData(view: View) {
        val notetext=input.text.toString()
        if(notetext.isNotEmpty()){
            viewModel.insertNote(note(notetext))
            Toast.makeText(this,"${notetext} Inserted",Toast.LENGTH_LONG).show()
        }
    }

}