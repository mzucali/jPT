package minerals;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import main.gui.jMineralCalc;


import atoms.carbongroup.Si;

//import com.sun.java_cup.internal.Main;

import oxydes.Oxydes;
import cations.Cations;

public class Amphibole extends MineralPhase {

	// (Fe,Mg)7Si8 O22 (OH)2 - Antofillite
	// Ca2 Mg5 Si8 O22 (OH)2 - tremolite
	// Ca2[Mg3Al2][Al2Si6]O22(OH)2 - tschermakite
	// Na2 Mg3 Al2 Si8 O22 (OH)2 - glaucophane

	public static int ideal_cation_sum = 8; // <-- DROOP
	public static Double mineralOssigeniI = 23.00; // totale ossigeni TEORICI
													// per il ricalcolo del
													// mineral
	public static String mineralNameString = "amphibole";

	public double AlIV;
	public double AlVI;
	public double sumA; // from 0 to 1
	public double B; // fix to 2
	public double C; // fix to 5
	public double T; // fix to 8
	public double NaA;
	public double NaB;
	public double NaCaB;
	public double CaB;
	public double NaKA;
	public double Fe2_B;

	public double sumC;
	public double sumB;

	public double Na_NaCa;//Na/(Na+Ca)
	public double Al_AlSi;//Al/(Al+SiVI)
	
	public File outFile_amp;
	private PrintWriter outPrinter_amp;
	
	/*******************/

	public Amphibole() {
		// TODO Auto-generated constructor stub
	}

	public Amphibole(String[] tokenizedLineStrings,
			ArrayList<Oxydes> listaOxTmp, ArrayList<Cations> listaCat)
			throws Exception {
		super(tokenizedLineStrings, listaOxTmp, listaCat);
		

	}

	
	  @Override
	    protected void calcAdditionalValues() {
	    	// TODO Auto-generated method stub
	    	super.calcAdditionalValues();
	    	setTuttiGliOssidiValori();
	    	
	    //	System.out.println("WINAMPH output...");
			outFile_amp = new File("WinAmph_OUT.xls");
			try {
				if (isAMPHexport()){
				printOutWinAmphValues();}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	  
	  
	  
	public void checkSites() {
		setTuttiGliOssidiValori();
		// public double AlIV;
		// public double AlVI;

		// public double T; //fix to 8 using Si, then Al, then Ti (no Fe3+ per
		// semplicitˆ)
		// public double C; //fix to 5 using excess Al and Ti from T, and then
		// successively Zr, Cr, Fe3+, Mn3+, Mg, Fe2, Mn2.....
		// public double B; //fix to 2 using excess Mg, Fe2+, Mn, Li from C,
		// THEN Ca, then Na

		// public double sumA; //from 0 to 1 using excess Na from B, then all K.



		try{

			// check sites for amphiboles

			T = 8;
			C = 5;
			B = 2;

			if (T - SiO2.getCatVal()>0)
			{
			AlIV =T - SiO2.getCatVal();
			}else{
				AlIV = 0;
			}
			
			AlVI = Al2O3.getCatVal() - AlIV;
			
			if (MineralPhase.isFe2O3_present()){
				
			}else{
				Fe2O3 = new oxydes.Fe2O3();
				Fe2O3.setCatVal(0.00);
			}
			

			if (MineralPhase.isMnO_present()){
			}else{MnO = new oxydes.MnO();
			MnO.setCatVal(0.00);
			}
			


//			jMineralCalc.getConsole().println("TiO2 :"+TiO2.getCatVal());
//			jMineralCalc.getConsole().println("Fe2O3 :"+Fe2O3.getCatVal());
//			jMineralCalc.getConsole().println("FeO :"+FeO.getCatVal());
//			jMineralCalc.getConsole().println("MgO :"+MgO.getCatVal());
//			jMineralCalc.getConsole().println("MnO :"+MnO.getCatVal());
			
			sumC = AlVI + TiO2.getCatVal() + Fe2O3.getCatVal()+ FeO.getCatVal() + MgO.getCatVal() + MnO.getCatVal();
					
	//		jMineralCalc.getConsole().println("SumC: "+sumC);
	
			
			if (sumC > 5) {
				Fe2_B = sumC - C;
		//		jMineralCalc.getConsole().println("Fe2_B: "+Fe2_B);
			} else {
				Fe2_B = 0;
		//		jMineralCalc.getConsole().println("Fe2_B: "+Fe2_B);
			}
			
			sumB = Fe2_B + CaO.getCatVal();
			
			if (sumB<B){
	//sumB = 2;
	NaB = 2-CaO.getCatVal()-Fe2_B;
	NaA = Na2O.getCatVal()-NaB;
	//jMineralCalc.getConsole().println("NaB: "+NaB+" NaA: "+NaA);
			}else{
	NaB=0;
	double restB = sumB-B;
	System.out.println(restB);
	
	
	NaA=Na2O.getCatVal();
//	jMineralCalc.getConsole().println("NaB: "+NaB+" NaA: "+NaA);

			}
			
//			if (sumB > B) {
//				NaB = 2-CaO.getCatVal()-Fe2_B;//sumB-B;
//				NaA = Na2O.getCatVal() - NaB;//(sumB - B);
//			} else {
//
//				NaA = Na2O.getCatVal();
//				NaB = 0;
//			}

			sumA = NaA + K2O.getCatVal();

		} catch (Exception e) {
			e.printStackTrace();
					jMineralCalc.getConsole().println("Amphibole calc: the problem may be due to the absence of " +
							"some oxydes: check for the presence of: TiO2, FeO, MgO, MnO");


		}

		setT(T);
		setC(C);
		setB(B);
		setA(sumA);
		setSumA(sumA);
		setAlVI(AlVI);
		setAlIV(AlIV);
		setNaA(NaA);
		setNaB(NaB);
		setNaCaB(NaCaB);
		setCaB(CaO.getCatVal());
		setNaKA(sumA);
		setNa_NaCa(NaB/(NaB+CaB)); ///DA CONTROLLARE
		setAl_AlSi(AlVI/(AlVI+SiO2.getCatVal())); ///DA CONTROLLARE
		
	}





	@Override
	public void printSupplementaryHeaders(PrintWriter outWr) {
		// TODO Auto-generated method stub
		super.printSupplementaryHeaders(outWr);
		outWr.write("\tAlIV\tAlVI\tT\tC\tB\tsumA\tNaB\t(Na+K)\tNaA\tNa/(Na+Ca)\tAl/(Al+Si)");

	}

	@Override
	public void printSupplemetaryValues(PrintWriter out) {
		// TODO Auto-generated method stub
		out = new PrintWriter(out);
		// super.printSupplemetaryValues(out);
		checkSites();
		out.write("\t" + formatter.format(getAlIV()) + "\t"
				+ formatter.format(getAlVI()) + "\t" + formatter.format(getT())
				+ "\t" + formatter.format(getC()) + "\t"
				+ formatter.format(getB()) + "\t" + formatter.format(getSumA())+"\t"
				+ formatter.format(getNaB())+"\t"+ formatter.format(getNaKA())+"\t" +formatter.format(getNaA())+"\t"
				+ formatter.format(getNa_NaCa())+"\t"+formatter.format(getAl_AlSi()));


	}


	
	public void printOutWinAmphHeader(PrintWriter out3) throws IOException{
	
		out3.write("Sample No\tSiO2\tTiO2\tZrO2\tAl2O3\tV2O3\tCr2O3\tMn2O3\tFe2O3\tFeO\tMnO\tNiO\tCoO\tZnO\tMgO\tCaO\tBaO\tSrO\tNa2O\tK2O\tLi2O\tF\tCl\tH2O\n");
	
	out3.close();
	printOutWinAmphValues();
}

public void printOutWinAmphValues() throws IOException{
	
	//
	
	if (outFile_amp.exists()) {
		
		 outPrinter_amp = new PrintWriter(new FileWriter(outFile_amp, true));
		

	} else {

		outPrinter_amp = new PrintWriter(new FileWriter(outFile_amp, true));
		System.out.println(" headers to be written...");
		printOutWinAmphHeader(outPrinter_amp);

	}
	outPrinter_amp.write(getSampleS());
	if(isSiO2_present()){
		outPrinter_amp.write("\t"+formatter.format(SiO2.getOxyVal()));
		System.out.println("WINAMPH - SIO2: "+formatter.format(SiO2.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}
	if(isTiO2_present()){
		outPrinter_amp.write("\t"+formatter.format(TiO2.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}
	if(isZrO2_present()){
		outPrinter_amp.write("\t"+formatter.format(ZrO2.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}
	if(isAl2O3_present()){
		outPrinter_amp.write("\t"+formatter.format(Al2O3.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}
	if(isV2O3_present()){
		outPrinter_amp.write("\t"+formatter.format(V2O3.getOxyVal()));
		System.out.println("V2O3: "+formatter.format(V2O3.getOxyVal()));

	}else{outPrinter_amp.write("\t0");		System.out.println("V2O3: 0");
}
	if(isCr2O3_present()){
		outPrinter_amp.write("\t"+formatter.format(Cr2O3.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}
	if(isMn2O3_present()){
		outPrinter_amp.write("\t"+formatter.format(Mn2O3.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}
	if(isFe2O3_present()){
		outPrinter_amp.write("\t"+formatter.format(Fe2O3.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}
	if(isFeO_present()){
		outPrinter_amp.write("\t"+formatter.format(FeO.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}
	if(isMnO_present()){
		outPrinter_amp.write("\t"+formatter.format(MnO.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}
	if(isNiO_present()){
		outPrinter_amp.write("\t"+formatter.format(NiO.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}
	if(isCoO_present()){
		outPrinter_amp.write("\t"+formatter.format(CoO.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}	
	if(isZnO_present()){
		outPrinter_amp.write("\t"+formatter.format(ZnO.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}	
	if(isMgO_present()){
		outPrinter_amp.write("\t"+formatter.format(MgO.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}	
	if(isCaO_present()){
		outPrinter_amp.write("\t"+formatter.format(CaO.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}	
	if(isBaO_present()){
		outPrinter_amp.write("\t"+formatter.format(BaO.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}	
	if(isSrO_present()){
		outPrinter_amp.write("\t"+formatter.format(SrO.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}	
	if(isNa2O_present()){
		outPrinter_amp.write("\t"+formatter.format(Na2O.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}	
	if(isK2O_present()){
		outPrinter_amp.write("\t"+formatter.format(K2O.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}	
	if(isLi2O_present()){
		outPrinter_amp.write("\t"+formatter.format(Li2O.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}	
	if(isCl_present()){
		outPrinter_amp.write("\t"+formatter.format(Cl.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}	
	if(isF_present()){
		outPrinter_amp.write("\t"+formatter.format(F.getOxyVal()));
	}else{outPrinter_amp.write("\t0");}	
	if(isH2O_present()){
		outPrinter_amp.write("\t"+formatter.format(H2O.getOxyVal())+"\n");
	}else{outPrinter_amp.write("\t0\n");}	
	
	
	outPrinter_amp.close();
	
}

	








	public double getT() {
		return T;
	}

	public void setT(double t) {
		T = t;
	}

	public double getC() {
		return C;
	}

	public void setC(double c) {
		C = c;
	}

	public double getB() {
		return B;
	}

	public void setB(double b) {
		B = b;
	}

	public double getSumA() {
		return sumA;
	}

	public void setA(double a) {
		sumA = a;
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
		return ".amp";
	}

	public double getNaA() {
		return NaA;
	}

	public void setNaA(double naA) {
		NaA = naA;
	}

	public double getNaCaB() {
		return NaCaB;
	}

	public void setNaCaB(double naCaB) {
		NaCaB = naCaB;
	}

	public double getCaB() {
		return CaB;
	}

	public void setCaB(double caB) {
		CaB = caB;
	}

	public double getNaKA() {
		return NaKA;
	}

	public void setNaKA(double naKA) {
		NaKA = naKA;
	}

	public double getNaB() {
		return NaB;
	}

	public void setNaB(double naB) {
		NaB = naB;
	}

	public double getFe2_B() {
		return Fe2_B;
	}

	public void setFe2_B(double fe2B) {
		Fe2_B = fe2B;
	}

	public double getSumC() {
		return sumC;
	}

	public void setSumC(double sumC) {
		this.sumC = sumC;
	}

	public double getSumB() {
		return sumB;
	}

	public void setSumB(double sumB) {
		this.sumB = sumB;
	}

	public void setSumA(double sumA) {
		this.sumA = sumA;
	}

	public double getNa_NaCa() {
		return Na_NaCa;
	}

	public void setNa_NaCa(double naNaCa) {
		Na_NaCa = naNaCa;
	}

	public double getAl_AlSi() {
		return Al_AlSi;
	}

	public void setAl_AlSi(double alAlSi) {
		Al_AlSi = alAlSi;
	}

}
