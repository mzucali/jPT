package minerals;

import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;

public class Pumpellyite extends MineralPhase {

	
	public static int ideal_cation_sum=8; //
	public static Double mineralOssigeniI=12.00; //PER PMP ANIDRA, SE CON OH 14.00 OXtotale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="pumpellyite";
	
	
	
	public Pumpellyite(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
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
		return ".pump";
	}
	
	
	
	
	
	
	
}
