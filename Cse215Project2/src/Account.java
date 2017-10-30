
import java.io.*;

import javax.swing.JOptionPane;

import sun.awt.image.BadDepthException;

public class Account {

	private String name;
	private String username;
	private double acbalance;
	private String password;
	
	File datastore = new File("F:\\Cse215Project2\\ClientData.txt");
	
	public Account(String cname, String cusername, String cpassword){
		name = cname;
		username = cusername;
		password = cpassword;
		acbalance = 0.0;
		
		try (FileWriter myF = new FileWriter(datastore, true);
			BufferedWriter bw = new BufferedWriter(myF);
			PrintWriter fileinput = new PrintWriter(myF);)
		{
			fileinput.println(name);
			fileinput.println(username);
			fileinput.println(password);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//JOptionPane.showMessageDialog(null, "Congratulations !!!\nAccount Create Successfully");
		//System.out.println(name+username+password);
	}
	
	public void deposit(double amt)
    {
		
			acbalance = acbalance + amt;
   	 		JOptionPane.showMessageDialog(null,"Amount Deposited");
		
    }
	
    public void withdraw(double amt) throws Exception 
    {
   	 try
   	 { 
   	    if(acbalance >= amt)
   	    {
   		    acbalance = acbalance - amt;
   		    JOptionPane.showMessageDialog(null,"Amount Withdrawn");
   	    }
   	    else
   	    {
   		    throw new Exception("Could not Withdraw: Insufficent Amount.");
   	    }
   	 }
   	 catch(BadDepthException bae)
   	 {
             bae.printStackTrace();
        }
    }
	
	public double getBalance(){
		return acbalance;
	}
	
}
