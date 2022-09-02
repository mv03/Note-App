package com.example.noteapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Delete

class NotesRVAdapter(private val context: Context,private val listner:INoteRVAdapter): RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    val allnotes=ArrayList<note>()

    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView=itemView.findViewById<TextView>(R.id.textView)
        var delbtn:ImageView = itemView.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder=NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.delbtn.setOnClickListener{
            listner.onItemClicked(allnotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote=allnotes[position]
        holder.textView.text=currentNote.text
    }

    override fun getItemCount(): Int {
        return allnotes.size
    }
    fun updateList(newList:List<note>){
        allnotes.clear()
        allnotes.addAll(newList)

        notifyDataSetChanged()
    }

}
interface INoteRVAdapter{
    fun onItemClicked(note: note)
}