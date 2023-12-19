package com.fedmog1lnkv.mangareader.domain.interactor

import com.fedmog1lnkv.mangareader.domain.model.User
import com.fedmog1lnkv.mangareader.domain.repository.UserRepository
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val userRepository: UserRepository
) {
    fun getUser(): User {
        return userRepository.getUser()
    }
}