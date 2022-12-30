package com.example.challengelima.database.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = User.TABLE_NAME)
data class User(
        @PrimaryKey(autoGenerate = true)
        var userId: Long = 0L,

        @ColumnInfo(name = "user_name")
        var userName: String = "Default Title",

        @ColumnInfo(name = "user_email")
        var userEmail: String = "Default Content",

        @ColumnInfo(name = "user_password")
        var userPassword: String = "Default Content",
){
        companion object{
                const val TABLE_NAME = "user_table"
        }
}