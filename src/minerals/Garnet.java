package minerals;

import java.io.PrintWriter;
import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;
import datafiles.AnalysisDataFile;


public class Garnet extends MineralPhase {

	// (Ca,Fe,Mg)3 Al2 Si3 O12
	
	public static int ideal_cation_sum=8; //
	public static Double mineralOssigeniI=12.00; //totale ossigeni TEORICI per il ricalcolo del mineral
	public static String mineralNameString="garnet";
	
	public double alm;
	public double py;
	public double grs;
	public double spss;
	private boolean setAlmPyGrsTRUE=false;

	
//	public static String extension = ".grt";

	public Garnet(){
			print();
		}    
    
	void print() {
		System.out.println("garnet extends MineralPhase");
    }
	
	
    public Garnet(String[] tokenizedLineStrings, ArrayList<Oxydes> listaOxTmp,
			ArrayList<Cations> listaCat) throws Exception {
		super(tokenizedLineStrings, listaOxTmp, listaCat);
    	System.out.println("\n Extended garnet subclass....\n");
    	//check
    	//if(isCalcFormulaB()==true){
    	//calcAlmPyGrsSpss();
    	//}else{}

    }
    
    
    public void calcFe3_R() throws Exception{
//    	if(isDROOP_B()==false){
//    		if(listaOssidi.get(AnalysisDataFile.getTokenFe2O3()).getOxyVal()==null){
    		System.out.println("calculating Fe3+ and Fe2O3 for Garnet");

    			calcFe3_Droop();
//    			
//    		}
//    	System.out.println("NO DROOP needed");
//    	}

    
    	
    }
    
    @Override
    protected void calcAdditionalValues() {
    	// TODO Auto-generated method stub
    	super.calcAdditionalValues();
    	setTuttiGliOssidiValori();
    	calcAlmPyGrsSpss();
    	try {
			calcFe3_R();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void calcAlmPyGrsSpss(){
    	if(MineralPhase.isMnO_present()){
    	//if(AnalysisDataFile.getTokenMnO()!=null){
    	//	CASO  MnO 
    		
    	//	System.out.println("MnO present: "+getListaOssidi().get(AnalysisDataFile.getTokenMnO()).getCatVal());// MineralPhase.getFeO.getCatVal());
    	//	System.out.println("MnO present: "+MnO.getCatVal());
    	alm = FeO.getCatVal()/(FeO.getCatVal()+MgO.getCatVal()+CaO.getCatVal()+MnO.getCatVal())*100;
    	py = MgO.getCatVal()/(FeO.getCatVal()+MgO.getCatVal()+CaO.getCatVal()+MnO.getCatVal())*100;
    	grs = CaO.getCatVal()/(FeO.getCatVal()+MgO.getCatVal()+CaO.getCatVal()+MnO.getCatVal())*100;
    	spss = MnO.getCatVal()/(FeO.getCatVal()+MgO.getCatVal()+CaO.getCatVal()+MnO.getCatVal())*100;
    	}else{
    		// CASO MnO = 0;
        	alm = FeO.getCatVal()/(FeO.getCatVal()+MgO.getCatVal()+CaO.getCatVal())*100;
        	py = MgO.getCatVal()/(FeO.getCatVal()+MgO.getCatVal()+CaO.getCatVal())*100;
        	grs = CaO.getCatVal()/(FeO.getCatVal()+MgO.getCatVal()+CaO.getCatVal())*100;
        	spss = 0.00;
    	}
    	
    	setAlm(alm);
    	setPy(py);
    	setGrs(grs);
    	setSpss(spss);
    	System.out.println("\t"+formatter.format(getAlm())+"\t"+formatter.format(getPy())+"\t"+formatter.format(getGrs())+"\t"+formatter.format(getSpss()));
    	setAlmPyGrsTRUE=true;
    
    
    
    }
	
    
    @Override
    public void printSupplementaryHeaders(PrintWriter outWr) {
    	// TODO Auto-generated method stub
    	super.printSupplementaryHeaders(outWr);
    	if(setAlmPyGrsTRUE&&isDROOP_B()){
    	outWr.write("\tAlm\tPy\tGrs\tSpss\tFe2_NEW\tFE3_NEW\tFEO_NEW\tFE2O3_NEW");
    	}else if (setAlmPyGrsTRUE) {
    		outWr.write("\tAlm\tPy\tGrs\tSpss");
		}else if (isDROOP_B()) {
			outWr.write("\tFe2_NEW\tFE3_NEW\tFEO_NEW\tFE2O3_NEW");
			
		}
    }
	
@Override
public void printSupplemetaryValues(PrintWriter out) {
	// TODO Auto-generated method stub
	if(setAlmPyGrsTRUE==false){calcAlmPyGrsSpss();}
	try {
		calcFe3_R();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	out = new PrintWriter(out);
	super.printSupplemetaryValues(out);
	if(isDROOP_B()){
	out.write("\t"+formatter.format(getAlm())+"\t"+formatter.format(getPy())+"\t"+formatter.format(getGrs())+"\t"+formatter.format(getSpss())+"\t"+formatter.format(Fe2_new)+"\t"+formatter.format(Fe3_new)
			+"\t"+formatter.format(FeO_new)+"\t"+formatter.format(Fe2O3_new));
	} else {
		out.write("\t"+formatter.format(getAlm())+"\t"+formatter.format(getPy())+"\t"+formatter.format(getGrs())+"\t"+formatter.format(getSpss()));
	}

}
/*public  void printSupplemetaryValues(PrintWriter out) {
		setAlmPyGrs();
    	System.out.println("\t"+formatter.format(getAlm())+"\t"+formatter.format(getPy())+"\t"+formatter.format(getGrs())+"\t"+formatter.format(getSpss()));
    	out.write("\t"+formatter.format(getAlm())+"\t"+formatter.format(getPy())+"\t"+formatter.format(getGrs())+"\t"+formatter.format(getSpss()));
    	out.write("\t" + formatter.format(getSUM_cationsD()));
    	out.write("\t"+formatter.format(12.333456));

    }*/


	
	public Double getMineralOssigeniI() {
		return mineralOssigeniI;
	}

	public int getIdeal_cation_sum() {
		return ideal_cation_sum;
	}

	public String getMineralNameString() {
		return mineralNameString;
	}
	
//	public String getExtension() {
//		return extension;
//	}




	public double getAlm() {
		return alm;
	}

	public void setAlm(double alm) {
		this.alm = alm;
	}

	public double getPy() {
		return py;
	}

	public void setPy(double py) {
		this.py = py;
	}

	public double getGrs() {
		return grs;
	}

	public void setGrs(double grs) {
		this.grs = grs;
	}

	public double getSpss() {
		return spss;
	}

	public void setSpss(double spss) {
		this.spss = spss;
	}

	public String getExtension() {
		return ".grt";
	}

    
	
	
	
	
	
	
	
	
}
