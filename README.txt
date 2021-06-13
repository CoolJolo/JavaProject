## Getting Started

https://www.geeksforgeeks.org/multithreaded-servers-in-java/ 

Client-Side Program:A client can communicate with a server using this code. This involves 
   1. Establish a Socket Connection 
   2. Communication 
Server-Side Program:When a new client is connected, and he sends the message to the server. 
1. Server class:The steps involved on the server side are similar to the articleSocket Programming in Javawith a slight change to create the thread object after obtaining the streams and port number. 
    Establishing the Connection:Server socket object is initialized and inside a while loop a socket object continuously accepts an incoming connection. 
    Obtaining the Streams:Theinputstreamobject andoutputstreamobject is extracted from the current requests socket object. 
    Creating a handler object:After obtaining the streams and port number, a new clientHandler object (the above class) is created with these parameters. 
    Invoking thestart()method:The start() method is invoked on this newly created thread object. 
2. ClientHandler class:As we will be using separate threads for each request, lets understand the working and implementation of theClientHandlerclass implementing Runnable. An object of this class acts as a Runnable target for a new thread. 
    First, this class implements Runnable interface so that it can be passed as aRunnabletarget while creating a newThread. 
    Secondly, the constructor of this class takes a parameter, which can uniquely identify any incoming request, i.e. aSocket. 
    Inside therun()method of this class, it reads the clients message and replies. 
Steps: 
    Compile both Client and Server programs. 
    Run the server first and then the Client. 

