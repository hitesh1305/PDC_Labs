import java.io.*; 
import java.net.*; 
public class SocketClient { 
public static void main(String[] args) { 
String serverAddress = "localhost"; 
int port = 5000; 
try { 
// Connect to server 
Socket socket = 
new Socket(serverAddress, port); 
System.out.println( 
"Connected to server."); 
// Create output stream 
PrintWriter output = 
new PrintWriter( 
socket.getOutputStream(), 
true); 
// Create input stream 
BufferedReader input = 
new BufferedReader( 
new InputStreamReader( 
socket.getInputStream())); 
// Send message 
output.println( 
"Hello Server, this is the Client."); 
// Receive response 
String response = 
input.readLine(); 
System.out.println( 
"Server Response: " + response); 
// Close resources 
output.close(); 
input.close(); 
socket.close(); 
} catch (IOException e) { 
System.out.println( 
"Client Error: " + e); 
} 
} 
}