package com.exemple.testPFE11

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
       return 4
    }

    override fun createFragment(position: Int): Fragment {
      return when(position){
          0 -> FirestFragment()
          1 -> Too_Fragment()
          2 -> Three_Fragment()
          else -> Four_Fragment() }

    }
}

