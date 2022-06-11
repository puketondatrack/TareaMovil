package com.example.tareamovil.ui.auto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tareamovil.R
import com.example.tareamovil.databinding.FragmentAutoBinding
import com.example.tareamovil.viewmodel.AutoViewModel

class AutoFragment : Fragment() {

    private lateinit var AutoViewModel: AutoViewModel
    private var _binding: FragmentAutoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        autoViewModel = ViewModelProvider(this).get(AutoViewModel::class.java)
        _binding = FragmentAutoBinding.inflate(inflater, container, false)

        binding.addAutoFabButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_auto_to_addAuto2Fragment)
        }

        //Activar el recicler view




        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}