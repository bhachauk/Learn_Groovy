// General Lists :

alphabets = 'a'..'z'

alphabetsMap = alphabets.withIndex().collectEntries{val,id -> id+=1;["$id":val]}

numbers = 1..10

// Quick Iterations

// Style 1:

5.upto(10){

    //println it
}

// Style 2:

for (letter in alphabets){

    //println letter
}

// Style 3:

for (String letter : alphabets)
{
    //println letter
}

10.times{
    //println 'Iteration : '+ it
}