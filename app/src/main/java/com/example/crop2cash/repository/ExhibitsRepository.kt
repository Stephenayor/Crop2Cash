package com.example.crop2cash.repository

import androidx.lifecycle.MutableLiveData
import com.example.crop2cash.base.BaseFragment
import com.example.crop2cash.model.Exhibit
import com.example.crop2cash.model.ExhibitsLoader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.UnknownHostException
import javax.inject.Inject

class ExhibitsRepository @Inject constructor() : BaseFragment() {
    private var slowNetworkIssues = MutableLiveData<Boolean>()

    fun getExhibitsList(): MutableLiveData<List<Exhibit>?>? {
        val mutableLiveData: MutableLiveData<List<Exhibit>?> = MutableLiveData<List<Exhibit>?>()

        val exhibitsLoaderApi: ExhibitsLoader? =
            exhibitsComponent.getRetrofitInstance()?.create(ExhibitsLoader::class.java)
        val call: Call<List<Exhibit>>? = exhibitsLoaderApi?.getExhibitList()
        call?.enqueue(object : Callback<List<Exhibit>?> {
            override fun onResponse(
                call: Call<List<Exhibit>?>,
                response: Response<List<Exhibit>?>
            ) {
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<Exhibit>?>, t: Throwable) {
                t.message

                if (t is UnknownHostException) {
                    slowNetworkIssues.value = true
                }
            }
        })

        return mutableLiveData
    }

    fun getSlowNetworkErrorMessage(): MutableLiveData<Boolean> {
        return slowNetworkIssues
    }
}