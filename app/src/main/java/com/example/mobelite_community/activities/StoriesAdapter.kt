package com.example.mobelite_community.activities

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobelite_community.R
import com.example.mobelite_community.model.entity.Photo


class StoriesAdapter(val context: Context, val posts: List<Photo>):
    RecyclerView.Adapter<StoriesAdapter.ViewHolder>() {

    inner class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindView(data: Photo){

                Glide.with(context /* context */)
                    .load(data.user.profileImage.large)
                    .into(itemView.findViewById<ImageView>(R.id.user_image))

            Glide.with(context /* context */)
                .load(data.url.regular)
                .into(itemView.findViewById<ImageView>(R.id.story))


            itemView.findViewById<TextView>(R.id.username).text = data.user.name

            itemView.setOnClickListener {
                val intent = Intent(context, PictureFullScreen::class.java).apply {
                    putExtra("name",data.user.name)
                    putExtra("username",data.user.username)
                    putExtra("photo",data.url.regular)
                    putExtra("photo_user",data.user.profileImage.large)
                }
                context.startActivity(intent)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.post_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(posts.get(position))
    }

    override fun getItemCount(): Int {
        return posts.size
    }


}