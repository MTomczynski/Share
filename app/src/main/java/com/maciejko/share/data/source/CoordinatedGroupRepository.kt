package com.maciejko.share.data.source

import com.maciejko.share.data.CoordinatedGroup
import io.reactivex.Completable
import io.reactivex.Single

class CoordinatedGroupRepository(
    private val coordinatedGroupDataSource: CoordinatedGroupDataSource
) : CoordinatedGroupDataSource {
    override fun getCoordinatedGroups(): Single<List<CoordinatedGroup>> {
        return coordinatedGroupDataSource.getCoordinatedGroups()
    }

    override fun saveCoordinatedGroup(coordinatedGroup: CoordinatedGroup): Completable {
        return coordinatedGroupDataSource.saveCoordinatedGroup(coordinatedGroup)
    }
}