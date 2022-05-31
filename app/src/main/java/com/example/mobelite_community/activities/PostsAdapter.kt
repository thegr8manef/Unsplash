package com.example.mobelite_community.activities

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mobelite_community.R
import com.example.mobelite_community.model.entity.Photo
import kotlin.random.Random
import com.bumptech.glide.Glide


class PostsAdapter(var context: Context,var photos: List<Photo>):
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    inner class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindView(photo: Photo){

         //   itemView.findViewById<ImageView>(R.id.image_grid).setImageResource(photo)
            itemView.findViewById<TextView>(R.id.item_name).text = photo.user.name
            itemView.findViewById<TextView>(R.id.item_decr).text = photo.user.username
            itemView.findViewById<ConstraintLayout>(R.id.grid_parent).layoutParams.height = Random.nextInt(300,1000)
            Glide.with(context /* context */)
                    .load(photo.url.regular)
                    .into(itemView.findViewById<ImageView>(R.id.image_grid))
            itemView.setOnClickListener {
                val intent = Intent(context, DetailScreen::class.java).apply {
                    putExtra("name",photo.user.name)
                    putExtra("username",photo.user.username)
                    putExtra("photo",photo.url.regular)
                    putExtra("short_desc",photo.description)
                    putExtra("long_desc",photo.alt_description)
                    putExtra("date_create",photo.created_at)
                    putExtra("date_update",photo.updated_at)
                    putExtra("photo_user",photo.user.profileImage.large)
                }
                context.startActivity(intent)
            }

        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(photos.get(position))
    }

    override fun getItemCount(): Int {
        return photos.size
    }


}