package minerals;

import java.io.PrintWriter;
import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;

public class Pyroxene extends MineralPhase {
	// NaAlSi2O6 - jadeite
	
	public static int ideal_cation_sum=4; //
	public static Double mineralOssigeniI=6.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="pyroxene";
	
	public double T; // 2
	public double M; // 1
	public double Z; // 1
	public double AlIV;
	public double AlVI;
	
	public Pyroxene(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
			ArrayList<Cations> listaCat) throws Exception {
		super(tokenizedLineStrings, listaOxTmp, listaCat);

    }
    
    

	public void checkSites() throws Exception{
		
		
		try {
			
		
		//check sites for pyroxene
		//T=2 (Si + AlIV), M=1 (AlVI + resto tranne Na-Ca), Z=1 (Na+Ca)
		
		T = 2;
		AlIV = T -SiO2.getCatVal();
		AlVI = Al2O3.getCatVal()-AlIV;
		
		if (isFe2O3_present()){
		// due opzioni in caso di Fe2O3 presente o NO
		M = AlVI  + FeO.getCatVal() + MgO.getCatVal() + MnO.getCatVal() + Fe2O3.getCatVal();
		}else{
			M = AlVI  + FeO.getCatVal() + MgO.getCatVal() + MnO.getCatVal();
		}
		
		Z = Na2O.getCatVal() + CaO.getCatVal();
		
		} catch (Exception e) {
			System.out.println("cat not found");		
}
		System.out.println(" T = "+T + " M = "+M+" Z = "+Z);	
		setT(T);
		setM(M);
		setZ(Z);
		setAlVI(AlVI);
		setAlIV(AlIV);
	}
	
    @Override
    public void printSupplementaryHeaders(PrintWriter outWr) {
    	super.printSupplementaryHeaders(outWr);
    	outWr.write("\tAl_IV\tAl_VI\tT\tM\tZ");
    	try {
			calcFe3_Droop();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	if(isDROOP_B()){
    		outWr.write("\tFe2_old\tFe2_new\tFe3\tFe2O3\tFeO_new");	
    	}
    }
	
@Override
public void printSupplemetaryValues(PrintWriter out) {
	out = new PrintWriter(out);
//	super.printSupplemetaryValues(out);
	try {
		System.out.println("check sites da printSummplementaryValues....");
		checkSites();
		//calcFe3_Droop();
	} catch (Exception e) {
		e.printStackTrace();
	}
	out.write("\t"+formatter.format(getAlIV())+"\t"+formatter.format(getAlVI())+"\t"+formatter.format(getT())+"\t"+formatter.format(getM())+"\t"+formatter.format(getZ()));

	System.out.println("\t"+formatter.format(getAlVI())+"\t"+formatter.format(getAlIV())+"\t"+formatter.format(getT())+"\t"+formatter.format(getM())+"\t"+formatter.format(getZ()));
	if(isDROOP_B()){
	out.write("\t"+formatter.format(getFe2_old())+"\t"+formatter.format(getFe2_new())+"\t"+formatter.format(getFe3_new())+"\t"+formatter.format(getFe2O3_new())+"\t"+formatter.format(getFeO_new()));
}
}

public double getT() {
	return T;
}



public void setT(double t) {
	T = t;
}



public double getM() {
	return M;
}



public void setM(double m) {
	M = m;
}



public double getZ() {
	return Z;
}



public void setZ(double z) {
	Z = z;
}



public double getAlIV() {
	return AlIV;
}



public void setAlIV(double alIV) {
	AlIV = alIV;
}



public double getAlVI() {
	return AlVI;
}



public void setAlVI(double alVI) {
	AlVI = alVI;
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
		return ".px";
	}



}
