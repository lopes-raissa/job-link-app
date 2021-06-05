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
import com.example.joblink.api.Calls.FeedCall
import com.example.joblink.api.RetrofitApi
import com.example.joblink.api.SessionManager
import com.example.joblink.model.PublicationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var adapterPublication: PublicationAdapter
    lateinit var rvPublcation: RecyclerView
    lateinit var sessionManager: SessionManager

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

        loadFeed()

    }

    private fun loadFeed() {

        rvPublcation = recycleViewPublcation
        adapterPublication = PublicationAdapter(activity)
        rvPublcation.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvPublcation.adapter = adapterPublication
        sessionManager = SessionManager(activity)

        var feeds: List<PublicationModel> = emptyList()

        val retrofit = activity?.let { RetrofitApi.getRetrofit(FeedCall::class.java, it) }
        //val feedsCall = retrofit.create(FeedCall::class.java)
        //val call = feedsCall.getPublication()
        val call = retrofit!!.getPublication()

        call.enqueue(object : Callback<List<PublicationModel>> {
            override fun onFailure(call: Call<List<PublicationModel>>, t: Throwable) {
                Log.e("XXXXXXXXXX HOME FRAG ERROR Teste", t.localizedMessage)
                Toast.makeText(activity, "Ops! falha na conexão.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<PublicationModel>>,
                response: Response<List<PublicationModel>>
            ) {
                if (sessionManager.fethAuthToken() != null) {

                    Log.i("Teste", response.code().toString())
                    Log.i(
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX HomeFragment Teste",
                        response.body().toString()
                    )
                    feeds = response.body()!!
                    adapterPublication.updateListPublication(feeds)
                }
            }
        })
    }


}