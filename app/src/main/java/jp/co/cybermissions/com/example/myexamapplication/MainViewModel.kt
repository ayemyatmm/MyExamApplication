package jp.co.cybermissions.com.example.myexamapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _nameText = MutableLiveData<String>()
    val nameText : LiveData<String>
        get() = _nameText
}