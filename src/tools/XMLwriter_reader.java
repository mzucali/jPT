package tools;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;

import sample.Sample;


import datafiles.AnalysisDataFile;

import minerals.MineralPhase;


/*@author: miki, 26/11/2009

questa classe serve per salvare gli oggetti su file di testo XML
per ora (26/11/2009) è possibile salvare gli oggetti dalle classi:
sample.class, 
AnalysisDataFile.class,  
MineralPhase.class


ESEMPIO
try{
//write
	sample sp0 = new sample();
	sp0.setFoo("ciccio");
	
XMLwriter_reader.write(sp0, "sample.xml");

//read        
sample sp3 = XMLwriter_reader.read("sample.xml");
        System.out.print("sp3 :"+sp3.getFoo());
		//sp3.printSampleName();
	}catch(Exception e){e.printStackTrace();}
*/




public class XMLwriter_reader {
    
// WRITE and READ sample.class
	public static void writeSample(Sample f, String filename) throws Exception{
        XMLEncoder encoder =
           new XMLEncoder(
              new BufferedOutputStream(
                new FileOutputStream(filename)));
        encoder.writeObject(f);
        encoder.close();
    }

    public static Sample readSample(String filename) throws Exception {
        XMLDecoder decoder =
            new XMLDecoder(new BufferedInputStream(
                new FileInputStream(filename)));
        Sample o = (Sample)decoder.readObject();
        decoder.close();
        return o;
    }

// WRITE and READ AnalysisDataFile.class

public static void writeAnalysisDataFile(AnalysisDataFile f, String filename) throws Exception{
    XMLEncoder encoder =
       new XMLEncoder(
          new BufferedOutputStream(
            new FileOutputStream(filename)));
    encoder.writeObject(f);
    encoder.close();
}

public static AnalysisDataFile readAnalysisDataFile(String filename) throws Exception {
    XMLDecoder decoder =
        new XMLDecoder(new BufferedInputStream(
            new FileInputStream(filename)));
    AnalysisDataFile o = (AnalysisDataFile)decoder.readObject();
    decoder.close();
    return o;
}


// WRITE and READ MineralPhase.class

public static void writeMineralPhase(MineralPhase f, String filename) throws Exception{
    XMLEncoder encoder =
       new XMLEncoder(
          new BufferedOutputStream(
            new FileOutputStream(filename)));
    encoder.writeObject(f);
    encoder.close();
}

public static MineralPhase readMineralPhase(String filename) throws Exception {
    XMLDecoder decoder =
        new XMLDecoder(new BufferedInputStream(
            new FileInputStream(filename)));
    MineralPhase o = (MineralPhase)decoder.readObject();
    decoder.close();
    return o;
}




}