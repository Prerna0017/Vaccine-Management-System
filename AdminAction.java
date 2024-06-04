package Final;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminAction extends VaccineSlots implements ActionListener{
    String stkCondition = "Check The Vaccine Booking Status";
    String stkStats = "Check The Vaccine Stock Statistics";
    static JFrame jframA = new JFrame("LOGGED IN AS ADMIN");
    JLabel welLabel;
    JLabel stkLCondition;
    JLabel stkLStats;
    JPanel vacc2 = new JPanel();
    JLabel choice2;
    JButton getBk;
    //JButton nxt;
    JButton getSc;
    JButton getSs;

    AdminAction(){
        initComponentsA();
    }
    
    void initComponentsA(){
        jframA.setSize(950,600);    //size of the frame
        jframA.setResizable(false);
        jframA.getContentPane().setBackground(new Color(254, 201, 215));    //color of the frame
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/logo.jpg");    //giving image path to image object
        jframA.setIconImage(imageIcon.getImage());  //setting icon on 
        
        ImageIcon image = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/welcomelogo.jpg");
        Image imgadmin = image.getImage();
        Image welLogo = imgadmin.getScaledInstance(75,72,6);
        image = new ImageIcon (welLogo);

        ImageIcon RecePic = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/prefervaccine.jpg");
        Image img = RecePic.getImage();
        Image RegLogo = img.getScaledInstance(220,220,6);
        RecePic = new ImageIcon (RegLogo);
        JLabel background = new JLabel("",RecePic,JLabel.CENTER); //creating a label for background
        background.setBounds(570,180,220,220);  //resizing the image to its frame size
        jframA.add(background);

        welLabel = new JLabel("WELCOME",image,JLabel.CENTER);
        welLabel.setBounds(200,50,450,100);
        welLabel.setHorizontalTextPosition(JLabel.LEFT);
        welLabel.setFont(new Font("Cambria",Font.BOLD,35));
        welLabel.setForeground(Color.BLACK);
        jframA.add(welLabel);

        vacc2.setSize(740, 470);
        vacc2.setBackground(new Color(255,241,230,100));
        vacc2.setBounds(100,50,740,470); 
        jframA.add(vacc2);

        choice2 = new JLabel("What do you want to do:");
        jframA.setLayout(null);
        choice2.setBounds(150,100,400,190);
        choice2.setFont(new Font("Cambria",Font.BOLD,27));
        choice2.setForeground(Color.BLACK);
        jframA.add(choice2);
/*
        ImageIcon image2 = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/StkCondition.jpg");
        Image img2admin = image2.getImage();
        Image ScLogo = img2admin.getScaledInstance(50,45,6);
        image2 = new ImageIcon (ScLogo);

        getSc = new JButton(image2);
        getSc.setBounds(150,250,50,45); //setting location
        getSc.setFont(new Font("Cambria",Font.BOLD,23));
        //getSc.setBackground(new Color(255, 172, 197));
        getSc.setForeground(Color.BLACK);
        getSc.setBorder(BorderFactory.createSoftBevelBorder(900));
		getSc.setFocusable(false);
		getSc.addActionListener(this);
        jframA.add(getSc);  //adding to frame
*/
        ImageIcon image3 = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/StkStats.jpg");
        Image img3admin = image3.getImage();
        Image StLogo = img3admin.getScaledInstance(50,45,6);
        image3 = new ImageIcon (StLogo);

        getSs = new JButton(image3);
        getSs.setBounds(150,260,50,45); //setting location
        getSs.setFont(new Font("Cambria",Font.BOLD,23));
        //getSc.setBackground(new Color(255, 172, 197));
        getSs.setForeground(Color.BLACK);
        getSs.setBorder(BorderFactory.createSoftBevelBorder(900));
		getSs.setFocusable(false);
		getSs.addActionListener(this);
        jframA.add(getSs);  //adding to frame

        /*stkLCondition = new JLabel(stkCondition);
        stkLCondition.setBounds(210,260,350,30);
        stkLCondition.setFont(new Font("Cambria",Font.BOLD,21));
        stkLCondition.setForeground(Color.BLACK);
        jframA.add(stkLCondition);*/

        stkLStats = new JLabel(stkStats);
        stkLStats.setBounds(210,270,350,30);
        stkLStats.setFont(new Font("Cambria",Font.BOLD,21));
        stkLStats.setForeground(Color.BLACK);
        jframA.add(stkLStats);

        getBk = new JButton("< LOGOUT");
        jframA.add(getBk);  //adding to frame
        getBk.setBounds(210,430,200,30); //setting location
        getBk.setFont(new Font("Cambria",Font.BOLD,23));
        getBk.setBackground(new Color(255, 172, 197));
        getBk.setForeground(Color.BLACK);
        getBk.setBorder(BorderFactory.createSoftBevelBorder(900));
		getBk.setFocusable(false);
		getBk.addActionListener(this);

       /* nxt = new JButton("NEXT >");
        jframA.add(nxt);  //adding to frame
        nxt.setBounds(480,430,200,30); //setting location
        nxt.setFont(new Font("Cambria",Font.BOLD,23));
        nxt.setBackground(new Color(255, 172, 197));
        nxt.setForeground(Color.BLACK);
        nxt.setBorder(BorderFactory.createSoftBevelBorder(900));
		nxt.setFocusable(false);
		nxt.addActionListener(this); */

        jframA.setLayout(null);
        jframA.setVisible(true);
        jframA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //should close
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getBk)
        {
            jframA.dispose();
            Nplog.jframe.setVisible(true);
        }
        else if (e.getSource() == getSc){
            jframA.dispose();
            AdminEntry1 Ae = new AdminEntry1();
        }
        else if (e.getSource() == getSs){
            jframA.dispose();
            tryAdminEntry2 Ae = new tryAdminEntry2();
        }
    }
    
    
}
