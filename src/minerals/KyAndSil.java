	package minerals;

import java.util.ArrayList;

import oxydes.Oxydes;
//import sun.tools.tree.SuperExpression;
import cations.Cations;

public class KyAndSil extends MineralPhase {

	//Al2SiO5 - sil kyanite andalusite
	
	static int  ideal_cation_sum=12; //
	static Double  mineralOssigeniI=20.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	static String mineralNameString="KyAndSil";
	

	
	
	
	public KyAndSil(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
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
	return ".als";
}
}
