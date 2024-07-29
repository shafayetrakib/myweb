package com.cellstechlimited.myweb.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cellstechlimited.myweb.view.fragments.SignIn
import com.cellstechlimited.myweb.view.fragments.SignUpFragment

class SigupTablayoutAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SignUpFragment()
            1 -> SignIn()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}