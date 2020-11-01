package com.example.kotlinapplication.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kotlinapplication.fragment.OneFragment
import com.example.kotlinapplication.fragment.TwoFragment

class MyAdapter (var context: Context,var fm : FragmentManager,var totalCount : Int) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
       return totalCount
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0-> {
                OneFragment()
            }
            1-> {
                TwoFragment()
            }
            2-> {
                OneFragment()
            }
            3-> {
                TwoFragment()
            }

            else -> getItem(position)
        }
    }
}