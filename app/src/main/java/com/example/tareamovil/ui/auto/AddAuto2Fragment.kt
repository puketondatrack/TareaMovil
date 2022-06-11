package com.example.tareamovil.ui.auto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tareamovil.R
import com.example.tareamovil.databinding.FragmentAddAutoBinding
import com.example.tareamovil.model.auto
import com.example.tareamovil.viewmodel.AutoViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddLugar2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddAuto2Fragment : Fragment() {
    private var _binding: FragmentAddAutoBinding? = null
    private val binding get() = _binding!!

    private lateinit var autoViewModel: AutoViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddAutoBinding.inflate(inflater, container, false)

        autoViewModel = ViewModelProvider(this).get(AutoViewModel::class.java)


        binding.submitBtn.setOnClickListener{ addAuto()}


        return binding.root
    }

    private fun addAuto(){
        val nombre = binding.autoName.text.toString()
        if(validation(nombre)){
            val auto = auto(0, nombre)
            autoViewModel.addAuto(auto)
            Toast.makeText(requireContext(), getString(R.string.msg_auto_added), Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(requireContext(), getString(R.string.msg_error), Toast.LENGTH_LONG).show()
        }
    }

    private fun validation (nombre: String): Boolean{
        return !(nombre.isEmpty())

    }


}