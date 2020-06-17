package com.example.twitchapp

import adapter.EntryRecyclerAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_entries.*
import room.AppDatabase
import room.Entry
import room.EntryDAO


class EntriesActivity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var entryDAO: EntryDAO? = null

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: EntryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entries)

        db = AppDatabase.getAppDataBase(context = this)
        entryDAO = db?.entryDAO()

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        // adapter = EntryRecyclerAdapter()
        recyclerView.adapter = adapter


    }


    private fun getEntriesFromDB(): LiveData<List<Entry>> {

        return entryDAO!!.getAll()
    }


}