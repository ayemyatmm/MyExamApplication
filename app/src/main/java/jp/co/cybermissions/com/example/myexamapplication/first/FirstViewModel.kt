package jp.co.cybermissions.com.example.myexamapplication.first

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import jp.co.cybermissions.com.example.myexamapplication.LoginViewModel
import jp.co.cybermissions.com.example.myexamapplication.R
import kotlin.random.Random

class FirstViewModel: ViewModel() {

    private val _nameText = MutableLiveData<String>()
    val nameText : LiveData<String>
        get() = _nameText

    private val _textFinish = MutableLiveData<Boolean>()
    val textFinish : LiveData<Boolean>
    get() = _textFinish

    fun onText(){
        _nameText.value = nameText.value.toString()
    }

    fun onTextFinish(){
        _textFinish.value = true
    }
}