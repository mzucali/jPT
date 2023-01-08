package minerals;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.lang.Math;
import oxydes.Oxydes;
import cations.Cations;

public class Biotite extends MineralPhase {
	public static int ideal_cation_sum=7; //<-- DROOP
	public static Double mineralOssigeniI=22.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="biotite";
	
	private double temp_Ti_Henry2005;
	
	public Biotite() {
		// TODO Auto-generated constructor stub
	}

	public Biotite(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
			ArrayList<Cations> listaCat) throws Exception {
		super(tokenizedLineStrings, listaOxTmp, listaCat);

	}

	
	public Biotite(String[] array_singola_lineaA,
			ArrayList<Oxydes> lista_Ossidi, ArrayList<Cations> lista_Cations,
			ArrayList<MineralPhase> mfsArrayList) throws Exception {
		super(array_singola_lineaA, lista_Ossidi, lista_Cations, mfsArrayList);
	}

	@Override
	protected void calcAdditionalValues() {
		super.calcAdditionalValues();
		setTuttiGliOssidiValori();
		calcT_Henry();	
		
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
		return ".bio";
	}

	public void calcT_Henry(){
		if (isTiO2_present()) {
			System.out.println("calculating T for Biotite from Ti content (Henry, 2005)");
			System.out.println("4-6kbar peraluminous Bt in metapelites");
			// T=((ln(Ti)-a-c*(Xmg)**3)/b)**0.333
			double a=-2.3594;
			//double b =0.0000000046482;
			double b =4.6482E-9;
			double c=-1.7283;
			
			double XMG = MgO.getCatVal()/(MgO.getCatVal()+FeO.getCatVal());
			System.out.println("XMG= "+XMG);
			//double XMG = 0.33;
			double Ti = TiO2.getCatVal();
			System.out.println("Ti= "+Ti);
			double logTi = Math.log(Ti); 
			System.out.println("logTi ="+logTi);
			double temp = Math.pow((logTi-a-c*(Math.pow(XMG,3)))/b,0.333333);
			System.out.println("Temperature using Ti content in Biotite is: "+temp+"\n");
			setTiTemp(temp);
			
		}
	}
	
	   private void setTiTemp(double temp) {
		temp_Ti_Henry2005=temp;
		return;
	}

	@Override
	    public void printSupplementaryHeaders(PrintWriter outWr) {
	    	// TODO Auto-generated method stub
	    	super.printSupplementaryHeaders(outWr);
	    	if(isTiO2_present()){
	    	outWr.write("\tTemp_TiContent_Henry2005");
	    	}
	    }
		
	@Override
	public void printSupplemetaryValues(PrintWriter out) {
		if(isTiO2_present()){
		out = new PrintWriter(out);
		super.printSupplemetaryValues(out);
		
		out.write("\t"+formatter.format(temp_Ti_Henry2005));
		}

	}
	
	
	
}
