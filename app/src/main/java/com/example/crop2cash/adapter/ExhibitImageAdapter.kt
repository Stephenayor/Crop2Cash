package com.example.crop2cash.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crop2cash.R
import com.example.crop2cash.model.Exhibit

class ExhibitImageAdapter(private val exhibitList: List<Exhibit>) :
    RecyclerView.Adapter<ExhibitImageAdapter.ExhibitsImageViewHolder>(){
//    var exhibitsList: List<Exhibit?> = listOf<Exhibit>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitsImageViewHolder {
        return ExhibitsImageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.exhibits_child_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExhibitsImageViewHolder, position: Int) {
        val exhibit = exhibitList[position]
        Glide.with(holder.exhibitImages.context)
            .load(exhibit?.images)
            .into(holder.exhibitImages)
    }

    override fun getItemCount(): Int {
        return exhibitList.size
    }

    class ExhibitsImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exhibitImages = itemView.findViewById<ImageView>(R.id.exhibit_child_imageView)!!
    }
}