package com.example.tareamovil.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tareamovil.data.AutoDatabase
import com.example.tareamovil.model.auto
import com.example.tareamovil.repository.AutoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AutoViewModel(application: Application) :AndroidViewModel(application) {
    val getAllData: LiveData<List<auto>>

    private val repository: AutoRepository

    init{
        val autoDao = AutoDatabase.getDatabase(application).autoDao()
        repository = AutoRepository(autoDao)
        getAllData = repository.detAllData
    }

    fun addAuto(auto: auto){
        viewModelScope.launch(Dispatchers.IO) {repository.addAuto(auto)}
    }

    fun updateAuto(auto: auto){
        viewModelScope.launch(Dispatchers.IO) {repository.updateAuto(auto)}
    }

    fun deleteAuto(auto: auto){
        viewModelScope.launch(Dispatchers.IO) {repository.deleteAuto(auto)}
    }
}