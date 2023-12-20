package com.fedmog1lnkv.mangareader.data.repository

import android.content.Context
import com.fedmog1lnkv.mangareader.data.dto.UserDTO
import com.fedmog1lnkv.mangareader.data.mapper.UserMapper
import com.fedmog1lnkv.mangareader.domain.model.User
import com.fedmog1lnkv.mangareader.domain.repository.UserRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson,
) : UserRepository {
    override fun getUser(): User {
        context.resources.openRawResource(com.fedmog1lnkv.mangareader.R.raw.user_data)
            .use { inputStream ->
                val buffer = ByteArray(inputStream.available())
                inputStream.read(buffer)
                val jsonString = String(buffer, Charsets.UTF_8)

                val userData = gson.fromJson(jsonString, UserDTO::class.java)
                return UserMapper.fromDto(userData)
            }
    }
}