package minerals;

import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;


public class Qtz extends MineralPhase {
	public static int ideal_cation_sum=1; //
	public static Double mineralOssigeniI=2.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="quartz";
	
	
	public Qtz(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
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
	
}
