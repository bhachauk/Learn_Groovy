#### CHAPTER 1 : GROOVY BASICS
---
 
:green_book: Initiative codes :octocat:
<ol>
<li>HelloWorld</li><pre>Traditional Start with printing "Hello World"</pre>
<li>Dir_File_Display</li><pre>Displays all files in the directory</pre>
<li>Check_File</li><pre>Check a file is really in current directory</pre>
</ol>

#### String Index Basics : <br>
---

```
 assert 17 == './removehey/fshls/sfsl'.lastIndexOf('/')

 assert 17 == './removehey/fshls/sfsl'.indexOf('/',12)
```

#### MAP BASICS : 
---

1. Modify_Map
```groovy
map.keySet().each{ map[it]=map[it].minus(filter_list)}
```

#### Alphabets
---

```groovy
println (["a".."z"].join()) 
```

##### Output:
---
```text
[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
```