/*
 * jpt2AXdomino.java
 *
 * Created on November 10, 2006, 11:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tools;

/**
 *
 * @author miki
 */


//import jPT.Forms.jPTMainTab1;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class jpt2Domino {
    
    private static String inFile;
    private static String outFile;
    private static File outputFile;
    private static PrintWriter out;
    private static String[] array1;
    private static String[] array_of_NOMI_DI_OSSIDI;

    
    /**
     * Creates a new instance of jpt2AXdomino
     */

    public void jpt2Domino_calc(String inFile) throws FileNotFoundException, IOException {
    
        jpt2Domino.setInFile(inFile);
        jpt2Domino.setOutFile(inFile+"_.THERIN");
        setOutFile(getOutFile());
        //setInFile(inFile);
        //inFile = args[0];
        //outFile = args[1];
        BufferedReader in = new BufferedReader(new FileReader(getInFile()));
        outputFile = new File(getOutFile());
        out = new PrintWriter(new FileWriter(outputFile));
        //jPTMainTab1.printText("testo");
        System.out.println("*********************");
        //jPTMainTab1.printText("*********************");
        System.out.println("Routine to convert MinTab-like files (es: jpt) to DOMINO-formatted files \n");
        //jPTMainTab1.printText("Routine to convert MinTab-like files (es: jpt) to DOMINO-formatted files \n");
        System.out.println("by Michele Zucali - 1st JANUARY 2009 \n");
        //jPTMainTab1.printText("by Michele Zucali - 1st JANUARY 2009 \n");
        System.out.println("Dip. Scienze della Terra A. Desio - Milano");
        //jPTMainTab1.printText("Dip. Scienze della Terra A. Desio - Milano");
        System.out.println("http://users.unimi.it/mzucali"+" - Michele.Zucali@unimi.it \n");
        //jPTMainTab1.printText("http://users.unimi.it/mzucali"+" - Michele.Zucali@unimi.it \n");
        System.out.println("http://users.unimi.it/mzucali/dev/jPT.htm");
        //jPTMainTab1.printText("http://users.unimi.it/mzucali/dev/jPT.htm");
        
        System.out.println("input file: " + inFile + " ; output file : " + getOutFile());
        //jPTMainTab1.printText("input file: " + inFile + " ; output file : " + getOutFile());
        String s2;
        int lineCount = 0;
        try {
            while ((in.readLine()) != null)                //		System.out.println(in.readLine());
                lineCount++;
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
        in.close();
        
        System.out.println("number of lines in input file: "+lineCount);
        //jPTMainTab1.printText("number of lines in input file: "+lineCount);
        
        int numOfAnalysis = --lineCount;


// SCRIVE LE LINEE DI TESTO DI COMMENTO CHE SI TROVANO NEI FILE THERIN DI DE_CAPITANI
        write_out_headers();


        // LEGGE GLI array_of_chemical_species (nomi degli OSSIDI) DAL FILE JPT E LI SALVA in array_of_NOMI_DI_OSSIDI

        BufferedReader in1 = new BufferedReader(new FileReader(inFile));
        String s1 = in1.readLine();
        array_of_NOMI_DI_OSSIDI = s1.split("\\t");
        for (int i=2;i<array_of_NOMI_DI_OSSIDI.length; i++)
       //     out.write(array[i]);
 //           out.write(" " + array[i]);
 //       out.write("\n");
 //       System.out.println("writing headers on out file");
 //       jPTMainTab1.printText("writing headers on out file");


            check_and_change_NOMI_DI_OSSIDI(array_of_NOMI_DI_OSSIDI);

        for (int j=0; j<numOfAnalysis;j++){
            s2 = in1.readLine();
            
            // --> CAMBIA label per minerali
            array1 = s2.split("\\t");
         //   changeMinLabel();
            
            for (int k = 2; k < array1.length; k++) {
                out.write(array_of_NOMI_DI_OSSIDI[k] + "("+array1[k]+")");
            }
            out.write("    *   "+array1[1]+" "+array1[0]+"\n");
           // out.write("\n");
            
            
        }
        System.out.println("writing analyses on out file");
        //jPTMainTab1.printText("writing analyses on out file");
        out.write("*");
        out.write("\n");
        out.close();
        in1.close();
        System.out.println("closing files and exiting");
        //jPTMainTab1.printText("closing files and exiting");
    //    System.exit(0);
        
    }
    
    static void changeMinLabel() {
                /*
                 * ("wm 22 || Bi,bt 22 || ep 25 ||"); ("gt,grt 12 || il,ilm 3 || px,cpx
                 * 6 || ch,chl 28 ||"); ("cd,crd 18 || ct,ctd,cld 14 || cc 14 || am,amp
                 * 23 ||"); ("sp 32 || fd,fs,kfs 8 || as,als 20 || ol 4 ||"); ("sa,sap
                 * 20 sapphirine || se,serp 28 serpentine"); ("rt 20 || st 20 || st 20 ||
                 * ta,tc,tlc 22 || sp- spinel || turm-turmaline || cor-corindone ||");
                 * ("xx 10"); (" 1 unknown");
                 */
        if (array1[1].equalsIgnoreCase("Gt")
        || array1[1].equalsIgnoreCase("grt")
        || array1[1].equalsIgnoreCase("ga")) {
            array1[1] = "g";
        } else if (array1[1].equalsIgnoreCase("AM")
        || array1[1].equalsIgnoreCase("amp")
        || array1[1].equalsIgnoreCase("amph")) {
            array1[1] = "amph";
        } else if (array1[1].equalsIgnoreCase("CI")
        || array1[1].equalsIgnoreCase("ctd")
        || array1[1].equalsIgnoreCase("ct")
        || array1[1].equalsIgnoreCase("cld")) {
            array1[1] = "ctd";
        } else if (array1[1].equalsIgnoreCase("BI")
        || array1[1].equalsIgnoreCase("bt")) {
            array1[1] = "bi";
        } else if (array1[1].equalsIgnoreCase("wm")) {
            array1[1] = "mu";
        } else if (array1[1].equalsIgnoreCase("fds")
        || array1[1].equalsIgnoreCase("fs")
        || array1[1].equalsIgnoreCase("kfs")
        || array1[1].equalsIgnoreCase("ab")
        || array1[1].equalsIgnoreCase("pl")       
        || array1[1].equalsIgnoreCase("an")) {
            array1[1] = "fsp";
        } else if (array1[1].equalsIgnoreCase("ep")) {
            array1[1] = "ep";
        } else if (array1[1].equalsIgnoreCase("px")
        || array1[1].equalsIgnoreCase("cpx")) {
            array1[1] = "cpx";
        } else if (array1[1].equalsIgnoreCase("opx")) {
            array1[1] = "opx";
        } else if (array1[1].equalsIgnoreCase("ch")) {
            array1[1] = "chl";
        } else if (array1[1].equalsIgnoreCase("tlc")
        || array1[1].equalsIgnoreCase("ta")
        || array1[1].equalsIgnoreCase("tc")) {
            array1[1] = "ta";
        } else if (array1[1].equalsIgnoreCase("scap")) {
            array1[1] = "scap";
        } else if (array1[1].equalsIgnoreCase("ol")) {
            array1[1] = "ol";
        } else if (array1[1].equalsIgnoreCase("cd")
        || array1[1].equalsIgnoreCase("crd")) {
            array1[1] = "cd";
        } else if (array1[1].equalsIgnoreCase("st")) {
            array1[1] = "st";
        } else if (array1[1].equalsIgnoreCase("sp")) {
            array1[1] = "sp";
        } else if (array1[1].equalsIgnoreCase("cc")) {
            array1[1] = "carb";
        } else if (array1[1].equalsIgnoreCase("il")
        || array1[1].equalsIgnoreCase("ilm")) {
            array1[1] = "ilhem";
        } else if (array1[1].equalsIgnoreCase("sa")
        || array1[1].equalsIgnoreCase("sap")) {
            array1[1] = "spr";
        } else if (array1[1].equalsIgnoreCase("osm")) {
            array1[1] = "osm";
        }
    }

    public static String getInFile() {
        return inFile;
    }

    public static void setInFile(String aInFile) {
        inFile = aInFile;
    }

    public static String getOutFile() {
        return outFile;
    }

    public static void setOutFile(String aOutFile) {
        outFile = aOutFile;
    }

    private void check_and_change_NOMI_DI_OSSIDI(String[] array_of_NOMI_DI_OSSIDI) {
    int u;
        for (u=0;u<array_of_NOMI_DI_OSSIDI.length;u++)
        
        if (array_of_NOMI_DI_OSSIDI[u].equalsIgnoreCase("Al2O3"))
        {array_of_NOMI_DI_OSSIDI[u] = "AL";}

        else if (array_of_NOMI_DI_OSSIDI[u].equalsIgnoreCase("SiO2"))
        {array_of_NOMI_DI_OSSIDI[u] = "SI"; }
            else if (array_of_NOMI_DI_OSSIDI[u].equalsIgnoreCase("MGO"))
        {array_of_NOMI_DI_OSSIDI[u] = "MG"; }
            else if (array_of_NOMI_DI_OSSIDI[u].equalsIgnoreCase("FEO"))
        {array_of_NOMI_DI_OSSIDI[u] = "FE"; }
            else if (array_of_NOMI_DI_OSSIDI[u].equalsIgnoreCase("MNO"))
        {array_of_NOMI_DI_OSSIDI[u] = "MN"; }
            else if (array_of_NOMI_DI_OSSIDI[u].equalsIgnoreCase("NA2O"))
        {array_of_NOMI_DI_OSSIDI[u] = "NA"; }
            else if (array_of_NOMI_DI_OSSIDI[u].equalsIgnoreCase("CAO"))
        {array_of_NOMI_DI_OSSIDI[u] = "CA"; }
            else if (array_of_NOMI_DI_OSSIDI[u].equalsIgnoreCase("K2O"))
        {array_of_NOMI_DI_OSSIDI[u] = "K"; }
            else {array_of_NOMI_DI_OSSIDI[u]="XXX";}
    }
            

    private void write_out_headers() throws FileNotFoundException, IOException {
    File inputFile = new File("THERIN_headers.txt");
//	File outputFile = new File("outagain.txt");

        FileReader in = new FileReader(inputFile);
 //       FileWriter out = new FileWriter(outputFile);
        int c;

        while ((c = in.read()) != -1)
           out.write(c);

        in.close();
        out.close();
    }
    
}
