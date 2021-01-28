package com.betterzw.wanandroid.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.betterzw.wanandroid.bean.HomeListItem
import com.betterzw.wanandroid.databinding.ListItemPhotoBinding
import com.betterzw.wanandroid.ui.WebViewActivity

class HomeListAdapter : PagingDataAdapter<HomeListItem, HomeListAdapter.GalleryViewHolder>(GalleryDiffCallback()) {


    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val photo = getItem(position)
        if (photo != null) {
            holder.bind(photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            ListItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class GalleryViewHolder(
        private val binding: ListItemPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.photo?.let { photo ->

//                    val direction = HomeFragmentDirections.actionMainFragmentToWebViewActivity(photo.link, photo.chapterName ?: "")
//                    view.findNavController().navigate(direction)
//                    view.findNavController().navigate(direction)

                    Intent(view.context, WebViewActivity::class.java).run {
                        putExtra(Constant.CONTENT_URL_KEY, photo.link)
                        putExtra(Constant.CONTENT_ID_KEY, photo.id)
                        putExtra(Constant.CONTENT_TITLE_KEY, photo.title)
                        view.context.startActivity(this)
                    }

                }
            }
        }

        fun bind(item: HomeListItem) {
            binding.apply {
                photo = item
                executePendingBindings()
            }
        }
    }
}

private class GalleryDiffCallback : DiffUtil.ItemCallback<HomeListItem>() {
    override fun areItemsTheSame(oldItem: HomeListItem, newItem: HomeListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeListItem, newItem: HomeListItem): Boolean {
        return oldItem == newItem
    }
}

