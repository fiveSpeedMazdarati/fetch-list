package com.lukebusch.fetchlist.domain

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lukebusch.fetchlist.R

class ListItemAdapter(private val listOfItems: List<ListDisplayItem>) : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("VIEW_HOLDER", listOfItems.toString())
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfItems[position]
        holder.textView2.text = item.id
        holder.textView1.text = item.name
        holder.textView3.text = item.listId

    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

    // This could be in its own file if the view is more complicated than this
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.findViewById(R.id.text_view_left_tv)
        val textView2: TextView = itemView.findViewById(R.id.text_view_middle_tv)
        val textView3: TextView = itemView.findViewById(R.id.text_view_right_tv)
    }

}