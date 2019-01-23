#### Loops - Quick book
<hr>

###### Introduction:

Generating quick list of common utils.

```groovy
alphabets = 'a'..'z'

alphabetsMap = alphabets.withIndex().collectEntries{val,id -> id+=1;["$id":val]}

numbers = 1..10

println alphabets

println alphabetsMap

println numbers
```


###### For loops:
<hr>
Quick Iterate between two numbers. 

Style 1:
```groovy
5.upto(10){

	println it
}
```

Style 2:
```groovy
for (letter in alphabets){

	println letter
}
```
Style 3:

```groovy
for (String letter : alphabets)
{
	println letter
}
```

Style 4:

```groovy
10.times{
	println 'Iteration : '+ it
}
```

Ref : [link](http://grails.asia/groovy-for-loop-examples)