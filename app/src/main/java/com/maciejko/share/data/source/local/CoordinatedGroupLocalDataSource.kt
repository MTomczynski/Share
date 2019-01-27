package com.maciejko.share.data.source.local

import com.maciejko.share.data.CoordinatedGroup
import com.maciejko.share.data.source.CoordinatedGroupDataSource
import io.reactivex.Completable
import io.reactivex.Single

class CoordinatedGroupLocalDataSource(
    private val coordinatedGroupDao: CoordinatedGroupDao
) : CoordinatedGroupDataSource {

    override fun getCoordinatedGroups(): Single<List<CoordinatedGroup>> {
        return coordinatedGroupDao.getCoordinatedGroups()
    }

    override fun saveCoordinatedGroup(coordinatedGroup: CoordinatedGroup): Completable {
        return coordinatedGroupDao.saveCoordinatedGroup(coordinatedGroup)
    }
}