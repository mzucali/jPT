package minerals;

import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;

public class Epidote extends MineralPhase {
	// Ca2Al3Si3O13H - zoisite/clinozoisite
	// Ca2FeAl2Si3O13H - epidote
	// Ca2Fe2AlSi3O13H - Fe-epidote
	//
	
	public static int ideal_cation_sum=8; //
	public static Double mineralOssigeniI=12.50; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="epidote";
	
	
	
	public Epidote(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
			ArrayList<Cations> listaCat) throws Exception {
		
		super(tokenizedLineStrings, listaOxTmp, listaCat);

		checkFe2O3();
/*		calcMineralFormula();
		calcAdditionalValues();


	setTuttiGliOssidiValori(); // con questo estrai dagli ArrayList i valori


	out1 = new File(AnalysisDataFile.getInputFile() +"_OUT_"+ getExtension()+".xls");

	printSorted();*/
    }
    
    

	
	public void checkFe2O3(){
		

		
		return;
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
		return ".ep";
	}
	
	
	
	
	
	
	
}
