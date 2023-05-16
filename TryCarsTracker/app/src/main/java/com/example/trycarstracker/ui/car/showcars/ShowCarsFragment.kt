package com.example.trycarstracker.ui.car.showcars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.trycarstracker.R
import com.example.trycarstracker.databinding.FragmentShowCarsBinding
import com.example.trycarstracker.ui.car.viewmodel.CarViewModel

class ShowCarsFragment : Fragment() {

    private lateinit var binding: FragmentShowCarsBinding

    private val viewmodel: CarViewModel by activityViewModels{
        CarViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_show_cars, container, false)
        binding = FragmentShowCarsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}