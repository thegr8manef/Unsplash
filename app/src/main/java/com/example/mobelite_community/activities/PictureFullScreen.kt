package com.example.mobelite_community.activities


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobelite_community.R
import com.squareup.picasso.Picasso


class PictureFullScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_full_screen)
        val imageView3 = findViewById<ImageView>(R.id.bt_cancel)
        imageView3.setOnClickListener { finish() }
        val intent = intent

        val username = intent.getStringExtra("username")
        val textusername = findViewById<TextView>(R.id.profile_username)
        textusername.text = username
        val photo = intent.getStringExtra("photo")
        val imageView = findViewById<ImageView>(R.id.full_img)
        Picasso.get().load(photo).fit().into(imageView)
        val photo_user = intent.getStringExtra("photo_user")
        val imageView1 = findViewById<ImageView>(R.id.profile_image)
        Picasso.get().load(photo_user).fit().into(imageView1)

    }
}