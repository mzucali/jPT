package minerals;

import main.*;
import main.gui.Console;
import main.gui.jMineralCalc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import java.io.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.util.Arrays;

import java.util.Date;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sun.codemodel.JSwitch;

import atoms.Periodic_Table;

import cations.Cations;
import datafiles.AnalysisDataFile; //import libs.ArrayTranspose;

import oxydes.*;
import sample.Sample;
import tools.*;
//import sun.rmi.runtime.GetThreadPoolAction;

//import oxydes.Oxydes;
//import oxydes.SiO2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package Phases;

/**
 * 2009 giugno-luglio dovrebbe essere un OGGETTO principale per la definizione
 * della FASE MINERALOGICA
 * 
 * @author miki
 */

public class MineralPhase {

	 static int mineralPhaseCounterI = 0;
	 static Integer posizioneMineralI;
	 static Integer mineralPhaseIDI;

	public SiO2 SiO2;//0
	public  Al2O3 Al2O3;//1
	public  TiO2 TiO2;//2
	public  Na2O Na2O;//10
	public  K2O K2O;//11
	public  CaO CaO;//9
	public  FeO FeO;//4
	public  Fe2O3 Fe2O3;
	public  Cr2O3 Cr2O3;
	public  MnO MnO;
	public  ZnO ZnO;
	public  MgO MgO;
	public  P2O5 P2O5;
	public  B2O3 B2O3;
	public  CO2 CO2;
	public  PbO PbO;
	public  ThO2 ThO2;
	public  UO2 UO2;
	public  H2O H2O;
	public   SrO SrO;
	public   La2O3 La2O3;
	public   Pr2O3 Pr2O3;
	public   Y2O3 Y2O3;
	public   Nd2O3 Nd2O3;
	public   Sm2O3 Sm2O3;
	public   Ce2O3 Ce2O3;
	public   Gd2O3 Gd2O3;
	public   SO3 SO3;
	public   ZrO2 ZrO2;
	public   V2O3 V2O3;
	public   Mn2O3 Mn2O3;
	public   CoO CoO;
	public   NiO NiO;
	public   BaO BaO;
	public   Li2O Li2O;
	public   Cl Cl;
	public   F F;
	 
	 /// TUTTI i TOKEN si riferiscono alla LISTA OSSIDI
	 // percio' valgono -2 rispetto alla posizione nell'array_input_data[] che comprende anche sample e mineral
	 	private static int tokenFeO;
		private static int tokenFe2O3;
		private static int tokenMnO;
		private static int tokenMgO;
		private static int tokenZnO;
		private static int tokenCaO;
		private static int tokenNa2O;
		private static int tokenK2O;
		private static int tokenP2O5;
		private static int tokenB2O3;
		private static int tokenLa2O3;
		private static int tokenCe2O3;
		private static int tokenSrO;
		private static int tokenNd2O3;
		private static int tokenNiO;
		private static int tokenBaO;
		private static int tokenSO3;
		private static int tokenSiO2;
		private static int tokenTiO2;
		private static int tokenAl2O3;
		private static int tokenCr2O3;
		private static int tokenPbO;
		private static int tokenThO2;
		private static int tokenUO2;
		private static int tokenPr2O3;
		private static int tokenY2O3;
		private static int tokenSm2O3;
		private static int tokenLi2O;
		private static int tokenZrO2;
		private static int tokenMn2O3;
		private static int tokenCoO;
		private static int tokenGd2O3;
		private static int tokenH2O;
		private static int tokenCl;
		private static int tokenF;
		private static int tokenV2O3;
		private static int tokenCO2;
		
		public static int posizioneSiO2;
		public static int posizioneAl2O3;
		public static int posizioneMnO;
		public static int posizioneCl;
		public static int posizioneNa2O;
		public static int posizioneK2O;
		public static int posizioneBaO;
		public static int posizioneZnO;
		public static int posizioneNiO;
		public static int posizioneCr2O3;
		public static int posizioneV2O3;
		public static int posizioneH2O;
		public static int posizioneGd2O3;
		public static int posizioneCoO;
		public static int posizionePbO;
		public static int posizioneThO2;
		public static int posizioneUO2;
		public static int posizioneFeO;
		public static int posizioneFe2O3;
		public static int posizioneMgO;
		public static int posizioneCaO;
		public static int posizioneTiO2;
		public static int posizioneNd2O3;
		public static int posizioneSrO;
		public static int posizioneLa2O3;
		public static int posizioneCe2O3;
		public static int posizioneB2O3;
		public static int posizioneY2O3;
		public static int posizionePr2O3;
		public static int posizioneSm2O3;
		public static int posizioneP2O5;
		public static int posizioneZrO2;
		public static int posizioneMn2O3;
		public static int posizioneSO3;
		public static int posizioneLi2O;
		public static int posizioneF;
		public static int posizioneCO2;
		
		public static int posizioneSDUO2;
		public static int posizioneSDPbO;
		public static int posizioneSDThO2;
		
		
		
		
		//QUESTI token si riferiscono alla posizione nell'array
		//perche' NON sono OSSIDI in lista
		
		private static int tokenArraySDPbO;
		private static int tokenArraySDThO2;
		private static int tokenArraySDUO2;
		private static int tokenSample; // 0 x definizione 
		private static int tokenMineral; // 1 x definizione		
		
	 public DecimalFormat formatter = new DecimalFormat("##.00000");
	 static Integer posizioneSampleI;

	 double SUM_oxidesD;
	 double SUM_cationsD;
	
	 double Fe2_old;
	 double Fe3_new;
	 double Fe2_new;
	 double Fe2O3_new;
	 double FeO_new;
	 double FeO_old;

	 int perc_amountI; // quntita' di fase mineralogica in percentuale
								// tra 0 e 100
	 double fact_amountD; // quantit�� di fase mineralogica tra 0 e 1

	 String mineralSampleS; // sigla del minerale (SAMPLE)
	 String mineralCodeString; // nome del mineral (MINERAL)
	 String mineralNameString = "unknown"; // nome completo (e.g.
													// garnet)
	 String extension = ".gen";

	 int ideal_cation_sum; // //<-- DROOP (Fe3+)
	 Double mineralOssigeniI = 100.00; // totale ossigeni TEORICI per
												// il ricalcolo del mineral
	 int mineralCationiI; // totale cationi calcolati dai dati NON
									// TEORICO
	 int mineralAnioniI; // totale anioni calcolati dai dati NON
									// TEORICO

	/*
	 * Lista degli OSSIDI e dei CATIONI effettivamente presenti durante il
	 * calcolo questi derivano dagli ossidi di input oppure da possibili
	 * ricalcoli di ossidi (es. Fe2O3)
	 */
	  ArrayList<Oxydes> listaOssidi = new ArrayList<Oxydes>();
	 ArrayList<Oxydes> listone;
	 ArrayList<Cations> listaCationi;// = new ArrayList<Cations>();

	 Double sumOfOxides;
	 Double sumOfMoleProportion;
	 Double sumOfAtomProportion;
	 Double anionsMultFactor;

	 boolean calcFormulaB = false;
	private boolean controllo_header;
	//public PrintWriter outPrinteWriter;
	//  File out1;
	public File out1;
	public File out2; // questo secondo file dovrebbe raccogliere tutte le analisi ricalcolate
	// public PrintWriter out;
	// private String out1;
	
	private PrintWriter printwriter;
	private PrintWriter printwriterALL;
	
	private boolean isDROOP_B=false;
	
	private static boolean SiO2_present;
	private static boolean TiO2_present;
	private static boolean Al2O3_present;
	private static boolean Na2O_present;
	private static boolean CaO_present;
	private static boolean K2O_present;
	private static boolean P2O5_present;
	private static boolean Fe2O3_present;
	private static boolean MnO_present;
	private static boolean Mn2O3_present;
	private static boolean MgO_present;
	private static boolean FeO_present;
	private static boolean Cr2O3_present;
	private static boolean ZnO_present;
	private static boolean B2O3_present;
	private static boolean CO2_present;
	private static boolean SrO_present;
	private static boolean La2O3_present;
	private static boolean PbO_present;
	private static boolean UO2_present;
	private static boolean ThO2_present;
	private static boolean Pr2O3_present;
	private static boolean Y2O3_present;
	private static boolean Nd2O3_present;
	private static boolean Sm2O3_present;
	private static boolean Ce2O3_present;
	private static boolean Gd2O3_present;
	private static boolean SO3_present;
	private static boolean NiO_present;
	private static boolean BaO_present;
	private static boolean SDUO2_present;
	private static boolean SDThO2_present;
	private static boolean SDPbO_present;
	private static boolean ZrO2_present;
	private static boolean V2O3_present;
	private static boolean Li2O_present;
	private static boolean F_present;
	private static boolean Cl_present;
	private static boolean H2O_present;
	private static boolean CoO_present;
	
	
	public static boolean XLSexport;
	public static boolean KANEKOexport;
	public static boolean AMPHexport;
	public static boolean AXexport;
	
	


	
	//private static SDUO2 SDUO2;



	public double SDUO2;
	public double SDThO2;
	public double SDPbO;
//	public double SDPbO_ppm;
//	public double SDThO2_ppm;
//	public double SDUO2_ppm;
	
	public double thppm; //= (ThO2.getOxyVal())/264.036*232.038;
	public double uppm; //= (UO2.getOxyVal()/270.027)*238.028;;
	public double pbppm;// = (PbO.getOxyVal()/223.199)*207.199;
	
	public double SDThO2_ppm; // = thppm*SDThO2/100;
	public double SDUO2_ppm; // = uppm*SDUO2/100;
	public double SDPbO_ppm; // = pbppm*SDPbO/100;
	
	String[] array_inputData; 
	ArrayList<String> stringone = new ArrayList<String>();
	public String[] array_Ossidi;
	public ArrayList<Oxydes> listaOssidiSave;
	public ArrayList<Oxydes>[] arrayListaOssidi;

	
	
	/* constructors */

	public MineralPhase() {
		// questo creas solo una fase mineralogica ma non fa nulla
		init();
			}

	private void init() {
		incrementMineralPhaseCounter();
		checkOssidi();

	
	}

	private void checkOssidi() {
		System.out.println("checking ossidi");
		if (isSiO2_present()){
			addSiO2();
		}
		 if (isAl2O3_present()){
			addAl2O3();
		}
		 if (isTiO2_present()){
			addTiO2();
		}
		 if (isNa2O_present()){
			addNa2O();
		}
		 if (isK2O_present()){
			addK2O();
		}
		 if (isCaO_present()){
			addCaO();
		}
		 if (isFeO_present()){
			addFeO();
		}
		 if (isFe2O3_present()){
			addFe2O3();
		}
		 if (isCr2O3_present()){
			addCr2O3();
		}
		 if (isMnO_present()){
			addMnO();
		}
		 if (isZnO_present()){
			addZnO();
		}
		 if (isMgO_present()){
			addMgO();
		}
		 if (isP2O5_present()){
			addP2O5();
		}
		 if (isB2O3_present()){
			addB2O3();
		}
		 if (isCO2_present()){
			addCO2();
		}
		 if (isPbO_present()){
			addPbO();
		}
		 if (isThO2_present()){
			addThO2();
		}
		 if (isUO2_present()){
			addUO2();
		}
		 if (isH2O_present()){
			addH2O();
		}		
		 if (isSrO_present()){
			addSrO();
		}		
		 if (isLa2O3_present()){
			addLa2O3();
		}		
		 if (isPr2O3_present()){
			addPr2O3();
		}		
		 if (isY2O3_present()){
			addY2O3();
		}		
		 if (isNd2O3_present()){
			addNd2O3();
		}		
		 if (isSm2O3_present()){
			addSm2O3();
		}
		 if (isCe2O3_present()){
			addCe2O3();
		}
		 if (isGd2O3_present()){
			addGd2O3();
		}
		 if (isSO3_present()){
			addSO3();
		}
		 if (isZrO2_present()){
			addZrO2();
		}
		 if (isV2O3_present()){
			addV2O3();
		}
		 if (isMn2O3_present()){
			addMn2O3();
		}
		 if (isCoO_present()){
			addCoO();
		}
		 if (isNiO_present()){
			addNiO();
		}
		 if (isBaO_present()){
			addBaO();
		}
		 if (isLi2O_present()){
			addLi2O();
		}
		 if (isCl_present()){
			addCl();
		}
		 if (isF_present()){
			addF();
		}

	}

	public MineralPhase(String[] tokenized_lineStrings,
			ArrayList<Oxydes> lista_Ox_tmp, ArrayList<Cations> lista_Cat, ArrayList<MineralPhase> mf_array )
			throws Exception {
		// questa crea una fase mineralogica da un array di una stringa di dati
		// + un ArrayList di Ossidid (SOLO quelli effettivamente letti)
		// e un ArrayList di Cations (quelli effettivamente letti)
		// anche se in realt� i cationi non li uso perche' sono parte degli ossidi
		
		init();
		array_inputData = tokenized_lineStrings;
		setSampleS(array_inputData[0]);
		setMineralCodeString(array_inputData[1]);
		setOssidi(array_inputData, listaOssidi);
		setSD();
		calcMineralFormula();		
	//	mf_array.add(this);
	}

	
	// QUESTO � quello utilizzato attualmente (10 luglio 2011)
	public MineralPhase(String[] tokenized_lineStrings,
			ArrayList<Oxydes> lista_Ox_tmp, ArrayList<Cations> lista_Cat)
			throws Exception {
		// questa crea una fase mineralogica da un array di una stringa di dati
		// + un ArrayList di Ossidid (SOLO quelli effettivamente letti)
		// e un ArrayList di Cations (quelli effettivamente letti)
		// anche se in realt� i cationi non li uso perche' sono parte degli ossidi
		
		init();
		array_inputData = tokenized_lineStrings;
		setSampleS(array_inputData[0]);
		setMineralCodeString(array_inputData[1]);
		setOssidi(array_inputData, listaOssidi);
		setSD();
		calcMineralFormula();	
	//	setCationiInLista();
		// questi sono dei tools per esportare gli input da utilizzare in altri fogli excel
		// per ora li metto qui ma vorrei poterli mettere posteriori
		if(isKANEKOexport()){
			new exportGrtBtCrd_kaneko2004(this);
		}
		if(isXLSexport()){
			new jpt2xls_formula(this);
		}

//		testTokens();
		

	}
	
	
	public void testTokens(){

//		System.out.println("gettokenSiO2: "+getTokenSiO2());
//		System.out.println("tokenSiO2: "+ tokenSiO2);
//		System.out.println("posizioneSiO2: "+ posizioneSiO2);
//		System.out.println("index listaOssidi: ");
		// using traditional for loop with iterator
		
		
		System.out.println("CONTROLLO DA LISTAOSSIDI");
		for (Oxydes ox: getListaOssidi()){
			System.out.println("Label: "+ox.getOxyLabel() +" posizione: "+ox.getPosizione() );
			System.out.println("Da ListaOssidi: "+ ox.getOxyLabel()+ " = "+ox.getOxyVal());
		}
		
		if (listaOssidi.contains(SiO2)){
			int position=listaOssidi.indexOf(SiO2);
			System.out.println("\t index SIO2: "+position);
		}
		if (listaOssidi.contains(FeO)){
			int position=listaOssidi.indexOf(FeO);
			System.out.println("\t index FeO: "+position);
			
		}
		
		
		
//		System.out.println("\t posizioni \t");
//		//listaOssidi.get
//		System.out.println("SiO2?: "+listaOssidi.get(getTokenSiO2()+2).getOxyLabel());
//		System.out.println("Al2O3?: "+listaOssidi.get(getTokenAl2O3()+2).getOxyLabel());
//		System.out.println("K2O?: "+listaOssidi.get(getTokenK2O()+2).getOxyLabel());
//		System.out.println("Al2O3: "+getTokenAl2O3());
		
		System.out.println("CONTROLLO DAI SINGOLI OSSIDI");
		System.out.println("SiO2 (oxide) = " + SiO2.getOxyVal());
		System.out.println("FeO (oxide) = " + FeO.getOxyVal());
		System.out.println("MgO (oxide) = " + MgO.getOxyVal());
		System.out.println("Al2O3 (oxide) = " + Al2O3.getOxyVal());
		System.out.println("TiO2 (oxide) = " + TiO2.getOxyVal());
		
		
	}
private void setCationiInLista() {
	System.out.println("SiO2..setCationList: "+SiO2.getCatVal());
	
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());		
//	listaOssidi.get(MineralPhase.posizioneAl2O3-2).setCatVal(Al2O3.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
//	listaOssidi.get(MineralPhase.posizioneSiO2-2).setCatVal(SiO2.getCatVal());
	
}

	// METODO per caso in cui venga inserito il numero di OSSIGENI
	public MineralPhase(String[] tokenized_lineStrings,
			ArrayList<Oxydes> lista_Ox_tmp, ArrayList<Cations> lista_Cat,
			String ossigeni) throws Exception {
		// questa crea una fase mineralogica da un array di una stringa di dati
		// + un ArrayList di Ossidid (SOLO quelli effettivamente letti)
		// e un ArrayList di Cations (quelli effettivamente letti)
		// + string ossigeni
		
		setMineralOssigeniD(Double.parseDouble(ossigeni));


		
		
		init();
		array_inputData = tokenized_lineStrings;
		setSampleS(array_inputData[0]);
		setMineralCodeString(array_inputData[1]);
		setOssidi(array_inputData, listaOssidi);
		setSD();
		calcMineralFormula();	
		
		// questi sono dei tools per esportare gli input da utilizzare in altri fogli excel
		// per ora li metto qui ma vorrei poterli mettere posteriori
		if(isKANEKOexport()){
			new exportGrtBtCrd_kaneko2004(this);
		}
		if(isXLSexport()){
			new jpt2xls_formula(this);
		}

	}

	

	 void calcAdditionalValues() {
		// not implemented here but in subclasses

	}

	/* setters and getters */

	/* Fact_amount: */

	public String getMineralCodeString() {
		return mineralCodeString;
		// MINERAL
	}

	public void setMineralCodeString(String mineralCodeString) {
		this.mineralCodeString = mineralCodeString;
		// MINERAL
	}

	public String getMineralNameString() {
		return mineralNameString;
		// nome completo
	}

	public void setMineralNameString(String mineralNameString) {
		this.mineralNameString = mineralNameString;
		// nome completo
	}

	public String getSampleS() {
		return mineralSampleS;
		// SAMPLE
	}

	public void setSampleS(String sampleS) {
		this.mineralSampleS = sampleS;
		// SAMPLE
	}

	public double getFact_amount() {
		return fact_amountD;
	}

	public void setFact_amount() {
		this.fact_amountD = perc_amountI / 100;
	}

	public int getPerc_amount() {
		return perc_amountI;
	}

	public void setPerc_amount(int perc_amount) {
		this.perc_amountI = perc_amount;
		setFact_amount();
	}

	public double getSUM_oxides() {
		return SUM_oxidesD;
	}

	public void setSUM_oxides(double SUM_oxides) {
		this.SUM_oxidesD = SUM_oxides;
	}

	public double getSUM_cationsD() {
		return SUM_cationsD;
	}

	public void setSUM_cationsD(double SUM_cationsD) {
		this.SUM_cationsD = SUM_cationsD;
	}

	public void incrementMineralPhaseCounter() {
		System.out.println("Previous mineralPhaseCounter: "
				+ mineralPhaseCounterI);
		++mineralPhaseCounterI;
		System.out.println("New mineralPhaseCounter: " + mineralPhaseCounterI);
		return;
	}

	public int getMineralPhaseIDI() {
		return mineralPhaseIDI;
	}

	public void setMineralPhaseIDI(int mineralPhaseIDI) {
		MineralPhase.mineralPhaseIDI = mineralPhaseIDI;
	}

	public int getMineralAnioniI() {
		return mineralAnioniI;
	}

	public void setMineralAnioniI(int mineralAnioniI) {
		this.mineralAnioniI = mineralAnioniI;
	}

	public int getMineralCationiI() {
		return mineralCationiI;
	}

	public void setMineralCationiI(int mineralCationiI) {
		this.mineralCationiI = mineralCationiI;
	}

	public Double getMineralOssigeniI() {
		return mineralOssigeniI;
	}

	public void setMineralOssigeniI(Double mineralOssigeniI) {
		this.mineralOssigeniI = mineralOssigeniI;
	}

	public void setMineralOssigeniD(Double mineralOssigeniD) {
		this.mineralOssigeniI = mineralOssigeniD;
	}

	public static int getMineralPhaseCounterI() {
		return mineralPhaseCounterI;
	}

	public static void setMineralPhaseCounterI(int mineralPhaseCounterI) {
		MineralPhase.mineralPhaseCounterI = mineralPhaseCounterI;
	}

	/**
	 * @param array_inputData
	 * @param listaOssidi
	 */
	public void setOssidi(String[] array_inputData,ArrayList<Oxydes> listaOssidi_l) {
	//	System.out.println("\nsetOssidi output MineralPhase \n");
		//setListaOssidi(listaOssidi_l);
		for (Oxydes it : listaOssidi_l) {
			// questo ciclo FOR prende i dati dall'array di dati e li assegna ad
			// ogni
			// ossido (it) della lista di ossidi
			// QUESTO avviene in modo cieco, cioe' ancora non so quale sia il
			// valore di ogni ossido
			// in modo palese
			
			for (int i = 0; i < array_inputData.length; i++) {
				if (it.getPosizione() == i) {
					it.setOxyVal(Double.parseDouble(array_inputData[i]));
				//	System.out.println(it.getOxyLabel() + " is: "+ it.getOxyVal());
				} else {
				}
			}
			
		//	setListaOssidi(listaOssidi_l);
			// a questo punto per ogni it (elemento della lista di ossidi)
			// attribuisco "in chiaro" i valori agli ossidi

		}
	}
	public void setSD(){
		System.out.println("\n\narray_inputdata: "+array_inputData);
		System.out.println("lista ossidi size: "+listaOssidi.size());
		System.out.println("array_inputData length: "+array_inputData.length);
		if(SDThO2_present&&SDUO2_present&&SDPbO_present){
			System.out.println("\n SDPbO from array_inputData[tokenSDPbO]= "+array_inputData[tokenArraySDPbO]);
			System.out.println("\n SDThO2 from array_inputData[tokenSDThO]= "+array_inputData[tokenArraySDThO2]);
			System.out.println("\n SDUO2 from array_inputData[tokenSDUO]= "+array_inputData[tokenArraySDUO2]);
		
			SDPbO = Double.parseDouble(array_inputData[tokenArraySDPbO]);
			SDThO2 = Double.parseDouble(array_inputData[tokenArraySDThO2]);
			SDUO2 = Double.parseDouble(array_inputData[tokenArraySDUO2]);
			
			listaOssidi.get(tokenUO2).setSD(SDUO2);
			listaOssidi.get(tokenPbO).setSD(SDPbO);
			listaOssidi.get(tokenThO2).setSD(SDThO2);
		
		thppm= (ThO2.getOxyVal())/264.036*232.038;
		uppm= (UO2.getOxyVal()/270.027)*238.028;;
		pbppm = (PbO.getOxyVal()/223.199)*207.199;
		
		SDThO2_ppm = thppm*SDThO2/100;
		SDUO2_ppm = uppm*SDUO2/100;
		SDPbO_ppm = pbppm*SDPbO/100;
		
		}
		
		
	}

	public void setTuttiGliOssidiValori() {
		for (Oxydes it : listaOssidi) {

			if (it.getOxyLabel() == "SiO2") {
				SiO2 = new SiO2();
				SiO2 = (oxydes.SiO2) it;
				
				// SiO2.setOxyVal(it.getOxyVal());
				System.out.println("SiO2 = " + SiO2.getOxyVal());
			} else if (it.getOxyLabel() == "Al2O3") {
				Al2O3 = new Al2O3();
				Al2O3 = (oxydes.Al2O3) it; // setOxyVal(it.getOxyVal());
				System.out.println("Al2O3 = " + Al2O3.getOxyVal());
			} else if (it.getOxyLabel() == "TiO2") {
				TiO2 = new TiO2();
				TiO2 = (oxydes.TiO2) it; // setOxyVal(it.getOxyVal());
				System.out.println("TiO2 = " + TiO2.getOxyVal());
			} else if (it.getOxyLabel() == "MgO") {
				MgO = new MgO();
				MgO = (oxydes.MgO) it;
				// MgO.setOxyVal(it.getOxyVal());
				System.out.println("MgO = " + MgO.getOxyVal());
			} else if (it.getOxyLabel() == "FeO") {
				FeO = new FeO();
				FeO = (oxydes.FeO) it;
				// FeO.setOxyVal(it.getOxyVal());
				System.out.println("FeO = " + FeO.getOxyVal());
			} else if (it.getOxyLabel() == "Fe2O3") {
				Fe2O3 = new Fe2O3();
				Fe2O3 = (oxydes.Fe2O3) it;
				// Fe2O3.setOxyVal(it.getOxyVal());
				System.out.println("Fe2O3 = " + Fe2O3.getOxyVal());
			} else if (it.getOxyLabel() == "Cr2O3") {
				Cr2O3 = new Cr2O3();
				Cr2O3 = (oxydes.Cr2O3) it;
				// Cr2O3.setOxyVal(it.getOxyVal());
				System.out.println("Cr2O3 = " + Cr2O3.getOxyVal());
			} else if (it.getOxyLabel() == "MnO") {
				MnO = new MnO();
				MnO = (oxydes.MnO) it;
				// MnO.setOxyVal(it.getOxyVal());
				System.out.println("MnO = " + MnO.getOxyVal());
			} else if (it.getOxyLabel() == "ZnO") {
				ZnO = new ZnO();
				ZnO = (oxydes.ZnO) it;
				// ZnO.setOxyVal(it.getOxyVal());
				System.out.println("ZnO = " + ZnO.getOxyVal());
			} else if (it.getOxyLabel() == "Na2O") {
				Na2O = new Na2O();
				Na2O = (oxydes.Na2O) it;
				// Na2O.setOxyVal(it.getOxyVal());
				System.out.println("Na2O = " + Na2O.getOxyVal());
			} else if (it.getOxyLabel() == "K2O") {
				K2O = new K2O();
				K2O = (oxydes.K2O) it;
				// K2O.setOxyVal(it.getOxyVal());
				System.out.println("K2O = " + K2O.getOxyVal());
			} else if (it.getOxyLabel() == "CaO") {
				CaO = new CaO();
				CaO = (oxydes.CaO) it;
				// CaO.setOxyVal(it.getOxyVal());
				System.out.println("CaO = " + CaO.getOxyVal());
			} else if (it.getOxyLabel() == "P2O5") {
				P2O5 = new P2O5();
				P2O5 = (oxydes.P2O5) it;
				// P2O5.setOxyVal(it.getOxyVal());
				System.out.println("P2O5 = " + P2O5.getOxyVal());
			} else if (it.getOxyLabel() == "CO2") {
				CO2 = new CO2();
				CO2 = (oxydes.CO2) it;
				// CO2.setOxyVal(it.getOxyVal());
				System.out.println("CO2 = " + CO2.getOxyVal());
			}else if (it.getOxyLabel() == "H2O") {
				H2O = new H2O();
				H2O = (oxydes.H2O) it;
				// CO2.setOxyVal(it.getOxyVal());
				System.out.println("H2O = " + H2O.getOxyVal());
			}

			
			
		}
		// ora tutti gli ossidi SONO palesi (e.g. SiO2, Al2O3, etc....) e hanno tutti
		// i valori attribuiti
		// in funzione di quando si chiama

	}

	public int getPerc_amountI() {
		return perc_amountI;
	}

	public void setPerc_amountI(int percAmountI) {
		perc_amountI = percAmountI;
	}

	public double getFact_amountD() {
		return fact_amountD;
	}

	public void setFact_amountD(double factAmountD) {
		fact_amountD = factAmountD;
	}

	public int getIdeal_cation_sum() {
		return ideal_cation_sum;
	}

	public void setIdeal_cation_sum(int idealCationSum) {
		ideal_cation_sum = idealCationSum;
	}

	public ArrayList<Oxydes> getListaOssidi() {
		return listaOssidi;
	}

	public void setListaOssidi(ArrayList<Oxydes> listaOssidi_tmp) {
		//ArrayList<Oxydes> listaOssidi1 = new ArrayList<Oxydes>();
	//	listaOssidi1=listaOssidi_tmp;
	}

	public ArrayList<Cations> getListaCationi() {
		return listaCationi;
	}

	public void setListaCationi(ArrayList<Cations> listaCationi_tmp) {
		listaCationi = listaCationi_tmp;
	}

	public void calcMineralFormula() throws Exception {
		
		
		if(calcFormulaB){
			System.out.println("Formula already calculated......leaving the calcMineralFormula method");
		}else{
		
			System.out.println("Start calculating formula from within calcMineralFormula()\n");

		calcSumOfOxides();
		calcMoleProportions();
		calcAtomProportion();
		calcAnions();
		calcCations();


		setCalcFormulaB(true);
		//setTuttiGliOssidiValori();
		//ADDITIONAL VALUES
		calcAdditionalValues();
		// set ossidi dalla lista
		//setTuttiGliOssidiValori();
		
		jMineralCalc.getConsole().println("\ncampione: "+getSampleS());
		jMineralCalc.getConsole().println("somma ossidi: "+getSUM_oxides()+"\n");
		
		//PRINT x ogni fase
		out1 = new File(AnalysisDataFile.getInputFile() +"_OUT_"+ getExtension()+".xls");
		printSorted();


		//PRINT SU UNICO FILE
		out2 = new File(AnalysisDataFile.getInputFile()+"_ALL_OUT.xls");
	// prova 24 sett 2015 x stampa con virgole
		printSortedUniqueFile();
		
		}

	}
public void printCalculatedAnalyis() throws IOException, Exception {

	printSorted();
	
	}

public void calcMineralFormula(MineralPhase mfs) throws Exception {
		
		
		if(mfs.calcFormulaB){
			System.out.println("Formula already calculated......leaving the calcMineralFormula method");
		}else{
		
			System.out.println("Start calculating formula from within calcMineralFormula()\n");

		mfs.calcSumOfOxides();//calcSumOfOxides();
		mfs.calcMoleProportions();
		mfs.calcAtomProportion();
		mfs.calcAnions();
		mfs.calcCations();

		


		System.out.println("cations sum: " + mfs.getSUM_cationsD());
		System.out.println("MineralPhase.calcMineralFormula(): "
				+ mfs.getMineralNameString() + ", ossigeni: "
				+ mfs.getMineralOssigeniI());

		System.out.println();
		System.out.println();
		mfs.setCalcFormulaB(true);
		mfs.setTuttiGliOssidiValori();
		//ADDITIONAL VALUES
		mfs.calcAdditionalValues();
		// set ossidi dalla lista
		mfs.setTuttiGliOssidiValori();
		
		//PRINT
		out1 = new File(AnalysisDataFile.getInputFile() +"_OUT_"+ mfs.getExtension()+".xls");
		mfs.printSorted();
		//PRINT SU UNICO FILE
		out2 = new File(AnalysisDataFile.getInputFile()+"_ALL_OUT.xls");
		mfs.printSortedUniqueFile();
		
		}

	}
	public void calcMoleProportions() {
		sumOfMoleProportion = 0.00;

		for (Oxydes i : listaOssidi) {
			Double tmp = i.getOxyVal() / i.getPESO_MOLECOLARE_D();// i.getPESO_MOLECOLARE_D();
/*			System.out.print("i.getOxyVal() " + i.getOxyVal());
			System.out.print(" | i.getPESO_MOLECOLARE_D() "
					+ i.getPESO_MOLECOLARE_D());*/
			i.setMoleProportion(tmp);
			// CO2.setOxyVal(it.getOxyVal());
			// System.out.print(" | moli "+i.getOxyLabel()+" : " +
			// i.getMoleProportion());

		}
		for (Oxydes i : listaOssidi) {
			// calcola SOMMA delle Moli
			sumOfMoleProportion += i.getMoleProportion();
		}
		
		setSumOfMoleProportion(sumOfMoleProportion);
		System.out.println("SUM of Mole Proportion for Mineral Phase "
				+ this.getMineralCodeString() + " : "
				+ getSumOfMoleProportion());

	}

	// PROPORZIONE ATOMICA DELL'OSSIGENO

	public void calcAtomProportion() {
		sumOfAtomProportion = 0.00;

		for (Oxydes i : listaOssidi) {
			i.setAtomProportion(i.getMoleProportion()
					* i.getFATTORE_MOLTIPLICATIVO());// =

			sumOfAtomProportion += i.getAtomProportion();
		}
		setSumOfAtomProportion(sumOfAtomProportion);

	}

	public void calcAnions() {
		anionsMultFactor = getMineralOssigeniI() / getSumOfAtomProportion();
		for (Oxydes i : listaOssidi) {
			i.setAnions(anionsMultFactor * i.getAtomProportion());
		}

	}

	public void calcCations() {
		SUM_cationsD = 0.00;

		for (Oxydes i : listaOssidi) {
			i.setCatVal(i.getAnionsProportion() * i.getFATTORE_DIVISIONE_D());
			System.out.println("CAT: "+i.getCatLabel()+" = "+i.getCatVal());
			SUM_cationsD += i.getCatVal();
		}
		setSUM_cationsD(SUM_cationsD);
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * PROPORZIONE ATOMICA DELL'OSSIGENO
	 *//**
	 * Constructor for objects of class Formula
	 * 
	 * posizione ossidi in oxides[]: [0] SiO2; [1] TiO2, [2] Al2O3, [3] Cr2O3,
	 * [4] FeO, [5] MnO, [6] MgO, [7] ZnO, [8] CaO, [9] Na2O, [10] K2O, [11]
	 * P2O5
	 * 
	 * 
	 */
	/*

*/

	public void calcSumOfOxides() {
		sumOfOxides = 0.00;
		for (Oxydes i : listaOssidi) {
			sumOfOxides += i.getOxyVal();

		}
		setSUM_oxides(sumOfOxides);
		System.out.println("SUM of OX: "+getSUM_oxides());
		jMineralCalc.getConsole().println(
				"sum of Oxides for Mineral Phase "
						+ this.getMineralCodeString() + " : " + formatter.format(sumOfOxides));
	}

	public Double getSumOfMoleProportion() {
		return sumOfMoleProportion;
	}

	public void setSumOfMoleProportion(Double sumOfMoleProportion) {
		this.sumOfMoleProportion = sumOfMoleProportion;
	}

	public Double getSumOfAtomProportion() {
		return sumOfAtomProportion;
	}

	public void setSumOfAtomProportion(Double sumOfAtomProportion) {
		this.sumOfAtomProportion = sumOfAtomProportion;
	}

	public Double getAnionsMultFactor() {
		return anionsMultFactor;
	}

	public void setAnionsMultFactor(Double anionsMultFactor) {
		this.anionsMultFactor = anionsMultFactor;
	}

	public boolean isCalcFormulaB() {
		return calcFormulaB;
	}

	public void setCalcFormulaB(boolean calcFormulaB) {
		this.calcFormulaB = calcFormulaB;
	}

	@SuppressWarnings("unchecked")
	public void printHeader(PrintWriter out3) throws Exception {
		
		jMineralCalc.getConsole().println("PRINT HEADER!");
		ArrayList<Oxydes> clone = (ArrayList<Oxydes>) listaOssidi.clone();
		ArrayList<Oxydes> listaOssidi_print = clone;
		Collections.sort(listaOssidi_print);
		
		out3.write("Sample\tMineral\t");
		
		
		for (Oxydes x : listaOssidi_print) {
			out3.write(x.getOxyLabel() + "\t");
			// out.write(x.getCatLabel());
		}
		// + oxidesForHeaders(headers, numOfOxides)
		out3.write("Sum\tOx\t");
		for (Oxydes x : listaOssidi_print) {
			// out.write(x.getOxyLabel());
			out3.write(x.getCatLabel() + "\t");
		}

		out3.write("cationSUM");
		printSupplementaryHeaders(out3);

		out3.write("\n");
		out3.close();
		// setControllo_header(controllo_header);
		controllo_header = true;
		System.out.println("controllo header: " + controllo_header);
		setControllo_header(true);// controllo_header = true;
		System.out.println("controllo header2: " + isControllo_header());
		printSorted();
	}

	@SuppressWarnings("unchecked")
	public void printHeaderALL(PrintWriter out3) throws Exception {
		
		jMineralCalc.getConsole().println("PRINT HEADER!");
		ArrayList<Oxydes> clone = (ArrayList<Oxydes>) listaOssidi.clone();
		ArrayList<Oxydes> listaOssidi_print = clone;
		Collections.sort(listaOssidi_print);
		
		out3.write("Sample\tMineral\t");
		
		
		for (Oxydes x : listaOssidi_print) {
			out3.write(x.getOxyLabel() + "\t");
			// out.write(x.getCatLabel());
		}
		// + oxidesForHeaders(headers, numOfOxides)
		out3.write("Sum\tOx\t");
		for (Oxydes x : listaOssidi_print) {
			// out.write(x.getOxyLabel());
			out3.write(x.getCatLabel() + "\t");
		}

		out3.write("cationSUM");
		printSupplementaryHeaders(out3);

		out3.write("\n");
		out3.close();
		// setControllo_header(controllo_header);
		controllo_header = true;
		System.out.println("controllo header: " + controllo_header);
		setControllo_header(true);// controllo_header = true;
		System.out.println("controllo header2: " + isControllo_header());
		printSortedUniqueFile();
	}
	
	public void printSupplementaryHeaders(PrintWriter outWr) {
		// Qui non fa nulla, implementato nelle sottoclassi

	}

	public void printSupplemetaryValues(PrintWriter out) {
		// Qui non fa nulla, implementato nelle sottoclassi
	}

	@SuppressWarnings("unchecked")
	void printSorted() throws IOException, Exception {
		
		ArrayList<Oxydes> clone = (ArrayList<Oxydes>) listaOssidi.clone();
		ArrayList<Oxydes> listaOssidi_print = clone;
		Collections.sort(listaOssidi_print);
		
		
	//	System.out.println("NEW PRINT SORTED");
		// print sorted data
		if (out1.exists()) {
			System.out.println("print sorted file exists...");
			printwriter = new PrintWriter(new FileWriter(out1, true));
			jMineralCalc.getConsole().println("FILE EXISTS!");
		} else {

			System.out.println("print sorted file NOT exists...");
			printwriter = new PrintWriter(new FileWriter(out1, true));
			System.out.println(" headers to be written...");
			jMineralCalc.getConsole().println("FILE DOES NOT EXIST!");
			// out = new PrintWriter(new FileWriter(out1, true));
			printHeader(printwriter);

		}
		jMineralCalc.getConsole().println("NEW PRINT SORTED!");
		//stampa su OUT
		// 
		//
		// code
		
		printwriter.write(getSampleS() + "\t" + getMineralCodeString());

		for (Oxydes x : listaOssidi_print) {
			printwriter.write("\t" + formatter.format(x.getOxyVal()));
		}

		printwriter.write("\t" + formatter.format(getSUM_oxides()) + "\t"
				+ getMineralOssigeniI());
		
		for (Oxydes x : listaOssidi_print) {
			printwriter.write("\t" + formatter.format(x.getCatVal()));
		}

		printwriter.write("\t" + formatter.format(getSUM_cationsD()));
		printSupplemetaryValues(printwriter);
		printwriter.write("\n");
		printwriter.close();
		tools.transposeTabFile.go(out1); 
		

	}
	
	
	@SuppressWarnings("unchecked")
	void printSortedUniqueFile() throws IOException, Exception {
		
		ArrayList<Oxydes> clone = (ArrayList<Oxydes>) listaOssidi.clone();
		ArrayList<Oxydes> listaOssidi_print = clone;
		Collections.sort(listaOssidi_print);
		
		
		// print sorted data
		if (out2.exists()) {
			//System.out.println("print sorted file exists...");
			printwriterALL = new PrintWriter(new FileWriter(out2, true));

		} else {

			//System.out.println("print sorted file NOT exists...");
			printwriterALL = new PrintWriter(new FileWriter(out2, true));
			//System.out.println(" headers to be written...");
			// out = new PrintWriter(new FileWriter(out1, true));
			printHeaderALL(printwriterALL);

		}
		jMineralCalc.getConsole().println("NEW PRINT UNIQUE FILE SORTED");
		//stampa su OUT
		// 
		//
		// code
		
		printwriterALL.write(getSampleS() + "\t" + getMineralCodeString());

		for (Oxydes x : listaOssidi_print) {
			printwriterALL.write("\t" + formatter.format(x.getOxyVal()));
		}

		printwriterALL.write("\t" + formatter.format(getSUM_oxides()) + "\t"
				+ getMineralOssigeniI());
		
		for (Oxydes x : listaOssidi_print) {
			printwriterALL.write("\t" + formatter.format(x.getCatVal()));
		}

		printwriterALL.write("\t" + formatter.format(getSUM_cationsD()));
		printSupplemetaryValues(printwriterALL);
		printwriterALL.write("\n");
		printwriterALL.close();

	}

	@SuppressWarnings("unchecked")
	public void calcFe3_Droop() throws Exception {
		Fe2_old = FeO.getCatVal(); //listaOssidi.get(AnalysisDataFile.getTokenFeO()).getCatVal();
		FeO_old = FeO.getOxyVal(); //listaOssidi.get(AnalysisDataFile.getTokenFeO()).getOxyVal();
		
		if(isFeO_present()){

		} 
	
		
			
		 Fe2_new =0;
		 Fe3_new = 0;
		 Fe2O3_new=0;
		 FeO_new=0;
		 
		 double sumCations_tmp = 0;

		 ArrayList<Oxydes> clone = (ArrayList<Oxydes>) listaOssidi.clone();

		 ArrayList<Oxydes> listaOssidi_tmp = clone;

//			for (Oxydes u: listaOssidi_tmp){
//					System.out.println("lista tmp, cat values: "+ u.getCatVal());
//				}
		 /*
		 * DAVE WATERS - after DROOP Min. Mag. 1987 V51 pp 431-435 F (Fe2O3) =
		 * 2X.(1 - T/S) X = oxygen in the formula UNIT (es = 12) T = ideal
		 * number of cations per formula unit, S = cation total obtained when
		 * all iron is assumed to be Fe2+
		 */

//		for (Oxydes z : listaOssidi) {
//			if (z.getOxyLabel().equalsIgnoreCase("Fe2O3") ){
//
//				System.out
//						.println("Fe2O3 already present no Droop calc  performed");
//				setFe2O3_present(true);
//			} else {
//					setFe2O3_present(false);
//					}
	//		System.out.println("starting Fe2O3 calc _ DROOP mode");

			if(isFe2O3_present()==false && isFeO_present()==true){
				System.out.println("Starting Fe2O3 calc _ DROOP mode\n");
				// if (Fe2O3.getOxyVal()==null){
				// check if Fe2O3 value exists

				

				/* F=2*X*(1-(T/S)) */
				// Fe3 = 2 * X * (1 - (T / S));
				// F=46(1-16/S)
				// F=46(1-13/Phi)
				// Phi=SUM(Si,Ti,Al,Cr,Fe,Mn,Mg)
				
				// int T = runningMF.getIdealCationSum();
				// double S = cationSum;
				// int X = runningMF.getMineralOxyInt();
				// first check, if the formula is applicable (S>T)
				
				if (getSUM_cationsD() > getIdeal_cation_sum()) {
					Fe3_new=2* getMineralOssigeniI()* (1 - (getIdeal_cation_sum() / getSUM_cationsD()));

					
					Collections.copy(listaOssidi_tmp, listaOssidi);
					for (Oxydes x : listaOssidi_tmp) {
						x.setCatVal(x.getCatVal()
								* (getIdeal_cation_sum() / getSUM_cationsD()));
						sumCations_tmp += x.getCatVal();
					//	setSUM_cationsD(SUM_cationsD);
					}
					
//					for (Oxydes x : listaOssidi) {
//						x.setCatVal(x.getCatVal()
//								* (getIdeal_cation_sum() / getSUM_cationsD()));
//						SUM_cationsD += x.getCatVal();
//						setSUM_cationsD(SUM_cationsD);
//					}
				} else {
					System.out.println("No Fe3+ in the mineral phase");
					
				}
				System.out.println("Fe3_tmp_before_check = "+Fe3_new);

				// Fetot = cationsForOxide[FormulaSetup.tokenFeO];
				// System.out.println("numOfOxides: " +
				// runningMF.getNumOfOxidesWt());
				// System.out.print("runningMF")

				// FeO.setCatVal(Fe2O3.getCatVal()*FeO.getCatVal());
				// new_Fetot = Fetot*Fe3;

				// second check
				if (Fe2_old > Fe3_new) {
//					listaOssidi_tmp.get(AnalysisDataFile.getTokenFeO()).setCatVal(
//							listaOssidi_tmp.get(AnalysisDataFile.getTokenFeO())
//									.getCatVal()
//									- Fe3_new);
					Fe2_new = Fe2_old - Fe3_new;
					System.out.println("Fe3_droop: " + Fe3_new);
					System.out.println("Fe2_new_after_droop: " + Fe2_new);

				} else {

					Fe2_new=0;
				}
				double Fe2_ratio = Fe2_new/(Fe2_new+Fe3_new);
				double Fe3_ratio = Fe3_new/(Fe2_new+Fe3_new);
				FeO_new = FeO_old*Fe2_ratio;
				Fe2O3_new = 1.1113*FeO_old*Fe3_ratio;
				setFe2O3_new(Fe2O3_new);
				setFeO_new(FeO_new);
				setDROOP_B(true);

			}
	}


	//}

	public boolean isControllo_header() {
		return controllo_header;
	}

	public void setControllo_header(boolean b) {
		controllo_header = b;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public File getOut1() {
		return out1;
	}

	public void setOut1(File out1) {
		this.out1 = out1;
	}

	public PrintWriter getOut() {
		return printwriter;
	}

	public void setOut(PrintWriter out) {
		this.printwriter = out;
	}

	public  void addOssido_lista_Ossidi(Oxydes aOxydes) {
		listaOssidi.add(aOxydes);
		// System.out.println("lista ossidi: "+lista_Ossidi);
	}
	public void addOssido_lista_Ossidi(Oxydes aOxydes, int posizioneOssido) {
		listaOssidi.add(posizioneOssido, aOxydes);
		
		System.out.println("Aggiunto ossido "+listaOssidi.get(posizioneOssido).getOxyLabel()+" alla posizione :"+listaOssidi.get(posizioneOssido));
		
	}
	
	public void addCation_lista_Cationi(Cations aCations) {
		listaCationi.add(aCations);
		// System.out.println("lista cationi: "+lista_Cations);
	}
	// FINE CLASSE

	public boolean isDROOP_B() {
		return isDROOP_B;
	}

	public void setDROOP_B(boolean isDROOPB) {
		isDROOP_B = isDROOPB;
	}

	public static boolean isFe2O3_present() {
		return Fe2O3_present;
	}

	public static void setFe2O3_present(boolean fe2o3Present) {
		Fe2O3_present = fe2o3Present;
	}

	public static boolean isSiO2_present() {
		return SiO2_present;
	}

	public static void setSiO2_present(boolean siO2Present) {
		SiO2_present = siO2Present;
	}

	public static boolean isTiO2_present() {
		return TiO2_present;
	}

	public static void setTiO2_present(boolean tiO2Present) {
		TiO2_present = tiO2Present;
	}

	public static boolean isAl2O3_present() {
		return Al2O3_present;
	}

	public static void setAl2O3_present(boolean al2o3Present) {
		Al2O3_present = al2o3Present;
	}

	public static boolean isNa2O_present() {
		return Na2O_present;
	}

	public static void setNa2O_present(boolean na2oPresent) {
		Na2O_present = na2oPresent;
	}

	public static boolean isCaO_present() {
		return CaO_present;
	}

	public static void setCaO_present(boolean caOPresent) {
		CaO_present = caOPresent;
	}

	public static boolean isK2O_present() {
		return K2O_present;
	}

	public static void setK2O_present(boolean k2oPresent) {
		K2O_present = k2oPresent;
	}

	public static boolean isP2O5_present() {
		return P2O5_present;
	}

	public static void setP2O5_present(boolean p2o5Present) {
		P2O5_present = p2o5Present;
	}

	public static boolean isMnO_present() {
		return MnO_present;
	}

	public static void setMnO_present(boolean mnOPresent) {
		MnO_present = mnOPresent;
	}

	public static boolean isFeO_present() {
		return FeO_present;
	}

	public static void setFeO_present(boolean feOPresent) {
		FeO_present = feOPresent;
	}

	public static boolean isCr2O3_present() {
		return Cr2O3_present;
	}

	public static void setCr2O3_present(boolean cr2o3Present) {
		Cr2O3_present = cr2o3Present;
	}

	public static boolean isZnO_present() {
		return ZnO_present;
	}

	public static void setZnO_present(boolean znOPresent) {
		ZnO_present = znOPresent;
	}

	public static boolean isB2O3_present() {
		return B2O3_present;
	}

	public static void setB2O3_present(boolean b2o3Present) {
		B2O3_present = b2o3Present;
	}

	public static boolean isCO2_present() {
		return CO2_present;
	}

	public static void setCO2_present(boolean cO2Present) {
		CO2_present = cO2Present;
	}

	public static boolean isMgO_present() {
		return MgO_present;
	}

	public static void setMgO_present(boolean mgOPresent) {
		MgO_present = mgOPresent;
	}

	public static boolean isSrO_present() {
		return SrO_present;
	}

	public static void setSrO_present(boolean srOPresent) {
		SrO_present = srOPresent;
	}

	public static boolean isLa2O3_present() {
		return La2O3_present;
	}

	public static void setLa2O3_present(boolean la2o3Present) {
		La2O3_present = la2o3Present;
	}

	public static void setPbO_present(boolean b) {
		PbO_present = b;		
	}

	public static boolean isUO2_present() {
		return UO2_present;
	}

	public static void setUO2_present(boolean uO2Present) {
		UO2_present = uO2Present;
	}

	public static boolean isThO2_present() {
		return ThO2_present;
	}

	public static void setThO2_present(boolean thO2Present) {
		ThO2_present = thO2Present;
	}

	public static boolean isPr2O3_present() {
		return Pr2O3_present;
	}

	public static void setPr2O3_present(boolean pr2o3Present) {
		Pr2O3_present = pr2o3Present;
	}

	public static boolean isY2O3_present() {
		return Y2O3_present;
	}

	public static void setY2O3_present(boolean y2o3Present) {
		Y2O3_present = y2o3Present;
	}

	public static boolean isNd2O3_present() {
		return Nd2O3_present;
	}

	public static void setNd2O3_present(boolean nd2o3Present) {
		Nd2O3_present = nd2o3Present;
	}

	public static boolean isSm2O3_present() {
		return Sm2O3_present;
	}

	public static void setSm2O3_present(boolean sm2o3Present) {
		Sm2O3_present = sm2o3Present;
	}

	public static boolean isCe2O3_present() {
		return Ce2O3_present;
	}

	public static void setCe2O3_present(boolean ce2o3Present) {
		Ce2O3_present = ce2o3Present;
	}

	public static boolean isGd2O3_present() {
		return Gd2O3_present;
	}

	public static void setGd2O3_present(boolean gd2o3Present) {
		Gd2O3_present = gd2o3Present;
	}

	public static boolean isPbO_present() {
		return PbO_present;
	}

	
	public double getFe2_old() {
		return Fe2_old;
	}

	public void setFe2_old(double fe2Old) {
		Fe2_old = fe2Old;
	}

	public double getFe3_new() {
		return Fe3_new;
	}

	public void setFe3_new(double fe3New) {
		Fe3_new = fe3New;
	}

	public double getFe2_new() {
		return Fe2_new;
	}

	public void setFe2_new(double fe2New) {
		Fe2_new = fe2New;
	}

	public double getFe2O3_new() {
		return Fe2O3_new;
	}

	public void setFe2O3_new(double fe2o3New) {
		Fe2O3_new = fe2o3New;
	}

	public double getFeO_new() {
		return FeO_new;
	}

	public void setFeO_new(double feONew) {
		FeO_new = feONew;
	}

	public static boolean isSO3_present() {
		return SO3_present;
	}

	public static void setSO3_present(boolean sO3Present) {
		SO3_present = sO3Present;
	}

	public static boolean isNiO_present() {
		return NiO_present;
	}

	public static void setNiO_present(boolean niOPresent) {
		NiO_present = niOPresent;
	}

	public static boolean isBaO_present() {
		return BaO_present;
	}

	public static void setBaO_present(boolean baOPresent) {
		BaO_present = baOPresent;
	}

	public static void setSDUO2_present(boolean b) {
		SDUO2_present = true;
		
	}

	public static void setSDThO2_present(boolean b) {
		SDThO2_present = true;
		
	}

	public static void setSDPbO_present(boolean b) {
		SDPbO_present = true;
		
	}

	public SiO2 getSiO2() {
		return SiO2;
	}

	public void setSiO2(SiO2 siO2) {
		SiO2 = siO2;
	}

	public Double getSumOfOxides() {
		return sumOfOxides;
	}

	public void setSumOfOxides(Double sumOfOxides) {
		this.sumOfOxides = sumOfOxides;
	}

	public String[] getArray_inputData() {
		return array_inputData;
	}

	public void setArray_inputData(String[] arrayInputData) {
		array_inputData = arrayInputData;
	}

	public ArrayList<String> getStringone() {
		return stringone;
	}

	public void setStringone(ArrayList<String> stringone) {
		this.stringone = stringone;
	}


	public void setListone(ArrayList<Oxydes> listone) {
		listaOssidi = listone;
	}

	/**
	 * @return the array_Ossidi
	 */
	public String[] getArray_Ossidi() {
		return array_Ossidi;
	}

	/**
	 * @param arrayOssidi the array_Ossidi to set
	 */
	public void setArray_Ossidi(String[] arrayOssidi) {
		array_Ossidi = arrayOssidi;
	}

	
	/// INIZIO PROVA FUNZIONA!!!!! 23 novembre 2011
	
	public static void activateSiO2(int j) {
		setSiO2_present(true);
		setTokenSiO2(j-2);
		setPosizioneSiO2(j);
	}
	public static void setPosizioneSiO2(int posizioneSiO2) {
		MineralPhase.posizioneSiO2 = posizioneSiO2;
	}
	public void addSiO2(){
			SiO2 = new SiO2();
			SiO2.setPosizioneSiO2(MineralPhase.posizioneSiO2);
			SiO2.setPosizione(MineralPhase.posizioneSiO2);
			addOssido_lista_Ossidi(SiO2);		
	}
	
	//// FINE PROVA 
	public static void setPosizioneAl2O3(int posizioneAl2O3) {
		MineralPhase.posizioneAl2O3 = posizioneAl2O3;		
	}
	public static void activateAl2O3(int j) {
		setAl2O3_present(true);
		setTokenAl2O3(j-2);
		setPosizioneAl2O3(j);

	}
	public void addAl2O3(){
		Al2O3 = new Al2O3();
		Al2O3.setPosizioneAl2O3(MineralPhase.posizioneAl2O3);
		Al2O3.setPosizione(MineralPhase.posizioneAl2O3);
		addOssido_lista_Ossidi(Al2O3);		
}
	
	
//	private static int posizionePbO;	
	public static void setPosizionePbO(int posizionePbO) {
		MineralPhase.posizionePbO = posizionePbO;		
	}
	public static void activatePbO(int j) {
		setPbO_present(true);
		setTokenPbO(j-2);
		setPosizionePbO(j);
		//PbO.setPosizione(j);
	//	addOssido_lista_Ossidi(PbO);
	}
	public void addPbO(){
		PbO = new PbO();
		PbO.setPosizionePbO(MineralPhase.posizionePbO);
		PbO.setPosizione(MineralPhase.posizionePbO);
		addOssido_lista_Ossidi(PbO);		
}
	
	
//	private static int posizioneThO2;	
	public static void setPosizioneThO2(int posizioneThO2) {
		MineralPhase.posizioneThO2 = posizioneThO2;		
	}
	public static void activateThO2(int j) {
		setThO2_present(true);
		setTokenThO2(j-2);
		setPosizioneThO2(j);

	}
	public void addThO2(){
		ThO2 = new ThO2();
		ThO2.setPosizioneThO2(MineralPhase.posizioneThO2);
		ThO2.setPosizione(MineralPhase.posizioneThO2);
		addOssido_lista_Ossidi(ThO2);		
}
	
	

	public static void setPosizioneUO2(int posizioneUO2) {
		MineralPhase.posizioneUO2 = posizioneUO2;		
	}
	public static void activateUO2(int j) {
		setUO2_present(true);
		setTokenUO2(j-2);
		setPosizioneUO2(j);

	}
	public void addUO2(){
		UO2 = new UO2();
		UO2.setPosizioneUO2(MineralPhase.posizioneUO2);
		UO2.setPosizione(MineralPhase.posizioneUO2);
		addOssido_lista_Ossidi(UO2);		
}

	public static void activateSDUO2(int j) {
		setSDUO2_present(true);
		tokenArraySDUO2= j;
		setPosizioneSDUO2(j);
	}

	private static void setPosizioneSDUO2(int j) {
posizioneSDUO2 = j;		
	}

	private static void setPosizioneSDThO2(int j) {
		posizioneSDThO2 = j;		
			}
	private static void setPosizioneSDPbO(int j) {
		posizioneSDPbO = j;		
			}
	
	public static void activateSDThO2(int j) {
		setSDThO2_present(true);
		tokenArraySDThO2= j;
		setPosizioneSDThO2(j);
	}

	public static void activateSDPbO(int j) {
		setSDPbO_present(true);
		tokenArraySDPbO= j;
		setPosizioneSDPbO(j);
	}

	public static void setPosizioneTiO2(int posizioneTiO2) {
		MineralPhase.posizioneTiO2 = posizioneTiO2;		
	}
	public static void activateTiO2(int j) {
		setTiO2_present(true);
		setTokenTiO2(j-2);
		setPosizioneTiO2(j);

	}
	public void addTiO2(){
		TiO2 = new TiO2();
		TiO2.setPosizioneTiO2(MineralPhase.posizioneTiO2);
		TiO2.setPosizione(MineralPhase.posizioneTiO2);
		addOssido_lista_Ossidi(TiO2);		
}

	

	public static void setPosizioneCr2O3(int posizioneCr2O3) {
		MineralPhase.posizioneCr2O3 = posizioneCr2O3;		
	}
	public static void activateCr2O3(int j) {
		setCr2O3_present(true);
		setTokenCr2O3(j-2);
		setPosizioneCr2O3(j);

	}
	public void addCr2O3(){
		Cr2O3 = new Cr2O3();
		Cr2O3.setPosizioneCr2O3(MineralPhase.posizioneCr2O3);
		Cr2O3.setPosizione(MineralPhase.posizioneCr2O3);
		addOssido_lista_Ossidi(Cr2O3);		
}

	public static void setPosizioneFeO(int posizioneFeO) {
		MineralPhase.posizioneFeO = posizioneFeO;		
	}
	public static void activateFeO(int j) {
		setFeO_present(true);
		setTokenFeO(j-2);
		setPosizioneFeO(j);

	}
	public void addFeO(){
		FeO = new FeO();
		FeO.setPosizioneFeO(MineralPhase.posizioneFeO);
		FeO.setPosizione(MineralPhase.posizioneFeO);
		addOssido_lista_Ossidi(FeO);	
//		addOssido_lista_Ossidi(FeO, posizioneFeO);		
}



	public static void setPosizioneFe2O3(int posizioneFe2O3) {
		MineralPhase.posizioneFe2O3 = posizioneFe2O3;		
	}
	public static void activateFe2O3(int j) {
		setFe2O3_present(true);
		setTokenFe2O3(j-2);
		setPosizioneFe2O3(j);

	}
	public void addFe2O3(){
		Fe2O3 = new Fe2O3();
		Fe2O3.setPosizioneFe2O3(MineralPhase.posizioneFe2O3);
		Fe2O3.setPosizione(MineralPhase.posizioneFe2O3);
		addOssido_lista_Ossidi(Fe2O3);		
}

	public static void setPosizioneMnO(int posizioneMnO) {
		MineralPhase.posizioneMnO = posizioneMnO;		
	}
	public static void activateMnO(int j) {
		setMnO_present(true);
		setTokenMnO(j-2);
		setPosizioneMnO(j);

	}
	public void addMnO(){
		MnO = new MnO();
		MnO.setPosizioneMnO(MineralPhase.posizioneMnO);
		MnO.setPosizione(MineralPhase.posizioneMnO);
		addOssido_lista_Ossidi(MnO);		
}

	public static void setPosizioneMgO(int posizioneMgO) {
		MineralPhase.posizioneMgO = posizioneMgO;		
	}
	public static void activateMgO(int j) {
		setMgO_present(true);
		setTokenMgO(j-2);
		setPosizioneMgO(j);

	}
	public void addMgO(){
		MgO = new MgO();
		MgO.setPosizioneMgO(MineralPhase.posizioneMgO);
		MgO.setPosizione(MineralPhase.posizioneMgO);
		addOssido_lista_Ossidi(MgO);		
}

	public static void setPosizioneZnO(int posizioneZnO) {
		MineralPhase.posizioneZnO = posizioneZnO;		
	}
	public static void activateZnO(int j) {
		setZnO_present(true);
		setTokenZnO(j-2);
		setPosizioneZnO(j);

	}
	public void addZnO(){
		ZnO = new ZnO();
		ZnO.setPosizioneZnO(MineralPhase.posizioneZnO);
		ZnO.setPosizione(MineralPhase.posizioneZnO);
		addOssido_lista_Ossidi(ZnO);		
}

	public static void setPosizioneCaO(int posizioneCaO) {
		MineralPhase.posizioneCaO = posizioneCaO;		
	}
	public static void activateCaO(int j) {
		setCaO_present(true);
		setTokenCaO(j-2);
		setPosizioneCaO(j);

	}
	public void addCaO(){
		CaO = new CaO();
		CaO.setPosizioneCaO(MineralPhase.posizioneCaO);
		CaO.setPosizione(MineralPhase.posizioneCaO);
		addOssido_lista_Ossidi(CaO);		
}
	public static void setPosizioneCO2(int posizioneCO2) {
		MineralPhase.posizioneCO2 = posizioneCO2;		
	}
	public static void activateCO2(int j) {
		setCO2_present(true);
		setTokenCO2(j-2);
		setPosizioneCO2(j);

	}
	public void addCO2(){
		CO2 = new CO2();
		CO2.setPosizioneCO2(MineralPhase.posizioneCO2);
		CO2.setPosizione(MineralPhase.posizioneCO2);
		addOssido_lista_Ossidi(CO2);		
}
	public static void setPosizioneNa2O(int posizioneNa2O) {
		MineralPhase.posizioneNa2O = posizioneNa2O;		
	}
	public static void activateNa2O(int j) {
		setNa2O_present(true);
		setTokenNa2O(j-2);
		setPosizioneNa2O(j);

	}
	public void addNa2O(){
		Na2O = new Na2O();
		Na2O.setPosizioneNa2O(MineralPhase.posizioneNa2O);
		Na2O.setPosizione(MineralPhase.posizioneNa2O);
		addOssido_lista_Ossidi(Na2O);		
}

	public static void setPosizioneK2O(int posizioneK2O) {
		MineralPhase.posizioneK2O = posizioneK2O;		
	}
	public static void activateK2O(int j) {
		setK2O_present(true);
		setTokenK2O(j-2);
		setPosizioneK2O(j);

	}
	public void addK2O(){
		K2O = new K2O();
		K2O.setPosizioneK2O(MineralPhase.posizioneK2O);
		K2O.setPosizione(MineralPhase.posizioneK2O);
		addOssido_lista_Ossidi(K2O);		
}

	public static void setPosizioneP2O5(int posizioneP2O5) {
		MineralPhase.posizioneP2O5 = posizioneP2O5;		
	}
	public static void activateP2O5(int j) {
		setP2O5_present(true);
		setTokenP2O5(j-2);
		setPosizioneP2O5(j);

	}
	public void addP2O5(){
		P2O5 = new P2O5();
		P2O5.setPosizioneP2O5(MineralPhase.posizioneP2O5);
		P2O5.setPosizione(MineralPhase.posizioneP2O5);
		addOssido_lista_Ossidi(P2O5);		
}

	public static void setPosizioneB2O3(int posizioneB2O3) {
		MineralPhase.posizioneB2O3 = posizioneB2O3;		
	}
	public static void activateB2O3(int j) {
		setB2O3_present(true);
		setTokenB2O3(j-2);
		setPosizioneB2O3(j);

	}
	public void addB2O3(){
		B2O3 = new B2O3();
		B2O3.setPosizioneB2O3(MineralPhase.posizioneB2O3);
		B2O3.setPosizione(MineralPhase.posizioneB2O3);
		addOssido_lista_Ossidi(B2O3);		
}

	public static void setPosizioneSrO(int posizioneSrO) {
		MineralPhase.posizioneSrO = posizioneSrO;		
	}
	public static void activateSrO(int j) {
		setSrO_present(true);
		setTokenSrO(j-2);
		setPosizioneSrO(j);

	}
	public void addSrO(){
		SrO = new SrO();
		SrO.setPosizioneSrO(MineralPhase.posizioneSrO);
		SrO.setPosizione(MineralPhase.posizioneSrO);
		addOssido_lista_Ossidi(SrO);		
}
	
	
	public static void setPosizioneLa2O3(int posizioneLa2O3) {
		MineralPhase.posizioneLa2O3 = posizioneLa2O3;		
	}
	public static void activateLa2O3(int j) {
		setLa2O3_present(true);
		setTokenLa2O3(j-2);
		setPosizioneLa2O3(j);

	}
	public void addLa2O3(){
		La2O3 = new La2O3();
		La2O3.setPosizioneLa2O3(MineralPhase.posizioneLa2O3);
		La2O3.setPosizione(MineralPhase.posizioneLa2O3);
		addOssido_lista_Ossidi(La2O3);		
}

	public static void setPosizionePr2O3(int posizionePr2O3) {
		MineralPhase.posizionePr2O3 = posizionePr2O3;		
	}
	public static void activatePr2O3(int j) {
		setPr2O3_present(true);
		setTokenPr2O3(j-2);
		setPosizionePr2O3(j);

	}
	public void addPr2O3(){
		Pr2O3 = new Pr2O3();
		Pr2O3.setPosizionePr2O3(MineralPhase.posizionePr2O3);
		Pr2O3.setPosizione(MineralPhase.posizionePr2O3);
		addOssido_lista_Ossidi(Pr2O3);		
}

	public static void setPosizioneY2O3(int posizioneY2O3) {
		MineralPhase.posizioneY2O3 = posizioneY2O3;		
	}
	public static void activateY2O3(int j) {
		setY2O3_present(true);
		setTokenY2O3(j-2);
		setPosizioneY2O3(j);

	}
	public void addY2O3(){
		Y2O3 = new Y2O3();
		Y2O3.setPosizioneY2O3(MineralPhase.posizioneY2O3);
		Y2O3.setPosizione(MineralPhase.posizioneY2O3);
		addOssido_lista_Ossidi(Y2O3);		
}

	public static void setPosizioneNd2O3(int posizioneNd2O3) {
		MineralPhase.posizioneNd2O3 = posizioneNd2O3;		
	}
	public static void activateNd2O3(int j) {
		setNd2O3_present(true);
		setTokenNd2O3(j-2);
		setPosizioneNd2O3(j);

	}
	public void addNd2O3(){
		Nd2O3 = new Nd2O3();
		Nd2O3.setPosizioneNd2O3(MineralPhase.posizioneNd2O3);
		Nd2O3.setPosizione(MineralPhase.posizioneNd2O3);
		addOssido_lista_Ossidi(Nd2O3);		
}
	public static void setPosizioneSm2O3(int posizioneSm2O3) {
		MineralPhase.posizioneSm2O3 = posizioneSm2O3;		
	}
	public static void activateSm2O3(int j) {
		setSm2O3_present(true);
		setTokenSm2O3(j-2);
		setPosizioneSm2O3(j);

	}
	public void addSm2O3(){
		Sm2O3 = new Sm2O3();
		Sm2O3.setPosizioneSm2O3(MineralPhase.posizioneSm2O3);
		Sm2O3.setPosizione(MineralPhase.posizioneSm2O3);
		addOssido_lista_Ossidi(Sm2O3);		
}

	public static void setPosizioneCe2O3(int posizioneCe2O3) {
		MineralPhase.posizioneCe2O3 = posizioneCe2O3;		
	}
	public static void activateCe2O3(int j) {
		setCe2O3_present(true);
		setTokenCe2O3(j-2);
		setPosizioneCe2O3(j);

	}
	public void addCe2O3(){
		Ce2O3 = new Ce2O3();
		Ce2O3.setPosizioneCe2O3(MineralPhase.posizioneCe2O3);
		Ce2O3.setPosizione(MineralPhase.posizioneCe2O3);
		addOssido_lista_Ossidi(Ce2O3);		
}

	public static void setPosizioneGd2O3(int posizioneGd2O3) {
		MineralPhase.posizioneGd2O3 = posizioneGd2O3;		
	}
	public static void activateGd2O3(int j) {
		setGd2O3_present(true);
		setTokenGd2O3(j-2);
		setPosizioneGd2O3(j);

	}
	public void addGd2O3(){
		Gd2O3 = new Gd2O3();
		Gd2O3.setPosizioneGd2O3(MineralPhase.posizioneGd2O3);
		Gd2O3.setPosizione(MineralPhase.posizioneGd2O3);
		addOssido_lista_Ossidi(Gd2O3);		
}
	public static void setPosizioneSO3(int posizioneSO3) {
		MineralPhase.posizioneSO3 = posizioneSO3;		
	}
	public static void activateSO3(int j) {
		setSO3_present(true);
		setTokenSO3(j-2);
		setPosizioneSO3(j);

	}
	public void addSO3(){
		SO3 = new SO3();
		SO3.setPosizioneSO3(MineralPhase.posizioneSO3);
		SO3.setPosizione(MineralPhase.posizioneSO3);
		addOssido_lista_Ossidi(SO3);		
}

	public static void setPosizioneNiO(int posizioneNiO) {
		MineralPhase.posizioneNiO = posizioneNiO;		
	}
	public static void activateNiO(int j) {
		setNiO_present(true);
		setTokenNiO(j-2);
		setPosizioneNiO(j);

	}
	public void addNiO(){
		NiO = new NiO();
		NiO.setPosizioneNiO(MineralPhase.posizioneNiO);
		NiO.setPosizione(MineralPhase.posizioneNiO);
		addOssido_lista_Ossidi(NiO);		
}

	public static void setPosizioneBaO(int posizioneBaO) {
		MineralPhase.posizioneBaO = posizioneBaO;		
	}
	public static void activateBaO(int j) {
		setBaO_present(true);
		setTokenBaO(j-2);
		setPosizioneBaO(j);

	}
	public void addBaO(){
		BaO = new BaO();
		BaO.setPosizioneBaO(MineralPhase.posizioneBaO);
		BaO.setPosizione(MineralPhase.posizioneBaO);
		addOssido_lista_Ossidi(BaO);		
}

	/**
	 * @return the tokenSiO2
	 */
	public static int getTokenSiO2() {
		return tokenSiO2;
	}

	/**
	 * @param tokenSiO2 the tokenSiO2 to set
	 */
	public static void setTokenSiO2(int tokenSiO2) {
		MineralPhase.tokenSiO2 = tokenSiO2;
	}

	/**
	 * @return the tokenFeO
	 */
	public static int getTokenFeO() {
		return tokenFeO;
	}

	/**
	 * @param tokenFeO the tokenFeO to set
	 */
	public static void setTokenFeO(int tokenFeO) {
		MineralPhase.tokenFeO = tokenFeO;
	}

	/**
	 * @return the tokenFe2O3
	 */
	public static int getTokenFe2O3() {
		return tokenFe2O3;
	}

	/**
	 * @param tokenFe2O3 the tokenFe2O3 to set
	 */
	public static void setTokenFe2O3(int tokenFe2O3) {
		MineralPhase.tokenFe2O3 = tokenFe2O3;
	}

	/**
	 * @return the tokenMnO
	 */
	public static int getTokenMnO() {
		return tokenMnO;
	}

	/**
	 * @param tokenMnO the tokenMnO to set
	 */
	public static void setTokenMnO(int tokenMnO) {
		MineralPhase.tokenMnO = tokenMnO;
	}

	/**
	 * @return the tokenMgO
	 */
	public static int getTokenMgO() {
		return tokenMgO;
	}

	/**
	 * @param tokenMgO the tokenMgO to set
	 */
	public static void setTokenMgO(int tokenMgO) {
		MineralPhase.tokenMgO = tokenMgO;
	}

	/**
	 * @return the tokenZnO
	 */
	public static int getTokenZnO() {
		return tokenZnO;
	}

	/**
	 * @param tokenZnO the tokenZnO to set
	 */
	public static void setTokenZnO(int tokenZnO) {
		MineralPhase.tokenZnO = tokenZnO;
	}

	/**
	 * @return the tokenCaO
	 */
	public static int getTokenCaO() {
		return tokenCaO;
	}

	/**
	 * @param tokenCaO the tokenCaO to set
	 */
	public static void setTokenCaO(int tokenCaO) {
		MineralPhase.tokenCaO = tokenCaO;
	}

	/**
	 * @return the tokenNa2O
	 */
	public static int getTokenNa2O() {
		return tokenNa2O;
	}

	/**
	 * @param tokenNa2O the tokenNa2O to set
	 */
	public static void setTokenNa2O(int tokenNa2O) {
		MineralPhase.tokenNa2O = tokenNa2O;
	}

	/**
	 * @return the tokenK2O
	 */
	public static int getTokenK2O() {
		return tokenK2O;
	}

	/**
	 * @param tokenK2O the tokenK2O to set
	 */
	public static void setTokenK2O(int tokenK2O) {
		MineralPhase.tokenK2O = tokenK2O;
	}

	/**
	 * @return the tokenP2O5
	 */
	public static int getTokenP2O5() {
		return tokenP2O5;
	}

	/**
	 * @param tokenP2O5 the tokenP2O5 to set
	 */
	public static void setTokenP2O5(int tokenP2O5) {
		MineralPhase.tokenP2O5 = tokenP2O5;
	}

	/**
	 * @return the tokenB2O3
	 */
	public static int getTokenB2O3() {
		return tokenB2O3;
	}

	/**
	 * @param tokenB2O3 the tokenB2O3 to set
	 */
	public static void setTokenB2O3(int tokenB2O3) {
		MineralPhase.tokenB2O3 = tokenB2O3;
	}

	/**
	 * @return the tokenLa2O3
	 */
	public static int getTokenLa2O3() {
		return tokenLa2O3;
	}

	/**
	 * @param tokenLa2O3 the tokenLa2O3 to set
	 */
	public static void setTokenLa2O3(int tokenLa2O3) {
		MineralPhase.tokenLa2O3 = tokenLa2O3;
	}

	/**
	 * @return the tokenCe2O3
	 */
	public static int getTokenCe2O3() {
		return tokenCe2O3;
	}

	/**
	 * @param tokenCe2O3 the tokenCe2O3 to set
	 */
	public static void setTokenCe2O3(int tokenCe2O3) {
		MineralPhase.tokenCe2O3 = tokenCe2O3;
	}

	/**
	 * @return the tokenSrO
	 */
	public static int getTokenSrO() {
		return tokenSrO;
	}

	/**
	 * @param tokenSrO the tokenSrO to set
	 */
	public static void setTokenSrO(int tokenSrO) {
		MineralPhase.tokenSrO = tokenSrO;
	}

	/**
	 * @return the tokenNd2O3
	 */
	public static int getTokenNd2O3() {
		return tokenNd2O3;
	}

	/**
	 * @param tokenNd2O3 the tokenNd2O3 to set
	 */
	public static void setTokenNd2O3(int tokenNd2O3) {
		MineralPhase.tokenNd2O3 = tokenNd2O3;
	}

	/**
	 * @return the tokenNiO
	 */
	public static int getTokenNiO() {
		return tokenNiO;
	}

	/**
	 * @param tokenNiO the tokenNiO to set
	 */
	public static void setTokenNiO(int tokenNiO) {
		MineralPhase.tokenNiO = tokenNiO;
	}

	/**
	 * @return the tokenBaO
	 */
	public static int getTokenBaO() {
		return tokenBaO;
	}

	/**
	 * @param tokenBaO the tokenBaO to set
	 */
	public static void setTokenBaO(int tokenBaO) {
		MineralPhase.tokenBaO = tokenBaO;
	}

	/**
	 * @return the tokenSO3
	 */
	public static int getTokenSO3() {
		return tokenSO3;
	}

	/**
	 * @param tokenSO3 the tokenSO3 to set
	 */
	public static void setTokenSO3(int tokenSO3) {
		MineralPhase.tokenSO3 = tokenSO3;
	}

	/**
	 * @return the tokenMineral
	 */
	public static int getTokenMineral() {
		return tokenMineral;
	}

	/**
	 * @param tokenMineral the tokenMineral to set
	 */
	public static void setTokenMineral(int tokenMineral) {
		MineralPhase.tokenMineral = tokenMineral;
	}

	/**
	 * @return the tokenTiO2
	 */
	public static int getTokenTiO2() {
		return tokenTiO2;
	}

	/**
	 * @param tokenTiO2 the tokenTiO2 to set
	 */
	public static void setTokenTiO2(int tokenTiO2) {
		MineralPhase.tokenTiO2 = tokenTiO2;
	}

	/**
	 * @return the tokenAl2O3
	 */
	public static int getTokenAl2O3() {
		return tokenAl2O3;
	}

	/**
	 * @param tokenAl2O3 the tokenAl2O3 to set
	 */
	public static void setTokenAl2O3(int tokenAl2O3) {
		MineralPhase.tokenAl2O3 = tokenAl2O3;
	}

	/**
	 * @return the tokenCr2O3
	 */
	public static int getTokenCr2O3() {
		return tokenCr2O3;
	}

	/**
	 * @param tokenCr2O3 the tokenCr2O3 to set
	 */
	public static void setTokenCr2O3(int tokenCr2O3) {
		MineralPhase.tokenCr2O3 = tokenCr2O3;
	}

	/**
	 * @return the tokenPbO
	 */
	public static int getTokenPbO() {
		return tokenPbO;
	}

	/**
	 * @param tokenPbO the tokenPbO to set
	 */
	public static void setTokenPbO(int tokenPbO) {
		MineralPhase.tokenPbO = tokenPbO;
	}

	/**
	 * @return the tokenThO2
	 */
	public static int getTokenThO2() {
		return tokenThO2;
	}

	/**
	 * @param tokenThO2 the tokenThO2 to set
	 */
	public static void setTokenThO2(int tokenThO2) {
		MineralPhase.tokenThO2 = tokenThO2;
	}

	/**
	 * @return the tokenUO2
	 */
	public static int getTokenUO2() {
		return tokenUO2;
	}

	/**
	 * @param tokenUO2 the tokenUO2 to set
	 */
	public static void setTokenUO2(int tokenUO2) {
		MineralPhase.tokenUO2 = tokenUO2;
	}

	/**
	 * @return the tokenPr2O3
	 */
	public static int getTokenPr2O3() {
		return tokenPr2O3;
	}

	/**
	 * @param tokenPr2O3 the tokenPr2O3 to set
	 */
	public static void setTokenPr2O3(int tokenPr2O3) {
		MineralPhase.tokenPr2O3 = tokenPr2O3;
	}

	/**
	 * @return the tokenY2O3
	 */
	public static int getTokenY2O3() {
		return tokenY2O3;
	}

	/**
	 * @param tokenY2O3 the tokenY2O3 to set
	 */
	public static void setTokenY2O3(int tokenY2O3) {
		MineralPhase.tokenY2O3 = tokenY2O3;
	}

	/**
	 * @return the tokenSm2O3
	 */
	public static int getTokenSm2O3() {
		return tokenSm2O3;
	}

	/**
	 * @param tokenSm2O3 the tokenSm2O3 to set
	 */
	public static void setTokenSm2O3(int tokenSm2O3) {
		MineralPhase.tokenSm2O3 = tokenSm2O3;
	}

	/**
	 * @return the tokenGd2O3
	 */
	public static int getTokenGd2O3() {
		return tokenGd2O3;
	}

	/**
	 * @param tokenGd2O3 the tokenGd2O3 to set
	 */
	public static void setTokenGd2O3(int tokenGd2O3) {
		MineralPhase.tokenGd2O3 = tokenGd2O3;
	}

	/**
	 * @return the zrO2_present
	 */
	public static boolean isZrO2_present() {
		return ZrO2_present;
	}

	/**
	 * @param zrO2_present the zrO2_present to set
	 */
	public static void setZrO2_present(boolean zrO2_present) {
		ZrO2_present = zrO2_present;
	}

	/**
	 * @return the v2O3_present
	 */
	public static boolean isV2O3_present() {
		return V2O3_present;
	}

	/**
	 * @param v2o3_present the v2O3_present to set
	 */
	public static void setV2O3_present(boolean v2o3_present) {
		V2O3_present = v2o3_present;
	}

	/**
	 * @return the li2O_present
	 */
	public static boolean isLi2O_present() {
		return Li2O_present;
	}

	/**
	 * @param li2o_present the li2O_present to set
	 */
	public static void setLi2O_present(boolean li2o_present) {
		Li2O_present = li2o_present;
	}

	/**
	 * @return the f_present
	 */
	public static boolean isF_present() {
		return F_present;
	}

	/**
	 * @param f_present the f_present to set
	 */
	public static void setF_present(boolean f_present) {
		F_present = f_present;
	}

	/**
	 * @return the cl_present
	 */
	public static boolean isCl_present() {
		return Cl_present;
	}

	/**
	 * @param cl_present the cl_present to set
	 */
	public static void setCl_present(boolean cl_present) {
		Cl_present = cl_present;
	}





	/**
	 * @return the h2O_present
	 */
	public static boolean isH2O_present() {
		return H2O_present;
	}

	/**
	 * @param h2o_present the h2O_present to set
	 */
	public static void setH2O_present(boolean h2o_present) {
		H2O_present = h2o_present;
	}

	/**
	 * @return the sDUO2_present
	 */
	public static boolean isSDUO2_present() {
		return SDUO2_present;
	}

	/**
	 * @return the sDThO2_present
	 */
	public static boolean isSDThO2_present() {
		return SDThO2_present;
	}

	/**
	 * @return the sDPbO_present
	 */
	public static boolean isSDPbO_present() {
		return SDPbO_present;
	}

	public static void setPosizioneCoO(int posizioneCoO) {
		MineralPhase.posizioneCoO = posizioneCoO;		
	}
	public static void activateCoO(int j) {
		setCoO_present(true);
		setTokenCoO(j-2);
		setPosizioneCoO(j);

	}
	public void addCoO(){
		CoO = new CoO();
		CoO.setPosizioneCoO(MineralPhase.posizioneCoO);
		CoO.setPosizione(MineralPhase.posizioneCoO);
		addOssido_lista_Ossidi(CoO);		
}

	private static void setTokenCoO(int i) {
MineralPhase.tokenCoO  = i;		
	}

	private static void setCoO_present(boolean b) {
	CoO_present = b;
	}

	public static void setPosizioneZrO2(int posizioneZrO2) {
		MineralPhase.posizioneZrO2 = posizioneZrO2;		
	}
	public static void activateZrO2(int j) {
		setZrO2_present(true);
		setTokenZrO2(j-2);
		setPosizioneZrO2(j);

	}
	public void addZrO2(){
		ZrO2 = new ZrO2();
		ZrO2.setPosizioneZrO2(MineralPhase.posizioneZrO2);
		ZrO2.setPosizione(MineralPhase.posizioneZrO2);
		addOssido_lista_Ossidi(ZrO2);		
}

	
	public static void setPosizioneV2O3(int posizioneV2O3) {
		MineralPhase.posizioneV2O3 = posizioneV2O3;		
	}
	public static void activateV2O3(int j) {
		setV2O3_present(true);
		setTokenV2O3(j-2);
		setPosizioneV2O3(j);

	}
	public void addV2O3(){
		V2O3 = new V2O3();
		V2O3.setPosizioneV2O3(MineralPhase.posizioneV2O3);
		V2O3.setPosizione(MineralPhase.posizioneV2O3);
		addOssido_lista_Ossidi(V2O3);		
}
	
	
	private static void setTokenV2O3(int i) {
MineralPhase.tokenV2O3=i;		
	}

	private static void setTokenZrO2(int i) {
		MineralPhase.tokenZrO2=i;		
	}

	/**
	 * @return the mn2O3_present
	 */
	public static boolean isMn2O3_present() {
		return Mn2O3_present;
	}

	/**
	 * @param mn2o3_present the mn2O3_present to set
	 */
	public static void setMn2O3_present(boolean mn2o3_present) {
		Mn2O3_present = mn2o3_present;
	}


	/**
	 * @return the coO_present
	 */
	public static boolean isCoO_present() {
		return CoO_present;
	}

	public static void setPosizioneCl(int posizioneCl) {
		MineralPhase.posizioneCl = posizioneCl;		
	}
	public static void activateCl(int j) {
		setCl_present(true);
		setTokenCl(j-2);
		setPosizioneCl(j);

	}
	public void addCl(){
		Cl = new Cl();
		Cl.setPosizioneCl(MineralPhase.posizioneCl);
		Cl.setPosizione(MineralPhase.posizioneCl);
		addOssido_lista_Ossidi(Cl);		
}

	public static void setPosizioneH2O(int posizioneH2O) {
		MineralPhase.posizioneH2O = posizioneH2O;		
	}
	public static void activateH2O(int j) {
		setH2O_present(true);
		setTokenH2O(j-2);
		setPosizioneH2O(j);

	}
	public void addH2O(){
		H2O = new H2O();
		H2O.setPosizioneH2O(MineralPhase.posizioneH2O);
		H2O.setPosizione(MineralPhase.posizioneH2O);
		addOssido_lista_Ossidi(H2O);		
}
	
	
	
	
	private static void setTokenH2O(int i) {
		MineralPhase.tokenH2O = i;		
	}

	private static void setTokenCl(int i) {
		MineralPhase.tokenCl = i;		
	}

	public static void setPosizioneF(int posizioneF) {
		MineralPhase.posizioneF = posizioneF;		
	}
	public static void activateF(int j) {
		setF_present(true);
		setTokenF(j-2);
		setPosizioneF(j);

	}
	public void addF(){
		F = new F();
		F.setPosizioneF(MineralPhase.posizioneF);
		F.setPosizione(MineralPhase.posizioneF);
		addOssido_lista_Ossidi(F);		
}

	public static void setPosizioneMn2O3(int posizioneMn2O3) {
		MineralPhase.posizioneMn2O3 = posizioneMn2O3;		
	}
	public static void activateMn2O3(int j) {
		setMn2O3_present(true);
		setTokenMn2O3(j-2);
		setPosizioneMn2O3(j);

	}
	public void addMn2O3(){
		Mn2O3 = new Mn2O3();
		Mn2O3.setPosizioneMn2O3(MineralPhase.posizioneMn2O3);
		Mn2O3.setPosizione(MineralPhase.posizioneMn2O3);
		addOssido_lista_Ossidi(Mn2O3);		
}

	public static void setPosizioneLi2O(int posizioneLi2O) {
		MineralPhase.posizioneLi2O = posizioneLi2O;		
	}
	public static void activateLi2O(int j) {
		setLi2O_present(true);
		setTokenLi2O(j-2);
		setPosizioneLi2O(j);

	}
	public void addLi2O(){
		Li2O = new Li2O();
		Li2O.setPosizioneLi2O(MineralPhase.posizioneLi2O);
		Li2O.setPosizione(MineralPhase.posizioneLi2O);
		addOssido_lista_Ossidi(Li2O);		
}
	/**
	 * @return the tokenLi2O
	 */
	public static int getTokenLi2O() {
		return tokenLi2O;
	}

	/**
	 * @param tokenLi2O the tokenLi2O to set
	 */
	public static void setTokenLi2O(int tokenLi2O) {
		MineralPhase.tokenLi2O = tokenLi2O;
	}

	/**
	 * @return the tokenMn2O3
	 */
	public static int getTokenMn2O3() {
		return tokenMn2O3;
	}

	/**
	 * @param tokenMn2O3 the tokenMn2O3 to set
	 */
	public static void setTokenMn2O3(int tokenMn2O3) {
		MineralPhase.tokenMn2O3 = tokenMn2O3;
	}

	/**
	 * @return the tokenF
	 */
	public static int getTokenF() {
		return tokenF;
	}

	/**
	 * @param tokenF the tokenF to set
	 */
	public static void setTokenF(int tokenF) {
		MineralPhase.tokenF = tokenF;
	}

	public static boolean isXLSexport() {
		return XLSexport;
	}

	public static void setXLSexport(boolean xLSexport) {
		XLSexport = xLSexport;
	}

	public static boolean isAMPHexport() {
		return AMPHexport;
	}

	public static void setAMPHexport(boolean aMPHexport) {
		AMPHexport = aMPHexport;
	}

	public static boolean isAXexport() {
		return AXexport;
	}

	public static void setAXexport(boolean aXexport) {
		AXexport = aXexport;
	}

	public static boolean isKANEKOexport() {
		return KANEKOexport;
	}

	public static void setKANEKOexport(boolean kANEKOexport) {
		KANEKOexport = kANEKOexport;
	}

	/**
	 * @return the tokenSample
	 */
	public static int getTokenSample() {
		return tokenSample;
	}

	/**
	 * @param tokenSample the tokenSample to set
	 */
	public static void setTokenSample(int tokenSample) {
		MineralPhase.tokenSample = tokenSample;
	}

	/**
	 * @return the tokenZrO2
	 */
	public static int getTokenZrO2() {
		return tokenZrO2;
	}

	/**
	 * @return the tokenCoO
	 */
	public static int getTokenCoO() {
		return tokenCoO;
	}

	/**
	 * @return the tokenH2O
	 */
	public static int getTokenH2O() {
		return tokenH2O;
	}

	/**
	 * @return the tokenCl
	 */
	public static int getTokenCl() {
		return tokenCl;
	}

	/**
	 * @return the tokenV2O3
	 */

	public static int getTokenV2O3() {
		return tokenV2O3;
	}

	public static void setTokenCO2(int tokenCO2) {
		MineralPhase.tokenCO2 = tokenCO2;
	}

	public static int getTokenCO2() {
		return tokenCO2;
	}








		
	}


	// END of MINERALPHASE
//}
