package com.stefanini.cat.network.parser

data class Response(
    var status: String,
    val data: List<Photo>

)