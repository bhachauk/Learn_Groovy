/*
Understanding the date time utils
 */

// Today
Date today = new Date()

// Today Formatted
println today.format("dd-MM-yyyy")

// Getting day/month/year/hour/minute sepeartely

println "Day     : " + today.date
println "Month   : " + (today.month + 1)
println "Year    : " + (today.year + 1900)
println "Hours   : " + today.hours
println "Minutes : " + today.minutes

// Previous day
println today - 1

// previous week
println today - 7