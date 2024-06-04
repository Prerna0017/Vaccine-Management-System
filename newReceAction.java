package Final;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class newReceAction extends Takerlogin implements ActionListener{
    File fV = new File("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine");
    final int noOfCovaxinDoses = 100 ;
    final int noOfCovishieldDoses = 100;
    static JFrame jframR = new JFrame("LOGGED IN AS RECEIVER");
    JPanel vacc = new JPanel();
    JLabel welLabel;
    JLabel choice;
    JRadioButton Covaxin;
    JRadioButton Covishield;
    JButton bk;
    JButton next;
    String selection;
    String line = "";

    newReceAction(){
        Takerlogin.jframet.dispose();
        initComponentsR();
    }
    
    void initComponentsR(){
        
        jframR.setSize(950,600);    //size of the frame
        jframR.setResizable(false);
        jframR.getContentPane().setBackground(new Color(254, 201, 215));    //color of the frame
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/logo.jpg");    //giving image path to image object
        jframR.setIconImage(imageIcon.getImage());  //setting icon on 
 
        ImageIcon welIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/welcomelogo.jpg");
        Image imgadmin = welIcon.getImage();
        Image welLogo = imgadmin.getScaledInstance(75,72,6);
        welIcon = new ImageIcon (welLogo);

        ImageIcon RecePic = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/prefervaccine.jpg");
        Image img = RecePic.getImage();
        Image RegLogo = img.getScaledInstance(220,220,6);
        RecePic = new ImageIcon (RegLogo);
        JLabel background = new JLabel("",RecePic,JLabel.CENTER); //creating a label for background
        background.setBounds(570,180,220,220);  //resizing the image to its frame size
        jframR.add(background);

        welLabel = new JLabel("WELCOME",welIcon,JLabel.CENTER);
        welLabel.setBounds(200,50,450,100);
        welLabel.setHorizontalTextPosition(JLabel.LEFT);
        welLabel.setFont(new Font("Cambria",Font.BOLD,35));
        welLabel.setForeground(Color.BLACK);
        jframR.add(welLabel);

        vacc.setSize(740, 470);
        vacc.setBackground(new Color(255,241,230,100));
        vacc.setBounds(100,50,740,470); 
        jframR.add(vacc);


        choice = new JLabel("Which Vaccine would you Prefer:");
        jframR.setLayout(null);
        choice.setBounds(150,100,400,190);
        choice.setFont(new Font("Cambria",Font.BOLD,25));
        choice.setForeground(Color.BLACK);
        jframR.add(choice);

        Covaxin = new JRadioButton("COVAXIN");
        Covaxin.setBounds(150,270,150,20);
        Covaxin.setFont(new Font("Cambria",Font.BOLD,18));
        Covaxin.setBackground(new Color(255,241,230,100));
        Covaxin.setFocusable(false);
        jframR.add(Covaxin);

        Covishield = new JRadioButton("COVISHIELD");
        Covishield.setBounds(150,350,150,20);
        Covishield.setFont(new Font("Cambria",Font.BOLD,18));
        Covishield.setBackground(new Color(255,241,230,100));
        Covishield.setFocusable(false);
        jframR.add(Covishield);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(Covaxin);
        radioGroup.add(Covishield);

        bk = new JButton("< LOGOUT");
        jframR.add(bk);  //adding to frame
        bk.setBounds(150,430,200,30); //setting location
        bk.setFont(new Font("Cambria",Font.BOLD,23));
        bk.setBackground(new Color(255, 172, 197));
        bk.setForeground(Color.BLACK);
        bk.setBorder(BorderFactory.createSoftBevelBorder(900));
		bk.setFocusable(false);
		bk.addActionListener(this);

        next = new JButton("LETS GET THE VACCINE.... >");
        jframR.add(next);  //adding to frame
        next.setBounds(390,430,400,30); //setting location
        next.setFont(new Font("Cambria",Font.BOLD,23));
        next.setBackground(new Color(255, 172, 197));
        next.setForeground(Color.BLACK);
        next.setBorder(BorderFactory.createSoftBevelBorder(900));
		next.setFocusable(false);
		next.addActionListener(this);

        //write();
        
        jframR.setLayout(null);
        jframR.setVisible(true);
        jframR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //should close
        
    }

    boolean reduceCovaxin(){
        String n2 ;
        try {
            RandomAccessFile raf = new RandomAccessFile(fV+"\\CovaVaccineData.txt","rw");
            //while((raf.readLine()) != null){
                n2 = raf.readLine();
                int n1 = Integer.parseInt(n2);
                
                if(n1 <= 0){
                    JOptionPane.showMessageDialog(null,"No vaccine available");
                    return false;
                }
                else{
                        raf.setLength(0);
                        int ans = --n1;
                        System.out.println(ans);
                        String ansS = String.valueOf(ans);
                        System.out.println(ansS);
                        raf.writeBytes(ansS);
                        JOptionPane.showMessageDialog(null,"Data Saved Successfully");
                }
                    
        }catch(EOFException e){
            e.printStackTrace();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        return true;
    }

    boolean reduceCovishield(){
        String n2 ;
        try {
            RandomAccessFile raf = new RandomAccessFile(fV+"\\CoviVaccineData.txt","rw");
            //while((raf.readLine()) != null){
                n2 = raf.readLine();
                int n1 = Integer.parseInt(n2);
                if (n1 <= 0 ){
                    JOptionPane.showMessageDialog(null,"No vaccine available");
                    return false;
                }
                else{
                    raf.setLength(0);
                    int ans = --n1;
                    System.out.println(ans);
                    String ansS = String.valueOf(ans);
                    System.out.println(ansS);
                    raf.writeBytes(ansS);
                    JOptionPane.showMessageDialog(null,"Data Saved Successfully");
                }
        }catch(EOFException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return true;
    }
   
    void readCovaFile(){
        try {
            FileReader fr =  new FileReader(fV+"\\CovaVaccineData.txt");
            System.out.println("File exists");
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter(fV+"\\CovaVaccineData.txt");
                System.out.println("File created");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    void readCoviFile(){
        try {
            FileReader fr =  new FileReader(fV+"\\CoviVaccineData.txt");
            System.out.println("File exists");
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter(fV+"\\CoviVaccineData.txt");
                System.out.println("File created");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    void readVaccFile(){
        try {
            FileReader fr =  new FileReader(fV+"\\vaccRegAll.csv");
            System.out.println("File exists");
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter(fV+"\\vaccRegAll.csv");
                System.out.println("File created");
                FileWriter fW = new FileWriter(fV+"\\vaccRegAll.csv",true);
                BufferedWriter bW = new BufferedWriter(fW);
                PrintWriter pW = new PrintWriter(bW); 
                pW.println("Username"+","+"Vaccine"+","+"1st Dose"+","+"2nd Dose");
                bW.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void enterVacc(String s,int days){
        try {
            FileWriter fW = new FileWriter(fV+"\\vaccRegAll.csv",true);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pW = new PrintWriter(bW);
            LocalDate d = java.time.LocalDate.now();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, days);  
	        //Date after adding the days to the current date
	        String n = sdf.format(cal.getTime()); 
            pW.println(uN+","+s+","+d+","+n);
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
        int op = 0;
        if (e.getSource()==bk){
            jframR.dispose();
            Nplog.jframe.setVisible(true);
        }
        else if(e.getSource() == next) {

            
            
            if (!Covaxin.isSelected() && !Covishield.isSelected())
            {
                JOptionPane.showMessageDialog(jframR,"Please Enter Any one Vaccine","Entry Checking", JOptionPane.ERROR_MESSAGE);
            }
            else if (Covaxin.isSelected())
            {
                selection = "Covaxin";
                op = JOptionPane.showConfirmDialog(jframR,"You have selected Covaxin","CONFIRMATION",JOptionPane.OK_CANCEL_OPTION);
                if (op == 0)
                {
                    readCovaFile();
                    if(!reduceCovaxin()){
                        jframR.setVisible(true);
                    }
                    else{
                        readVaccFile();
                        enterVacc(selection,60);
                        jframR.dispose();
                        ReceEntry r = new ReceEntry();
                    }
                }
                else
                {
                    jframR.setVisible(true);
                }
            }
            else if (Covishield.isSelected())
            {
                selection = "Covishield";
                op = JOptionPane.showConfirmDialog(jframR,"You have selected Covishield","CONFIRMATION",JOptionPane.OK_CANCEL_OPTION);
                if (op == 0)
                {
                    readCoviFile();
                    if(!reduceCovishield()){
                        jframR.setVisible(true);
                    }
                    else{
                        readVaccFile();
                        enterVacc(selection,80);
                        jframR.dispose();
                        ReceEntry r = new ReceEntry();
                    }
                }
                else
                {
                    jframR.setVisible(true);
                }
            } 
        }
    }   
}
