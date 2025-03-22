package com.example.e_book.di

import com.example.e_book.repo.repo
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HiltModule {

    @Provides
    @Singleton
    fun provideFirebaseService(): FirebaseDatabase {

        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideRepo(firebaseDatabase: FirebaseDatabase): repo {
        return repo(firebaseDatabase)
    }
}