package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Mass(@SerializedName("lb")
                val lb: Int = 0,
                @SerializedName("kg")
                val kg: Int = 0)