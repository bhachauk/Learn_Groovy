#### CHAPTER 1 : GROOVY BASICS  <br> 
:green_book: Initiative codes :octocat:
<ol>
<li>HelloWorld</li><pre>Traditional Start with printing "Hello World"</pre>
<li>Dir_File_Display</li><pre>Displays all files in the directory</pre>
<li>Check_File</li><pre>Check a file is really in current directory</pre>
</ol>

#### List Basic :<br>
```groovy
list.each { println it}        // Iterates
list.any { it instanceof String }    // Return boolean
list.retainAll { it instanceof String } // Return filtered list
list.removeIf { it==null } // Return filtered list
```
#### SORTING WITH SPACE_SHIP :rocket: OPERATOR :
<pre> In List Sort Example : </pre>
```groovy
[4, 2, 1, 3].sort{ a, b -> a <=> b }
```
#### MAP BASICS : <br>
1. Modify_Map
```groovy
map.keySet().each{ map[it]=map[it].minus(filter_list)}
```
