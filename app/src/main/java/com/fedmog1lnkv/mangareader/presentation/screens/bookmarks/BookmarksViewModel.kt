package com.fedmog1lnkv.mangareader.presentation.screens.bookmarks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fedmog1lnkv.mangareader.domain.interactor.MangaInteractor
import com.fedmog1lnkv.mangareader.domain.model.Bookmark
import com.fedmog1lnkv.mangareader.domain.model.Manga
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarksViewModel @Inject constructor(
    private val mangaInteractor: MangaInteractor
) : ViewModel() {
    private val _bookmarks = MutableStateFlow<List<Bookmark>>(emptyList())
    val bookmarks: StateFlow<List<Bookmark>> = _bookmarks

    private val _mangasFlow = MutableStateFlow<List<Manga>>(emptyList())
    val mangasFlow: StateFlow<List<Manga>> = _mangasFlow

    init {
        getBookmarks()
    }

    fun selectBookmark(bookmark: Bookmark) = viewModelScope.launch {
        _mangasFlow.value = bookmark.mangas
    }

    private fun getBookmarks() = viewModelScope.launch {
        _bookmarks.value = mangaInteractor.getBookmarks()
    }
}