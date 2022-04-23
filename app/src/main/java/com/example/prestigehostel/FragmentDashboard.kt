package com.example.prestigehostel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.prestigehostel.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


/**
 * created by maxwell takyi on 21 april 2022
 *
 */
class FragmentDashboard : Fragment() {

    private lateinit var imageSlider: ImageSlider

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
        imageList.add(SlideModel("https://cdn.w600.comps.canstockphoto.com/fashion-house-concept-banner-header-vector-clipart_csp67606305.jpg"))
        imageList.add(SlideModel("https://c8.alamy.com/comp/PETCYW/back-to-school-web-banner-colorful-kid-backpack-illustration-student-bag-with-class-supplies-and-happy-typography-quote-eps10-vector-PETCYW.jpg"))

        imageSlider.setImageList(imageList,ScaleTypes.FIT)
    }


}