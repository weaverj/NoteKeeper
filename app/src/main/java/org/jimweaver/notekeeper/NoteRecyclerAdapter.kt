package org.jimweaver.notekeeper

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NoteRecyclerAdapter(val context: Context, val notes : List<NoteInfo>) : Adapter<NoteRecyclerAdapter.ViewHolder>() {

    private val inflater : LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView : View = inflater.inflate(R.layout.item_note_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note : NoteInfo = notes[position]
        holder.courseTitle.text = note.course?.title
        holder.noteTitle.text = note.title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var courseTitle : TextView = itemView.findViewById(R.id.text_course_title)
        var noteTitle : TextView = itemView.findViewById(R.id.text_note_title)
    }
}