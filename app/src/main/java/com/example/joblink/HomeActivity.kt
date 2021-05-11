package com.example.joblink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.joblink.adapter.PublicationAdapter
import com.example.joblink.datasource.Datasource
import com.example.joblink.model.Publication
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        startRecycleView()
    }

    private fun startRecycleView() {
        recycleViewPublcation.layoutManager = LinearLayoutManager(this)
        recycleViewPublcation.adapter = PublicationAdapter(Datasource.getPublications())
    }
}