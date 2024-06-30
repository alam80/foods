package com.alam.foods.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class UserModel(
    val name: String?= null,
    val email: String?= null,
    val password: String?= null,
)
