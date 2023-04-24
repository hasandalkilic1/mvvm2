package eu.tutorials.mvvm2.ui.vievmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.tutorials.mvvm2.data.entity.Person
import eu.tutorials.mvvm2.data.repo.PersonDaoRepository
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor (var pRepo:PersonDaoRepository):ViewModel() {
    var personList= MutableLiveData<List<Person>>()
    init {
        getAllPerson()
        personList=pRepo.connectAllPerson()
    }

    fun search(searchWord:String){
        pRepo.personSearch(searchWord)
    }

    fun personDelete(personId:Int){
        pRepo.personDelete(personId)
    }

    fun getAllPerson(){
        pRepo.getAllPerson()
    }
}