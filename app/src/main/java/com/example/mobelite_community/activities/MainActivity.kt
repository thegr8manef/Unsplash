package com.example.mobelite_community.activities

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.ScrollView
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mobelite_community.*
import com.example.mobelite_community.databinding.ActivityMainBinding
import com.example.mobelite_community.model.entity.Photo
import com.example.mobelite_community.model.entity.Post
import com.example.mobelite_community.view_model.PhotoVM


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var photos : ArrayList<Photo>
    private lateinit var photoVM : PhotoVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view : NestedScrollView? = binding.root
        setContentView(view)

        photoVM = PhotoVM()
        photos = ArrayList()

        search("tunisie")
        binding.email.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                search(binding.email.text.toString())
            }
            false
        })

    }

    private fun search(search : String){
        photoVM.getData(search).observe(this, Observer {
            photos.addAll(it)

            val adapterPost = PostsAdapter(this, it)
            binding.images.setHasFixedSize(true)
            binding.images.itemAnimator = null
            binding.images.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            //  binding.images.setLayoutManager(GridLayoutManager(this, 2))

            binding.images.adapter = adapterPost

            val adapterStory = StoriesAdapter(this,it )
            binding.stories.layoutManager = LinearLayoutManager(this)
            binding.stories.setLayoutManager(
                LinearLayoutManager(
                    this,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            )

            binding.stories.adapter = adapterStory
        })
    }
}