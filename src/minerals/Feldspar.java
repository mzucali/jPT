package minerals;

import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;

public class Feldspar extends MineralPhase {
	public static int ideal_cation_sum=5; //<-- DROOP
	public static Double mineralOssigeniI=8.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="feldpsar";
	
	
	public Feldspar() {
		// TODO Auto-generated constructor stub
	}

	public Feldspar(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
			ArrayList<Cations> listaCat) throws Exception {
		super(tokenizedLineStrings, listaOxTmp, listaCat);

	}

	public int getIdeal_cation_sum() {
		return ideal_cation_sum;
	}



	public Double getMineralOssigeniI() {
		return mineralOssigeniI;
	}

	

	public String getMineralNameString() {
		return mineralNameString;
	}

	public String getExtension() {
		return ".fds";
	}

}