package com.mathe.coreandroid

import androidx.room.Room
import com.mathe.coreandroid.datasource.local.RoomTransactionDataSource
import com.mathe.coreandroid.datasource.local.RoomUserDataSource
import com.mathe.coreandroid.datasource.local.RoomWalletDataSource
import com.mathe.coreandroid.datasource.remote.RemoteQuotationDataSource
import com.mathe.coreandroid.db.WalletDataBase
import com.mathe.coreandroid.remote.api.BitcoinMarketApi
import com.mathe.coreandroid.remote.api.CentralBankApi
import com.mathe.data.repository.local.TransactionRepository
import com.mathe.data.repository.local.UserRepository
import com.mathe.data.repository.local.WalletRepository
import com.mathe.data.repository.remote.QuotationRepository
import com.mathe.data.usercasehome.*
import com.mathe.data.usercaselogin.*
import com.mathe.domain.datasource.QuotationsDataSource
import com.mathe.domain.datasource.TransactionDataSource
import com.mathe.domain.datasource.UserDataSource
import com.mathe.domain.datasource.WalletDataSource
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val MARKET_BITCOIN = "MARKET_BITCOIN"
const val CENTRAL_BANK = "CENTRAL_BANK"

val coreApiModules = module {
    factory { get<Retrofit>(MARKET_BITCOIN.toQualifier()).create(BitcoinMarketApi::class.java) }
    factory { get<Retrofit>(CENTRAL_BANK.toQualifier()).create(CentralBankApi::class.java) }
    single(MARKET_BITCOIN.toQualifier()) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.MARKET_BITCOIN_URL)
            .addConverterFactory(get())
            .build()
    } bind Retrofit::class

    single(CENTRAL_BANK.toQualifier()) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.CENTRAL_BANK_URL)
            .addConverterFactory(get())
            .build()
    } bind Retrofit::class

    single {
        GsonConverterFactory.create()
    } bind Converter.Factory::class


    //room
    single {
        Room.databaseBuilder(get(), WalletDataBase::class.java, "database")
            .build()
    } bind WalletDataBase::class

    factory { get<WalletDataBase>().userDao() }

    factory { get<WalletDataBase>().walletDao() }

    factory { get<WalletDataBase>().transactionDao() }

    factory<UserDataSource> {
        RoomUserDataSource(
            userDao = get()
        )
    }
    factory<WalletDataSource> {
        RoomWalletDataSource(
            walletDao = get()
        )
    }

    factory<TransactionDataSource> {
        RoomTransactionDataSource(transactionDao = get())
    }


    factory { RegisterUser(userRepository = get()) }

    factory { AuthenticateUser(userRepository = get()) }

    factory { UserRepository(userDataSource = get()) }

    factory { GetActiveUser(userRepository = get()) }

    factory { Login(userRepository = get()) }

    factory { Logout(userRepository = get()) }

    factory { FindUserId(userRepository = get()) }

    factory {SalveTransaction(transactionRepository = get())}

    factory { GetAllTransactions(get()) }

    factory { WalletRepository(get()) }

    factory {
        GetWallet(get())
    }
    factory {
        CreateNewWallet(get())
    }
    factory<QuotationsDataSource> {
        RemoteQuotationDataSource(
            bitcoinMarketApi = get(),
            centralBankApi = get()
        )
    } bind RemoteQuotationDataSource::class


    factory {
        QuotationRepository(
            quotationsDataSource = get()
        )
    }
    factory {
        GetQuotationBitcoin(
            quotationRepository = get()
        )
    } bind GetQuotationBitcoin::class
    factory {
        GetQuotationDollar(
            quotationRepository = get()
        )
    } bind GetQuotationDollar::class

    factory {
        UpdateWallet(get())
    }
    factory {
        TransactionRepository(transactionDataSource = get())
    }
}


fun String.toQualifier() = named(this)