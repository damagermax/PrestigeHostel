package com.example.prestigehostel.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.prestigehostel.repositories.RoomsRepository
import com.example.prestigehostel.utils.Response

class RoomsViewModel(
    private val roomsRepository: RoomsRepository = RoomsRepository()
) : ViewModel() {

    fun getRooms(): LiveData<Response> = roomsRepository.getRooms()
}