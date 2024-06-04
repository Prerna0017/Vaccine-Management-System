package Final;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Nplog extends JFrame implements ActionListener{

    static JFrame jframe  = new JFrame("Vaccine Management System");   //name of the frame
    JLabel topiclabel; //login label
    JLabel me;
    JLabel label = new JLabel("Login"); //login label
    JButton admin;    //button to login as admin
    JButton rece;    //button to login as vaccine receiver
    JLabel newA = new JLabel("Dont Have An Account?..Create one"); //creating new account label
    JButton create;    //button to login as vaccine receiver
    
    //header
    JPanel heading = new JPanel();
    //login panel
    JPanel log = new JPanel();
    

    public static void main(String args[]) throws IOException{
        Nplog n = new Nplog();
        n.print();
    }
    
    Nplog(){
        initComponents();
    }

    public void initComponents() {
        
		jframe.setSize(950,600);    //size of the frame
        jframe.setResizable(false);
        //jframe.getContentPane().setBackground(new Color(100,225,225));    //color of the frame
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/logo.jpg");    //giving image path to image object
        jframe.setIconImage(imageIcon.getImage());  //setting icon on frame
        
        JLabel background = new JLabel("",imageIcon,JLabel.CENTER); //creating a label for background
        background.setBounds(0,0,950,600);  //resizing the image to its frame size
        jframe.add(background); //adding background image

        heading.setBackground(new Color(147,230,247,100));
        //heading.setBackground(new Color(0,0,0,100));
        heading.setBounds(0,465,950,100); 
        //heading.setBounds(0,0,950,100); 
        background.add(heading);      

        topiclabel = new JLabel("VACCINE MANAGEMENT SYSTEM");
        topiclabel.setBounds(130,460,800,100);  //setting location
        topiclabel.setFont(new Font("Cambria", Font.BOLD, 43));
        topiclabel.setForeground(Color.BLACK);
        heading.add(topiclabel);  //adding it on frame

        me = new JLabel("By Prerna Jadhav");
        me.setBounds(400,550,300,50);
        me.setFont(new Font("Cambria", Font.PLAIN, 23));
        me.setForeground(Color.BLACK);
        heading.add(me); 

        //login panel
        log.setSize(550, 350);
        //log.setBackground(new Color(147,230,247,100));
        log.setBackground(new Color(0,0,0,60));
        log.setBounds(200,50,550,350); 
        //log.setBounds(200,150,550,350); 
        background.add(log);

        label.setBounds(440,70,400,50);  //setting location
        label.setFont(new Font("Cambria", Font.BOLD, 32));
        label.setForeground(Color.BLACK);
        background.add(label);  //adding it on frame

        ImageIcon adminIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/adminlogo.png");
        Image img = adminIcon.getImage();
        Image adminLogo = img.getScaledInstance(43,35,6);
        adminIcon = new ImageIcon (adminLogo);

        admin = new JButton("AS ADMIN",adminIcon);  
        background.add(admin);  //adding to frame
        admin.setBounds(370, 125, 200, 50); //setting location
        admin.setFont(new Font("Cambria",Font.BOLD,23));
        admin.setBackground(new Color(177,214,255));
        admin.setForeground(Color.BLACK);
        admin.setBorder(BorderFactory.createSoftBevelBorder(900));
		admin.setFocusable(false);
		admin.addActionListener(this);

        ImageIcon receIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/Recelogo.jpg");
        Image img2 = receIcon.getImage();
        Image receLogo = img2.getScaledInstance(43,35,6);
        receIcon = new ImageIcon (receLogo);

        rece = new JButton("AS RECEIVER",receIcon); 
        background.add(rece);  //adding to frame
        rece.setBounds(355, 195, 230, 50); //setting location
        rece.setFont(new Font("Cambria",Font.BOLD,23));
        rece.setBackground(new Color(177,214,255));
        rece.setForeground(Color.BLACK);
        rece.setBorder(BorderFactory.createSoftBevelBorder(900));
		rece.setFocusable(false);
		rece.addActionListener(this);

        
        newA.setBounds(305, 190, 380, 200);  //setting location
        newA.setFont(new Font("Cambria", Font.BOLD, 25));
        newA.setForeground(Color.BLACK);
        background.add(newA);  //adding it on frame
        

        ImageIcon createIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/createlogo.png");
        Image img3 = createIcon.getImage();
        Image createLogo = img3.getScaledInstance(43,35,6);
        createIcon = new ImageIcon (createLogo);

        create = new JButton("REGISTER",createIcon);
        background.add(create);  //adding to frame
        create.setBounds(370, 323, 200, 50); //setting location
        create.setFont(new Font("Cambria",Font.BOLD,23));
        create.setBackground(new Color(177,214,255));
        create.setForeground(Color.BLACK);
        create.setBorder(BorderFactory.createSoftBevelBorder(900));
		create.setFocusable(false);
		create.addActionListener(this);

        
        jframe.setLayout(null);
        jframe.setVisible(true);    //should be visible
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //should close

    }
    void print(){
        System.out.println("Hello");
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if(event.getSource() == admin) {
            jframe.dispose();
            //Adminlog adminlog = new Adminlog();
            Adminlogin ad = new Adminlogin();
        }
        else if(event.getSource() == rece) {
            jframe.dispose();
            //Takerlog takerlog = new Takerlog();
            Takerlogin takerlog = new Takerlogin();
        }
        else if(event.getSource() == create) {
            jframe.dispose();
            //Register register = new Register();
            //RegTest r=  new RegTest();
            RegAll r=  new RegAll();
        }
        
        
    }
}
