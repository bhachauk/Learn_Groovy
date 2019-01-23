## Map
---

**Simple Map Init :**

```groovy
Map m = [:]
```

### Adding Elements
---

```groovy
Map avengers = [:]
avengers["Iron Man"] = "Robert Downy Jr"
avengers["Hulk"] = "Mark Ruffalo"
avengers["Doctor Strange"] = "Benedict Cumberbatch"
```

### Map Each
---

```groovy
avengers.each{
    println it.key + ' --- '+ it.value
}
```

**Or**

```groovy
avengers.each{key, val ->
    println key + ' --- '+ val
}
```

```groovy
avengers.a.eachWithIndex{a,b -> 
    println a.key + ' ---- '+ a.value + ' -- '+ b
}
```

```groovy
avengers.a.eachWithIndex{a,b,c -> 
    println a + ' ---- '+ b + ' -- '+ c
}
```


#### MAP Operations: 
---

1. Filter by Keys list

```groovy
def a=[1:"a", 2:"b"]; 
a =a.subMap([1]); 
println a
```