package com.example.instaclone2.search.view

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instaclone2.R
import com.example.instaclone2.common.base.BaseFragment
import com.example.instaclone2.databinding.FragmentSearchBinding
import com.example.instaclone2.search.Search

class SearchFragment : BaseFragment<FragmentSearchBinding, Search.Presenter>(
    R.layout.fragment_search,
    FragmentSearchBinding::bind
) {

    override lateinit var presenter: Search.Presenter

    override fun setupViews() {
        binding?.searchRv?.layoutManager = LinearLayoutManager(requireContext())
        binding?.searchRv?.adapter = PostAdapter()
    }

    override fun setupPresenter() {
        TODO("Not yet implemented")
    }

    override fun getMenu() = R.menu.menu_search

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        val searchManager = requireActivity().getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = (menu.findItem(R.id.menu_search).actionView as SearchView)
        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(requireActivity().componentName))
            setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    return false
                }
            })
        }

    }

    private class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            return PostViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return 30
        }

        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            holder.bind(R.drawable.ic_insta_add)
        }

        private class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            fun bind(image: Int){
                itemView.findViewById<ImageView>(R.id.search_img_user).setImageResource(image)
            }
        }
    }
}