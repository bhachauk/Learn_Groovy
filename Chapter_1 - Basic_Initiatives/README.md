#### CHAPTER 1 : GROOVY BASICS  <br> 
:green_book: Initiative codes :octocat:
<ol>
<li>HelloWorld</li><pre>Traditional Start with printing "Hello World"</pre>
<li>Dir_File_Display</li><pre>Displays all files in the directory</pre>
<li>Check_File</li><pre>Check a file is really in current directory</pre>
</ol>

#### String Index Basics : <br>

```
 assert 17 == './removehey/fshls/sfsl'.lastIndexOf('/')

 assert 17 == './removehey/fshls/sfsl'.indexOf('/',12)
```

#### MAP BASICS : <br>
1. Modify_Map
```groovy
map.keySet().each{ map[it]=map[it].minus(filter_list)}
```
