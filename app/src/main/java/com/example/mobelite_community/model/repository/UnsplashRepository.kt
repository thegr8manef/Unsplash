package com.example.mobelite_community.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mobelite_community.model.entity.Photo
import com.example.mobelite_community.model.entity.UnsplashResponse
import com.example.mobelite_community.model.repository.remote.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UnsplashRepository {


    fun getData(search : String) : LiveData<List<Photo>>{
        var sort : String = "popular"
        var mutableLiveData = MutableLiveData<List<Photo>> ()

        val getPost = Retrofit.api.getAllData(1,30,sort,search)

        getPost?.clone()?.enqueue(object :  Callback<UnsplashResponse> {

            override fun onResponse(

                call: Call<UnsplashResponse>,
                response: Response<UnsplashResponse>
            ) {
                Log.println(Log.ASSERT, "", response.message())
                if (response.isSuccessful){

                    mutableLiveData.value = response.body()?.results
//                   response.body()?.results?.forEach{
//                       Log.println(Log.ASSERT, "", it.toString())
//                   }
                }
            }

            override fun onFailure(call: Call<UnsplashResponse> , t: Throwable) {
                Log.println(Log.ASSERT, "", t.message.toString())

            }



        })

        return mutableLiveData
    }


}