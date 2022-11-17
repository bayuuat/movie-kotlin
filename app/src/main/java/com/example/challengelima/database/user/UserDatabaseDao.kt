package com.example.challengelima.database.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDatabaseDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * from user_table WHERE user_email = :email AND user_password = :pass")
    fun get(email: String, pass: String): User?
}