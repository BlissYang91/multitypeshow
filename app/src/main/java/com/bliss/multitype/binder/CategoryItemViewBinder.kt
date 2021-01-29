package com.bliss.multitype.binder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bliss.multitype.app.R
import com.bliss.multitype.data.Category
import com.drakeet.multitype.ItemViewBinder

class CategoryItemViewBinder:ItemViewBinder<Category,CategoryItemViewBinder.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: Category) {
        holder.title.text = item.title
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
       return ViewHolder(inflater.inflate(R.layout.item_category,parent,false))
    }
}