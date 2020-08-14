package com.example.navigation.utils

import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

fun Fragment.navigate(directions: NavDirections) = try {
    findNavController().navigate(directions)
} catch (e: Exception) {
    e.printStackTrace()
}

inline fun <reified T : NavArgs> Fragment.navValue(): T {
    return navArgs<T>().value
}