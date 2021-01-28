package com.betterzw.wanandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.betterzw.wanandroid.adapter.HomeListAdapter
import com.betterzw.wanandroid.databinding.ActivityMainBinding
import com.betterzw.wanandroid.databinding.FragmentHomeBinding
import com.betterzw.wanandroid.viewmodels.HomeListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val adapter = HomeListAdapter()
    private var searchJob: Job? = null
    private val viewModel: HomeListViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding

//    private lateinit var viewModel: BlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root


        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

//        binding.toolbar.navigation
        binding.photoList.adapter = adapter

        binding.photoList.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))


      /*  viewModel.plantAndGardenPlantings.observe(viewLifecycleOwner) { result ->
            binding.hasPlantings = !result.isNullOrEmpty()
            adapter.submitList(result)
        }*/

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        getHomeList("0")


//        val direction = HomeFragmentDirections.actionHomeFragmentToWebViewActivity("")
//        findNavController().navigate(direction)
//        findNavController().navigate(direction)
    }


    private fun getHomeList(query: String) {
        // Make sure we cancel the previous job before creating a new one
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.getHomeList(query).collectLatest {
                binding.hasContent = true
                adapter.submitData(it)
            }
        }
    }

}