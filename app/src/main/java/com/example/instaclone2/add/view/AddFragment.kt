package com.example.instaclone2.add.view

import com.example.instaclone2.R
import com.example.instaclone2.add.Add
import com.example.instaclone2.common.base.BaseFragment
import com.example.instaclone2.databinding.FragmentAddBinding
import com.google.android.material.tabs.TabLayoutMediator

class AddFragment : BaseFragment<FragmentAddBinding, Add.Presenter>(
    R.layout.fragment_add,
    FragmentAddBinding::bind
), Add.View {

    override lateinit var presenter: Add.Presenter

    override fun setupPresenter() {
        TODO("Not yet implemented")
    }

    override fun setupViews() {
        val tabLayout = binding?.addTab
        val viewPager = binding?.addViewpager
        val adapter = AddViewPagerAdapter(requireActivity())
        viewPager?.adapter = adapter

        if(tabLayout != null && viewPager != null){
            TabLayoutMediator(tabLayout, viewPager){ tab, position ->
                tab.text = getString(adapter.tabs[position])
            }.attach()
        }


    }


}