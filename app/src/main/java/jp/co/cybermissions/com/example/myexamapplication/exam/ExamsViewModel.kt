package jp.co.cybermissions.com.example.myexamapplication.exam

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import jp.co.cybermissions.com.example.myexamapplication.R
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class ExamsViewModel : ViewModel() {

    private val timer : CountDownTimer

    companion object {

        // Time when the game is over
        private const val DONE = 0L

        // Countdown time interval
        private const val ONE_SECOND = 1000L

        // Total time for the game
        private const val COUNTDOWN_TIME = 60000L

    }

    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    // The String version of the current time
    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    private val _examFinish = MutableLiveData<Boolean>()
    val examFinish: LiveData<Boolean>
        get() = _examFinish


    data class Question(
        val text: String,
        val answers: List<String>
    )

    var questions : MutableList<Question> = mutableListOf(
        Question(text = "Q。じこ",
            answers = listOf("事故", "事個", "事姑", "自己")),
        Question(text = "Q。もんだい",
            answers = listOf("問題", "門題", "聞題", "悶題")),
        Question(text = "Q。環境",
            answers = listOf("かんきょう", "けんきょう", "かんきゅう", "けんきゅう")),
        Question(text = "Q。改札",
            answers = listOf("かいさつ", "かいもく", "にゅうさつ", "ていさつ")),
        Question(text = "Q。減って",
            answers = listOf("へって", "ふって", "うって", "うしなって")),
        Question(text = "Q。活動",
            answers = listOf("かつどう", "かっぱつ", "かつやく", "うんどう")),
        Question(text = "Q。先日",
            answers = listOf("せんじつ", "せんにち", "さくじつ", "ぜんじつ")),
        Question(text = "Q。大変",
            answers = listOf("たいへん", "たいべん", "おおへん", "だいへん")),
        Question(text = "Q。厳しい",
            answers = listOf("きびしい", "かなしい", "くるしい", "さびしい")),
        Question(text = "Q。結婚式",
            answers = listOf("けっこんしき", "けごんしき", "けっこんしぎ", "けこんしき")),
//        Question(text = "Q。恥",
//            answers = listOf("はじ", "いびき", "あせ", "ち"))

    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    var questionIndex = 0
    var numQuestions = Math.min((questions.size + 1) , 10)

    init {
        _score.value = 0

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished/ONE_SECOND
            }

            override fun onFinish() {
                _currentTime.value = DONE
                onExamFinish()
            }
         }
        timer.start()
        randomizeQuestions()
     }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel","GameViewModel destroyed!")
        timer.cancel()
    }

    fun onPlus(){
        _score.value = (_score.value)?.plus(1)
    }

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

     fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
    }

    fun onExamFinishComplete(){
        _examFinish.value = false
    }
    fun onExamFinish(){
        _examFinish.value = true
    }
}