
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

import sun.awt.image.BadDepthException;


public class BankMain extends JFrame{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Account acc;

	public static void main(String[] args) {
		
		JFrame SRBM = new JFrame("SR Bank Record Manager");
		
		SRBM.setSize(470,400);
		
		try {
			SRBM.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("dollar.jpg")))));
		} catch (IOException e2) {
			e2.printStackTrace(); 
		}
		
		SRBM.setLocation(350, 100);
		
		SRBM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SRBM.setLayout(new FlowLayout());	
		
		JLabel tt = new JLabel();
        tt.setText("WELCOME TO SR BANK RECORD MANAGER!");
        tt.setFont(new Font("Times New Roman", 3, 19));
        tt.setForeground(Color.BLACK);
        SRBM.add(tt);
		
		JButton Crac = new JButton();
		
		Crac.setText("Create Account");
		Crac.setFont(new Font("Times New Roman", 1, 18));
		Crac.setPreferredSize(new Dimension(200, 80));
		Crac.setBackground(Color.WHITE);
		SRBM.add(Crac);
		
		Crac.addActionListener(new ActionListener(){
			public JTextField AcHName;
			public JTextField uName;
			public JTextField uPass;
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame signup = new JFrame("Sign Up");
				signup.setSize(400,400);
				
				signup.setLocation(200, 0);
				
				//signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				signup.setLayout(new FlowLayout());
				
				JPanel acname = new JPanel();
				acname.setLayout(new FlowLayout());
				acname.add(new JLabel("Your Name:"));		
				AcHName = new JTextField(15);
				acname.add(AcHName);		
				signup.add(acname);
				
				JPanel uname = new JPanel();
				uname.add(new JLabel("Username:"));
				uName = new JTextField(15);
				uname.add(uName);
				signup.add(uname);
				
				JPanel upass = new JPanel();
				upass.add(new JLabel("Password:"));
				uPass = new JPasswordField(15);
				upass.add(uPass);
				signup.add(upass);
				
				JButton sub = new JButton();
				sub.setText("Submit");
				sub.setPreferredSize(new Dimension(150, 50));
				signup.add(sub);
				
				sub.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						String name = AcHName.getText();
						String username = uName.getText();
						String password = uPass.getText();
						acc = new Account(name, username, password);
						JOptionPane.showMessageDialog(null, "Congratulations !!!\nAccount Create Successfully");
						signup.setVisible(false);
					}
				});
				
				
				signup.setVisible(true);
			}
		});
		
		JFrame BB = new JFrame("SR Bank Record Manager");
		BB.setSize(470,400);
		
		try {
			BB.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("dollar.jpg")))));
		} catch (IOException e2) {
			e2.printStackTrace(); 
		}
		
		BB.setLocation(350, 100);
		BB.setLayout(new FlowLayout());	
		
		JLabel tt2 = new JLabel();
        tt2.setText("WELCOME TO SR BANK RECORD MANAGER!");
        tt2.setFont(new Font("Times New Roman", 1, 19));
        tt2.setForeground(Color.BLACK);
        BB.add(tt2);
		
		JButton depo = new JButton();
		depo.setText("Deposit");
		depo.setFont(new Font("Times New Roman", 1, 19));
		depo.setBackground(Color.WHITE);
		depo.setPreferredSize(new Dimension(200, 80));
		BB.add(depo);
		
		depo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try 
				{
					String balance;
			
					balance = JOptionPane.showInputDialog(null, "Enter Amount to Deposit: ");
					double amount = Double.parseDouble(balance);
					acc.deposit(amount);
				}
				catch(NumberFormatException | NullPointerException nfe1)
				{
					JOptionPane.showMessageDialog(null, nfe1, "Error", 2);
				}
			}
			
		});
		
		JButton wdraw = new JButton();
		wdraw.setText("Withdraw");
		wdraw.setFont(new Font("Times New Roman", 1, 19));
		wdraw.setBackground(Color.WHITE);
		wdraw.setPreferredSize(new Dimension(200, 80));
		BB.add(wdraw);
		
		wdraw.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				   try
		           {
		               String num;
		               num = JOptionPane.showInputDialog(null, "Enter a Amount To Withdraw:", "Withdraw Amount", 1);
		               double num1 = Double.parseDouble(num);
		               acc.withdraw(num1);
		           }
		           catch(BadDepthException | NumberFormatException | NullPointerException ex)
		           {
		               JOptionPane.showMessageDialog(null, ex, "Error", 2);
		           } catch (Exception e1) {
		        	   e1.printStackTrace();
				}
			}
			
		});
		
		JButton checkb = new JButton();
		checkb.setText("Check Balance");
		checkb.setFont(new Font("Times New Roman", 1, 19));
		checkb.setBackground(Color.WHITE);
		checkb.setPreferredSize(new Dimension(400, 80));
		BB.add(checkb);
		
		checkb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				double amnt = acc.getBalance();
				
				JOptionPane.showMessageDialog(null, "Your current balance is: " + amnt);
				}catch(NullPointerException ex){
					JOptionPane.showMessageDialog(null, ex, "Error", 2);
				}
				
			}
			
		});
		
		JButton ex2 = new JButton();
		ex2.setText("Log Out");
		ex2.setFont(new Font("Times New Roman", 1, 15));
		ex2.setBackground(Color.WHITE);
		ex2.setPreferredSize(new Dimension(100, 80));
		BB.add(ex2);
		
		ex2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);	
				SRBM.setVisible(true);
				BB.setVisible(false);
			}									
		});

		
		JButton login = new JButton();
		login.setText("Log In");
		login.setFont(new Font("Times New Roman", 1, 19));
		login.setPreferredSize(new Dimension(200, 80));
		login.setBackground(Color.WHITE);
		login.setForeground(Color.BLACK);
		SRBM.add(login);
		
		login.addActionListener(new ActionListener() {
				//public String username;
				//public String pass;

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame Login = new JFrame("Log In");
				Login.setSize(400,400);
				Login.setLocation(200, 0);
				Login.setLayout(new FlowLayout());
				
				JPanel uname = new JPanel();
				uname.add(new JLabel("Username:"));
				JTextField uName = new JTextField(15);
				uname.add(uName);
				Login.add(uname);
				
				JPanel upass = new JPanel();
				upass.add(new JLabel("Password:"));
				JPasswordField uPass = new JPasswordField(15);
				upass.add(uPass);
				Login.add(upass);
				
				JButton lgin = new JButton();
				lgin.setText("Submit");
				lgin.setPreferredSize(new Dimension(150, 40));
				Login.add(lgin);
				
				lgin.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						String username = uName.getText();
						@SuppressWarnings("deprecation")
						String password = uPass.getText();
						File file = new File("F:\\Cse215Project2\\ClientData.txt");
						
						try {
							Scanner infile = new Scanner(file);
							
							infile.useDelimiter("[\n]");
							int flag = 0;
							while(infile.hasNext()){
								String name = infile.next();
								String checkuser = infile.next();
								String checkpass = infile.next();
								//System.out.println(name + "\n" + username +"\n" + checkuser);
								
								if(username.trim().equals(checkuser.trim()) && password.trim().equals(checkpass.trim())){
									
									SRBM.setVisible(false);
									acc = new Account(name,username,password);									
									BB.setVisible(true);														
									flag = 0;
									//System.out.print("Done");
									Login.setVisible(false);
									break;									
								}
								
								else{
									flag = -1;
								}
							}
							if(flag == -1){
								JOptionPane.showMessageDialog(null,"Invalid Username Or Password");
								Login.setVisible(true);
							}
							
							infile.close();
														
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						
						//Login.setVisible(false);
					}
				});
				
				Login.setVisible(true);
				
			}
		});
				
		JButton me = new JButton();
		me.setText("About");
		me.setFont(new Font("Times New Roman", 1, 19));
		me.setPreferredSize(new Dimension(200, 80));
		me.setBackground(Color.WHITE);
		SRBM.add(me);
		
		me.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "SR Bank Record Manager\nDeveloped by: \nShahrear Rahman\n1610053642");
			}
			
		});
		
		JButton ex = new JButton();
		ex.setText("Exit");
		ex.setFont(new Font("Times New Roman", 1, 19));
		ex.setPreferredSize(new Dimension(100, 80));
		ex.setBackground(Color.WHITE);
		SRBM.add(ex);
		
		ex.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
			
		});
		
		SRBM.setVisible(true);
	}

}


