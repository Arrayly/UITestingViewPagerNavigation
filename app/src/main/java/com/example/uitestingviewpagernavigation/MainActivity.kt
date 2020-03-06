package com.example.uitestingviewpagernavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.uitestingviewpagernavigation.fragments.FragmentOne
import com.example.uitestingviewpagernavigation.fragments.FragmentThree
import com.example.uitestingviewpagernavigation.fragments.FragmentTwo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById(R.id.MainActivity_viewPager)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter


    }



    inner class ViewPagerAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val COUNT = 3

        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = FragmentOne()
                1 -> fragment = FragmentTwo()
                2 -> fragment = FragmentThree()
            }

            return fragment!!
        }

        override fun getCount(): Int {
            return COUNT
        }
    }
}
