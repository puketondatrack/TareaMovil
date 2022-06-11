package com.example.tareamovil.repository

import androidx.lifecycle.LiveData
import com.example.tareamovil.data.AutoDao
import com.example.tareamovil.model.auto

class AutoRepository(private val AutoDao: AutoDao) {
    val detAllData: LiveData<List<auto>> = AutoDao.getAlData()

    suspend fun addAuto(auto: auto){
        AutoDao.add(auto)
    }

    suspend fun updateAuto(auto: auto){
        AutoDao.add(auto)
    }

    suspend fun deleteAuto(auto: auto){
        AutoDao.add(auto)
    }
}