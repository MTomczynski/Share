package com.maciejko.share.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.maciejko.share.data.Converters
import com.maciejko.share.data.CoordinatedGroup

@Database(entities = [CoordinatedGroup::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CoordinatedGroupDatabase : RoomDatabase() {
    abstract fun coordinatedGroupDao(): CoordinatedGroupDao
}