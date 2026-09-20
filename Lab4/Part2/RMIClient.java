import java.rmi.registry.*; 
 
public class RMIClient { 
 
    public static void main(String[] args) { 
 
        try { 
 
            // Connect to RMI Registry 
            Registry registry = 
                    LocateRegistry.getRegistry( 
                            "localhost", 
                            1099); 
 
            // Lookup remote object 
            StringAnalyzer analyzer = 
                    (StringAnalyzer) 
                    registry.lookup( 
                            "StringAnalyzer"); 
 
            // Invoke remote method 
            String text = 
                    "Parallel Computing"; 
 
            int result = 
                    analyzer.countCharacters(text); 
 
            System.out.println( 
                    "String: " + text); 
 
            System.out.println( 
                    "Number of Characters: " 
                    + result); 
 
        } catch (Exception e) { 
 
            System.out.println( 
                    "Client Error: " + e); 
        } 
    } 
} 