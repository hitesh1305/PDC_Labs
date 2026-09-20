import java.rmi.registry.*; 
public class RMIServer { 
public static void main(String[] args) { 
try { 
// Create remote object 
StringAnalyzerImpl obj = 
new StringAnalyzerImpl(); 
// Create RMI Registry 
Registry registry = 
LocateRegistry.createRegistry(1099); 
// Bind remote object 
registry.rebind( 
"StringAnalyzer", 
obj); 
System.out.println( 
"RMI Server is ready..."); 
} catch (Exception e) { 
System.out.println( 
"Server Error: " + e); 
} 
} 
}