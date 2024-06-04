package Final;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class VaccineSlots{

    File fV = new File("C:/Users/Jadhav/Desktop/2nd year/4th sem/Java Programming/Project/Vaccine");
    int Vln = 2;

    static int noOfCovaxinDoses = 100;
    static int noOfCovishieldDoses = 100;

    void createFolder(){
        if (!fV.exists()){
            fV.mkdirs();
        }
    }

    void readVFile(){
        try {
            FileReader fr =  new FileReader(fV+"\\vaccineData.txt");
            System.out.println("File exists");
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter(fV+"\\vaccineData.txt");
                System.out.println("File created");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        
    }

    void multipleSetVLogic(int Covaxin, int Covishield){
        try {
            RandomAccessFile raf = new RandomAccessFile(fV+"\\vaccineData.txt","rw");
            
            /*int i;
            for (i = 0; i<=Vln; i+=2){
                System.out.println("count: "+i);
               // String line = raf.readLine();
                String forCovaxin ;
                String line2 = raf.readLine();
                String forCovishield = line2.substring(9);*/
                String forCovaxin,forCovishield;
            if(Covaxin.isSelected())
            {
                if("Covaxin".equals(forCovaxin))
                {
                    String line = raf.readLine();
                    forCovaxin = line.substring(9);
                }
            }
            if(Covishield.isSelected())
            {
                if("Covishield".equals(forCovishield))
                {
                    String line = raf.readLine();
                    forCovishield = line.substring(9);
                }
            }/*
            if(.equals(forRUser) & encryptedCheckPassd.equals(forRPswd)){
                    JOptionPane.showMessageDialog(null,"Password Matched");
                    jframet.dispose();
                    tryReceAction r = new tryReceAction();
                }
                else if (i == (Vln-1)){
                    JOptionPane.showMessageDialog(null,"Wrong Password");
                    //System.out.println("Wrong Password");
                }
                for (int k = 1; k<=1; k++){
                    raf.readLine();
                }
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void countLines(){
        try {
            Tln = 1;
            RandomAccessFile raf = new RandomAccessFile(fT+"\\adminLogins.txt","rw");
            for (int i = 0; raf.readLine() != null; i++){
                Tln++;
            }
            System.out.println("Number of Lines: "+Tln);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    void addData(int Covaxin, int Covishield){
        try {
            RandomAccessFile raf = new RandomAccessFile(fV+"\\vaccineData.txt","rw");
            for (int i = 0; i < Vln; i++){
                raf.readLine();
            }
            
            raf.writeBytes("Covaxin:"+Covaxin+"\r\n");
            raf.writeBytes("Covishield:"+Covishield+"\r\n");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void reduceCovaxin(){
        noOfCovaxinDoses--;
        System.out.println("No.of Covaxin Doses: "+noOfCovaxinDoses);
    }
    void reduceCovishield(){
        noOfCovishieldDoses--;
        System.out.println("No.of Covishield Doses: "+noOfCovishieldDoses);
    }
}
