package Final;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class Adminlogin extends JFrame implements ActionListener{
    
    General e = new General();
    File f = new File("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine");
    String Username, Password;
    int ln;

    JFrame jfram = new JFrame("ADMIN LOGIN");
    JLabel signup;
    JLabel username;
    JLabel password;
    JTextField usr;
    JPasswordField pass;
    JCheckBox showPass = new JCheckBox ("Show Password");
    JButton login;
    JButton clr;
    JButton add;
    JButton back;
    JPanel halflog;
    
    Adminlogin(){
        initComponents();
    }

    void initComponents(){
        jfram.setSize(950,600);    //size of the frame
        jfram.setResizable(false);
        jfram.getContentPane().setBackground(new Color(100,225,225));    //color of the frame
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/logo.jpg");    //giving image path to image object
        jfram.setIconImage(imageIcon.getImage());  //setting icon on frame

        ImageIcon backimg = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/halfimg.jpg");    //giving image path to image object
        Image finalhalf = backimg.getImage();
        Image finalimg = finalhalf.getScaledInstance(600, 600,6);
        backimg = new ImageIcon (finalimg);
        jfram.setIconImage(backimg.getImage());  //setting icon on frame

        JLabel halfimage = new JLabel("",backimg,JLabel.CENTER); //creating a label for background
        halfimage.setBounds(0,0,475, 600);  //resizing the image to its frame size
        jfram.add(halfimage); //adding background image
        
        halflog = new JPanel();
        halflog.setBackground(new Color(0,0,0,20));
        halflog.setBounds(540,60,319,450); 
        //heading.setBounds(0,0,950,100); 
        jfram.add(halflog); 

        ImageIcon signupIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/signup.png");
        Image imgadmin = signupIcon.getImage();
        Image signupLogo = imgadmin.getScaledInstance(70,67,6);
        signupIcon = new ImageIcon (signupLogo);

        signup = new JLabel("Sign Up",signupIcon,JLabel.CENTER);
        signup.setHorizontalTextPosition(JLabel.LEFT);
        signup.setFont(new Font("Cambria",Font.BOLD,35));
        signup.setForeground(Color.BLACK);
        halflog.add(signup);

        username = new JLabel("Username");
        username.setFont(new Font("Cambria",Font.PLAIN,20));
        username.setForeground(Color.BLACK);
        username.setBounds(570,150,100,30);
        jfram.add(username);

        password = new JLabel("Password");
        password.setFont(new Font("Cambria",Font.PLAIN,20));
        password.setForeground(Color.BLACK);
        password.setBounds(570,250,100,30);
        jfram.add(password);

        usr = new JTextField();
        usr.setPreferredSize(new Dimension(240,40));
        usr.setBounds(570,190,240,40);
        jfram.add(usr);

        pass = new JPasswordField();
        pass.setEchoChar('*');
        pass.setPreferredSize(new Dimension(240,40));
        pass.setBounds(570,290,240,40);
        jfram.add(pass);

        login = new JButton("LOGIN");
        login.setBounds(570,400,100,30); //setting location
        login.setFont(new Font("Cambria",Font.BOLD,20));
        login.setBackground(new Color(0,214,255));
        login.setForeground(Color.BLACK);
        login.setBorder(BorderFactory.createSoftBevelBorder(900));
		login.setFocusable(false);
		login.addActionListener(this);
        jfram.add(login);  //adding to frame

        add = new JButton("REGISTER");
        add.setBounds(700,400,100,30);
        add.setFont(new Font("Cambria",Font.BOLD,20));
        add.setBackground(new Color(0,214,255));
        add.setForeground(Color.BLACK);
        add.setBorder(BorderFactory.createSoftBevelBorder(900));
        add.setFocusable(false);
		add.addActionListener(this);
        jfram.add(add);

        back = new JButton("BACK");
        back.setBounds(700,460,100,30); //setting location
        back.setFont(new Font("Cambria",Font.BOLD,20));
        back.setBackground(new Color(0,214,255));
        back.setForeground(Color.BLACK);
        back.setBorder(BorderFactory.createSoftBevelBorder(900));
		back.setFocusable(false);
		back.addActionListener(this);
        jfram.add(back);

        clr = new JButton("CLEAR");
        clr.setBounds(570,460,100,30); //setting location
        clr.setFont(new Font("Cambria",Font.BOLD,20));
        clr.setBackground(new Color(0,214,255));
        clr.setForeground(Color.BLACK);
        clr.setBorder(BorderFactory.createSoftBevelBorder(900));
		clr.setFocusable(false);
		clr.addActionListener(this);
        jfram.add(clr);

        showPass.setBounds(570,345,150,30); 
        showPass.setBackground(new Color(0,214,255));
        showPass.setFont(new Font("Cambria",Font.BOLD,14));
        showPass.setForeground(Color.BLACK);
        showPass.setFocusable(false);
        jfram.add(showPass);
        showPass.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent E){
                if (showPass.isSelected()){
                    pass.setEchoChar((char)0);
                }
                else{
                    pass.setEchoChar('*');
                }
            }
        });

        this.pack();
        jfram.setLayout(null);
        jfram.setVisible(true);
        jfram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //should close
    }

    void createFolder(){
        if (!f.exists()){
            f.mkdirs();
        }
    }

    void readFile(){
        try {
            FileReader fr =  new FileReader(f+"\\adminLogins.txt");
            System.out.println("File exists");
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter(f+"\\adminLogins.txt");
                System.out.println("File created");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    void addData(String user, char[] passd){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\adminLogins.txt","rw");
            for (int i = 0; i < ln; i++){
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            String encryptedUser = e.encrypt(user);
            raf.writeBytes("Username:"+encryptedUser+"\r\n" );
            String encryptedPassd = e.encrypt(String.valueOf(passd));
            raf.writeBytes("Password:"+encryptedPassd);
            JOptionPane.showMessageDialog(null,"Data Saved Successfully");
            
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void multipleSetLogic(String user, char[] passd){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\adminLogins.txt","rw");
            String encryptedCheckUser = e.encrypt(user);
            String encryptedCheckPassd = e.encrypt(String.valueOf(passd));
            for (int i = 0; i<=ln; i+=3){
                System.out.println("count: "+i);
                String line = raf.readLine();
                String forUser = line.substring(9);
                
                String line2 = raf.readLine();
                String forPswd = line2.substring(9);
                if(encryptedCheckUser.equals(forUser) & encryptedCheckPassd.equals(forPswd)){
                    JOptionPane.showMessageDialog(null,"Password Matched");
                    break;
                }
                else if (i == (ln-3)){
                    JOptionPane.showMessageDialog(null,"Wrong Password");
                    System.out.println("Wrong Password");
                }
                for (int k = 1; k<=1; k++){
                    raf.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void countLines(){
        try {
            ln = 1;
            RandomAccessFile raf = new RandomAccessFile(f+"\\adminLogins.txt","rw");
            for (int i = 0; raf.readLine() != null; i++){
                ln++;
            }
            System.out.println("Number of Lines: "+ln);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==clr){
            usr.setText("");
            pass.setText("");
        }
        else if(e.getSource()==add){
            if(usr.getText().isEmpty()){
                JOptionPane.showMessageDialog(jfram,"Please Enter Username","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            //else if(pass.getPassword().isEmpty()){
            else if(pass.getPassword().length == 0){
                JOptionPane.showMessageDialog(jfram,"Please Enter Password","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else{
            createFolder();
            readFile();
            countLines();
            addData(usr.getText(),pass.getPassword());
            }
        }   
        else if(e.getSource()==login){
            if(usr.getText().isEmpty()){
                JOptionPane.showMessageDialog(jfram,"Please Enter Username","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(pass.getPassword().length == 0){
                JOptionPane.showMessageDialog(jfram,"Please Enter Password","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else {
            createFolder();
            readFile();
            countLines();
            multipleSetLogic(usr.getText(),pass.getPassword());
            jfram.dispose();
            AdminAction a = new AdminAction();
            }
        }
        else if(e.getSource() == back) {
            jfram.dispose();
            Nplog.jframe.setVisible(true);
        }   
    }
}
