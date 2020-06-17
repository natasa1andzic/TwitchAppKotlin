package com.example.twitchapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_new_entry.*
import kotlinx.android.synthetic.main.toolbar.*


class AddNewEntryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_entry)

        setSupportActionBar(toolbar)

        saveBtn.setOnClickListener {
            val intent = Intent(this, EntriesActivity::class.java)

            val bundle = Bundle()
            bundle.putString("title", titleEt.text.toString())
            bundle.putString("description", descriptionEt.text.toString())
            intent.putExtras(bundle)

            startActivity(intent)
        }


    }
}