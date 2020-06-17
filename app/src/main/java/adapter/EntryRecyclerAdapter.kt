package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.twitchapp.R
import kotlinx.android.synthetic.main.entry_recycler_item.view.*
import room.Entry

class EntryRecyclerAdapter(
    private val entries: ArrayList<Entry>,
    val callback: Callback,
    val context: Context
) :
    Adapter<EntryRecyclerAdapter.EntryHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntryHolder {
        return EntryHolder(
            LayoutInflater.from(context).inflate(R.layout.entry_recycler_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    override fun onBindViewHolder(holder: EntryHolder, position: Int) {
        holder.bind(entries[position])
    }

    inner class EntryHolder(itemView: View) : ViewHolder(itemView) {

        private val titleTv = itemView.titleTv
        private val descriptionTv = itemView.descriptionTv

        fun bind(entry: Entry) {
            titleTv.text = entry.title
            descriptionTv.text = entry.description
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    callback.onItemClicked(entries[adapterPosition])
            }
        }
    }

    interface Callback {
        fun onItemClicked(entry: Entry)
    }
}