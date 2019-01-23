# String
---

### Length
---

```groovy
assert 3 == "hai".size()
assert 3 == "hai".length()
```

### each
---

```groovy
"hai".each{println it}
```

```commandline
h
a
i
```

### toList()
---

```groovy
assert ["h","a", "i"] == "hai".toList()
```


### Using `split()` and `tokenize()`
---

My rule of thumb is to use **split()**. It does not mean
**tokenize()** is a bad method. But **tokenize()** needs
more care than **split()**.

There are **Three** key differences,
- `split()` returns **String[]** and `tokenize()` returns **List**.
- `tokenize` uses every character in given string as **delimiter**.
    So for one character both may looks same like shown below.
    ```groovy
    assert ["bh", "nuch", "nder"] == "bhanuchander".split("a")
    assert ["bh", "nuch", "nder"] == "bhanuchander".tokenize("a")
    ```
    
    But when we use multiple char in argument,
    ```groovy
    assert ["", "anuchander"] == "bhanuchander".split("bh")
    assert ["anuc","ander"] == "bhanuchander".tokenize("bh")
    ```
- Tokenize removes empty elements like `''` and `null`.
    ```groovy
    assert ["field1","field2","","field4"] == "field1,field2,,field4".split(",")
    assert ["field1","field2","field4"] == "field1,field2,,field4".tokenize(",")
    ```

### String Indexing
---

```
 assert 17 == './removehey/fshls/sfsl'.lastIndexOf('/')

 assert 17 == './removehey/fshls/sfsl'.indexOf('/',12)
```