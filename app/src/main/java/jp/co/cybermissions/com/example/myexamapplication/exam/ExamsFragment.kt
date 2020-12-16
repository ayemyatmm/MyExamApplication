package jp.co.cybermissions.com.example.myexamapplication.exam

import android.os.Bundle
import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import jp.co.cybermissions.com.example.myexamapplication.R
import jp.co.cybermissions.com.example.myexamapplication.communicator
import jp.co.cybermissions.com.example.myexamapplication.databinding.FragmentExamsBinding
import jp.co.cybermissions.com.example.myexamapplication.databinding.FragmentMainBinding

class ExamsFragment : Fragment() {

    private lateinit var viewModel : ExamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentExamsBinding>(
            inflater,
            R.layout.fragment_exams,
            container,false
        )

        viewModel = ViewModelProvider(this).get(ExamsViewModel::class.java)
        binding.examsViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        binding.submitButton.setOnClickListener{
            view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId

            if(-1 != checkedId){
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                if (viewModel.answers[answerIndex] == viewModel.currentQuestion.answers[0]) {
                    viewModel.onPlus()
                    viewModel.questionIndex++
                    if (viewModel.questionIndex < viewModel.numQuestions) {
                        viewModel.currentQuestion = viewModel.questions[viewModel.questionIndex]
                        viewModel.setQuestion()
                        binding.invalidateAll()
                    } else {
                        view.findNavController()
                            .navigate(ExamsFragmentDirections.actionExamFragmentToScoreFragment())
//                        viewModel.onGameFinish()
                    }
                }
                else {
                    viewModel.onMinus()
                    viewModel.questionIndex++
                    if (viewModel.questionIndex < viewModel.numQuestions) {
                        viewModel.currentQuestion = viewModel.questions[viewModel.questionIndex]
                        viewModel.setQuestion()
                        binding.invalidateAll()
                    } else {
                        view.findNavController()
                            .navigate(ExamsFragmentDirections.actionExamFragmentToScoreFragment())
//                        viewModel.onGameFinish()
                    }
                }
            }
        }
        viewModel.eventGameFinish.observe(this,Observer<Boolean>{hasFinished->
            if(hasFinished) gameFinished()
        })
        return binding.root
    }

    private fun gameFinished(){
        Toast.makeText(activity, "Take Exam has Just Finished",Toast.LENGTH_SHORT).show()
        val action = ExamsFragmentDirections.actionExamFragmentToScoreFragment()
        action.score = viewModel.score.value?:0

        NavHostFragment.findNavController(this).navigate(action)
        viewModel.onGameFinishComplete()
    }

}