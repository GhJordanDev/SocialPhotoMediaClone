package com.example.instaclone2.profile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instaclone2.R
import com.example.instaclone2.common.base.BaseFragment
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import com.example.instaclone2.databinding.FragmentProfileBinding
import com.example.instaclone2.register.RegisterEmail

class ProfileFragment
    : BaseFragment<FragmentProfileBinding, Profile.Presenter>(
    R.layout.fragment_profile,
    FragmentProfileBinding::bind
    ), Profile.View {

    override lateinit var presenter: Profile.Presenter

    private val adapter = PostAdapter()

    override fun setupPresenter() {
        // TODO:  presenter = ProfilePresenter(this, repository)
    }

    override fun setupViews() {
        binding?.profileRv?.layoutManager = GridLayoutManager(requireContext(), 3)
        binding?.profileRv?.adapter = adapter

        presenter.fetchUserProfile()
        presenter.fetchUserPosts()
    }

    override fun showProgress(enabled: Boolean) {
        binding?.profileProgress?.visibility = if(enabled) View.VISIBLE else View.GONE
    }

    override fun displayUserProfile(userAuth: UserAuth) {
        binding?.profileTxtPostCount?.text = userAuth.postCount.toString()
        binding?.profileTxtFollowing?.text = userAuth.followingCount.toString()
        binding?.profileTxtFollowers?.text = userAuth.followersCount.toString()
        binding?.profileTxtUsername?.text = userAuth.name
        binding?.profileTxtBio?.text = "TODO"

        presenter.fetchUserPosts()
    }

    override fun displayRequestFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun displayEmptyPosts() {
        binding?.profileTxtEmpty?.visibility = View.VISIBLE
        binding?.profileRv?.visibility = View.GONE
    }

    override fun displayFullPosts(posts: List<Post>) {
        binding?.profileTxtEmpty?.visibility = View.GONE
        binding?.profileRv?.visibility = View.VISIBLE

        adapter.items = posts
        adapter.notifyDataSetChanged()
    }

    override fun getMenu(): Int? {
        return R.menu.menu_profile
    }

}