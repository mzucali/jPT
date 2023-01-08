package main;

import java.util.prefs.*;

@SuppressWarnings("unused")
public class PreferencesFile {

	private boolean calcFe3Droop;
	private boolean printTABoutput;
	private boolean saveXMLsample;
	private boolean preferenceFile;
	private String prefsFile;
	private final static String version = "2.1";
	
	
	
	
public PreferencesFile(){
	init();
	
}



public void init(){
	// da sviluppare
	System.out.println(" init preference file......");
	
}

public void readPreferenceFile(){
	// SE preferenceFile==true
	// ALLRA leggi preference da FILE
	// da sviluppare
}

public boolean isCalcFe3Droop() {
	return calcFe3Droop;
}



public void setCalcFe3Droop(boolean calcFe3Droop) {
	this.calcFe3Droop = calcFe3Droop;
}



public boolean isPrintTABoutput() {
	return printTABoutput;
}



public void setPrintTABoutput(boolean printTABoutput) {
	this.printTABoutput = printTABoutput;
}



public boolean isSaveXMLsample() {
	return saveXMLsample;
}



public void setSaveXMLsample(boolean saveXMLsample) {
	this.saveXMLsample = saveXMLsample;
}



@Override
public String toString() {
	return "PreferencesFile [calcFe3Droop=" + calcFe3Droop
			+ ", printTABoutput=" + printTABoutput + ", saveXMLsample="
			+ saveXMLsample + "]";
}



public static String getVersion() {
	return version;
}




	
}
