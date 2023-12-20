package com.fedmog1lnkv.mangareader.presentation.screens.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fedmog1lnkv.mangareader.domain.interactor.UserInteractor
import com.fedmog1lnkv.mangareader.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(private val userInteractor: UserInteractor):ViewModel() {
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            _user.value = userInteractor.getUser()
        }
    }
}