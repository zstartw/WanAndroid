package com.betterzw.wanandroid.data

import androidx.paging.PagingSource
import com.betterzw.wanandroid.api.RetrofitService
import com.betterzw.wanandroid.bean.CommonData
import com.betterzw.wanandroid.bean.HomeListItem
import java.lang.Exception

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class HomePagingSource (
    private val service: RetrofitService,
    private val query: String
) : PagingSource<Int, HomeListItem>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeListItem> {
        val page = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

        return  try{
            val response = service.getHomeList(page)
            val items = response.data.datas
            LoadResult.Page(
                data = items,
                prevKey = if (page == UNSPLASH_STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (page == response.data.pageCount) null else page + 1
            )
        }catch (exception: Exception){
            LoadResult.Error(exception)
        }
    }

}