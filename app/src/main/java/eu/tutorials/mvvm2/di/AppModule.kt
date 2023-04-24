package eu.tutorials.mvvm2.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import eu.tutorials.mvvm2.data.repo.PersonDaoRepository
import eu.tutorials.mvvm2.room.Database
import eu.tutorials.mvvm2.room.PersonDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonDaoRepository(pDao:PersonDao):PersonDaoRepository{
        return PersonDaoRepository(pDao)
    }

    @Provides
    @Singleton
    fun providePersonDao(@ApplicationContext context: Context):PersonDao{
        val db= Room.databaseBuilder(context,Database::class.java,"directory.sqlite")
            .createFromAsset("directory.sqlite").build()
        return db.getPersonDao()
    }
}