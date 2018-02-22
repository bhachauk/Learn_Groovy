#### JAVA PACKAGING
This session will refresh you about the **JAVA pACKAGING**. Let's start with the example scenario,

##### STEPS :

 - Create file `A.class` in the directory `./pack`.
 ```
package pack;
public class A {
    public static String NAME = "this is A";
}
 ```
 - Create file `B.class` in the directory `./pack1`.
 ```
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
 java testpackage.TestPackageClass
 ```
