package com.dzakyhdr.unsplash.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dzakyhdr.unsplash.data.remote.Error
import com.dzakyhdr.unsplash.data.remote.UnsplashRepository
import com.dzakyhdr.unsplash.data.remote.model.UnsplashResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: UnsplashRepository) : ViewModel() {

    private val _listPhotos = MutableStateFlow(listOf<UnsplashResponseItem>())
    val listPhotos: StateFlow<List<UnsplashResponseItem>> get() = _listPhotos


    private var _errorStatus = MutableLiveData<String?>()
    val errorStatus: LiveData<String?> get() = _errorStatus

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    init {
        getPhotos()
    }


    private fun getPhotos() {
        viewModelScope.launch {
            try {
                _loading.value = true
                _listPhotos.emit(repository.getPhotos())
            } catch (e: Error) {
                _errorStatus.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }


    fun onSnackbarShow() {
        _errorStatus.value = null
    }
}