package com.example.project7.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.app.NotificationCompat.MessagingStyle.Message
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project7.repository.RepositoryMhs
import com.example.project7.data.entity.Mahasiswa
import kotlinx.coroutines.launch



//untuk menghandle atau memberikan nilai validasi apakah benar atau salah
data class FormErrorState(
    val nim: String? = null,
    val nama: String? = null,
    val jenisKelamin: String? = null,
    val alamat: String? = null,
    val kelas: String? = null,
    val angkatan: String? = null,
){
    fun isValid(): Boolean{
        return nim == null && nama == null && jenisKelamin == null &&
                alamat == null && kelas == null && angkatan == null
    }
}

//menyimpan input form ke dalam entity
//event adalah aksi
//state adalah hasil dari event
fun MahasiswaEvent.toMahasiswaEntity(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    jenisKelamin = jenisKelamin,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan
)

//data class variable yang menyimpan data input form
data class MahasiswaEvent(
    val nim: String = " ",
    val nama: String = " ",
    val jenisKelamin: String = " ",
    val alamat: String = " ",
    val kelas: String = " ",
    val angkatan: String = " ",
)