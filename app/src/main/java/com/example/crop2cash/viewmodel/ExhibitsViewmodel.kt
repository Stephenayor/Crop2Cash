package com.example.crop2cash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.crop2cash.base.BaseFragment
import com.example.crop2cash.base.BaseViewModel
import com.example.crop2cash.di.DaggerRealExhibitsComponent
import com.example.crop2cash.model.Exhibit
import com.example.crop2cash.repository.ExhibitsRepository
import javax.inject.Inject

class ExhibitsViewmodel @Inject constructor() : BaseViewModel() {
    @Inject
    lateinit var exhibitsRepository: ExhibitsRepository


    fun getExhibitsList(): LiveData<List<Exhibit>?>? {
        return exhibitsRepository.getExhibitsList()
    }

    fun getSlowNetworkErrorMessage(): LiveData<Boolean>{
        return exhibitsRepository.getSlowNetworkErrorMessage()
    }
}