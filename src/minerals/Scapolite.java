package minerals;

import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;

public class Scapolite extends MineralPhase {
	// Ca2Al3Si3O13H - zoisite/clinozoisite
	// Ca2FeAl2Si3O13H - epidote
	// Ca2Fe2AlSi3O13H - Fe-epidote
	//
	
	public static int ideal_cation_sum=15; //
	public static Double mineralOssigeniI=33.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="scapolite";
	
	
	
	public Scapolite(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
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
		return ".sc";
	}
	
	
	
	
	
	
	
}
