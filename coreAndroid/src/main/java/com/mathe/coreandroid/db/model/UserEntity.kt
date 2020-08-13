package com.mathe.coreandroid.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.mathe.coreandroid.db.DBConst

@Entity(
    tableName = DBConst.USER.TABLE,
    primaryKeys = [DBConst.USER.COLUMNS.USERNAME]
)
data class UserEntity(
    @ColumnInfo(name = DBConst.USER.COLUMNS.USERNAME) val username: String,
    @ColumnInfo(name = DBConst.USER.COLUMNS.NAME) val name: String,
    @ColumnInfo(name = DBConst.USER.COLUMNS.PASSWORD) val password: String

)