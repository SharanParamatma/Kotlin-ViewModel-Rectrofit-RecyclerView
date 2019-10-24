package com.vama.hidoc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataViewModel : ViewModel() {

    private val mutableLiveData = MutableLiveData<Example>()
    val text: LiveData<Example>
        get() {
            val retrofitN = Retrofit.Builder().baseUrl(ServiceParama.Base_URl).addConverterFactory(GsonConverterFactory.create()).build()
            val serviceCall = retrofitN.create<ServiceParama>(ServiceParama::class.java)
            val callN = serviceCall.getFeed("2946", 0)
            callN.enqueue(object : Callback<Example> {
                override fun onResponse(call: Call<Example>, response: retrofit2.Response<Example>) {
                    mutableLiveData.setValue(response.body())
                    Log.e("Failure", "" + mutableLiveData.toString())
                }

                override fun onFailure(call: Call<Example>, t: Throwable) {
                    Log.e("Failure", "" + t.message)
                }

            })

            return mutableLiveData
        }


}
