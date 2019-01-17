package com.maciejko.share.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
@Entity(tableName = "coordinatedGroups")
data class CoordinatedGroup(
    @Json(name = "id") @PrimaryKey val id: String = UUID.randomUUID().toString(),
    @Json(name = "name") val name: String,
    @Json(name = "items") val items: Map<Role, CoordinatedFile> = emptyMap()
)