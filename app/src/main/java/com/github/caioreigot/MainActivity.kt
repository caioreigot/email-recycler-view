package com.github.caioreigot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.caioreigot.model.fakeEmails

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewMain = findViewById(R.id.recycler_view_main)

        recyclerViewMain.adapter = EmailAdapter(fakeEmails())
        recyclerViewMain.layoutManager = LinearLayoutManager(this)
    }

}