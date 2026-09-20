import java.rmi.*; 
public interface StringAnalyzer extends Remote { 
int countCharacters(String str) 
throws RemoteException; 
} 
