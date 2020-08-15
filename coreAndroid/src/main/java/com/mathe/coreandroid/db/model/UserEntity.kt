package com.mathe.coreandroid.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mathe.coreandroid.db.DBConst

@Entity(
    tableName = DBConst.USER.TABLE
 )
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = DBConst.USER.COLUMNS.USERNAME) val username: String,
    @ColumnInfo(name = DBConst.USER.COLUMNS.NAME) val name: String,
    @ColumnInfo(name = DBConst.USER.COLUMNS.PASSWORD) val password: String

)