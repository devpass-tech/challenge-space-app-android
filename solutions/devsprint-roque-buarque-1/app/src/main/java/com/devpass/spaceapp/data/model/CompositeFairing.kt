package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class CompositeFairing(@SerializedName("diameter")
                            val diameter: Diameter,
                            @SerializedName("height")
                            val height: Height)