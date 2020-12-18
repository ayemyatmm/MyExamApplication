package jp.co.cybermissions.com.example.myexamapplication.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import jp.co.cybermissions.com.example.myexamapplication.LoginViewModel
import jp.co.cybermissions.com.example.myexamapplication.R
import jp.co.cybermissions.com.example.myexamapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentFirstBinding = DataBindingUtil.inflate(inflater
        , R.layout.fragment_first,container,false)

        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        binding.firstViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        binding.takeExamButton.setOnClickListener{ view : View ->
            viewModel.onText()
            viewModel.onTextFinish()
            view.findNavController().navigate(R.id.action_firstFragment_to_examFragment)
        }
        return binding.root
    }

}