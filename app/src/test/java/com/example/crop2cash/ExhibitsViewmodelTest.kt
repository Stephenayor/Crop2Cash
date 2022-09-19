package com.example.crop2cash

import com.example.crop2cash.di.DaggerRealExhibitsComponent
import junit.framework.Assert.assertTrue
import org.junit.Test

class ExhibitsViewmodelTest {

    @Test
    fun checkExhibitsViewmodelData(){

        val exhibitsComponent = DaggerRealExhibitsComponent.create()

        val exhibitViewmodel = exhibitsComponent.getExhibitsViewModel()

        assertTrue(exhibitViewmodel.getExhibitsList() != null)

    }
}