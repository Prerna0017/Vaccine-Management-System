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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminEntry1 implements ActionListener {

    JFrame jframA2 = new JFrame("VACCINE STOCK STATUS");
    JLabel stStats;
    JLabel choice3;
    JButton get1;
    JButton get2;
    JButton getBk;
    JPanel A2;
    JLabel Entry;
    JLabel Stats;

    AdminEntry1(){
        initComponentsA2();
    }

    void initComponentsA2(){
        jframA2.setSize(950,600);    //size of the frame
        jframA2.setResizable(false);
        jframA2.getContentPane().setBackground(new Color(247, 246, 197));    //color of the frame
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/logo.jpg");    //giving image path to image object
        jframA2.setIconImage(imageIcon.getImage());  //setting icon on 
        
   /*     ImageIcon SsPic = new ImageIcon("C:/Users/Jadhav/Desktop/prefervaccine.jpg");
        Image img = SsPic.getImage();
        Image RegLogo = img.getScaledInstance(220,220,6);
        SsPic = new ImageIcon (RegLogo);
        JLabel background = new JLabel("",SsPic,JLabel.CENTER); //creating a label for background
        background.setBounds(570,180,220,220);  //resizing the image to its frame size
        jframA2.add(background);
    */

        ImageIcon image = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/vacc2.jpg");
        Image imgadmin = image.getImage();
        Image welLogo = imgadmin.getScaledInstance(70,67,6);
        image = new ImageIcon (welLogo);
        
        ImageIcon RecePic = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/vacc.jpg");
        Image img = RecePic.getImage();
        Image RegLogo = img.getScaledInstance(220,220,6);
        RecePic = new ImageIcon (RegLogo);
        JLabel background = new JLabel("",RecePic,JLabel.CENTER); //creating a label for background
        background.setBounds(570,180,220,220);  //resizing the image to its frame size
        jframA2.add(background);

        stStats = new JLabel("VACCINE STOCK STATUS",image,JLabel.RIGHT);
        stStats.setBounds(150,50,600,100);
        stStats.setHorizontalTextPosition(JLabel.LEFT);
        stStats.setFont(new Font("Cambria",Font.BOLD,35));
        stStats.setForeground(Color.BLACK);
        jframA2.add(stStats);
        
        A2 = new JPanel();
        A2.setSize(740, 470);
        A2.setBackground(new Color(243, 250, 225, 100));
        A2.setBounds(100,50,740,470); 
        jframA2.add(A2);
        

        choice3 = new JLabel("What do you want to do:");
        jframA2.setLayout(null);
        choice3.setBounds(150,100,400,190);
        choice3.setFont(new Font("Cambria",Font.BOLD,27));
        choice3.setForeground(Color.BLACK);
        jframA2.add(choice3);


        ImageIcon image2 = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/book.png");
        Image img2admin = image2.getImage();
        Image ScLogo = img2admin.getScaledInstance(50,48,6);
        image2 = new ImageIcon (ScLogo);

        get1 = new JButton(image2);
        get1.setBounds(150,250,50,48); //setting location
        get1.setFont(new Font("Cambria",Font.BOLD,23));
        //get1.setBackground(new Color(255, 172, 197));
        get1.setForeground(Color.BLACK);
        get1.setBorder(BorderFactory.createSoftBevelBorder(900));
		get1.setFocusable(false);
		get1.addActionListener(this);
        jframA2.add(get1);  //adding to frame

        ImageIcon image3 = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/received.jpg");
        Image img3admin = image3.getImage();
        Image StLogo = img3admin.getScaledInstance(50,45,6);
        image3 = new ImageIcon (StLogo);

        get2 = new JButton(image3);
        get2.setBounds(150,310,50,45); //setting location
        get2.setFont(new Font("Cambria",Font.BOLD,23));
        //get1.setBackground(new Color(255, 172, 197));
        get2.setForeground(Color.BLACK);
        get2.setBorder(BorderFactory.createSoftBevelBorder(900));
		get2.setFocusable(false);
		get2.addActionListener(this);
        jframA2.add(get2);  //adding to frame

        Entry = new JLabel("Confirm Booking");
        Entry.setBounds(210,260,350,30);
        Entry.setFont(new Font("Cambria",Font.BOLD,21));
        Entry.setForeground(Color.BLACK);
        jframA2.add(Entry);

        Stats = new JLabel("Confirm Received");
        Stats.setBounds(210,320,350,30);
        Stats.setFont(new Font("Cambria",Font.BOLD,21));
        Stats.setForeground(Color.BLACK);
        jframA2.add(Stats);

        getBk = new JButton("< BACK");
        jframA2.add(getBk);  //adding to frame
        getBk.setBounds(210,430,200,30); //setting location
        getBk.setFont(new Font("Cambria",Font.BOLD,23));
        getBk.setBackground(new Color(247, 246, 197));
        getBk.setForeground(Color.BLACK);
        getBk.setBorder(BorderFactory.createSoftBevelBorder(900));
		getBk.setFocusable(false);
		getBk.addActionListener(this);

        jframA2.setLayout(null);
        jframA2.setVisible(true);
        jframA2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //should close
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == getBk)
       {
           jframA2.dispose();
           AdminAction.jframA.setVisible(true);
       }
       else if (e.getSource() == get1)
       {
           String no = JOptionPane.showInputDialog(jframA2, "Enter Today's Doses");
           System.out.println(no);
       }
       else if (e.getSource() == get2)
       {
           JOptionPane.showInputDialog(jframA2, "Enter Today's Doses");
       }
    }
}
