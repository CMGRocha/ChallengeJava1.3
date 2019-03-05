# ChallengeJava1.3

This exercise focuses on the connection between two Java components, which act like a “client-server”, and in the concurrence between objects. 
In this way, the exercise should result into two main components: Component 1 and Component 2.

Component 1 should be composed by two parts: InputFrame and Sender_Converter. The InputFrame should read messages from the shell. 
Sender_Converter should convert each message and propagate it to Component 2.

Between the InputFrame and the Sender_Converter frames, a communication mechanism must exist based in a concurrent queue. 
It is expected that the InputFrame thread puts each received message in the queue. 
These messages should be detected and therefore consumed by the Sender_Converter thread. 
After reading each message, the Sender_Converter should convert it into an Hexadecimal message and sent it to Component 2 using a socket.

Component 2 will be responsible for the transformation of the Hexadecimal message into a plain text message and show it in the shell. 
After writing the output message, it should notify Component 1 that the message was shown, or not.

If necessary you can, or you should, add a complementary thread for the correct implementation of this exercise.
The implementation of this exercise must be done using Java 1.3.

https://imgur.com/p7MzIyF
