package com.example.crop2cash.base

import androidx.fragment.app.Fragment
import com.example.crop2cash.di.DaggerRealExhibitsComponent
import com.example.crop2cash.di.RealExhibitsComponent

abstract class BaseFragment : Fragment() {

    protected  val exhibitsComponent: RealExhibitsComponent
        get() = DaggerRealExhibitsComponent.create()
}