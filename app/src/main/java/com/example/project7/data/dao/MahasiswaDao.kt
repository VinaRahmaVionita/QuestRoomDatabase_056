package com.example.project7.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.project7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow


@Dao
interface MahasiswaDao {
    //mengambil semua data mahasiswa yg tersimpan di database
    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa(): Flow<List<Mahasiswa>>

    //mengambil dsta mahasiswa berdasarkan no induk
    @Query("SELECT * FROM mahasiswa WHERE nim = :nim")
    fun getMahasiswa(nim: String): Flow<Mahasiswa>

    @Insert
    //melakukan insert
    suspend fun insertMahasiswa(
        mahasiswa: Mahasiswa
    )

    @Delete
    suspend fun deleteMahasiswa(
        mahasiswa: Mahasiswa
    )

    @Update
    //melakukan update
    suspend fun updateMahasiswa(
        mahasiswa: Mahasiswa
    )

}