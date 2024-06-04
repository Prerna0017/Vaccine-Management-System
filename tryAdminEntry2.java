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
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class tryAdminEntry2 implements ActionListener {

    public File f = new File("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine");
    int caln = 0;
    int ciln = 0;
    
    JFrame jframA2 = new JFrame("VACCINE STOCK STATISTICS");
    JLabel stStats;
    JLabel choice3;
    JButton get1;
    JButton get2;
    JButton getBk;
    JPanel A2;
    JLabel Entry;
    JLabel Stats;
    //int[] indices = new int[30];
    //int[] value = new int[30];
    //int [] index = new int[50];
    

    tryAdminEntry2(){
        initComponentsA2();
    }

    void initComponentsA2(){
        jframA2.setSize(950,600);    //size of the frame
        jframA2.setResizable(false);
        jframA2.getContentPane().setBackground(new Color(236, 188, 253));    //color of the frame
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/logo.jpg");    //giving image path to image object
        jframA2.setIconImage(imageIcon.getImage());  //setting icon on 
        
       ImageIcon image = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/StkStats.jpg");
        Image imgadmin = image.getImage();
        Image welLogo = imgadmin.getScaledInstance(70,67,6);
        image = new ImageIcon (welLogo);
        
        ImageIcon RecePic = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/doctors.jpg");
        Image img = RecePic.getImage();
        Image RegLogo = img.getScaledInstance(220,220,6);
        RecePic = new ImageIcon (RegLogo);
        JLabel background = new JLabel("",RecePic,JLabel.CENTER); //creating a label for background
        background.setBounds(570,180,220,220);  //resizing the image to its frame size
        jframA2.add(background);

        stStats = new JLabel("VACCINE STOCK STATISTICS",image,JLabel.RIGHT);
        stStats.setBounds(150,50,600,100);
        stStats.setHorizontalTextPosition(JLabel.LEFT);
        stStats.setFont(new Font("Cambria",Font.BOLD,35));
        stStats.setForeground(Color.BLACK);
        jframA2.add(stStats);
        
        A2 = new JPanel();
        A2.setSize(740, 470);
        A2.setBackground(new Color(199, 125, 255, 100));
        A2.setBounds(100,50,740,470); 
        jframA2.add(A2);
        

        choice3 = new JLabel("What do you want to do:");
        jframA2.setLayout(null);
        choice3.setBounds(150,100,400,190);
        choice3.setFont(new Font("Cambria",Font.BOLD,27));
        choice3.setForeground(Color.BLACK);
        jframA2.add(choice3);


        ImageIcon image2 = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/dEntry.jpg");
        Image img2admin = image2.getImage();
        Image ScLogo = img2admin.getScaledInstance(50,45,6);
        image2 = new ImageIcon (ScLogo);

        get1 = new JButton(image2);
        get1.setBounds(150,250,50,45); //setting location
        get1.setFont(new Font("Cambria",Font.BOLD,23));
        //get1.setBackground(new Color(255, 172, 197));
        get1.setForeground(Color.BLACK);
        get1.setBorder(BorderFactory.createSoftBevelBorder(900));
		get1.setFocusable(false);
		get1.addActionListener(this);
        jframA2.add(get1);  //adding to frame

        ImageIcon image3 = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/stats.jpg");
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

        Entry = new JLabel("Enter the Daily Statistics");
        Entry.setBounds(210,260,350,30);
        Entry.setFont(new Font("Cambria",Font.BOLD,21));
        Entry.setForeground(Color.BLACK);
        jframA2.add(Entry);

        Stats = new JLabel("View the Vaccine Stock Statistics");
        Stats.setBounds(210,320,350,30);
        Stats.setFont(new Font("Cambria",Font.BOLD,21));
        Stats.setForeground(Color.BLACK);
        jframA2.add(Stats);

        getBk = new JButton("< BACK");
        jframA2.add(getBk);  //adding to frame
        getBk.setBounds(210,430,200,30); //setting location
        getBk.setFont(new Font("Cambria",Font.BOLD,23));
        getBk.setBackground(new Color(201, 255, 226));
        getBk.setForeground(Color.BLACK);
        getBk.setBorder(BorderFactory.createSoftBevelBorder(900));
		getBk.setFocusable(false);
		getBk.addActionListener(this);

        jframA2.setLayout(null);
        jframA2.setVisible(true);
        jframA2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //should close
    }

    void createFolder(){
        if (!f.exists()){
            f.mkdirs();
        }
    }

    void readCovaFile(){
        try {
            FileReader fr =  new FileReader(f+"\\CovaVaccineData.txt");
            System.out.println("File exists");
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter(f+"\\CovaVaccineData.txt");
                System.out.println("File created");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    void readCoviFile(){
        try {
            FileReader fr =  new FileReader(f+"\\CoviVaccineData.txt");
            System.out.println("File exists");
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter(f+"\\CoviVaccineData.txt");
                System.out.println("File created");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    void addToCovaFile(int n)
    {
        String n2 ;
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\CovaVaccineData.txt","rw");
            //while((raf.readLine()) != null){
                n2 = raf.readLine();
                int n1 = Integer.parseInt(n2);
                raf.setLength(0);
                int ans = n+n1;
                System.out.println(ans);
                String ansS = String.valueOf(ans);
                System.out.println(ansS);
                
                raf.writeBytes(ansS);
            JOptionPane.showMessageDialog(null,"Data Saved Successfully");
            
        }catch(EOFException e){
            e.printStackTrace();
        } 
        catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
    }

    void addToCoviFile(int n3)
    {
        String n2 ;
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\CoviVaccineData.txt","rw");
            //while((raf.readLine()) != null){
                n2 = raf.readLine();
                int n1 = Integer.parseInt(n2);
                raf.setLength(0);
                int ans = n3+n1;
                System.out.println(ans);
                String ansS = String.valueOf(ans);
                System.out.println(ansS);
                
                raf.writeBytes(ansS);
            JOptionPane.showMessageDialog(null,"Data Saved Successfully");
            
        }catch(EOFException e){
            e.printStackTrace();
        } 
        catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    void countCovaLines(){
        try {
            caln = 1;
            RandomAccessFile raf = new RandomAccessFile(f+"\\CovaVaccineData.txt","rw");
            for (int i = 0; raf.readLine() != null; i++){
                caln++;
            }
            System.out.println("Number of Lines: "+caln);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    void countCoviLines(){
        try {
            ciln = 1;
            RandomAccessFile raf = new RandomAccessFile(f+"\\CoviVaccineData.txt","rw");
            for (int i = 0; raf.readLine() != null; i++){
                ciln++;
            }
            System.out.println("Number of Lines: "+ciln);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    void saveCovaRecords(int index,int num){
    try {
        FileWriter fW = new FileWriter(f+"\\tryCova.csv",true);
        BufferedWriter bW = new BufferedWriter(fW);
        PrintWriter pW = new PrintWriter(bW);
        pW.println(index+","+num);
        pW.flush();
        pW.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

    int countCovaIndex(){
        int count=1;
        try {
            /*FileReader fR = new FileReader(f+"\\try.csv");
            BufferedReader bR = new BufferedReader(fR);
            while ((bR.readLine()) != null){
                count++;
            }*/
            RandomAccessFile raf = new RandomAccessFile(f+"\\tryCova.csv","rw");
            for (int i = 0; raf.readLine() != null; i++){
                count++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    return count;
    }

    void saveCoviRecords(int index,int num){
        try {
            FileWriter fW = new FileWriter(f+"\\tryCovi.csv",true);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pW = new PrintWriter(bW);
            pW.println(index+","+num);
            pW.flush();
            pW.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
    }
    
    int countCoviIndex(){
            int count=1;
            try {
                /*FileReader fR = new FileReader(f+"\\try.csv");
                BufferedReader bR = new BufferedReader(fR);
                while ((bR.readLine()) != null){
                    count++;
                }*/
                RandomAccessFile raf = new RandomAccessFile(f+"\\tryCovi.csv","rw");
                for (int i = 0; raf.readLine() != null; i++){
                    count++;
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return count;
        }
/*
    int[] getIndexArray(){
        String line="";
        try {
                File f = new File("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine");
                FileWriter fw = new FileWriter(f+"\\index1.txt", true);
                FileWriter fv = new FileWriter(f+"\\valu1.txt", true);
                BufferedReader br2 = new BufferedReader(new FileReader("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine/tryCova.csv"));
                for (int i = 0;(line = br2.readLine())!=null;i++ ){
                    String[] values = line.split(",");
                    //System.out.println(values[0]);
                    fw.write(values[0]+"\n");
                    fv.write(values[1]+"\n");
                }
                BufferedReader br3 = new BufferedReader(new FileReader("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine/index1.txt"));
                for (int i = 0;(line = br3.readLine())!=null;i++ ){
                    index[i] = Integer.parseInt(br3.readLine());
                }
                System.out.println(index);
                fw.close();
                fv.close();
                br2.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    return index;
    }

    int[] getValueArray(){
        String line="";
       try {
                BufferedReader br2 = new BufferedReader(new FileReader("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine/tryCova.csv"));
                for (int i = 0;(line = br2.readLine())!=null;i++ ){
                    String[] values = line.split(",");
                    System.out.println(values[1]);
                    value[i] = Integer.parseInt(values[1]);
                    System.out.println(value[i]);
                }
                br2.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    return value;
    }

 
*/

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == getBk)
       {
           jframA2.dispose();
           AdminAction.jframA.setVisible(true);
       }
       else if (e.getSource() == get1)
       {
           String op = JOptionPane.showInputDialog(jframA2, "Enter Today's Doses..1 for Covaxin/n2 for Covishield");
           int opt = Integer.parseInt(op);
           if(opt == 1){
                String no = JOptionPane.showInputDialog(jframA2, "Enter Today's Covaxin Doses..");
                int number = Integer.parseInt(no);
                System.out.println(number);
                createFolder();
                readCovaFile();
                countCovaLines();
                addToCovaFile(number);
                saveCovaRecords(countCovaIndex(), number);
           }
           else if(opt == 2){
                String no = JOptionPane.showInputDialog(jframA2, "Enter Today's Covishield Doses..");
                int number = Integer.parseInt(no);
                System.out.println(number);
                createFolder();
                readCoviFile();
                countCoviLines();
                addToCoviFile(number);
                saveCoviRecords(countCoviIndex(), number);
           }
           else{
               JOptionPane.showMessageDialog(jframA2, "Invalid option");
           }
       }
       else if (e.getSource() == get2)
       {
            jframA2.dispose();
            int[] indices = {1,2,3,4,5,6,7,8,9};
            int[] values = {23,15,324,24,89,1,12,90,90};

                tryBarChart chart = new tryBarChart(indices,values, 0, indices[indices.length - 1] + 2, 0, 100, 1, 10);
                chart.setVisible(true);
       }
    }
}
