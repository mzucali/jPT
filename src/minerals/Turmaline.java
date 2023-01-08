package minerals;

import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;

public class Turmaline extends MineralPhase {

	
	public static int ideal_cation_sum=20; //
	public static Double mineralOssigeniI=31.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="turmaline";
	
	
	
	public Turmaline(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
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
		return ".turm";
	}
	
	
	
	
	
	
	
}
