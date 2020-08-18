package com.mathe.core.interactors

import java.text.SimpleDateFormat
import java.util.*

fun Date.getDatePast(day:Int = 0): Date = Calendar.getInstance().apply {
    add(Calendar.DATE, -day)
}.time

fun Date.americaPattern(): String {
    return SimpleDateFormat("MM/dd/yyyy", Locale("GMT-3")).apply {
    }.format(this)
}