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
import com.example.instaclone2.common.base.DependencyInjector
import com.example.instaclone2.common.model.UserAuth
import com.example.instaclone2.databinding.FragmentSearchBinding
import com.example.instaclone2.search.Search
import com.example.instaclone2.search.presenter.SearchPresenter

class SearchFragment : BaseFragment<FragmentSearchBinding, Search.Presenter>(
    R.layout.fragment_search,
    FragmentSearchBinding::bind
), Search.View {

    override lateinit var presenter: Search.Presenter

    private val adapter by lazy { SearchAdapter(onItemClicked) }

    private var searchListener : SearchListener?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is SearchListener){
            searchListener = context
        }
    }

    override fun setupViews() {
        binding?.searchRv?.layoutManager = LinearLayoutManager(requireContext())
        binding?.searchRv?.adapter = adapter
    }

    override fun setupPresenter() {
        val repository = DependencyInjector.searchRepository()
        presenter = SearchPresenter(this, repository)
    }

    private val onItemClicked : (String) -> Unit = { uuid ->
        searchListener?.goToProfile(uuid)
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

                override fun onQueryTextChange(newText: String?): Boolean {
                    if(newText?.isNotEmpty() == true){
                        presenter.fetchUsers(newText)
                        return true
                    }


                    return false
                }
            })
        }
    }

    override fun showProgress(enabled: Boolean) {
        binding?.searchProgress?.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    override fun displayFullUsers(users: List<UserAuth>) {
        binding?.searchTxtEmpty?.visibility = View.GONE
        binding?.searchRv?.visibility = View.VISIBLE
        adapter.items = users
        adapter.notifyDataSetChanged()
    }

    override fun displayEmptyUser() {
        binding?.searchTxtEmpty?.visibility = View.VISIBLE
        binding?.searchRv?.visibility = View.GONE
    }

    interface SearchListener {
        fun goToProfile(uuid: String)
    }
}