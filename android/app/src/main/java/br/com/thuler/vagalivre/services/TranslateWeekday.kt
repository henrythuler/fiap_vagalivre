package br.com.thuler.vagalivre.services

import java.text.SimpleDateFormat
import java.util.Locale

//Key: Day, Value: Translated Day
val weekdayTextMap = mapOf(
    "Monday" to "Segunda-feira",
    "Tuesday" to "Terça-feira",
    "Wednesday" to "Quarta-feira",
    "Thursday" to "Quinta-feira",
    "Friday" to "Sexta-feira",
    "Saturday" to "Sábado",
    "Sunday" to "Domingo"
)

//Returning the translated day according to it's key (day)
fun translateWeekdayText(weekdayText: String): String {
    return weekdayTextMap[weekdayText] ?: weekdayText
}

//Converting the 12 hours format to 24 hours format
fun convertFormatHour(hour12: String): String {
    //Spliting the hour and the period (AM, PM)
    //NNBSP is a special character, because we don't have a common space between them
    val hourPeriod = hour12.split(" ")
    val hour = hourPeriod[0]
    val period = hourPeriod[1]

    //The 12 hours format
    val format12Hours = SimpleDateFormat("hh:mm a", Locale.getDefault())

    //Parsing it to the 24 hours format
    val hours24: String = SimpleDateFormat("HH:mm", Locale.getDefault())
        .format(format12Hours.parse("$hour $period")!!)
    return hours24
}

//Getting the whole hour interval (09:00 AM – 10:00 PM) and parsing it
fun convertHoursInterval(interval12hours: String): String {
    //Splitting each hour period
    val hours = interval12hours.split(" – ")
    val openHour = convertFormatHour(hours[0])
    val closeHour = convertFormatHour(hours[1])
    return "$openHour – $closeHour"
}