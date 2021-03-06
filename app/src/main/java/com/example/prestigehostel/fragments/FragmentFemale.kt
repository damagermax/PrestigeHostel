package com.example.prestigehostel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.prestigehostel.R
import com.example.prestigehostel.adapters.NavigateToDetailScreen
import com.example.prestigehostel.adapters.RoomAdapter
import com.example.prestigehostel.models.RoomModel


/**
 * created by maxwell takyi on 22 april 2022
 */
class FragmentFemale : Fragment() , NavigateToDetailScreen{

    private lateinit var roomAdapter: RoomAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_female, container, false)

        // hook views
        recyclerView = view.findViewById(R.id.femaleRecyclerView)

        // call functions here
        setUpRecyclerView()
        return view
    }

    private fun setUpRecyclerView() {
        val dummy = arrayListOf<RoomModel>(
            RoomModel("G F 9","£ 2000",3,2,kitchen = true,false),
            RoomModel("G F 17","£ 1500",4,0,kitchen = true,true),
            RoomModel("G F 26","£ 1700",1,1,kitchen = true,false),
            RoomModel("G F 20","£ 2100",4,2,kitchen = true,true),
            RoomModel("1st F 35","£ 4000",4,0,kitchen = true,false),
            RoomModel("9th F 1","£ 325",2,1,kitchen = true,true),
            RoomModel("6th F 4","£ 235",4,0,kitchen = false,true),
            RoomModel("2nd F 69","£ 385",4,3,kitchen = true,false),
            RoomModel("1st F 10","£ 385",3,3,kitchen = false,true),
            RoomModel("G F 28","£ 585",1,0,kitchen = true,true),
            RoomModel("2nd F 8","£ 6485",4,4,kitchen = true,false),
            RoomModel("7th F 28","£ 585",4,3,kitchen = false,false),
            RoomModel("10th F 18","£ 665",2,2,kitchen = false,false),
            RoomModel("5th F 258","£ 7785",4,0,kitchen = true,false),
        )
        roomAdapter= RoomAdapter(this)
        recyclerView.setHasFixedSize(true)
        roomAdapter.setData(dummy)
        recyclerView.adapter=roomAdapter
    }

    override fun selectedRoom(roomModel: RoomModel) {
        Toast.makeText(requireContext(),"female",Toast.LENGTH_SHORT).show()
        val action=FragmentDashboardDirections.actionFragmentDashboardToFragmentDetail()
        findNavController().navigate(action)
    }

}