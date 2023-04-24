package eu.tutorials.mvvm2.ui.vievmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.tutorials.mvvm2.data.repo.PersonDaoRepository
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(var pRepo:PersonDaoRepository): ViewModel() {


    fun updatePerson(id:Int,name:String,gsm:String){
        pRepo.updatePerson(id,name,gsm)
    }
}