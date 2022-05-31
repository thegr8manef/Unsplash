package com.example.mobelite_community.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobelite_community.R
import com.squareup.picasso.Picasso


class DetailScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)
        val intent = intent
        val username = intent.getStringExtra("username")
        val textusername = findViewById<TextView>(R.id.profile_username)
        textusername.text = username
        val short_desc = intent.getStringExtra("short_desc")
        val textshort_desc = findViewById<TextView>(R.id.tv_small_desc)
        textshort_desc.text = short_desc
        val long_desc = intent.getStringExtra("long_desc")
        val textlong_desc = findViewById<TextView>(R.id.tv_long_desc)
        textlong_desc.text = long_desc
        val date_create = intent.getStringExtra("date_create")
        val textdate_create = findViewById<TextView>(R.id.tv_date_create)
        textdate_create.text = date_create
        val date_update = intent.getStringExtra("date_update")
        val textdate_update = findViewById<TextView>(R.id.tv_date_update)
        textdate_update.text = date_update
        val photo = intent.getStringExtra("photo")
        val imageView = findViewById<ImageView>(R.id.imageView)
        Picasso.get().load(photo).fit().into(imageView)
        val photo_user = intent.getStringExtra("photo_user")
        val imageView1 = findViewById<ImageView>(R.id.profile_image)
        Picasso.get().load(photo_user).fit().into(imageView1)
    }
}




