package com.example.userssp.interfaces

import com.example.userssp.User

interface OnClickListener {
    fun onClick(user: User, position: Int)
}