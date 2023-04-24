package eu.tutorials.mvvm2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import eu.tutorials.mvvm2.data.entity.Person

@Database(entities = [Person::class], version = 1)
abstract class Database:RoomDatabase() {
    abstract fun getPersonDao():PersonDao
}