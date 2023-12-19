package com.fedmog1lnkv.mangareader.domain.repository

import com.fedmog1lnkv.mangareader.domain.model.User

interface UserRepository {
    fun getUser(): User
}