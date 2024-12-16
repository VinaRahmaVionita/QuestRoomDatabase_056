package com.example.project7.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project7.data.entity.Mahasiswa
import com.example.project7.repository.RepositoryMhs
import com.example.project7.ui.navigation.DestinasiUpdate
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UpdateMhsViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: RepositoryMhs
) :ViewModel() {
   var updateUIState by mutableStateOf(MhsUIState())
       private set

   private val _nim: String = checkNotNull(savedStateHandle[DestinasiUpdate.NIM])

    init {
        viewModelScope.launch {
            updateUIState = repositoryMhs.getMhs(_nim)
                .filterNotNull()
                .first()
                .toUIStateMhs()
        }
    }

    fun updateState(mahasiswaEvent: MahasiswaEvent){
        updateUIState = updateUIState.copy(
            mahasiswaEvent = mahasiswaEvent,
        )
    }

    fun validasiFields() : Boolean {
        val event = updateUIState.mahasiswaEvent
        val errorState = FormErrorState(
            nim = if (event.nim.isNotEmpty()) null else "NIM tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            jenisKelamin = if (event.jenisKelamin.isNotEmpty()) null else "Jenis Kelamin tidak boleh kosong",
            alamat = if (event.alamat.isNotEmpty()) null else "alamat tidak boleh kosong",
            kelas = if (event.kelas.isNotEmpty()) null else "kelas tidak boleh kosong",
            angkatan = if (event.angkatan.isNotEmpty()) null else "angkatan tidak boleh kosong",
        )

        updateUIState = updateUIState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    suspend fun updateData () {
        val currentEvent = updateUIState.mahasiswaEvent
        if(validasiFields()) {
            try {
                repositoryMhs.updateMhs(currentEvent.toMahasiswaEntity())
                updateUIState = updateUIState.copy(
                    snackBarMessage = "Data berhasil diupdate",
                    mahasiswaEvent = MahasiswaEvent(),
                    isEntryValid = FormErrorState()
                )
                println("snackBarMessage diatur: ${updateUIState.
                        snackBarMessage}")
            } catch(e: Exception) {
                updateUIState = updateUIState.copy(
                    snackBarMessage = "Data gagal di update"
                )
            }
        }else {
            updateUIState = updateUIState.copy(
                snackBarMessage = "Data Gagal diupdate"
            )
        }
    }

    fun resetSnackBarMessage() {
        updateUIState = updateUIState.copy(snackBarMessage = null)
    }
}

fun Mahasiswa.toUIStateMhs(): MhsUIState = MhsUIState(
    mahasiswaEvent = this.toDetailUiEvent(),
)
