package com.example.challengelima

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.challengelima.database.user.User
import com.example.challengelima.database.user.UserDatabaseDao

@Database(entities = [User::class], version = 3, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {

    abstract val userDatabaseDao: UserDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getInstance(context: Context): MainDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            MainDatabase::class.java,
                            User.TABLE_NAME
                    )
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}