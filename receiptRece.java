package Final;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import jdk.internal.org.objectweb.asm.util.Printer;

public class receiptRece extends Takerlogin implements ActionListener {
    JFrame jframR2 = new JFrame();
    JPanel heading = new JPanel();
    JButton sO;
    JButton pr;
    JLabel topiclabel;
    JLabel bD;
    JLabel vD;
    JLabel bName;
    JLabel bAge;
    JLabel bPn;
    JLabel vName;
    JLabel d1;
    JLabel d2;
    JLabel vAt;
    JLabel TbName;
    JLabel TbAge;
    JLabel TbPn;
    JLabel TvName;
    JLabel Td1;
    JLabel Td2;
    JLabel TvAt;
    String line = "";
    String fullName = "";
    String fAge = "";
    String fPno = "";
    String vaccN = "";
    String fDose;
    String sDose;
    String time;
    String hospital;

    receiptRece(){
        multipleSetLogic();
        initComponentsR2();
    }

    void initComponentsR2(){
        jframR2.setSize(1050,700);    //size of the frame
        jframR2.setResizable(false);
        jframR2.getContentPane().setBackground(new Color(247, 246, 197));    //color of the frame
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/logo.jpg");    //giving image path to image object
        jframR2.setIconImage(imageIcon.getImage());  //setting icon on 

        heading.setBackground(new Color(0,0,0,20));
        heading.setBounds(0,0,1050,100); 
        jframR2.add(heading);    

        ImageIcon RecePic = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/final.jpg");
        Image img = RecePic.getImage();
        Image RegLogo = img.getScaledInstance(320,320,6);
        RecePic = new ImageIcon (RegLogo);
        JLabel background = new JLabel("",RecePic,JLabel.CENTER); //creating a label for background
        background.setBounds(700,180,320,320);  //resizing the image to its frame size
        jframR2.add(background);

        ImageIcon welIcon = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/receipt.png");
        Image imgadmin = welIcon.getImage();
        Image welLogo = imgadmin.getScaledInstance(80,80,6);
        welIcon = new ImageIcon (welLogo);
        
        topiclabel = new JLabel("RECEIPT",welIcon,JLabel.LEFT);
        topiclabel.setBounds(30,5,800,100);  //setting location
        topiclabel.setFont(new Font("Cambria", Font.BOLD, 43));
        topiclabel.setForeground(Color.BLACK);
        jframR2.add(topiclabel);  //adding it on frame

        ImageIcon image3 = new ImageIcon("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Java Project Images/signOut.png");
        Image img3admin = image3.getImage();
        Image StLogo = img3admin.getScaledInstance(80,75,6);
        image3 = new ImageIcon (StLogo);

        sO = new JButton(image3);
        sO.setBounds(900,10,80,75); //setting location
        sO.setFont(new Font("Cambria",Font.BOLD,23));
        sO.setForeground(Color.BLACK);
        sO.setBorder(BorderFactory.createSoftBevelBorder(900));
		sO.setFocusable(false);
		sO.addActionListener(this);
        jframR2.add(sO);  //adding to frame

        bD = new JLabel("Benificiary Details:");
        bD.setFont(new Font("Cambria",Font.PLAIN,28));
        bD.setForeground(Color.BLACK);
        bD.setBounds(70,150,250,40);
        jframR2.add(bD);

        bName = new JLabel("Benificiary Name:");
        bName.setFont(new Font("Cambria",Font.PLAIN,25));
        bName.setForeground(Color.BLACK);
        bName.setBounds(70,200,250,40);
        jframR2.add(bName);  

        bAge = new JLabel("Benificiary Age:");
        bAge.setFont(new Font("Cambria",Font.PLAIN,25));
        bAge.setForeground(Color.BLACK);
        bAge.setBounds(70,250,250,40);
        jframR2.add(bAge);

        bPn = new JLabel("Benificiary Contact No.:");
        bPn.setFont(new Font("Cambria",Font.PLAIN,25));
        bPn.setForeground(Color.BLACK);
        bPn.setBounds(70,300,250,40);
        jframR2.add(bPn);

        vD = new JLabel("Vaccine Details:");
        vD.setFont(new Font("Cambria",Font.PLAIN,28));
        vD.setForeground(Color.BLACK);
        vD.setBounds(70,400,250,40);
        jframR2.add(vD);
        
        vName = new JLabel("Vaccine Name:");
        vName.setFont(new Font("Cambria",Font.PLAIN,25));
        vName.setForeground(Color.BLACK);
        vName.setBounds(70,450,250,40);
        jframR2.add(vName);

        d1 = new JLabel("First Dose:");
        d1.setFont(new Font("Cambria",Font.PLAIN,25));
        d1.setForeground(Color.BLACK);
        d1.setBounds(70,500,250,40);
        jframR2.add(d1);
        
        d2 = new JLabel("Second Dose:");
        d2.setFont(new Font("Cambria",Font.PLAIN,25));
        d2.setForeground(Color.BLACK);
        d2.setBounds(70,550,250,40);
        jframR2.add(d2);

        vAt = new JLabel("Vaccine Time Slot & Scheduled at:");
        vAt.setFont(new Font("Cambria",Font.PLAIN,25));
        vAt.setForeground(Color.BLACK);
        vAt.setBounds(70,600,400,40);
        jframR2.add(vAt);

        TbName = new JLabel(fullName);
        TbName.setFont(new Font("Cambria",Font.PLAIN,25));
        TbName.setForeground(Color.BLACK);
        TbName.setBounds(500,200,250,40);
        jframR2.add(TbName);  

        TbAge = new JLabel(fAge);
        TbAge.setFont(new Font("Cambria",Font.PLAIN,25));
        TbAge.setForeground(Color.BLACK);
        TbAge.setBounds(500,250,250,40);
        jframR2.add(TbAge);  

        TbPn = new JLabel(fPno);
        TbPn.setFont(new Font("Cambria",Font.PLAIN,25));
        TbPn.setForeground(Color.BLACK);
        TbPn.setBounds(500,300,250,40);
        jframR2.add(TbPn);  

        TvName = new JLabel(vaccN);
        TvName.setFont(new Font("Cambria",Font.PLAIN,25));
        TvName.setForeground(Color.BLACK);
        TvName.setBounds(500,450,250,40);
        jframR2.add(TvName);

        Td1 = new JLabel(fDose);
        Td1.setFont(new Font("Cambria",Font.PLAIN,25));
        Td1.setForeground(Color.BLACK);
        Td1.setBounds(500,500,250,40);
        jframR2.add(Td1);
    
        Td2 = new JLabel(sDose);
        Td2.setFont(new Font("Cambria",Font.PLAIN,25));
        Td2.setForeground(Color.BLACK);
        Td2.setBounds(500,550,250,40);
        jframR2.add(Td2);

        TvAt = new JLabel (time+", "+hospital);
        TvAt.setFont(new Font("Cambria",Font.PLAIN,25));
        TvAt.setForeground(Color.BLACK);
        TvAt.setBounds(500,600,250,40);
        jframR2.add(TvAt);

        pr = new JButton("PRINT >");
        jframR2.add(pr);  //adding to frame
        pr.setBounds(800,600,200,30); //setting location
        pr.setFont(new Font("Cambria",Font.BOLD,23));
        pr.setBackground(new Color(247, 246, 197));
        pr.setForeground(Color.BLACK);
        pr.setBorder(BorderFactory.createSoftBevelBorder(900));
		pr.setFocusable(false);
		pr.addActionListener(this);

        jframR2.setLayout(null);
        jframR2.setVisible(true);
        jframR2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //should close
    }

    void printReceipt(JFrame jframR2){
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Receipt");
        printerJob.setPrintable(new Printable(){
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex>0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D graphics2D = (Graphics2D)graphics;
                graphics2D.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2 );
                graphics2D.scale(0.5, 0.5);
                jframR2.paint(graphics2D);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningResult = printerJob.printDialog();
        if (returningResult){
            try{
                printerJob.print();
            }catch(PrinterException printerException){
                JOptionPane.showMessageDialog(jframR2, this, "Print Error: "+printerException.getMessage(), 0);
            }
        } 
    }

    void readFile(){
        try {
            FileReader fr =  new FileReader(fT+"\\tryRegAll.csv");
            System.out.println("File exists");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    void multipleSetLogic(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine/tryRegAll.csv"));
            for (int i = 0;(line = br.readLine())!=null;i++ ){
                String[] values = line.split(",");
                if (uN.equals(values[0])){
                    fullName = values[1]+" "+values[2];
                    fAge = values[6];
                    fPno = values[5];
                    Takerlogin.jframet.dispose();
                }
            }


            BufferedReader br2 = new BufferedReader(new FileReader("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine/vaccRegAll.csv"));
            for (int i = 0;(line = br2.readLine())!=null;i++ ){
                String[] values = line.split(",");
                if (uN.equals(values[0])){
                    vaccN = values[1];
                    fDose = values[2];
                    sDose = values[3];
                    Takerlogin.jframet.dispose();
                }
            }

            BufferedReader br3 = new BufferedReader(new FileReader("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine/vaccDetails.csv"));
            for (int i = 0;(line = br3.readLine())!=null;i++ ){
                String[] values = line.split(",");
                if (uN.equals(values[0])){
                    time = values[2];
                    hospital = values[3];
                    Takerlogin.jframet.dispose();
                }
            }


            br.close();
            br2.close();
            br3.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == sO){
            int op = JOptionPane.showConfirmDialog(jframR2, "Signout From the Application","CONFIRMATION",JOptionPane.OK_CANCEL_OPTION);
            if (op == 0){
                JOptionPane.showMessageDialog(jframR2, "Thank You!!...Stay Healthy");
                jframR2.dispose();
                Nplog.jframe.setVisible(true);
            }
            else{
                jframR2.setVisible(true);
            }
        }
        else if (e.getSource() == pr){
            printReceipt(jframR2);
        }
    }
}
