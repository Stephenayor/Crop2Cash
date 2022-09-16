package com.example.crop2cash.base

import androidx.lifecycle.MutableLiveData
import com.example.crop2cash.model.Exhibit

abstract class BaseViewModel : BaseFragment() {

    var mutableLiveData: MutableLiveData<List<Exhibit>?>? = null
}