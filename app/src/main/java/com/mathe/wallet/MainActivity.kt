        package com.mathe.wallet

        import androidx.appcompat.app.AppCompatActivity
        import android.os.Bundle
        import androidx.navigation.Navigation
        import androidx.navigation.findNavController

        class MainActivity : AppCompatActivity() {
            private val navController by lazy { findNavController(R.id.navigate) }

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
            }

            override fun onSupportNavigateUp(): Boolean {
                return navController.navigateUp() || super.onSupportNavigateUp()
            }

            override fun onBackPressed() {

                when (Navigation.findNavController(this, R.id.mainContainer).currentDestination?.id) {
                    R.id.homeFragment, R.id.loginFragment, R.id.congratulationsFragment -> {

                    }
                    else -> {
                        super.onBackPressed()
                    }
                }
            }
        }