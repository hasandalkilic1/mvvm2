package eu.tutorials.mvvm2.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import eu.tutorials.mvvm2.data.entity.Person
import eu.tutorials.mvvm2.room.PersonDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonDaoRepository(var pDao:PersonDao) {

    var personList:MutableLiveData<List<Person>>
    init {
        personList= MutableLiveData()
    }

    fun connectAllPerson():MutableLiveData<List<Person>>{
        return personList
    }

    fun register(name:String,gsm:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val newPerson=Person(0,name,gsm)
            pDao.addPerson(newPerson)
        }
    }

    fun updatePerson(id:Int,name:String,gsm:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val updatedPerson=Person(id,name,gsm)
            pDao.updatePerson(updatedPerson)
        }
    }

    fun personSearch(searchWord:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
            personList.value = pDao.searchPerson(searchWord)
        }
    }

    fun personDelete(personId:Int){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val deletedPerson=Person(personId,"","")
            pDao.deletePerson(deletedPerson)
            getAllPerson()
        }
    }

    fun getAllPerson(){
        val job= CoroutineScope(Dispatchers.Main).launch {
            personList.value = pDao.getAllPerson()
        }

    }
}