package Final;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.*;

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

public class Takerlogin implements ActionListener {

    General t = new General();
    File fT = new File("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine");
    String TUsername, TPassword;
    int Tln;

    static JFrame jframet = new JFrame("VACCINE TAKER LOGIN");
    JPanel halfpan;
    JLabel halfpanimg;
    JLabel signup;
    JLabel rUsername;
    JLabel rPassword;
    JTextField rUsr;
    JPasswordField rPass;
    JCheckBox showPass2 = new JCheckBox("Show Password");
    JButton rLogin;
    JButton rBack;
    JButton rClr;
    public static String uN;
    
    Takerlogin(){
        initComponents();
    }

    void initComponents(){
        
        jframet.setSize(950,600);    //size of the frame
        jframet.setResizable(false);
        jframet.getContentPane().setBackground(new Color(100,225,225));    //color of the frame
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/logo.jpg");    //giving image path to image object
        jframet.setIconImage(imageIcon.getImage());  //setting icon on frame

        /*ImageIcon backimg = new ImageIcon("C:/Users/Jadhav/Desktop/halfimg.jpg");    //giving image path to image object
        Image finalhalf = backimg.getImage();
        Image finalimg = finalhalf.getScaledInstance(600, 600,6);
        backimg = new ImageIcon (finalimg);
        jfram.setIconImage(backimg.getImage());  //setting icon on frame
        */

        ImageIcon halfbackimg = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/getVaccLogo.jpg");
        JLabel halfpanimg = new JLabel("",halfbackimg,JLabel.CENTER); //creating a label for background
        halfpanimg.setBounds(0,0,475, 600);  //resizing the image to its frame size
        jframet.add(halfpanimg); //adding background image
        
        halfpan = new JPanel();
        halfpan.setBackground(new Color(0,0,0,20));
        halfpan.setBounds(540,60,325,450); 
        jframet.add(halfpan);

        ImageIcon signupIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/loginlogo.png");
        Image imgadmin = signupIcon.getImage();
        Image signupLogo = imgadmin.getScaledInstance(80,77,6);
        signupIcon = new ImageIcon (signupLogo);

        signup = new JLabel("LOGIN",signupIcon,JLabel.CENTER);
        signup.setHorizontalTextPosition(JLabel.LEFT);
        signup.setFont(new Font("Cambria",Font.BOLD,35));
        signup.setForeground(Color.BLACK);
        halfpan.add(signup);

        rUsername = new JLabel("Username");
        rUsername.setFont(new Font("Cambria",Font.PLAIN,20));
        rUsername.setForeground(Color.BLACK);
        rUsername.setBounds(570,150,100,30);
        jframet.add(rUsername);

        rPassword = new JLabel("Password");
        rPassword.setFont(new Font("Cambria",Font.PLAIN,20));
        rPassword.setForeground(Color.BLACK);
        rPassword.setBounds(570,250,100,30);
        jframet.add(rPassword);

        rUsr = new JTextField();
        rUsr.setPreferredSize(new Dimension(240,40));
        rUsr.setBounds(570,190,240,40);
        jframet.add(rUsr);

        rPass = new JPasswordField();
        rPass.setEchoChar('*');
        rPass.setPreferredSize(new Dimension(240,40));
        rPass.setBounds(570,290,240,40);
        jframet.add(rPass);

        rLogin = new JButton("LOGIN");
        rLogin.setBounds(570,390,100,30); //setting location
        rLogin.setFont(new Font("Cambria",Font.BOLD,20));
        rLogin.setBackground(new Color(0,214,255));
        rLogin.setForeground(Color.BLACK);
        rLogin.setBorder(BorderFactory.createSoftBevelBorder(900));
		rLogin.setFocusable(false);
		rLogin.addActionListener(this);
        jframet.add(rLogin);  //adding to frame

        rBack = new JButton("BACK");
        rBack.setBounds(700,440,100,30); //setting location
        rBack.setFont(new Font("Cambria",Font.BOLD,20));
        rBack.setBackground(new Color(0,214,255));
        rBack.setForeground(Color.BLACK);
        rBack.setBorder(BorderFactory.createSoftBevelBorder(900));
		rBack.setFocusable(false);
		rBack.addActionListener(this);
        jframet.add(rBack);

        rClr = new JButton("CLEAR");
        rClr.setBounds(570,440,100,30); //setting location
        rClr.setFont(new Font("Cambria",Font.BOLD,20));
        rClr.setBackground(new Color(0,214,255));
        rClr.setForeground(Color.BLACK);
        rClr.setBorder(BorderFactory.createSoftBevelBorder(900));
		rClr.setFocusable(false);
		rClr.addActionListener(this);
        jframet.add(rClr);

        showPass2.setBounds(570,340,150,30); 
        showPass2.setBackground(new Color(0,214,255));
        showPass2.setFont(new Font("Cambria",Font.BOLD,14));
        showPass2.setForeground(Color.BLACK);
        showPass2.setFocusable(false);
        jframet.add(showPass2);
        showPass2.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent E){
                if (showPass2.isSelected()){
                    rPass.setEchoChar((char)0);
                }
                else{
                    rPass.setEchoChar('*');
                }
            }
        });

        jframet.setLayout(null);
        jframet.setVisible(true);
        jframet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //should close
    }

    void createFolder(){
        if (!fT.exists()){
            fT.mkdirs();
        }
    }

    void readFile(){
        try {
            FileReader fr =  new FileReader(fT+"\\takerLogins.txt");
            System.out.println("File exists");
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter(fT+"\\takerLogins.txt");
                System.out.println("File created");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        
    }

    void multipleSetLogic(String user, char[] passd){
        try {
            RandomAccessFile raf = new RandomAccessFile(fT+"\\takerLogins.txt","rw");
            String encryptedCheckUser = t.encrypt(user);
            String encryptedCheckPassd = t.encrypt(String.valueOf(passd));
            int i;
            for (i = 0; i<=Tln; i+=3){
                System.out.println("count: "+i);
                String line = raf.readLine();
                String forRUser = line.substring(9);
                String line2 = raf.readLine();
                String forRPswd = line2.substring(9);
                if(encryptedCheckUser.equals(forRUser) & encryptedCheckPassd.equals(forRPswd)){
                    System.out.println("Hello1");
                    JOptionPane.showMessageDialog(null,"Password Matched");
                    jframet.dispose();
                    newReceAction r = new newReceAction();
                }
                else if (i == (Tln-3)){
                    System.out.println("Hello2");
                    JOptionPane.showMessageDialog(null,"Wrong Password");
                    //System.out.println("Wrong Password");
                }
                for (int k = 1; k<=1; k++){
                    System.out.println("Hello3");
                    raf.readLine();
                }
            }
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void countLines(){
        try {
            Tln = 1;
            RandomAccessFile raf = new RandomAccessFile(fT+"\\takerLogins.txt","rw");
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

        if (e.getSource()==rClr){
            rUsr.setText("");
            rPass.setText("");
        }
        else if(e.getSource() == rBack) {
            jframet.dispose();
            Nplog.jframe.setVisible(true);
        }
        else if(e.getSource() == rLogin) {
            if(rUsr.getText().isEmpty()){
                JOptionPane.showMessageDialog(jframet,"Please Enter Username","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if(rPass.getPassword().length == 0){
                JOptionPane.showMessageDialog(jframet,"Please Enter Password","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else{
                uN = rUsr.getText();
                System.out.println(uN);
                createFolder();
                readFile();
                countLines();
                multipleSetLogic(rUsr.getText(),rPass.getPassword());
            }
        }
        
    }

}
