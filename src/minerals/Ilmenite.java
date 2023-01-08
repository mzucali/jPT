package minerals;

import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;

public class Ilmenite extends MineralPhase {
	public static int ideal_cation_sum=2; //<-- DROOP
	public static Double mineralOssigeniI=3.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="ilmenite";
	
	
	public Ilmenite() {
		// TODO Auto-generated constructor stub
	}

	public Ilmenite(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
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
		return ".ilm";
	}

}
