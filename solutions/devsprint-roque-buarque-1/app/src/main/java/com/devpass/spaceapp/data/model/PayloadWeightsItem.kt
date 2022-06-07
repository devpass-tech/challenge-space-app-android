package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class PayloadWeightsItem(@SerializedName("lb")
                              val lb: Int = 0,
                              @SerializedName("name")
                              val name: String = "",
                              @SerializedName("id")
                              val id: String = "",
                              @SerializedName("kg")
                              val kg: Int = 0)