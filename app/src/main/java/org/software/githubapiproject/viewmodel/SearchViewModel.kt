package org.software.githubapiproject.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.software.githubapiproject.data.Item
import org.software.githubapiproject.repo.SearchUserRepo
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: SearchUserRepo) : ViewModel() {

    private val _list = MutableLiveData<List<Item>>()
    val list: LiveData<List<Item>> get() = _list

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> get() = _loading

    init {
        _loading.value = false
    }

    fun getSearchList(user: String) {
        //progressbar 실행
        _loading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.searchUser(user)
            if (response.isSuccessful) {
                _loading.postValue(false)
                _list.postValue(response.body()!!.items)
                Log.d(TAG, "getSearchList: ${response.body()!!.items.size}")
            } else{
                _loading.postValue(false)
                Log.e(TAG, "getSearchList: ${response.message()}")
            }
        }
    }
}


