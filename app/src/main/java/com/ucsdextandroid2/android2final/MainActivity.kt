package com.ucsdextandroid2.android2final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        DataSources.getInstance().getParks(object : DataSources.Callback<List<Park>> {
            override fun onDataFetched(data: List<Park>?) {
                Log.d("test", "Parks: " + data?.size)
                Log.d("name", data?.get(0)?.id)
                Log.d("image", data?.get(0)?.images?.get(0)?.url)
            }

        })

    }


}
