##### Prerequisite  :

 - netcat
 - telnet
 
##### Steps :

 1. Initiate **netcat** in a logical Port of Machine A :
 ```sh
  nc -l 10000
 ```
 > Here 10000 is a logical Port. You can assign `2 ^ 16` Ports. But some are default ports already.
 > This means the service started over network on the port. A normal `man nc` briefs about it.
 
 2. Now Connect using **Telnet** from the Machine B (or) local machine (Machine A):
    
  - From another Machine like said (Machine B)
  ```sh
  telnet ip 10000
  ```
  - From local Machine
  ```sh
   telnet localhost 10000
  ```

##### Thats it ...! We Done

A simple TCP/IP Session has been implemented in a logical port and can read/write (Means Normal chat :)).

Using Groovy/Java you can implement a code to read/write for any requirments.

For simple snippets about this *Socket Programming* , view my [Learn_Groovy](https://github.com/Bhanuchander210/Learn_Groovy/tree/master/Chapter_1%20-%20Basic_Initiatives/Socket) repo.
