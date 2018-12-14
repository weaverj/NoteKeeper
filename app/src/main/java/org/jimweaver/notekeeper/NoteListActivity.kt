package org.jimweaver.notekeeper

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.*

import kotlinx.android.synthetic.main.activity_note_list.*
import kotlinx.android.synthetic.main.content_note_list.*

// test comit

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(toolbar)
        initializeDisplayContent()

        fab.setOnClickListener {
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }

//        listNotes.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataManager.notes)
//
//        listNotes.setOnItemClickListener{parent, view, position, id ->
//            val activityIntent = Intent(this, MainActivity::class.java)
//            activityIntent.putExtra(NOTE_POSITION, position)
//            startActivity(activityIntent)
//
     }

    private fun initializeDisplayContent() {
        val recyclerNotes : RecyclerView = findViewById(R.id.list_notes)
        val notesLayoutManager : LinearLayoutManager = LinearLayoutManager(this)
        recyclerNotes.layoutManager = notesLayoutManager
    }

//    override fun onResume() {
//        super.onResume()
//        (listNotes.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
//    }



}
