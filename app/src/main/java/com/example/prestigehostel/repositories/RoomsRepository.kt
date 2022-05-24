package com.example.prestigehostel.repositories

import androidx.lifecycle.MutableLiveData
import com.example.prestigehostel.models.RoomModel
import com.example.prestigehostel.utils.Constants.ROOM_REF
import com.example.prestigehostel.utils.Response
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RoomsRepository(
    private val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference,
    private val roomsRef: DatabaseReference = rootRef.child(ROOM_REF)
) {

    fun getRooms(): MutableLiveData<Response> {
        val roomMutableLiveData = MutableLiveData<Response>()
        roomsRef.get().addOnCompleteListener { task ->
            val response =Response()

            if (task.isSuccessful){
                val result= task.result
                result?.let {
                    response.rooms=result.children.map {dataSnapshot ->
                        dataSnapshot.getValue(RoomModel::class.java)!!

                    }

                }
            }
            else{
                response.exception=task.exception
            }

            roomMutableLiveData.value=response

        }
        return roomMutableLiveData

    }
}