package com.fedmog1lnkv.mangareader.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.fedmog1lnkv.mangareader.domain.interactor.MangaInteractor
import com.fedmog1lnkv.mangareader.domain.model.Manga
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mangaInteractor: MangaInteractor
) : ViewModel() {
    private val _mangasFlow = MutableStateFlow<List<Manga>>(emptyList())
    val mangasFlow: StateFlow<List<Manga>> = _mangasFlow

    init {
        loadMangas()
    }

    fun loadMangas() {
        _mangasFlow.value = mangaInteractor.getMangas()
    }
}