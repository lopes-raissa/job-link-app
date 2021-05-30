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
import androidx.recyclerview.widget.RecyclerView
import com.example.joblink.R
import com.example.joblink.adapter.PublicationAdapter
import com.example.joblink.api.FeedCall
import com.example.joblink.api.RetrofitApi
import com.example.joblink.model.PublicationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var adapterPublication: PublicationAdapter
    lateinit var rvViewPublcation: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        startRecycleView()

        //Feedlist()
    }

    private fun startRecycleView() {

        rvViewPublcation = recycleViewPublcation
        adapterPublication = PublicationAdapter(activity)
        rvViewPublcation.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvViewPublcation.adapter = adapterPublication
    }

//    private fun Feedlist() {
//
//        var publications: List<PublicationModel> = listOf<PublicationModel>()
//
//        val retrofit = RetrofitApi.getRetrofit()
//        val feedCall = retrofit.create(FeedCall::class.java)
//        val call = feedCall.getPublication()
//
//        call.enqueue(object : Callback<List<PublicationModel>> {
//            override fun onFailure(call: Call<List<PublicationModel>>, t: Throwable) {
//                Toast.makeText(activity, "Ops! falha na conexão.", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(
//                call: Call<List<PublicationModel>>,
//                response: Response<List<PublicationModel>>
//            ) {
//                Log.i("Teste", response.body().toString())
//                publications = response.body()!! //Double BANG!!
//                adapterPublication.updateListPublication(publications)
//            }
//        })
//    }
}