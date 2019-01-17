package com.maciejko.share.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maciejko.share.data.CoordinatedGroup
import com.maciejko.share.data.source.CoordinatedGroupDataSource
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface CoordinatedGroupDao : CoordinatedGroupDataSource {
    @Query("SELECT * FROM coordinatedGroups")
    override fun getCoordinatedGroups(): Single<List<CoordinatedGroup>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun saveCoordinatedGroup(coordinatedGroup: CoordinatedGroup): Completable
}