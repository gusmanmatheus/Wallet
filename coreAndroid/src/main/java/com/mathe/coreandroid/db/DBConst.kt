package com.mathe.coreandroid.db

class DBConst {
    object USER {
        const val TABLE = "USER"

        object COLUMNS {
            const val ID = "ID"
            const val NAME = "NAME"
            const val USERNAME = "USERNAME"
            const val PASSWORD = "PASSWORD"
            const val ACTIVE ="ACTIVE"
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

}