package minerals;

import java.io.File;
import java.util.ArrayList;


import oxydes.Oxydes;
import cations.Cations;
import datafiles.AnalysisDataFile;

public class Clinohumite extends MineralPhase {

	
	public static int ideal_cation_sum=13; //
	public static Double mineralOssigeniI=18.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="clinohumite";
	
	
	
	public Clinohumite(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
			ArrayList<Cations> listaCat) throws Exception {
		
		super(tokenizedLineStrings, listaOxTmp, listaCat);

    }

	
	public Double getMineralOssigeniI() {
		return mineralOssigeniI;
	}
	
	public int getIdeal_cation_sum() {
		return ideal_cation_sum;
	}
	
	public String getMineralNameString() {
		return mineralNameString;
	}
	
	public String getExtension() {
		return ".chum";
	}
	
	
	
	
	
	
	
}
