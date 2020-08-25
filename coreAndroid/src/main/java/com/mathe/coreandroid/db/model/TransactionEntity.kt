package com.mathe.coreandroid.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mathe.coreandroid.db.DBConst
import java.util.*

@Entity(
    tableName = DBConst.TRANSACTION.TABLE,
    foreignKeys = [ForeignKey(
        entity =
        TransactionEntity::class,
        parentColumns = [DBConst.USER.COLUMNS.ID],
        childColumns = [DBConst.TRANSACTION.COLUMNS.USER_ID],
        onDelete = ForeignKey.NO_ACTION
    )]

)
class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBConst.TRANSACTION.COLUMNS.ID)
    val id: Long = 0,
    @ColumnInfo(name = DBConst.TRANSACTION.COLUMNS.BUY_TYPE)
    val buyType: String,
    @ColumnInfo(name = DBConst.TRANSACTION.COLUMNS.BUY_VALUE)
    val buyValue: Double,
    @ColumnInfo(name = DBConst.TRANSACTION.COLUMNS.SELL_TYPE)
    val sellType: String,
    @ColumnInfo(name = DBConst.TRANSACTION.COLUMNS.SELL_VALUE)
    val sellValue: Double,
    @ColumnInfo(name = DBConst.TRANSACTION.COLUMNS.DATE)
    val date: String,
    @ColumnInfo(name = DBConst.TRANSACTION.COLUMNS.USER_ID)
    val userId: Long
)