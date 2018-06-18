#### Integers

- byte
- short
- long
- char
- int

> Java only consider signed integers. The java developers thought unsigned integers are meaning less.

##### Types

###### Octal

Java picks the integer as **Octal** while it is declared with **0** in beginning like shown below.

```groovy
int octal_num = 07;
```

If you assign it as **08** It will rise error. To observe this,

```groovy
a = 017
b = 001
c = a+b

println Integer.toOctalString(c)
```

###### Hexa decimal

Also like Octal system, Hexa decimal can be declared as **0x** in the beginning of the number.

Example :

```groovy
a = 0x0015
b = 0x0001
c = a+b
println Integer.toHexString(c)
```

###### Binary

Simple example:

```groovy
int a = 0b0010_1000; 
assert a == 40
```

###### Note
<br>

> we can use **__** inside the integer to seperate decimals (Simply Ignored).

```groovy
int a = 100_100_500;
```

|Escape Sequence|Description|
|---------------|-----------|
|\ddd Octal character| (ddd)|
|\uxxxx | Hexadecimal Unicode character |(xxxx)|
|\' | Single quote|
|\" | Double quote|
|\\ | Backslash|
|\r | Carriage return|
|\n | New line (also known as line feed)|
|\f | Form feed|
|\t | Tab|
|\b | Backspace|