package com.mutakin.myfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.*

class MainActivity : AppCompatActivity() {
    lateinit var fragmentManager: FragmentManager
    lateinit var fragmentTransaction: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager

        val tvBackStackCount: TextView = findViewById(R.id.tv_backstack_count)

        if (savedInstanceState == null) {
          fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add<HomeFragment>(R.id.home_fragment_container).commit()
        }

        fragmentManager.addOnBackStackChangedListener {
            tvBackStackCount.text = "Fragment BackStacks Count : ${fragmentManager.backStackEntryCount}"
        }


    }


}