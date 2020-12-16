package jp.co.cybermissions.com.example.myexamapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import jp.co.cybermissions.com.example.myexamapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
//    private lateinit var communicator: communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentMainBinding = DataBindingUtil.inflate(inflater
        ,R.layout.fragment_main,container,false)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

//        communicator = activity as communicator

        binding.takeExamButton.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_examFragment)
//            communicator.passDataCom(viewModel.nameText.toString())
        }
            setHasOptionsMenu(true)
        return binding.root
    }
}