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