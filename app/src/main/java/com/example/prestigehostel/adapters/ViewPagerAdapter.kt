package com.example.prestigehostel.adapters


import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.prestigehostel.fragments.FragmentFemale
import com.example.prestigehostel.fragments.FragmentMale

class ViewPagerAdapter(fragmentActivity:Fragment):FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int =2

    override fun createFragment(position: Int): Fragment {
     return when(position){
           0 ->{FragmentMale()}
           1 ->{FragmentFemale()}
         else ->{throw Resources.NotFoundException("position not found")}
       }

    }


}