/*
 * jeol2jpt.java
 *
 * Created on March 19, 2007, 1:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tools;

/**
 *
 * @author miki
 */

//import jPT.Forms.jPTMainTab;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.regex;

import main.gui.jMineralCalc;


public class jeol2jpt {
    private static String inFile;
    private static String outFile;
    private static File outputFile;
    private static PrintWriter out;
    private static String[] array1;
    
    private static String inputFile;
    private static int lines;
    private static String sample;
    private static String mineral;
    private static double analisi;
    private static double SiO2=0;
    private static double TiO2=0;
    private static double Na2O=0;
    private static double Al2O3=0;
    private static double FeO=0;
    private static double MgO=0;
    private static double MnO=0;
    private static double ZnO=0;
    private static double Cr2O3=0;
    private static double K2O=0;
    private static double CaO=0;
    private static double Cl=0;
    
    private static String s1;
    private static String s2;
    private static String[] linee; // = new String[lineCount-1];
    
 //   public static void main(String [ ] args) throws FileNotFoundException, IOException {
   
        /** Creates a new instance of jeol2jpt */
         public jeol2jpt(String inFile)throws FileNotFoundException, IOException {
        
        
        inputFile = inFile;
        
        BufferedReader in = new BufferedReader(new FileReader(inputFile));
 //       jPTMainTab.printText("*********************");
        // READS FROM INPUT FILE AND COUNTS NUMBER OF LINES (lineCount)
        
        int lineCount = 0;
        try {
            while ((s1 = in.readLine()) != null)
                lineCount++;
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
        
        in.close();
        
        System.out.println("lines: "+lineCount);
       
        outputFile = new File("outJPT.txt");
        out = new PrintWriter(new FileWriter(outputFile));
        out.print("sample\tmineral\tSiO2\tTiO2\tNa2O\tAl2O3\tFeO\tMgO\tMnO\tZnO\tCr2O3\tK2O\tCaO\tCl\n");
        //print FOU "Sample mineral SiO2 TiO2 Na2O Al2O3  FeO  MgO  MnO  ZnO  Cr2O3  K2O  CaO \n";
        out.close();
        
        BufferedReader in3 = new BufferedReader(new FileReader(inputFile));
        analisi=0;
        
        for (int i = 0; i < lineCount; i++){
            s2 = in3.readLine();
            System.out.println("linea "+s2);
            String[] array = s2.split("\t");
            for(String a: array){System.out.println("array: "+a);}
            //           System.out.println("array[1]: "+array[1]);
            
            if (array.length>2){
                // Pattern p = Pattern.compile("a-zZ-A");
                // Pattern p = Pattern.compile("[\\.]");
                Pattern p = Pattern.compile("[a-zA-Z]");
                Matcher m = p.matcher(array[2]);
                if (m.find()){
                    System.out.println("trovato : "+array[2]);
                    sample = array[2];
                }
            }
            
            
            // cerca SIO2
            if (array[0].equalsIgnoreCase("SiO2")) {
                
                SiO2 = Double.parseDouble(array[1]);
                System.out.println("SIO2 = "+SiO2);
            }
            
            // cerca Na2O
            if (array[0].equalsIgnoreCase("Na2O")) {
                
                Na2O = Double.parseDouble(array[1]);
                System.out.println("Na2O = "+Na2O);
            }
            
            // cerca K2O
            if (array[0].equalsIgnoreCase("K2O")) {
                
                K2O = Double.parseDouble(array[1]);
                System.out.println("K2O = "+K2O);
            }
            
            // cerca FeO
            if (array[0].equalsIgnoreCase("FeO")) {
                
                FeO = Double.parseDouble(array[1]);
                System.out.println("FeO = "+FeO);
            }
            
            // cerca MgO
            if (array[0].equalsIgnoreCase("MgO")) {
                
                MgO = Double.parseDouble(array[1]);
                System.out.println("MgO = "+MgO);
            }
            
            // cerca Al2O3
            if (array[0].equalsIgnoreCase("Al2O3")) {
                
                Al2O3 = Double.parseDouble(array[1]);
                System.out.println("Al2O3 = "+Al2O3);
            }
            
            // cerca ZnO
            if (array[0].equalsIgnoreCase("ZnO")) {
                
                ZnO = Double.parseDouble(array[1]);
                System.out.println("ZnO = "+ZnO);
            }
            
            // cerca TiO2
            if (array[0].equalsIgnoreCase("TiO2")) {
                
                TiO2 = Double.parseDouble(array[1]);
                System.out.println("TiO2 = "+TiO2);
            }
            
            // cerca Cr2O3
            if (array[0].equalsIgnoreCase("Cr2O3")) {
                
                Cr2O3 = Double.parseDouble(array[1]);
                System.out.println("Cr2O3 = "+Cr2O3);
            }
            
            // cerca CaO
            if (array[0].equalsIgnoreCase("CaO")) {
                
                CaO = Double.parseDouble(array[1]);
                System.out.println("CaO = "+CaO);
            }
            
            // cerca Cl
            if (array[0].equalsIgnoreCase("Cl")) {
                
                Cl = Double.parseDouble(array[1]);
                System.out.println("Cl = "+Cl);
            }
            
            if (array[0].equalsIgnoreCase("Total")){
                
                System.out.println("fine analisi");
                analisi++;
                //   in3.close();
                out = new PrintWriter(new FileWriter(outputFile, true));
                //     out = new PrintWriter(new FileWriter(out1, true));
                mineral="xx";
                out.print(sample+"\t"+mineral+"\t"+SiO2+"\t"+TiO2+"\t"+Na2O+"\t"+Al2O3+"\t"
                        
                        +FeO+"\t"+MgO+"\t"+MnO+"\t"+ZnO+"\t"+Cr2O3+"\t"+K2O+"\t"+CaO+"\t"+Cl+"\n");
                out.close();
            }
            
        }
     //   jPTMainTab.printText("analisi totali: "+analisi);
      //  jPTMainTab.printText("results written on: "+outputFile.toString());
        System.out.println("analisi totali: "+analisi);
    }
}






