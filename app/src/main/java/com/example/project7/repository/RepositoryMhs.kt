package com.example.project7.repository

import com.example.project7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface RepositoryMhs {
    //untuk mendapatkan semua data mahasiswa dalm bentuk aliran data (flow)
    fun getAllMhs(): Flow<List<Mahasiswa>>

    //menganggil data mhs berdasarkan nim
    fun getMhs(nim: String): Flow<Mahasiswa>

    //delete
    suspend fun deleteMhs(
        mahasiswa: Mahasiswa
    )

    //update
    suspend fun updateMhs(
        mahasiswa: Mahasiswa
    )

    //insert data
    suspend fun insertMhs(
        mahasiswa: Mahasiswa
    )

}