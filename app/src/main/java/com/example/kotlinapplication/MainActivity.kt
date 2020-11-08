package com.example.kotlinapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapplication.adapter.MoviesAdapter
import com.example.kotlinapplication.model.MovieResponse
import com.example.kotlinapplication.model.Movies
import com.example.kotlinapplication.rest.APIClient
import com.example.kotlinapplication.rest.ApiInterface
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val TAG: String = MainActivity::class.java.simpleName
    val API_KEY: String = "ec44357d71b936de6ee7f5aa7837b6a4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        val progressBar = findViewById(R.id.progressBar) as ProgressBar
        val floatingActionButton = findViewById(R.id.floatingActionButton) as FloatingActionButton
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        if (API_KEY.isEmpty()) {
            toast("Please obtain your API KEY first from www.themoviedb.org")
            return
        }

        progressBar.visibility = View.VISIBLE
        var apiServices = APIClient.client?.create(ApiInterface::class.java)
        val call = apiServices?.getTopRatedMovies(API_KEY)
        call?.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                progressBar.visibility = View.GONE
                var list: List<Movies>? = response.body()?.results
                recyclerView.adapter = list?.let { MoviesAdapter(this@MainActivity, it) }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                progressBar.visibility = View.GONE
                Log.e(TAG, t.toString())
            }
        })


        floatingActionButton.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, TabActivity2::class.java))
        })

    }
}