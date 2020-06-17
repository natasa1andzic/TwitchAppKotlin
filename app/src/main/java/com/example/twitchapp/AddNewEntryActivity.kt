package com.example.twitchapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_new_entry.*
import kotlinx.android.synthetic.main.toolbar.*
import room.AppDatabase
import room.Entry
import room.EntryDAO


class AddNewEntryActivity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var entryDAO: EntryDAO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_entry)

        setSupportActionBar(toolbar)

        saveBtn.setOnClickListener {
            val intent = Intent(this, EntriesActivity::class.java)

//            val bundle = Bundle()
//            bundle.putString("title", titleEt.text.toString())
//            bundle.putString("description", descriptionEt.text.toString())
//            intent.putExtras(bundle)

            val title = titleEt.text.toString()
            val description = descriptionEt.text.toString()
            val newEntry = Entry(title, description, null)

            Observable.fromCallable {
                db = AppDatabase.getAppDataBase(context = this)
                entryDAO = db?.entryDAO()

                with(entryDAO) {
                    this?.insert(newEntry)
                }

                db?.entryDAO()?.getAll()
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        }
        startActivity(intent)
    }
}
