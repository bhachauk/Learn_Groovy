//groovy
def x= ['/bin/sh','-c',/grep -o 'OSI Alarm : Resynchronization ...' in1.txt | wc -l/].execute().text.trim()
println x

// Meta class with shell command execution.
List.metaClass.cmdexecute
{  List inp->
   println inp.execute().text
}

void execute (List cmd)
{
  println cmd.execute().text
}
