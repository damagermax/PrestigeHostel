package com.example.prestigehostel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.prestigehostel.R
import com.example.prestigehostel.adapters.ViewPagerAdapter
import com.example.prestigehostel.viewmodels.AuthViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch


/**
 * created by maxwell takyi on 21 april 2022
 *
 */
class FragmentDashboard : Fragment() {

    private lateinit var imageSlider: ImageSlider
    private val authViewModel:AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // Hooking views
        val tab = view.findViewById<TabLayout>(R.id.tabLayOut)
        val viewPager2 = view.findViewById<ViewPager2>(R.id.viewPager)
        imageSlider=view.findViewById(R.id.imageSlider)



        // Setting up tabLayout and viewpager2
        viewPager2.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tab, viewPager2) { tabLayout , index ->

            tabLayout.text = when (index) {
                0 -> {
                    "Male"
                }
                1 -> {
                    "Female"
                }
                else -> {
                    "Male"
                }
            }
        }.attach()

        // call functions here
        setUpImageSlider()

        return view
    }

    private fun setUpImageSlider(){

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel("https://static.vecteezy.com/system/resources/thumbnails/002/294/876/small/back-to-school-web-banner-design-school-bag-trophy-stack-of-books-education-ornament-header-or-footer-banner-free-vector.jpg"))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsuoS36jE0znlVBfzk2XZ2d-jBQ7O5MMnURw&usqp=CAU"))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZ9vmtzkeJQXFdQArvKMduGULQEIfcorCBhg&usqp=CAU"))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSc4YuuytVYaXO9C-DsrItu0JBDC3HUNbhhwQ&usqp=CAU"))

        imageSlider.setImageList(imageList,ScaleTypes.FIT)
    }


}