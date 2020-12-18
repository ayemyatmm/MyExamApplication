
package jp.co.cybermissions.com.example.myexamapplication.score

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import jp.co.cybermissions.com.example.myexamapplication.LoginViewModel
import jp.co.cybermissions.com.example.myexamapplication.R
import jp.co.cybermissions.com.example.myexamapplication.databinding.ScoreFragmentBinding

class ScoreFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
      val binding = DataBindingUtil.inflate<ScoreFragmentBinding>(inflater,
      R.layout.score_fragment,container,false)

        viewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(requireArguments()).score)
        viewModel = ViewModelProvider(this,viewModelFactory)
            .get(ScoreViewModel::class.java)
        binding.scoreViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.homebutton.setOnClickListener{
            view: View -> view.findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToMainFragment())
        }
        return binding.root

    }
}