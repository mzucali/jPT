package minerals;

import java.io.PrintWriter;
import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;

public class Chlorite extends MineralPhase {
	public static int ideal_cation_sum=0; //<-- DROOP
	public static Double mineralOssigeniI=28.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="chlorite";
	private double ChlT;
	private double AlIV; //SU 4 SiO2+AlIV o 14 ossigeni
	
	
	public Chlorite() {
		// TODO Auto-generated constructor stub
	}

	public Chlorite(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
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
		return ".chl";
	}
	
    @Override
    protected void calcAdditionalValues() {
    	// TODO Auto-generated method stub
    	super.calcAdditionalValues();
    	setTuttiGliOssidiValori();
    	calcChlT();

    }

	private void calcChlT() {
		// IMPORTANTE
		// AlIV  calcolato su 4 cationi tra Si+AlIV (cio su 14 ossigeni su formula)
		// T (~	= -61-92 + 321.98 (AlIV)
		AlIV = 4-SiO2.getCatVal()/2;
		if(Al2O3.getCatVal()/2-AlIV>0){
		ChlT = -61.92 + (321.98*AlIV);}
		else {AlIV=0;}
		return;
	}
	
    
    @Override
    public void printSupplementaryHeaders(PrintWriter outWr) {
    	// TODO Auto-generated method stub
    	super.printSupplementaryHeaders(outWr);

    	outWr.write("\tChlTemp\tAlIV_sum_4");

    }
	
@Override
public void printSupplemetaryValues(PrintWriter out) {
	// TODO Auto-generated method stub

	out = new PrintWriter(out);
	super.printSupplemetaryValues(out);
	
	out.write("\t"+formatter.format(ChlT)+"\t"+formatter.format(AlIV));


}

}
