package com.vama.hidoc

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Example {
    @SerializedName("success")
    @Expose
    var success: Int? = null
    @SerializedName("resultarray")
    @Expose
    var resultarray: List<Resultarray>? = null

    override fun toString(): String {
        return "Example{" +
                "success=" + success +
                ", resultarray=" + resultarray +
                '}'.toString()
    }
}
