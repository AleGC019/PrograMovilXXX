package com.example.trycarstracker.ui.car

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trycarstracker.R
import com.example.trycarstracker.databinding.FragmentCarBinding


class CarFragment : Fragment() {

    private lateinit var binding: FragmentCarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_car, container, false)

        binding = FragmentCarBinding.inflate(inflater, container, false)
        return binding.root
    }


}