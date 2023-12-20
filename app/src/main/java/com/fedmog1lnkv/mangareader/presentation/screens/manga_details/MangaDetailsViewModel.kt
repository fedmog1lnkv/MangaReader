package com.fedmog1lnkv.mangareader.presentation.screens.manga_details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fedmog1lnkv.mangareader.domain.interactor.MangaInteractor
import com.fedmog1lnkv.mangareader.domain.model.Manga
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MangaDetailsViewModel @Inject constructor(
    private val mangaInteractor: MangaInteractor,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _manga = MutableStateFlow<Manga?>(null)
    val manga: StateFlow<Manga?> = _manga

    init {
        savedStateHandle.get<String>(MangaDetailsActivity.ID)?.let { id ->
            getManga(id)
        }
    }

    private fun getManga(id: String) = viewModelScope.launch {
        _manga.value = mangaInteractor.getManga(id)
    }
}