package com.example.instaclone2.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instaclone2.R
import com.example.instaclone2.common.base.BaseFragment
import com.example.instaclone2.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, Home.Presenter>(
    R.layout.fragment_home,
    FragmentHomeBinding::bind
) {

    override lateinit var presenter: Home.Presenter

    override fun setupViews() {
        binding?.homeRv?.layoutManager = LinearLayoutManager(requireContext())
        binding?.homeRv?.adapter = PostAdapter()
    }

    override fun setupPresenter() {
        TODO("Not yet implemented")
    }

    override fun getMenu(): Int? {
        return R.menu.menu_home
    }

    private class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            return PostViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_post_list, parent, false)
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
                itemView.findViewById<ImageView>(R.id.home_img_post).setImageResource(image)
            }
        }
    }
}