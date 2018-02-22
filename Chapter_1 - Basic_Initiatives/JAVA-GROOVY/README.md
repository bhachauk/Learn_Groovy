#### JAVA PACKAGING
This session will refresh you about the **JAVA Packaging**. Let's start with the example scenario,

##### STEPS :

 - Create file `A.java` in the directory `./pack`.
 ```java
package pack;
public class A {
    public static String NAME = "this is A";
}
 ```
 - Create file `B.java` in the directory `./pack1`.
 ```java
 package pack1;

import pack.A;

public class B {

	public static String NAME = "this is B";

    public static void main(String[] args) {

        System.out.println("Now accessing " + A.NAME);
        
    }
}
```
 - If do `ls` , Output will be,
 ```
 pack  pack1
 ```
 - Then Compile the java files,
 ```
 javac pack\*.java
 javac pack1\*.java
 ```
 - After the successful compilation, 
 ```
 java pack1.B
 ```
 #### GROOVY PACKAGING
 
 ##### STEPS :

 - Create file `A.groovy` in the directory `./groovypack`.
 ```groovy
package groovypack;

name = 'This is A'
 ```
 - Create file `B.groovy` in the directory `./groovypack`.
 ```groovy
package groovypack;

name = 'This is B'
```

 - Create file `C.groovy` in the directory `./groovypack`.
 ```groovy
package groovypack;

import groovypack.A

import groovypack.B

println 'This is imported A :'+A.name

println 'This is imported B :'+B.name
```
 - If do `ls` , Output will be,
 ```
 groovypack
 ```
 - Then Compile the java files,
 ```
 groovyc groovypack\*.java
 ```
 - After the successful compilation, You can execute this class using `groovy-all-2.4.13.jar`
 ```
 java -cp .:groovy-all-2.4.13.jar groovypack.C
 ```
