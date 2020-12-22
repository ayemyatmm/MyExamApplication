package jp.co.cybermissions.com.example.myexamapplication.score

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import jp.co.cybermissions.com.example.myexamapplication.LoginViewModel
import jp.co.cybermissions.com.example.myexamapplication.R
import kotlin.random.Random

class ScoreViewModel(finalScore: Int) : ViewModel() {

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
    get() = _score

    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
    get() = _result

    init {
        _score.value = finalScore
        if(finalScore >= 5){
            _result.value = "Success"
        }
        else{
            _result.value = "Fail"
        }
    }
}