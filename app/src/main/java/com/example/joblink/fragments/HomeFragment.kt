package com.example.joblink.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.joblink.R
import com.example.joblink.adapter.PublicationAdapter
import com.example.joblink.api.PublicationCall
import com.example.joblink.api.RetrofitApi
import com.example.joblink.model.PublicationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var adapterPublication: PublicationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setListPublication()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapterPublication = PublicationAdapter(activity)

        startRecycleView()
    }

        private fun startRecycleView() {
        recycleViewPublcation.layoutManager = LinearLayoutManager(activity)
        }

    private fun setListPublication() {

        var publicationModel: List<PublicationModel> = listOf<PublicationModel>()

        var retrofit = RetrofitApi.getRetrofit()
        val PublicationCall = retrofit.create(PublicationCall::class.java)

        val call = PublicationCall.getPublication()

        call.enqueue(object : Callback<List<PublicationModel>> {

            override fun onFailure(call: Call<List<PublicationModel>>, t: Throwable) {
                Toast.makeText(activity, "Ops!! falha na conexão :(", Toast.LENGTH_SHORT).show()
                Log.e("ERROR_CONEX", t.message.toString())
            }

            override fun onResponse(call: Call<List<PublicationModel>>, response: Response<List<PublicationModel>>) {
                publicationModel = response.body()!!
                adapterPublication.updateListPublication(publicationModel)
            }
        })
    }
}