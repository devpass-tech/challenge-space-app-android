package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Payloads(@SerializedName("composite_fairing")
                    val compositeFairing: CompositeFairing,
                    @SerializedName("option_1")
                    val option: String = "")