package hossein.gheisary.recycleview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hossein.gheisary.recycleview.R
import hossein.gheisary.recycleview.model.ListItem
import kotlinx.android.synthetic.main.my_item_view.view.*

class ItemArrayAdapter: ListAdapter<ListItem, RecyclerView.ViewHolder>(ListItemCallback()) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ListenItemViewHolder).bind(item, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_item_view, parent, false)
        return ListenItemViewHolder(view)
    }

    inner class ListenItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvContent: TextView = itemView.tv_content

        fun bind(listItem : ListItem, position : Int) {
            tvContent.text = listItem.text
        }
    }

    class ListItemCallback : DiffUtil.ItemCallback<ListItem>() {
        override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem.text == newItem.text && oldItem.clicks == newItem.clicks
        }
    }
}