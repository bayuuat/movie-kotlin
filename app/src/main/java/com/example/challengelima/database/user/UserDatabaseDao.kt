package com.example.challengelima.database.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDatabaseDao {

    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Query("SELECT * from user_table WHERE user_email = :email AND user_password = :pass")
    fun get(email: String, pass: String): User?

    @Query("SELECT * from user_table WHERE userId = :id")
    fun getUserbyId(id: Long): User?
}