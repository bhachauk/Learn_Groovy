#groovy
def x= ['/bin/sh','-c',/grep -o 'OSI Alarm : Resynchronization ...' in1.txt | wc -l/].execute().text.trim()
println x
