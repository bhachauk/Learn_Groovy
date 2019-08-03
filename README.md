<p align="center">
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Groovy-logo.svg/614px-Groovy-logo.svg.png"/>
</p>

# Learn_Groovy

### What is Groovy ?
As Python, Groovy is also a **Dynamic language**  and the superset of java. 
The syntax of groovy is also like python and an advantage it doesn't need indentation.
Normal JAVA JVM is used to compile groovy scripts with a single jar `groovy-all.jar`.

```
java -cp .:groovy-2.4.13.jar groovy.ui.GroovyMain Code.groovy
```

A Groovy script can be run by `java` by adding classpath like shown above code.
Refer More with the official [Groovy doc](http://groovy-lang.org/documentation.html).

### How to setup in local ?

Download the latest [Groovy binary](http://groovy-lang.org/download.html#distro) from the official page.
**Unzip:**
```$xslt
unzip apache-groovy-binary-*.*.*.zip
```
Place this code on `~/.bashrc` or run directly on console.

**Environment**
```$xslt
export GROOVY_HOME=/path/to/uzip
export PATH=$PATH:$GROOVY_HOME/bin
```

### How to run this Dynamic java ?
Normal print line code like `print` by PYTHON, can be executed from the file `hello.groovy`,

```groovy
println "Hello_world"
```
To run this code execute the cli command,

```sh
groovy hello.groovy
```
### How to Package this ?

```groovy
// File: Sample.groovy
package io.github.bhanuchander210.learnGroovy
println 'Hello from Groovy'
```
Initially This packages should be compiled from the command `groovyc` and it can be run from `java` like shown below.

```exec
$ groovyc Sample.groovy
$ java -cp .:$GROOVY_HOME/embeddable/groovy-all-1.6.5.jar io.github.bhanuchander210.learnGroovy.Sample
Hello from Groovy
```
For Groovy and Java Packaging discussed inside the [Chapter 1. Basic Initiatives/GROOVY-JAVA](/Chapter_1%20-%20Basic_Initiatives/JAVA-GROOVY/README.md)

Thanks to :

- [groovydoc](http://groovy-lang.org/documentation.html)
- [haki](http://mrhaki.blogspot.in/)


##### Notes :
---

This repository may covers simple basic areas. I am collecting these areas with quick 
understandable code-snippets, whenever i have free times. If any area not covered it will be updated or
help me to improve this repo by your contribution.
