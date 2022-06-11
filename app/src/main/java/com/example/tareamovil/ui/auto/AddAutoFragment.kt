package com.example.tareamovil.ui.auto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.tareamovil.R
import com.example.tareamovil.databinding.FragmentAddAutoBinding
import com.example.tareamovil.model.auto
import com.example.tareamovil.viewmodel.AutoViewModel


class AddAutoFragment : Fragment() {
    private var _binding: FragmentAddAutoBinding? = null
    private val binding get() = _binding!!

    private lateinit var autoViewModel: AutoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddAutoBinding.inflate(inflater, container, false)

        autoViewModel = ViewModelProvider(this).get(AutoViewModel::class.java)


        binding.submitBtn.setOnClickListener{addAuto()}


        return binding.root
    }

    private fun addAuto() {
        val nombre = binding.autoName.text.toString()

        if(validation(nombre)) {
            val auto = auto(0, nombre)
            autoViewModel.addAuto(auto)
            Toast.makeText(requireContext(), getString(R.string.msg_auto_added), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), getString(R.string.msg_error), Toast.LENGTH_LONG).show()
        }
    }

    private fun validation (nombre: String): Boolean{
        return !(nombre.isEmpty())

    }

}