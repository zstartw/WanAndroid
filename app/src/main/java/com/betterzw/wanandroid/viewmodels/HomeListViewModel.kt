package com.betterzw.wanandroid.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.betterzw.wanandroid.bean.HomeListItem
import com.betterzw.wanandroid.data.HomeListRepository
import kotlinx.coroutines.flow.Flow

class HomeListViewModel @ViewModelInject constructor(
    private val repository: HomeListRepository
) : ViewModel(){

    fun getHomeList(queryString: String): Flow<PagingData<HomeListItem>> {
        return repository.getSearchResultStream(queryString).cachedIn(viewModelScope)
    }
}