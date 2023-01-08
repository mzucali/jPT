package minerals;

import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;

public class Serpentine extends MineralPhase {

	
	public static int ideal_cation_sum=5; //
	public static Double mineralOssigeniI=28.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="serpentine";
	
	
	
	public Serpentine(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
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
		return ".serp";
	}
	
	
	
	
	
	
	
}
