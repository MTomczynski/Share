package com.maciejko.share.data

import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class CoordinatedFile(
    @Json(name = "id") @PrimaryKey val id: String = UUID.randomUUID().toString(),
    @Json(name = "type") val type: String,
    @Json(name = "name") val name: String
)