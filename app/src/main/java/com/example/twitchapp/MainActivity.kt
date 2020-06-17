package com.example.twitchapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import room.AppDatabase
import room.Entry
import room.EntryDAO


class MainActivity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var entryDAO: EntryDAO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        addBtn.setOnClickListener {
            val intent = Intent(this, AddNewEntryActivity::class.java)
            startActivity(intent)
        }

        Observable.fromCallable {
            db = AppDatabase.getAppDataBase(context = this)
            entryDAO = db?.entryDAO()

            val entry1 = Entry(title="Day 1", description = "I have successfully infiltrated into...", imagePath = null)
            val entry2 = Entry(title="Day 2", description = "They have discovered who I really am...", imagePath = null)


            with(entryDAO){
                this?.insert(entry1)
                this?.insert(entry2)
            }
            db?.entryDAO()?.getAll()
        }.doOnNext { list ->
            var title = ""
            var description=""
            list?.map { title+= it.title+" - " }
            list?.map { description+= it.description+" - " }
            titleTv.text = title
            descriptionTv.text = description

        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

}