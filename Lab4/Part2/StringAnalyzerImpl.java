import java.rmi.*; 
import java.rmi.server.*; 
public class StringAnalyzerImpl extends UnicastRemoteObject 
implements StringAnalyzer { 
public StringAnalyzerImpl() 
throws RemoteException { 
super(); 
} 
@Override 
public int countCharacters(String str) 
throws RemoteException { 
return str.length(); 
} 
}