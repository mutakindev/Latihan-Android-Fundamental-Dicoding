package com.mutakin.myfragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class HomeFragment : Fragment(R.layout.fragment_home){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnToCategory: Button = view.findViewById(R.id.btn_category)

        btnToCategory.setOnClickListener {
          parentFragmentManager.commit {
              replace<CategoryFragment>(R.id.home_fragment_container)
              setReorderingAllowed(true)
              addToBackStack(null)
          }
        }
    }
}