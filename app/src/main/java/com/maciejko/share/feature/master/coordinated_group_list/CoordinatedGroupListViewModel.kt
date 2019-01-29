package com.maciejko.share.feature.master.coordinated_group_list

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maciejko.share.base.BaseViewModel
import com.maciejko.share.data.CoordinatedGroup
import com.maciejko.share.data.source.CoordinatedGroupRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class CoordinatedGroupListViewModel(
    private val coordinatedGroupRepository: CoordinatedGroupRepository
) : BaseViewModel() {

    private val _coordinatedGroupList = MutableLiveData<List<CoordinatedGroup>>()
    val coordinatedGroupList: LiveData<List<CoordinatedGroup>>
        get() = _coordinatedGroupList

    val isError = ObservableBoolean(false)
    val isLoading = ObservableBoolean(false)


    init {
        loadList()
    }

    private fun loadList() {
        coordinatedGroupRepository
            .getCoordinatedGroups()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                isLoading.set(true)
                isError.set(false)
            }
            .doOnEvent { _, _ -> isLoading.set(false) }
            .subscribeBy(
                onSuccess = {
                    _coordinatedGroupList.value = it
                },
                onError = {
                    Timber.e(it)
                    isError.set(true)
                }
            ).toDisposables()
    }
}