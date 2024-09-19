package com.example.dormeaseuser.ui.home

import java.io.Serializable

data class Complaints(
    val date: String,
    val time: String,
    val type: String,
    val roomNo: String,
    val problem: String,
    val description: String,
    val mailId: String
) : Serializable
