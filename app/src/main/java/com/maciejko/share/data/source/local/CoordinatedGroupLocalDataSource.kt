package com.maciejko.share.data.source.local

import com.maciejko.share.data.CoordinatedGroup
import com.maciejko.share.data.source.CoordinatedGroupDataSource
import io.reactivex.Completable
import io.reactivex.Single

class CoordinatedGroupLocalDataSource(
    val coordinatedGroupDao: CoordinatedGroupDao
) : CoordinatedGroupDataSource {

    override fun getCoordinatedGroups(): Single<List<CoordinatedGroup>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveCoordinatedGroup(coordinatedGroup: CoordinatedGroup): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}