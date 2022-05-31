package com.example.mobelite_community.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mobelite_community.model.entity.Photo
import com.example.mobelite_community.model.repository.UnsplashRepository

class PhotoVM : ViewModel() {

    val unsplashRepository = UnsplashRepository()

    fun getData(search : String): LiveData<List<Photo>>{
        return unsplashRepository.getData(search)
    }

}