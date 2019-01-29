package com.maciejko.share.util

import androidx.room.TypeConverter
import com.maciejko.share.data.CoordinatedFile
import com.maciejko.share.data.Role
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class Converters : KoinComponent {

    private val moshi: Moshi by inject()

    private val mapOfRoleToFileType =
        Types.newParameterizedType(Map::class.java, Role::class.java, CoordinatedFile::class.java)
    private val mapOfStringsAdapter = moshi.adapter<Map<Role, CoordinatedFile>>(mapOfRoleToFileType)


    @TypeConverter
    fun stringToMap(data: String): Map<Role, CoordinatedFile> {
        return mapOfStringsAdapter.fromJson(data).orEmpty()
    }

    @TypeConverter
    fun mapToString(map: Map<Role, CoordinatedFile>): String {
        return mapOfStringsAdapter.toJson(map)
    }
}