package com.mutakin.myfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class CategoryFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnDetailCategory: Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener {
            val mDetailCategoryFragment = DetailCategoryFragment()
            val description = "Kategori ini akan berisi produk-produk lifestyle"
            mDetailCategoryFragment.description = description

            mDetailCategoryFragment.arguments = bundleOf(DetailCategoryFragment.EXTRA_NAME to "LifeStyle")
            parentFragmentManager.beginTransaction().replace(R.id.home_fragment_container,mDetailCategoryFragment,DetailCategoryFragment::class.java.simpleName).addToBackStack(null).commit()
        }
    }




}