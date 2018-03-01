def s = new Socket("localhost", 10000);

s.withStreams { inStream, outStream ->

  // This is the chat area 

  outStream << "Hello test server"  // Sending messages
  
  println (inStream.newReader().readLine()) // Reading messages

}
