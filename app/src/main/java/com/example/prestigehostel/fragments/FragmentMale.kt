package com.example.prestigehostel.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.prestigehostel.R
import com.example.prestigehostel.adapters.NavigateToDetailScreen
import com.example.prestigehostel.adapters.RoomAdapter
import com.example.prestigehostel.models.RoomModel
import com.example.prestigehostel.utils.Constants.TAG
import com.example.prestigehostel.viewmodels.RoomsViewModel


/**
 * created by takyi maxwell on 22 april 2022
 */
class FragmentMale : Fragment(), NavigateToDetailScreen {

    private lateinit var roomAdapter: RoomAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var roomsViewModel: RoomsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_male, container, false)
        roomsViewModel = ViewModelProvider(this).get(RoomsViewModel::class.java)
        recyclerView = view.findViewById(R.id.maleRecyclerView)
        getRoomsFromRealTimeDatabase()
        return view
    }


    private fun getRoomsFromRealTimeDatabase() {
        roomsViewModel.getRooms().observe(viewLifecycleOwner) {response->

            response.rooms?.let { products ->
              setUpRecyclerView(products)
            }

            response.exception?.let { exception ->
                exception.message?.let {
                    Log.e(TAG, it)
                }
            }
        }
    }

    private fun setUpRecyclerView(products: List<RoomModel>) {

        roomAdapter = RoomAdapter(this)
        recyclerView.setHasFixedSize(true)
        roomAdapter.setData(products)
        recyclerView.adapter = roomAdapter
    }


    override fun selectedRoom(roomModel: RoomModel) {
        Toast.makeText(requireContext(), "male", Toast.LENGTH_SHORT).show()
        val action = FragmentDashboardDirections.actionFragmentDashboardToFragmentDetail()
        findNavController().navigate(action)
    }


}