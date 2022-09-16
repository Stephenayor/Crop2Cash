package com.example.crop2cash.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crop2cash.R
import com.example.crop2cash.model.Exhibit

class ExhibitsTitleAdapter :
    RecyclerView.Adapter<ExhibitsTitleAdapter.ExhibitsTitleViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()
    var exhibitsList: List<Exhibit> = listOf<Exhibit>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitsTitleViewHolder {
        return ExhibitsTitleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.exhibits_parent_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExhibitsTitleViewHolder, position: Int) {
        val exhibit = exhibitsList[position]
        holder.exhibitTitle.text = exhibit?.title
        val childLayoutManager =
            LinearLayoutManager(
                holder.exhibitsImageRecylerView.context,
                RecyclerView.HORIZONTAL,
                false
            )
        childLayoutManager.initialPrefetchItemCount = 3
        holder.exhibitsImageRecylerView.layoutManager = childLayoutManager
        holder.exhibitsImageRecylerView.adapter = ExhibitImageAdapter(exhibitsList[position].images)
        holder.exhibitsImageRecylerView.setRecycledViewPool(viewPool)
    }

    override fun getItemCount(): Int {
        return exhibitsList.size
    }


    class ExhibitsTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exhibitTitle = itemView.findViewById<TextView>(R.id.exhibits_title)!!
        val exhibitsImageRecylerView: RecyclerView =
            itemView.findViewById<RecyclerView>(R.id.rv_exhibit_images)
    }

}