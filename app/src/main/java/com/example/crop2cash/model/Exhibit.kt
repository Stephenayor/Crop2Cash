package com.example.crop2cash.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class Exhibit(
    @SerializedName("title"  ) var title  : String?           = null,
    @SerializedName("images" ) var images : ArrayList<String> = ArrayList()
)
