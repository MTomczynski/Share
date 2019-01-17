package com.maciejko.share.data.source

import com.maciejko.share.data.CoordinatedGroup
import io.reactivex.Completable
import io.reactivex.Single

interface CoordinatedGroupDataSource {
    fun getCoordinatedGroups(): Single<List<CoordinatedGroup>>
    fun saveCoordinatedGroup(coordinatedGroup: CoordinatedGroup): Completable
}