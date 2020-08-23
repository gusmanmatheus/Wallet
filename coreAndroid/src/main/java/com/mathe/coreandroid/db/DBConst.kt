package com.mathe.coreandroid.db

class DBConst {
    object USER {
        const val TABLE = "USER"

        object COLUMNS {
            const val ID = "ID"
            const val NAME = "NAME"
            const val USERNAME = "USERNAME"
            const val PASSWORD = "PASSWORD"
            const val ACTIVE = "ACTIVE"
        }
    }

    object Wallet {
        const val TABLE = "WALLET"

        object COLUMNS {
            const val ID = "ID"
            const val BITCOIN = "BITCOIN"
            const val BRITTA = "BRITTA"
            const val REAL = "REAL"
            const val USER_ID = "USER_ID"
        }
    }

    object TRANSACTION {
        const val TABLE = "TRANSACTION"

        object COLUMNS {
            const val BUY_TYPE = "BUY_TYPE"
            const val BUY_VALUE = "BUY_VALUE"
            const val SELL_TYPE = "SELL_TYPE"
            const val SELL_VALUE = "SELL_VALUE"
            const val DATE = "DATE"
            const val USER_ID = "USER_ID"
        }
    }

}