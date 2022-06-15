package com.dzakyhdr.unsplash.ui.detail

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
class DetailViewModel @Inject constructor(private val repository: UnsplashRepository) :
    ViewModel() {

    private var _detailPhoto = MutableLiveData<UnsplashResponseItem>()
    val detailPhoto: LiveData<UnsplashResponseItem> get() = _detailPhoto

    private var _errorStatus = MutableLiveData<String?>()
    val errorStatus: LiveData<String?> get() = _errorStatus

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun getDetail(id: String) {
        viewModelScope.launch {
            try {
                _detailPhoto.value = repository.getDetailPhoto(id)
            } catch (e: Error) {
                _errorStatus.value = e.message
            } finally {
                _loading.value = true
            }
        }
    }

}