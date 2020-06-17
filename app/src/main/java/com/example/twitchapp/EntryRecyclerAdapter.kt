package com.example.twitchapp

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import room.Entry

class EntryRecyclerAdapter : Adapter<EntryRecyclerAdapter.EntryHolder>() {


    private lateinit var entries: ArrayList<Entry>


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntryRecyclerAdapter.EntryHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    override fun onBindViewHolder(holder: EntryRecyclerAdapter.EntryHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class EntryHolder(itemView: View) : ViewHolder(itemView), View.OnClickListener {

        private var view: View = itemView
        private var entry: Entry? = null

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            Log.d("Item clicked", "yes yes")
        }

    }
}