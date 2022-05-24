package com.example.prestigehostel.utils

import com.example.prestigehostel.models.RoomModel
import java.lang.Exception

data class Response(
    var rooms: List<RoomModel>? = null,
    var exception: Exception? = null
)
