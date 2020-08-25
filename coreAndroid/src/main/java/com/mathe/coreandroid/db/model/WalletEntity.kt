package com.mathe.coreandroid.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mathe.coreandroid.db.DBConst

@Entity(
    tableName = DBConst.Wallet.TABLE,
     foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = [DBConst.USER.COLUMNS.ID],
        childColumns = [DBConst.Wallet.COLUMNS.USER_ID],
        onDelete = ForeignKey.NO_ACTION
    )
    ]
)
class WalletEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBConst.Wallet.COLUMNS.ID)
    val id: Long = 0,
    @ColumnInfo(name = DBConst.Wallet.COLUMNS.USER_ID)
    val userId: Long,
    @ColumnInfo(name = DBConst.Wallet.COLUMNS.BRITTA)
    val britta: Double,
    @ColumnInfo(name = DBConst.Wallet.COLUMNS.REAL)
    val real: Double,
    @ColumnInfo(name = DBConst.Wallet.COLUMNS.BITCOIN)
    val bitcoin: Double
)