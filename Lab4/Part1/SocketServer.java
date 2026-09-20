import java.io.*; 
import java.net.*; 
public class SocketServer { 
public static void main(String[] args) { 
int port = 5000; 
try { 
// Create server socket 
ServerSocket serverSocket = 
                    new ServerSocket(port); 
 
            System.out.println( 
                    "Server started..."); 
             
            System.out.println( 
                    "Waiting for client connection..."); 
 
            // Accept client connection 
            Socket socket = 
                    serverSocket.accept(); 
 
            System.out.println( 
                    "Client connected."); 
 
            // Create input stream 
            BufferedReader input = 
                    new BufferedReader( 
                            new InputStreamReader( 
                                    socket.getInputStream())); 
 
            // Create output stream 
            PrintWriter output = 
                    new PrintWriter( 
                            socket.getOutputStream(), 
                            true); 
 
            // Receive message 
            String message = 
                    input.readLine(); 
 
            System.out.println( 
                    "Client says: " + message); 
 
            // Send response 
            output.println( 
                    "Message received successfully by Server."); 
 
            // Close resources 
            input.close(); 
            output.close(); 
            socket.close(); 
            serverSocket.close(); 
 
        } catch (IOException e) { 
 
            System.out.println( 
                    "Server Error: " + e); 
        } 
    } 
}