package Final;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegAll implements ActionListener {
    General r = new General();
    File fA = new File("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine");
    File fT = new File("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine");
    String TUsername, TPassword;
    int Tln;

    JFrame registerT = new JFrame("REGISTER");
    JPanel regT = new JPanel();
    JLabel registerLabel;
    JLabel firName;
    JLabel lasName;
    JLabel mailId;
    JLabel Address;
    JLabel PhNo;
    JLabel Age;
    JLabel usrName;
    JLabel setPswd;
    JLabel conPswd;
    JTextField fName;
    JTextField lName;
    JTextField mId;
    JTextField Add;
    JTextField Pno;
    JTextField age;
    JTextField uName;
    JPasswordField sPd;
    JPasswordField cPd;
    JButton SubmitT;
    JButton backT;
  
    JCheckBox showPass3 = new JCheckBox ("Show Password");
    JCheckBox showPass4 = new JCheckBox ("Show Password");

    RegAll(){
        registerT.setSize(950,700);   //size of the frame
        registerT.setResizable(false);
        registerT.getContentPane().setBackground(new Color(200,243,252));
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/logo.jpg");    //giving image path to image object
        registerT.setIconImage(imageIcon.getImage());

        regT.setSize(740, 570);
        //regT.setBackground(new Color(147,230,247,100));
        regT.setBackground(new Color(47,230,247,100));
        regT.setBounds(100,50,740,570); 
        //regT.setBounds(200,150,550,350); 
        registerT.add(regT);

        ImageIcon firNameIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/loginlogo.png");
        Image imgadmin = firNameIcon.getImage();
        Image firNameLogo = imgadmin.getScaledInstance(80,77,6);
        firNameIcon = new ImageIcon (firNameLogo);

        registerLabel = new JLabel("REGISTER",firNameIcon,JLabel.CENTER);
        registerLabel.setBounds(250,5,250,100);
        //registerLabel.setBounds(370,55,250,100);
        registerLabel.setHorizontalTextPosition(JLabel.LEFT);
        registerLabel.setFont(new Font("Cambria",Font.BOLD,35));
        registerLabel.setForeground(Color.BLACK);
        regT.add(registerLabel);

        ImageIcon RegPic = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/regPic.jpeg");
        Image img = RegPic.getImage();
        Image RegLogo = img.getScaledInstance(240,240,6);
        RegPic = new ImageIcon (RegLogo);
        JLabel background = new JLabel("",RegPic,JLabel.CENTER); //creating a label for background
        background.setBounds(460,100,240,240);  //resizing the image to its frame size
        regT.setLayout(null);
        regT.add(background);

        firName = new JLabel ("First Name:");
        firName.setFont(new Font("Cambria",Font.PLAIN,20));
        firName.setForeground(Color.BLACK);
        firName.setBounds(168,150,150,40);
        registerT.add(firName);  

        lasName = new JLabel ("Last Name:");
        lasName.setFont(new Font("Cambria",Font.PLAIN,20));
        lasName.setForeground(Color.BLACK);
        lasName.setBounds(170,200,150,40);
        registerT.add(lasName);
        
        mailId = new JLabel ("E-Mail ID:");
        mailId.setFont(new Font("Cambria",Font.PLAIN,20));
        mailId.setForeground(Color.BLACK);
        mailId.setBounds(182,250,150,40);
        registerT.add(mailId);

        Address = new JLabel ("Address:");
        Address.setFont(new Font("Cambria",Font.PLAIN,20));
        Address.setForeground(Color.BLACK);
        Address.setBounds(190,300,150,40);
        registerT.add(Address);

        PhNo = new JLabel ("Phone No:");
        PhNo.setFont(new Font("Cambria",Font.PLAIN,20));
        PhNo.setForeground(Color.BLACK);
        PhNo.setBounds(182,350,150,40);
        registerT.add(PhNo);

        Age = new JLabel ("Age:");
        Age.setFont(new Font("Cambria",Font.PLAIN,20));
        Age.setForeground(Color.BLACK);
        Age.setBounds(560,400,150,40);
        registerT.add(Age);
        
        usrName = new JLabel ("Username:");
        usrName.setFont(new Font("Cambria",Font.PLAIN,20));
        usrName.setForeground(Color.BLACK);
        usrName.setBounds(175,400,150,40);
        registerT.add(usrName);
        
        setPswd = new JLabel ("Set Password:");
        setPswd.setFont(new Font("Cambria",Font.PLAIN,20));
        setPswd.setForeground(Color.BLACK);
        setPswd.setBounds(150, 450,150,40);
        registerT.add(setPswd);
        
        conPswd = new JLabel ("Confirm Password:");
        conPswd.setFont(new Font("Cambria",Font.PLAIN,20));
        conPswd.setForeground(Color.BLACK);
        conPswd.setBounds(110,500,200,40);
        registerT.add(conPswd);

        fName = new JTextField();
        fName.setPreferredSize(new Dimension(240,40));
        fName.setBounds(300,150,240,40);
        registerT.add(fName);

        lName = new JTextField();
        lName.setPreferredSize(new Dimension(240,40));
        lName.setBounds(300,200,240,40);
        registerT.add(lName);

        mId = new JTextField();
        mId.setPreferredSize(new Dimension(240,40));
        mId.setBounds(300,250,240,40);
        registerT.add(mId);

        Add = new JTextField();
        Add.setPreferredSize(new Dimension(240,40));
        Add.setBounds(300,300,240,40);
        registerT.add(Add);

        Pno = new JTextField();
        Pno.setPreferredSize(new Dimension(240,40));
        Pno.setBounds(300,350,240,40);
        registerT.add(Pno);

        age = new JTextField();
        age.setPreferredSize(new Dimension(240,40));
        age.setBounds(600,400,200,40);
        registerT.add(age);

        uName = new JTextField();
        uName.setPreferredSize(new Dimension(240,40));
        uName.setBounds(300,400,240,40);
        registerT.add(uName);

        sPd = new JPasswordField();
        sPd.setEchoChar('*');
        sPd.setPreferredSize(new Dimension(240,40));
        sPd.setBounds(300,450,240,40);
        registerT.add(sPd);

        cPd = new JPasswordField();
        cPd.setEchoChar('*');
        cPd.setPreferredSize(new Dimension(240,40));
        cPd.setBounds(300,500,240,40);
        registerT.add(cPd);

        SubmitT = new JButton("Submit");
        SubmitT.setBounds(260,570,170,40);
        SubmitT.setFont(new Font("Cambria",Font.BOLD,20));
        SubmitT.setBackground(new Color(0,214,255));
        SubmitT.setForeground(Color.BLACK);
        SubmitT.setBorder(BorderFactory.createSoftBevelBorder(900));
        SubmitT.setFocusable(false);
		SubmitT.addActionListener(this);
        registerT.add(SubmitT);

        backT = new JButton("Back");
        backT.setBounds(490,570,170,40);
        backT.setFont(new Font("Cambria",Font.BOLD,20));
        backT.setBackground(new Color(0,214,255));
        backT.setForeground(Color.BLACK);
        backT.setBorder(BorderFactory.createSoftBevelBorder(900));
        backT.setFocusable(false);
		backT.addActionListener(this);
        registerT.add(backT);

        showPass3.setBounds(560,450,240,40); 
        showPass3.setBackground(new Color(0,214,255));
        showPass3.setFont(new Font("Cambria",Font.BOLD,14));
        showPass3.setForeground(Color.BLACK);
        showPass3.setFocusable(false);
        registerT.add(showPass3);
        showPass3.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent E){
                if (showPass3.isSelected()){
                    sPd.setEchoChar((char)0);
                }
                else{
                    sPd.setEchoChar('*');
                }
            }
        });

        showPass4.setBounds(560,500,240,40); 
        showPass4.setBackground(new Color(0,214,255));
        showPass4.setFont(new Font("Cambria",Font.BOLD,14));
        showPass4.setForeground(Color.BLACK);
        showPass4.setFocusable(false);
        registerT.add(showPass4);
        showPass4.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent E){
                if (showPass4.isSelected()){
                    cPd.setEchoChar((char)0);
                }
                else{
                    cPd.setEchoChar('*');
                }
            }
        });


        registerT.setLayout(null);
        registerT.setVisible(true);    //should be visible
        registerT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    void createFolder(){
        if (!fT.exists()){
            fT.mkdirs();
        }
    }

    void createAllFolder(){
        if (!fA.exists()){
            fA.mkdirs();
        }
    }

    void readFile(){
        try {
            FileReader fr =  new FileReader(fT+"\\takerLogins.txt");
            System.out.println("File exists");
            fr.close();
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter(fT+"\\takerLogins.txt");
                System.out.println("File created");
                fw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addData(String user, char[] passd){
        try {
            RandomAccessFile raf = new RandomAccessFile(fT+"\\takerLogins.txt","rw");
            for (int i = 0; i < Tln; i++){
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            String encryptedRUser = r.encrypt(user);
            raf.writeBytes("Username:"+encryptedRUser+"\r\n" );
            String encryptedRPassd = r.encrypt(String.valueOf(passd));
            raf.writeBytes("Password:"+encryptedRPassd);
            System.out.println("Printed the necessary");
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addAllData(String fn,String ln,String m,String ad,String p,String a,String user){
        try {
            RandomAccessFile raf = new RandomAccessFile(fT+"\\takerAllData.txt","rw");
            for (int i = 0; i < Tln; i++){
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            raf.writeBytes("Username:"+user+"\r\n" );
            raf.writeBytes("First name:"+fn+"\r\n" );
            raf.writeBytes("Last name:"+ln+"\r\n" );
            raf.writeBytes("E-Mail ID:"+m+"\r\n" );
            raf.writeBytes("Address:"+ad+"\r\n" );
            raf.writeBytes("Phone No.:"+p+"\r\n" );
            raf.writeBytes("Age:"+a+"\r\n" );
            //raf.writeBytes("Password:"+passd);
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void csvAllData(String fn,String ln,String m,String ad,String p,String a,String user){
        try {
            FileWriter fW = new FileWriter(fT+"\\tryRegAll.csv",true);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pW = new PrintWriter(bW);
            pW.println(user+","+fn+","+ln+","+m+","+ad+","+p+","+a);
            bW.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void countLines(){
        try {
            Tln = 1;
            RandomAccessFile raf = new RandomAccessFile(fT+"\\takerAllData.txt","rw");
            for (int i = 0; raf.readLine() != null; i++){
                Tln++;
            }
            System.out.println("Number of Lines: "+Tln);
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       char[] cPwd = sPd.getPassword();
       char[] sPwd = cPd.getPassword();
        if(e.getSource()==SubmitT){
            
            if(r.containsDigit(fName.getText())){
                JOptionPane.showMessageDialog(registerT, "Entered First Name Contains Digit","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(r.containsDigit(lName.getText())){
                JOptionPane.showMessageDialog(registerT,"Entered Last Name Contains Digit","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(fName.getText().isEmpty()){
                JOptionPane.showMessageDialog(registerT,"Please Enter First Name","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(lName.getText().isEmpty()){
                JOptionPane.showMessageDialog(registerT,"Please Enter Last Name","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(mId.getText().isEmpty()){
                JOptionPane.showMessageDialog(registerT,"Please Enter MailId","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(Add.getText().isEmpty()){
                JOptionPane.showMessageDialog(registerT,"Please Enter Address","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(Pno.getText().isEmpty()){
                JOptionPane.showMessageDialog(registerT,"Please Enter Phone No.","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(!r.containsChar(Pno.getText())){
                JOptionPane.showMessageDialog(registerT,"Entered Phone Number Contains Character","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(!r.contains10Digit(Pno.getText())){
                JOptionPane.showMessageDialog(registerT,"Entered Phone Number Doesnt have 10 digits","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(age.getText().isEmpty()){
                JOptionPane.showMessageDialog(registerT,"Please Enter Age","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(!r.containsChar(age.getText())){
                JOptionPane.showMessageDialog(registerT,"Entered Age Contains Character","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if((Integer.parseInt(age.getText()))<20){
                JOptionPane.showMessageDialog(registerT,"Entered Age is less than 20","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(uName.getText().isEmpty()){
                JOptionPane.showMessageDialog(registerT,"Please Enter Username","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(sPd.getPassword().length == 0){
                JOptionPane.showMessageDialog(registerT,"Please Enter Password","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(cPd.getPassword().length == 0){
                JOptionPane.showMessageDialog(registerT,"Please Enter Password for confirmation","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(!String.valueOf(sPwd).equals(String.valueOf(cPwd))){
                JOptionPane.showMessageDialog(registerT,"Set Password and Confirmed Password didnt Matched","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                createFolder();
                readFile();
                countLines();
                addData(uName.getText(),cPd.getPassword());
                addAllData(fName.getText(),lName.getText(),mId.getText(),Add.getText(),Pno.getText(),age.getText(),uName.getText());
                csvAllData(fName.getText(),lName.getText(),mId.getText(),Add.getText(),Pno.getText(),age.getText(),uName.getText());
                JOptionPane.showMessageDialog(null,"DATA SAVED");
                registerT.dispose();
                Nplog.jframe.setVisible(true);
            }
        } 
        else if(e.getSource() == backT) {
            registerT.dispose();
            Nplog.jframe.setVisible(true);
        }
        
    }
        
    
}
