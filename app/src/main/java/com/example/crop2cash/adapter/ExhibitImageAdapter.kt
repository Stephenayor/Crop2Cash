package com.example.crop2cash.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crop2cash.R

class ExhibitImageAdapter(private val exhibitImageList: List<String>) :
    RecyclerView.Adapter<ExhibitImageAdapter.ExhibitsImageViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitsImageViewHolder {
        return ExhibitsImageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.exhibits_child_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExhibitsImageViewHolder, position: Int) {
        val exhibitImage = exhibitImageList[position]
        Glide.with(holder.exhibitImages.context)
            .load(exhibitImage)
            .error(R.drawable.error_image)
            .placeholder(R.drawable.error_image)
            .into(holder.exhibitImages)
    }

    override fun getItemCount(): Int {
        return exhibitImageList.size
    }

    class ExhibitsImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exhibitImages = itemView.findViewById<ImageView>(R.id.exhibit_child_imageView)!!
    }
}