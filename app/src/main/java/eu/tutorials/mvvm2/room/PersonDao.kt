package eu.tutorials.mvvm2.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import eu.tutorials.mvvm2.data.entity.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    suspend fun getAllPerson():List<Person>

    @Query("SELECT * FROM person WHERE name like '%' || :searchWord || '%'")
    suspend fun searchPerson(searchWord:String):List<Person>

    @Insert
    suspend fun addPerson(person: Person)

    @Update
    suspend fun updatePerson(person: Person)

    @Delete
    suspend fun deletePerson(person:Person)
}