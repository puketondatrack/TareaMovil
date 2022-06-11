package com.example.tareamovil.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tareamovil.model.auto

@Dao
interface AutoDao {

    @Query("SELECT * FROM AUTO")
    fun getAlData(): LiveData<List<auto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(auto: auto)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  updateLugar(auto: auto)

    @Delete
    suspend fun deleteLugar(auto: auto)
}