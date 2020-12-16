package jp.co.cybermissions.com.example.myexamapplication.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
    get() = _score

    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
    get() = _result

    init {
        _score.value = finalScore
    }
}