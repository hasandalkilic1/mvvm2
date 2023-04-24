package eu.tutorials.mvvm2.ui.vievmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.tutorials.mvvm2.data.repo.PersonDaoRepository
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(var pRepo:PersonDaoRepository): ViewModel() {


    fun register(name:String,gsm:String){
        pRepo.register(name,gsm)
    }
}