package com.example.jetpackcomposepokedex.data.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphaSapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y")
    val xy: XY
)