import groovy.time.*
def timeStart = new Date()
// Some code you want to time
def timeStop = new Date()
TimeDuration duration = TimeCategory.minus(timeStop, timeStart)
println "Run Time : "+ duration
