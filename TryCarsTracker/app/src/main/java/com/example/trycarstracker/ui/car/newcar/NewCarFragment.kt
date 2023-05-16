package com.example.trycarstracker.ui.car.newcar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.trycarstracker.R
import com.example.trycarstracker.databinding.FragmentNewCarBinding
import com.example.trycarstracker.ui.car.viewmodel.CarViewModel


class NewCarFragment : Fragment() {

    private lateinit var binding: FragmentNewCarBinding

    private val viewModel: CarViewModel by activityViewModels{
        CarViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_new_car, container, false)
        binding = FragmentNewCarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        setObservers()

    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun setObservers(){

    }


}