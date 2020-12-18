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

//    fun getFactToDisplay(context: Context): String {
//        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
//        val factTypePreferenceKey = context.getString(R.string.preference_fact_type_key)
//        val defaultFactType = context.resources.getStringArray(R.array.fact_type)[0]
//        val funFactType = sharedPreferences.getString(factTypePreferenceKey, defaultFactType)
//
//        return LoginViewModel.androidFacts[Random.nextInt(0, LoginViewModel.androidFacts.size)]
//    }
}