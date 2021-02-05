package com.example.myjsonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondActivityActivity : AppCompatActivity() {
    private var txtResult : TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtResult = findViewById(R.id.Resultxt)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://zjwkq.mocklab.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val jsonAPI: JsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        val call: Call<Todo> = jsonAPI.todo
        call.enqueue(object : Callback<Todo> {
            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                if (response.isSuccessful){
                    txtResult?.text = response.body()?.title
                    return
                }
//                txtResult?.text = "Not Successful"
            }

            override fun onFailure(call: Call<Todo>, t: Throwable) {
                txtResult?.text = ("""Failure """ + t.message)
                Log.d("abc",t.message.toString())
            }

        })
    }
}