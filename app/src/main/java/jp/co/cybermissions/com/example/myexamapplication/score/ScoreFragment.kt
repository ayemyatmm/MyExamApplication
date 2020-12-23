
package jp.co.cybermissions.com.example.myexamapplication.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import jp.co.cybermissions.com.example.myexamapplication.R
import jp.co.cybermissions.com.example.myexamapplication.databinding.ScoreFragmentBinding

class ScoreFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory
    var currentUser = FirebaseAuth.getInstance().currentUser?.displayName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<ScoreFragmentBinding>(
          inflater,
          R.layout.score_fragment, container, false
      )

        viewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(requireArguments()).score)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ScoreViewModel::class.java)
        binding.scoreViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.homebutton.setOnClickListener{ view: View -> view.findNavController().navigate(
            ScoreFragmentDirections.actionScoreFragmentToMainFragment()
        )
            val mDatabase = FirebaseDatabase.getInstance()
            val mDatabaseReference = mDatabase.getReference()
            mDatabaseReference.child("Exam").push().setValue(currentUser);
            mDatabaseReference.child("Exam").push().setValue(viewModel.score);
        }

        binding.yourDisplayText.text = "Hey "+ currentUser
        return binding.root

    }
}