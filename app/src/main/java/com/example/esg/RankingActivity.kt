package com.example.esg

import ApiService
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TableLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RankingActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService
    private lateinit var listViewRanking: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ranking_activity)

        val tableLayout = findViewById<TableLayout>(R.id.tableLayoutRanking)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://fiap-esg-backend.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)

        getRankingList()
    }

    private fun getRankingList() {
        apiService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val userList = response.body()
                    if (userList != null) {
                        val rankingNames = userList.map { it.name }
                        displayRanking(rankingNames)
                    }
                } else {
                    Toast.makeText(this@RankingActivity, "Erro ao obter lista de classificação", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@RankingActivity, "Erro de conexão", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun displayRanking(rankingNames: List<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, rankingNames)
        listViewRanking.adapter = adapter
    }
}
