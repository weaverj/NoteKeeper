package org.jimweaver.notekeeper

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    var adapter : NoteRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

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
        recyclerNotes.layoutManager = LinearLayoutManager(this)
        adapter =  NoteRecyclerAdapter(this, DataManager.notes)
        recyclerNotes.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
    }



}
