#### List Basic :<br>
```groovy
list.each { println it}        // Iterates
list.any { it instanceof String }    // Return boolean
list.retainAll { it instanceof String } // Return filtered list
list.removeIf { it==null } // Return filtered list
if(list1.any{val1-> list2.contains(val1)}) // list check list

```
##### List Basic Methods : <br>
```groovy

// Used to change the instance of list elements

List<Integer> changeToInt (List<Object> input)
{
	return input.collect { it=it.toInteger()}
}
```

### Group By:
---

```groovy
// Used to Group by a List

Map groupby (List<Object> fieldvalues)
{
	def groupbymap = fieldvalues.inject([:]) { groupbymap, x -> if (!groupbymap[x]) groupbymap[x] = 0; groupbymap[x] += 1; groupbymap }
}

//Simple Way :

a = [1,2,3,1,1,2]

a.groupBy().collect{k,v -> ["$k" : v.size()]}

```

#### Sorting With Space_Ship :rocket: Operator :
<pre> In List Sort Example : </pre>
```groovy
[4, 2, 1, 3].sort{ a, b -> a <=> b }
```
