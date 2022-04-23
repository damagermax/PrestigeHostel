package com.example.prestigehostel.models
/*
* created by maxwell takyi on 23 april 2022
* */


data class RoomModel (
    val number:String="",
    val status:String="",
    val price:String="",
    val numberOfGuest:Int=0,
    val bedsLeft:Int=0,
    val kitchen:Boolean=false,
    val bathroom:Boolean=false
        )