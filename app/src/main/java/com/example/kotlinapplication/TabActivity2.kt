package com.example.kotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.kotlinapplication.adapter.MyAdapter
import com.google.android.material.tabs.TabLayout

class TabActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab2)

        val tabLayout = findViewById(R.id.tabLayout) as TabLayout
        val viewPager = findViewById(R.id.viewPager) as ViewPager
        tabLayout.addTab(tabLayout.newTab().setText("ONE"))
        tabLayout.addTab(tabLayout.newTab().setText("TWO"))
        tabLayout.addTab(tabLayout.newTab().setText("THREE"))
        tabLayout.addTab(tabLayout.newTab().setText("FOUR"))
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        viewPager.adapter = MyAdapter(this,getSupportFragmentManager(),tabLayout.tabCount)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}