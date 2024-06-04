package Final;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ReceEntry extends Takerlogin implements ActionListener {
    File rE = new File("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine");
    JFrame jframR1 = new JFrame("LOGGED IN AS RECEIVER");
    JPanel vacc = new JPanel();
    JLabel welLabel;
    JButton getBack;
    JButton getNext;
    JLabel lb1;
    JLabel lb2;
    JRadioButton t1,t2,t3,h1,h2,h3;
    String time,hospi;
    String line="";
    String vaccN;

    ReceEntry(){
        initComponentsR1();
    }

    void initComponentsR1(){
        jframR1.setSize(950,600);    //size of the frame
        jframR1.setResizable(false);
        jframR1.getContentPane().setBackground(new Color(247, 246, 197));    //color of the frame
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/logo.jpg");    //giving image path to image object
        jframR1.setIconImage(imageIcon.getImage());  //setting icon on 
 
        ImageIcon welIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/ad.jpg");
        Image imgadmin = welIcon.getImage();
        Image welLogo = imgadmin.getScaledInstance(80,40,6);
        welIcon = new ImageIcon (welLogo);

        welLabel = new JLabel("WE ARE ALMOST DONE!!..",welIcon,JLabel.RIGHT);
        welLabel.setBounds(200,50,550,100);
        welLabel.setHorizontalTextPosition(JLabel.LEFT);
        welLabel.setFont(new Font("Cambria",Font.BOLD,35));
        welLabel.setForeground(Color.BLACK);
        jframR1.add(welLabel);

        vacc.setSize(740, 470);
        vacc.setBackground(new Color(243, 250, 225, 100));
        vacc.setBounds(100,50,740,470); 
        jframR1.add(vacc);

        lb1 = new JLabel("Enter the Slot:");
        jframR1.setLayout(null);
        lb1.setBounds(150,80,400,190);
        lb1.setFont(new Font("Cambria",Font.BOLD,25));
        lb1.setForeground(Color.BLACK);
        jframR1.add(lb1);

        vacc.setLayout(null);
        t1 = new JRadioButton("9 AM");
        t1.setBounds(100,170,100,30);
        t1.setFont(new Font("Cambria",Font.BOLD,21));
        t1.setBackground(new Color(243, 250, 225, 100));
        t1.setFocusable(false);
        vacc.add(t1);

        t2 = new JRadioButton("2 PM");
        t2.setBounds(300,170,100,30);
        t2.setFont(new Font("Cambria",Font.BOLD,21));
        t2.setBackground(new Color(243, 250, 225, 100));
        t2.setFocusable(false);
        vacc.add(t2);

        t3 = new JRadioButton("6 PM");
        t3.setBounds(500,170,100,30);
        t3.setFont(new Font("Cambria",Font.BOLD,21));
        t3.setBackground(new Color(243, 250, 225, 100));
        t3.setFocusable(false);
        vacc.add(t3);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(t1);
        radioGroup.add(t2);
        radioGroup.add(t3);

        lb2 = new JLabel("Enter the Hospital:");
        jframR1.setLayout(null);
        lb2.setBounds(150,200,400,190);
        lb2.setFont(new Font("Cambria",Font.BOLD,25));
        lb2.setForeground(Color.BLACK);
        jframR1.add(lb2);

        h1 = new JRadioButton("Jaslok Hospital");
        h1.setBounds(100,290,200,30);
        h1.setFont(new Font("Cambria",Font.BOLD,21));
        h1.setBackground(new Color(243, 250, 225, 100));
        h1.setFocusable(false);
        vacc.add(h1);

        h2 = new JRadioButton("JJ Hospital");
        h2.setBounds(300,290,200,30);
        h2.setFont(new Font("Cambria",Font.BOLD,21));
        h2.setBackground(new Color(243, 250, 225, 100));
        h2.setFocusable(false);
        vacc.add(h2);

        h3 = new JRadioButton("KEM Hospital");
        h3.setBounds(500,290,200,30);
        h3.setFont(new Font("Cambria",Font.BOLD,21));
        h3.setBackground(new Color(243, 250, 225, 100));
        h3.setFocusable(false);
        vacc.add(h3);

        ButtonGroup radioGroup2 = new ButtonGroup();
        radioGroup2.add(h1);
        radioGroup2.add(h2);
        radioGroup2.add(h3);

        getBack = new JButton("< BACK");
        jframR1.add(getBack);  //adding to frame
        getBack.setBounds(210,430,200,30); //setting location
        getBack.setFont(new Font("Cambria",Font.BOLD,23));
        getBack.setBackground(new Color(247, 246, 197));
        getBack.setForeground(Color.BLACK);
        getBack.setBorder(BorderFactory.createSoftBevelBorder(900));
		getBack.setFocusable(false);
		getBack.addActionListener(this);

        getNext = new JButton("SUBMIT >");
        jframR1.add(getNext);  //adding to frame
        getNext.setBounds(510,430,200,30); //setting location
        getNext.setFont(new Font("Cambria",Font.BOLD,23));
        getNext.setBackground(new Color(247, 246, 197));
        getNext.setForeground(Color.BLACK);
        getNext.setBorder(BorderFactory.createSoftBevelBorder(900));
		getNext.setFocusable(false);
		getNext.addActionListener(this);

        jframR1.setLayout(null);
        jframR1.setVisible(true);
        jframR1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //should close
    }

    void readVaccDetail(){
        try {
            FileReader fr =  new FileReader(rE+"\\vaccDetails.csv");
            System.out.println("File exists");
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter(rE+"\\vaccDetails.csv");
                System.out.println("File created");
                FileWriter fW = new FileWriter(rE+"\\vaccDetails.csv",true);
                BufferedWriter bW = new BufferedWriter(fW);
                PrintWriter pW = new PrintWriter(bW); 
                pW.println("Username"+","+"Vaccine"+","+"Time"+","+"Hospital");
                bW.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void enterVaccDetails(String t,String h){
        try {
            
            BufferedReader br2 = new BufferedReader(new FileReader("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine/vaccRegAll.csv"));
            for (int i = 0;(line = br2.readLine())!=null;i++ ){
                String[] values = line.split(",");
                if (uN.equals(values[0])){
                    vaccN = values[1];
                    Takerlogin.jframet.dispose();
                }
            }
            br2.close();

            
            FileWriter fW = new FileWriter(rE+"\\vaccDetails.csv",true);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pW = new PrintWriter(bW);
            
            pW.println(uN+","+vaccN+","+t+","+h);
            bW.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    
        // TODO Auto-generated method stub
        if(e.getSource() == getBack){
            jframR1.dispose();
            newReceAction.jframR.setVisible(true);
        }
        else if(e.getSource() == getNext){
            
            if (!t1.isSelected() && !t2.isSelected() && !t3.isSelected())
            {
                JOptionPane.showMessageDialog(jframR1,"Please Enter Any one Time Slot","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if (!h1.isSelected() && !h2.isSelected() && !h3.isSelected())
            {
                JOptionPane.showMessageDialog(jframR1,"Please Enter Any one Hospital","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            if (t1.isSelected()){
                time = t1.getText();
                
            }
            else if (t2.isSelected()){
                time = t2.getText();
                
            }
            else if (t3.isSelected()){
                time = t3.getText();
                
            }
            if (h1.isSelected()){
                hospi = h1.getText();
                
            }
            else if (h2.isSelected()){
                hospi = h2.getText();
                
            }
            else if (h3.isSelected()){
                hospi = h3.getText();
                
            }
            int opt2 = JOptionPane.showConfirmDialog(jframR1,"Time Slot "+time+" and "+hospi+" is Selected.","Entry Checking", JOptionPane.OK_CANCEL_OPTION);
            if (opt2 == 0)
            {
                enterVaccDetails(time,hospi);
                jframR1.dispose();
                receiptRece rR = new receiptRece();
            }
            else
            {
                jframR1.setVisible(true);
            }
        }
    }
}
