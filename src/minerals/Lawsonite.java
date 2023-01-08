package minerals;

import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;

public class Lawsonite extends MineralPhase {

	
	public static int ideal_cation_sum=8; //
	public static Double mineralOssigeniI= 8.00; //PER LWS ANIDRA, SE CON OH 10.00 OXtotale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="lawsonite";
	
	
	
	public Lawsonite(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
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
		return ".lws";
	}
	
	
	
	
	
	
	
}
