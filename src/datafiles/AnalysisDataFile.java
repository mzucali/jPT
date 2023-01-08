package datafiles;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package parsers;

//import MineralPhase;
//import Main_test;


import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
//org.apache.commons.lang3.StringUtils.containsIgnoreCase("AbBaCca", "bac");

import minerals.*;
import tools.*;
import cations.Cations;

import oxydes.*;
import main.*;
import main.gui.Console;
//import main.gui.MainJPT;
import main.gui.jMineralCalc;

/**
 * 
 * @author miki Luglio Agosto 2009 AnalysisDataFile dovrebbe essere il
 *         recipiente di un file di input costitutito da un certo numero di
 *         analisi Tutte le analisi sono caratterizzate da elementi comuni che
 *         dovrebbero, a logica, essere registrati qui
 * 
 *         esempio
 * 
 *         InputFileName NumOfAnalysis Headers Posizione degli headers (sample,
 *         Mineral, SiO2, etc....): cioe' la posizione nell'array Gli specifici
 *         valori sono invece attribuiti alle singole analisi Il FileParser (es.
 *         MinTabFileParser) legge queste informazioni dall'InputFile e le
 *         distribuisce a AnalysisDataFile o Alle Analisi (MineralPhase) a
 *         seconda del dato
 */
@SuppressWarnings("unused")
public class AnalysisDataFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private static int tokenSample;
	private static int tokenMineral;
	private static int numOfAnalysis;

	// private String DataFileName;
	public ArrayList<MineralPhase> mfsArrayList;//= new ArrayList<MineralPhase>();
	//mfsArrayList 
	//ArrayList<MineralPhase> arraylist_mf = new ArrayList<MineralPhase>();;
	private ArrayList<String> lineeAnalisi_List = new ArrayList<String>();
	private BufferedReader in;
	private static File inputFile;
	private int numOfLines;

	private String headers_String;


	private ArrayList<Cations> lista_Cations = new ArrayList<Cations>();
	private ArrayList<Oxydes> lista_Ossidi;// = new ArrayList<Oxydes>();
	


	// /constructors

	public AnalysisDataFile() {

	//	System.out.println("new AnalysisDataFile().....");

	}

	public AnalysisDataFile(String aFileString) throws NullPointerException,
			Exception {
		in = new BufferedReader(new FileReader(aFileString));
		System.out.println("\nNow adding a new AnalysisDataFile named: " + aFileString);
		mintabAnalysisDataFile_readAll(aFileString, mfsArrayList = new ArrayList<MineralPhase>());

//		for (MineralPhase mfs: mfsArrayList){
//		System.out.println("SAMPLE: "+mfs.getSampleS()+ " MINERAL: "+mfs.getMineralCodeString()+" SIZE ListaOssidi: "+mfs.getListaOssidi().size()
//				+" SIO2: "+mfs.getSiO2().getOxyVal()+"\n");
//		}
	
		/*
		 * test per tools.jpt2xls_formula.java
		 * serve x preparare i file di input per il ricalcolo delle formule proporzionali
		 * con i fogli di calcolo di excel
		*/
//		for (MineralPhase mfs: mfsArrayList){
//			jpt2xls_formula xls = new jpt2xls_formula(mfs);
//			//tools.jpt2xls_formula(mfs);
//		}
	}

	// * constructors FINE *//

	/*
	 * ArrayList di Ossidi e Cationi che viene passato alla MineralPhase assieme
	 * alla stringa dei dati TOKENATA
	 */

private void mintabAnalysisDataFile_readAll_bis(String aFileString) throws NullPointerException, Exception {

	// definizione INPUT FILE
	mfsArrayList = new ArrayList<MineralPhase>();
	AnalysisDataFile.inputFile = new File(aFileString);// FileReader(aFileString);
	in = new BufferedReader(new FileReader(aFileString));
	numOfLines = countLines(inputFile);
	setInputFile(inputFile);
	headers_String = in.readLine();
	//System.out.println("headers: " + "\n" + headers_String);
	jMineralCalc.getConsole().println("ciao");
	jMineralCalc.getConsole().println("headers: " + "\n" + headers_String);
//	Main_test.getConsole().println("headers: " + "\n" + headers_String);
	check_set_OxidePosition(headers_String); // questo seleziona tutte le
												// posizioni degli headers
												// (tokens)
	// definendo delle variabili statiche sia in AnalysisDataFile che in
	// MineralPhase
	String lineS;

	// legge TUTTE le linee dal file e le aggiunge all'ArraList che poi
	// viene passato
	while ((lineS = in.readLine()) != null) {
		jMineralCalc.getConsole().println(lineS);
		lineeAnalisi_List.add(lineS);
	}

	in.close();
	
	for (int i = 0; i < lineeAnalisi_List.size(); i++) {

		String singola_linea = lineeAnalisi_List.get(i);
		String[] array_singola_linea = singola_linea.split("\t");


		isParsableToDouble(array_singola_linea[1], array_singola_linea);


	}
	System.out.println("added mineral phases to sample");

	System.out.println("\t mineral phase calculation done! \n");

	System.out
			.println("AnalysisDataFile.mintabAnalysisDataFile_readAll() FINISHED");
//	jMineralCalc.getConsole().println("FINE...");

}

public void setOssido_listaOssido(int index, Oxydes aOxydes){
	
	lista_Ossidi.set(index, aOxydes);
	
}

	public void addOssido_lista_Ossidi(int index, Oxydes aOxydes) {
		lista_Ossidi.add(index, aOxydes);
		//lista_Ossidi.add
		// System.out.println("lista ossidi: "+lista_Ossidi);
	}
	public void addOssido_lista_Ossidi( Oxydes aOxydes) {
		lista_Ossidi.add(aOxydes);
		// System.out.println("lista ossidi: "+lista_Ossidi);
	}
	public void addCation_lista_Cationi(Cations aCations) {
		lista_Cations.add(aCations);
		// System.out.println("lista cationi: "+lista_Cations);
	}

	public void mintabAnalysisDataFile_readAll(String aFileString, ArrayList<MineralPhase> mfsAL)
			throws NullPointerException, Exception {

		// definizione INPUT FILE
		mfsArrayList = mfsAL;
		AnalysisDataFile.inputFile = new File(aFileString);// FileReader(aFileString);
		in = new BufferedReader(new FileReader(aFileString));
		numOfLines = countLines(inputFile);
		setInputFile(inputFile);
		headers_String = in.readLine();
		System.out.println("headers: " + "\n" + headers_String);
	//	MainJPT.getConsole().println("welcome to jPT console");
		jMineralCalc.getConsole().println("welcome to jPT console");
//		jMineralCalc.getConsole().println("headers: " + "\n" + headers_String);
//		Main_test.getConsole().println("headers: " + "\n" + headers_String);
		check_set_OxidePosition(headers_String); // questo seleziona tutte le
													// posizioni degli headers
													// (tokens)
		// definendo delle variabili statiche sia in AnalysisDataFile che in
		// MineralPhase
		String lineS;

		// legge TUTTE le linee dal file e le aggiunge all'ArraList che poi
		// viene passato
		while ((lineS = in.readLine()) != null) {
			jMineralCalc.getConsole().println(lineS);
			lineeAnalisi_List.add(lineS);
		}

		in.close();
		
		for (int i = 0; i < lineeAnalisi_List.size(); i++) {

			String singola_linea = lineeAnalisi_List.get(i);
			String[] array_singola_linea = singola_linea.split("\t");
		//	mfsArrayList = new ArrayList<MineralPhase>();
		//	System.out.println("\n adding mineral phases..........");
			// il successivo controlla il TIPO di MineralPhase leggendo la
			// posizione Mineral [1]
			// puo' anche trovare in valore numerico in quella posizione e di
			// conseguenza aggiunge una
			// MineralPhase generica con gli ossigeni = al valore numerico
			// trovato
			// comprende checkTypeMineralPhase
			// in checkTypeMineralPhase vengono aggiunte le varie fasi
			// mineralogiche all'ArrayList
			// mfsArrayList che passa MineralPhase
			// mfsArrayList.add(new Amphibole(array_singola_lineaA,
			// lista_Ossidi,lista_Cations));
			// lista_Cations � PER ORA INUTILE

			isParsableToDouble(array_singola_linea[1], array_singola_linea);
			// checkTypeOfMineralPhase(array_singola_linea[1],
			// array_singola_linea);

		}
		System.out.println("added mineral phases to sample");

		System.out.println("\t mineral phase calculation done! \n");

		System.out
				.println("AnalysisDataFile.mintabAnalysisDataFile_readAll() FINISHED");
		

	}

	/**
	 * @param aString
	 * @param array_singola_lineaA
	 * @throws Exception
	 */
	public void checkTypeOfMineralPhase(String aString,
			String[] array_singola_lineaA) throws Exception {
		
		if (aString.equalsIgnoreCase("Gt") || aString.equalsIgnoreCase("grt")
				|| aString.equalsIgnoreCase("g")
				|| aString.equalsIgnoreCase("gr")
				|| aString.equalsIgnoreCase("ga")
		//		|| StringUtils.containsIgnoreCase("a","ba")
				|| StringUtils.containsIgnoreCase(aString, "grt")){
			
			//org.apache.commons.lang3.StringUtils.containsIgnoreCase("AbBaCca", "bac");
			
		//	System.out.println("GREAT there is a garnet!");
			mfsArrayList.add(new Garnet(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			
			// mfsArrayList.add(new Garnet());

		} else if (aString.equalsIgnoreCase("am")
				|| aString.equalsIgnoreCase("amp")
				|| aString.equalsIgnoreCase("amph")
				|| StringUtils.containsIgnoreCase(aString, "am")) {

			mfsArrayList.add(new Amphibole(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			System.out.println("it's an amphibole phase!");

			//       
			//
		} else if (aString.equalsIgnoreCase("qtz")
				|| aString.equalsIgnoreCase("q")
				|| aString.equalsIgnoreCase("qz")
				|| StringUtils.containsIgnoreCase(aString, "q")) {
			// setMineralNameString("quartz");
			// setMineralOssigeniI(2);
			// setIdeal_cation_sum(1);
			mfsArrayList.add(new Qtz(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			System.out.println("it' a quartz phase");

			//
		} else if (aString.equalsIgnoreCase("PX")
				|| aString.equalsIgnoreCase("cpx")
				|| aString.equalsIgnoreCase("jd")
				|| aString.equalsIgnoreCase("omp")
				|| aString.equalsIgnoreCase("om")
				|| aString.equalsIgnoreCase("o")
				|| aString.equalsIgnoreCase("aeg")
				|| aString.equalsIgnoreCase("agt")
				|| aString.equalsIgnoreCase("augite")
				|| aString.equalsIgnoreCase("acm")
				|| aString.equalsIgnoreCase("acmite")
				|| StringUtils.containsIgnoreCase(aString, "px")
				|| StringUtils.containsIgnoreCase(aString, "om")
				|| StringUtils.containsIgnoreCase(aString, "jd")
				) {
			//       
			// setMineralNameString("pyroxene");
			// setMineralOssigeniI(6);//mineralOxy = 23;
			// setIdeal_cation_sum(4);
			
			Pyroxene px = new Pyroxene(array_singola_lineaA, lista_Ossidi,lista_Cations);
			mfsArrayList.add(px);
			
	//		mfsArrayList.add(new Pyroxene(array_singola_lineaA, lista_Ossidi,lista_Cations));
			System.out.println("it's a pyroxene phase");
			//                
		} else if (aString.equalsIgnoreCase("opx")) {
			//
			//
			// setMineralNameString("ortopyroxene");
			// setMineralOssigeniI(6);//mineralOxy = 23;
			// setIdeal_cation_sum(4);

			mfsArrayList.add(new Orthopyroxene(array_singola_lineaA,
					lista_Ossidi, lista_Cations));
			System.out.println("it's a orthopyroxene phase");

		} else if (aString.equalsIgnoreCase("AS")
				|| aString.equalsIgnoreCase("als")
				|| aString.equalsIgnoreCase("ky")
				|| aString.equalsIgnoreCase("and")
				|| aString.equalsIgnoreCase("sill")
				|| aString.equalsIgnoreCase("sil")
				|| StringUtils.containsIgnoreCase(aString, "sil")
				|| StringUtils.containsIgnoreCase(aString, "ky")
				|| StringUtils.containsIgnoreCase(aString, "and")
				) {
			//
			//
			// setMineralNameString("Al_Silicate");
			// setMineralOssigeniI(20);
			// setIdeal_cation_sum(12);
			System.out.println("it's a Al2SiO5 phase");
			mfsArrayList.add(new KyAndSil(array_singola_lineaA, lista_Ossidi,
					lista_Cations));

		} else if (aString.equalsIgnoreCase("BI")
				|| aString.equalsIgnoreCase("Bt")
				|| aString.equalsIgnoreCase("Bio")
				|| StringUtils.containsIgnoreCase(aString, "bt")
				|| StringUtils.containsIgnoreCase(aString, "bi")
				) {

			mfsArrayList.add(new Biotite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			
			
			
		}else if (aString.equalsIgnoreCase("wm")
				|| aString.equalsIgnoreCase("mb")
				|| aString.equalsIgnoreCase("mica")
				|| aString.equalsIgnoreCase("phe")
				|| aString.equalsIgnoreCase("phn")
				|| aString.equalsIgnoreCase("pg")
				|| aString.equalsIgnoreCase("pa")
				|| aString.equalsIgnoreCase("whitemica")
				|| StringUtils.containsIgnoreCase(aString, "wm")
				) {


			mfsArrayList.add(new Mica(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		}

		else if (aString.equalsIgnoreCase("ep")
				|| aString.equalsIgnoreCase("epidote")
				|| aString.equalsIgnoreCase("zo")
				|| aString.equalsIgnoreCase("czo")
				|| aString.equalsIgnoreCase("fe-ep")
				|| StringUtils.containsIgnoreCase(aString, "ep")
				) {

			mfsArrayList.add(new Epidote(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("mnz")
				|| aString.equalsIgnoreCase("mz")) {

			mfsArrayList.add(new Monazite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("cc")
				|| aString.equalsIgnoreCase("cal")
				|| aString.equalsIgnoreCase("cb")
				|| aString.equalsIgnoreCase("carbonate")
				|| aString.equalsIgnoreCase("calcite")) {

			mfsArrayList.add(new Carbonate(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("ch")
				|| aString.equalsIgnoreCase("chl")) {

			mfsArrayList.add(new Chlorite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("cd")
				|| aString.equalsIgnoreCase("crd")) {

			mfsArrayList.add(new Cordierite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("ct")
				|| aString.equalsIgnoreCase("ctd")
				|| aString.equalsIgnoreCase("ci")
				|| aString.equalsIgnoreCase("cld")) {

			mfsArrayList.add(new Cloritoide(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("ttn")
				|| aString.equalsIgnoreCase("tit")
				//|| aString.equalsIgnoreCase("se")
				) {

			mfsArrayList.add(new Titanite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("fd")
				|| aString.equalsIgnoreCase("fds")
				|| aString.equalsIgnoreCase("fp")
				|| aString.equalsIgnoreCase("fs")
				|| aString.equalsIgnoreCase("kfs")
				|| aString.equalsIgnoreCase("feldspar")) {

			mfsArrayList.add(new Feldspar(array_singola_lineaA, lista_Ossidi,
					lista_Cations));

		} else if (aString.equalsIgnoreCase("pl")
				|| aString.equalsIgnoreCase("an")
				|| aString.equalsIgnoreCase("ab")
				|| aString.equalsIgnoreCase("albite")
				|| aString.equalsIgnoreCase("anortite")
				|| aString.equalsIgnoreCase("anorthite")
			|| aString.equalsIgnoreCase("plagiocalse")){

			mfsArrayList.add(new Plagioclase(array_singola_lineaA,
					lista_Ossidi, lista_Cations));
		} else if (aString.equalsIgnoreCase("ol")) {

			mfsArrayList.add(new Olivine(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("ru")
				|| aString.equalsIgnoreCase("rt")) {

			mfsArrayList.add(new Rutile(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("ilmenite")
				|| aString.equalsIgnoreCase("ilm")
				|| aString.equalsIgnoreCase("il")) {

			mfsArrayList.add(new Ilmenite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("zr")
				|| aString.equalsIgnoreCase("zi")
				|| aString.equalsIgnoreCase("zc")
				|| aString.equalsIgnoreCase("zrc")
				|| aString.equalsIgnoreCase("zircon")) {

			mfsArrayList.add(new Zircone(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("sp")
				|| aString.equalsIgnoreCase("spn")
				|| aString.equalsIgnoreCase("spinel")) {

			mfsArrayList.add(new Spinel(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		} else if (aString.equalsIgnoreCase("ta")
				|| aString.equalsIgnoreCase("talc")
				|| aString.equalsIgnoreCase("tc")
				|| aString.equalsIgnoreCase("tlc")) {

			mfsArrayList.add(new Talc(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		}else if (aString.equalsIgnoreCase("lw")
				|| aString.equalsIgnoreCase("lws")
				|| aString.equalsIgnoreCase("law")) {

			mfsArrayList.add(new Lawsonite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		}else if (aString.equalsIgnoreCase("turm")
				|| aString.equalsIgnoreCase("tu")
				|| aString.equalsIgnoreCase("turmaline")) {

			mfsArrayList.add(new Turmaline(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		}else if (aString.equalsIgnoreCase("chum")
				|| aString.equalsIgnoreCase("clinohum")) {

			mfsArrayList.add(new Clinohumite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		}else if (aString.equalsIgnoreCase("vsv")
				|| aString.equalsIgnoreCase("vesuvianite")) {

			mfsArrayList.add(new Vesuvianite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			
		} else if (aString.equalsIgnoreCase("pump")
				|| aString.equalsIgnoreCase("pumpellite")
				|| aString.equalsIgnoreCase("pumpellyite")) {

			mfsArrayList.add(new Pumpellyite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			System.out.println("it' a pumpellyite phase");

			//
		
		}else if (aString.equalsIgnoreCase("serp")
				|| aString.equalsIgnoreCase("serpentine")
				|| aString.equalsIgnoreCase("serpentino")
				|| aString.equalsIgnoreCase("srp")
				|| aString.equalsIgnoreCase("se")) {

			mfsArrayList.add(new Serpentine(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			System.out.println("it' a serpentine phase");

			//
		
		}else if (aString.equalsIgnoreCase("sapph")
				|| aString.equalsIgnoreCase("sa")
				|| aString.equalsIgnoreCase("sapphirine")) {

			mfsArrayList.add(new Sapphirine(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			System.out.println("it' a sapphirine phase");

			//
		
		}else if (aString.equalsIgnoreCase("zircon")
				|| aString.equalsIgnoreCase("Zc")
				|| aString.equalsIgnoreCase("Zrc")
				|| aString.equalsIgnoreCase("Zr")) {

			mfsArrayList.add(new Serpentine(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			System.out.println("it' a serpentine phase");

			//
		
		}else if (aString.equalsIgnoreCase("st")
				|| aString.equalsIgnoreCase("staurolite")
				|| aString.equalsIgnoreCase("stauro")) {

			mfsArrayList.add(new Staurolite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			System.out.println("it' a staurolite phase");

			//
		
		}else if (aString.equalsIgnoreCase("ne")
				|| aString.equalsIgnoreCase("nepheline")) {

			mfsArrayList.add(new Nepheline(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			System.out.println("it' a nepheline phase");

			//
		
		}else if (aString.equalsIgnoreCase("lc")
				|| aString.equalsIgnoreCase("leucite")
				|| aString.equalsIgnoreCase("le")) {

			mfsArrayList.add(new Leucite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			System.out.println("it' a leucite phase");

			//
		
		}else if (aString.equalsIgnoreCase("ac")
				|| aString.equalsIgnoreCase("analcime")) {

			mfsArrayList.add(new Analcime(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			System.out.println("it' a analcime phase");

			//
		
		}else if (aString.equalsIgnoreCase("me")
				|| aString.equalsIgnoreCase("melilite")) {

			mfsArrayList.add(new Melilite(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
			System.out.println("it' a melilite phase");

			//
		
		}else if (aString.equalsIgnoreCase("xx")
				|| aString.equalsIgnoreCase("unknown")) {

			mfsArrayList.add(new Unknown(array_singola_lineaA, lista_Ossidi,
					lista_Cations));
		}



		else {
    	 
			jMineralCalc.getConsole().println(aString + " = unknown phase.....please control");
		//	System.out.println(aString + " = unknown phase.....please control");

			AnalysisDataFile.printError(aString+" = unknown phase.....please control");
   
		}
		
	}

	private void setMfsArrayList(ArrayList<MineralPhase> mfsArrayList2) {
		mfsArrayList = new ArrayList<MineralPhase>();
mfsArrayList = mfsArrayList2;
//System.out.println("\n\nEND OF ANALYSIS DATA FILE // setMFSArrayList\n");
for (MineralPhase mfs:this.mfsArrayList){
	//double siow =mfs.getListaOssidi().get(tokenSiO2);
	

}

	}

	private void check_set_OxidePosition(String s) throws Exception {

		/* legge la prima linea di HEADERS */

		String s1 = s;

		String[] array1 = s1.split("\\t");
//		String[] array1 = new String[array2.length-2];
		
		
//		for(int j=0; j<array2.length; j++ ){
//			
//			array1[j]=array2[j+2];
//		}
		
		//= Arrays.copyOfRange(arg0, arg1, arg2, arg3);
		lista_Ossidi=new ArrayList<Oxydes>();
		lista_Cations=new ArrayList<Cations>();
		try {
			/*
			 * //System.out.println("posizione ossidi in oxides[]: [0] SiO2; [1]
			 * TiO2, [2] Al2O3, [3] Cr2O3, [4] FeO, [5] Fe2O3, [6] MnO, [7] MgO,
			 * [8] ZnO, [9] CaO, [10] Na2O, [11] K2O, [12] P2O5, [13] B2O3, [14]
			 * SrO, [15] La2O3, [16] Ce2O3 [17] Nd2O3, [18] SO3
			 */

			for (int j = 0; j < array1.length; j++) {
				if (array1[j].equalsIgnoreCase("SiO2")) {

					//MineralPhase.setSiO2_present(true);
					
					MineralPhase.activateSiO2(j);
			//		   activateSiO2(j)
					
	//				System.out.println("posizione SiO2, j in check_set_OxidePosition: "+j);
					
	//				setTokenSiO2(j - 2);

	//				MineralPhase.activateSiO2(j);
	//				SiO2 = new SiO2();
	//				SiO2.setPosizioneSiO2(j);
	//				SiO2.setPosizione(j);

	//				addOssido_lista_Ossidi(SiO2);
	//				addCation_lista_Cationi(Si);

				} else if (array1[j].equalsIgnoreCase("TiO2")) {
					MineralPhase.activateTiO2(j);
					
					/*MineralPhase.setTiO2_present(true);
					setTokenTiO2(j - 2);

					TiO2 = new TiO2();

					TiO2.setPosizioneTiO2(j);// = j;
					TiO2.setPosizione(j);
					addOssido_lista_Ossidi(TiO2);
					addCation_lista_Cationi(Ti);
*/
				} else if (array1[j].equalsIgnoreCase("Al2O3")) {
					MineralPhase.activateAl2O3(j);
/*					MineralPhase.setAl2O3_present(true);
					setTokenAl2O3(j-2);
					Al2O3 = new Al2O3();
					Al2O3.setPosizioneAl2O3(j);
					Al2O3.setPosizione(j);
					addOssido_lista_Ossidi(Al2O3);
					addCation_lista_Cationi(Al);*/

				} else if (array1[j].equalsIgnoreCase("Cr2O3")) {
					MineralPhase.activateCr2O3(j);
/*					MineralPhase.setCr2O3_present(true);
					setTokenCr2O3(j-2);
					Cr2O3 = new Cr2O3();
					Cr2O3.setPosizioneCr2O3(j);
					Cr2O3.setPosizione(j);
					addOssido_lista_Ossidi(Cr2O3);
					addCation_lista_Cationi(Cr);*/

				} else if (array1[j].equalsIgnoreCase("FeO")) {
					MineralPhase.activateFeO(j);

					/*MineralPhase.setFeO_present(true);
					setTokenFeO(j-2);
					FeO = new FeO();
					FeO.setPosizioneFeO(j);
					FeO.setPosizione(j);
					addOssido_lista_Ossidi(FeO);
					//setOssido_listaOssido(tokenFeO, FeO);
					addCation_lista_Cationi(Fe);*/

				} else if (array1[j].equalsIgnoreCase("Fe2O3")) {
					MineralPhase.activateFe2O3(j);
					
					/*MineralPhase.setFe2O3_present(true);
					setTokenFe2O3(j - 2);
					Fe2O3 = new Fe2O3();
					Fe2O3.setPosizioneFe2O3(j);
					Fe2O3.setPosizione(j);
					addOssido_lista_Ossidi(Fe2O3);
					addCation_lista_Cationi(Fe3);
*/
				} else if (array1[j].equalsIgnoreCase("MnO")) {
					MineralPhase.activateMnO(j);
					/*MineralPhase.setMnO_present(true);
					setTokenMnO(j - 2);
					MnO = new MnO();
					MnO.setPosizioneMnO(j);
					MnO.setPosizione(j);
					addOssido_lista_Ossidi(MnO);
					addCation_lista_Cationi(Mn);*/

				} else if (array1[j].equalsIgnoreCase("MgO")) {
					MineralPhase.activateMgO(j);
					/*MineralPhase.setMgO_present(true);
					setTokenMgO(j - 2);
					MgO = new MgO();
					MgO.setPosizioneMgO(j);
					MgO.setPosizione(j);
					addOssido_lista_Ossidi(MgO);
					addCation_lista_Cationi(Mg);*/

				} else if (array1[j].equalsIgnoreCase("ZnO")) {
					MineralPhase.activateZnO(j);
/*					MineralPhase.setZnO_present(true);
					setTokenZnO(j - 2);
					ZnO = new ZnO();
					ZnO.setPosizioneZnO(j);
					ZnO.setPosizione(j);
					addOssido_lista_Ossidi(ZnO);
					addCation_lista_Cationi(Zn);
*/
				} else if (array1[j].equalsIgnoreCase("CaO")) {
					MineralPhase.activateCaO(j);
/*					MineralPhase.setCaO_present(true);
					setTokenCaO(j - 2);
					CaO = new CaO();
					CaO.setPosizioneCaO(j);
					CaO.setPosizione(j);
					addOssido_lista_Ossidi(CaO);
					addCation_lista_Cationi(Ca);
*/
				} else if (array1[j].equalsIgnoreCase("Na2O")) {
					MineralPhase.activateNa2O(j);
					/*
					MineralPhase.setNa2O_present(true);
					setTokenNa2O(j - 2);
					Na2O = new Na2O();
					Na2O.setPosizioneNa2O(j);
					Na2O.setPosizione(j);
					addOssido_lista_Ossidi(Na2O);
					addCation_lista_Cationi(Na);*/
				}
				//                    
				else if (array1[j].equalsIgnoreCase("K2O")) {
					MineralPhase.activateK2O(j);
					/*
					MineralPhase.setK2O_present(true);
					setTokenK2O(j - 2);
					K2O = new K2O();
					K2O.setPosizioneK2O(j);
					K2O.setPosizione(j);
					addOssido_lista_Ossidi(K2O);
					addCation_lista_Cationi(K);
*/
				} else if (array1[j].equalsIgnoreCase("P2O5")) {
					MineralPhase.activateP2O5(j);
					
					/*MineralPhase.setP2O5_present(true);
					setTokenP2O5(j - 2);
					P2O5 = new P2O5();
					P2O5.setPosizioneP2O5(j);
					P2O5.setPosizione(j);
					addOssido_lista_Ossidi(P2O5);
					addCation_lista_Cationi(P);
*/
				} else if (array1[j].equalsIgnoreCase("B2O3")) {
					MineralPhase.activateB2O3(j);
/*					MineralPhase.setB2O3_present(true);
					setTokenB2O3(j - 2);
					B2O3 = new B2O3();
					B2O3.setPosizioneB2O3(j);
					B2O3.setPosizione(j);
					addOssido_lista_Ossidi(B2O3);
					addCation_lista_Cationi(B);
*/
				} else if (array1[j].equalsIgnoreCase("SrO")) {
					MineralPhase.activateSrO(j);
					
					/*MineralPhase.setSrO_present(true);
					setTokenSrO(j - 2);
					SrO = new SrO();
					SrO.setPosizioneSrO(j);
					SrO.setPosizione(j);
					addOssido_lista_Ossidi(SrO);
					addCation_lista_Cationi(Sr);
*/
				} else if (array1[j].equalsIgnoreCase("La2O3")) {
					MineralPhase.activateLa2O3(j);
/*					MineralPhase.setLa2O3_present(true);
					setTokenLa2O3(j - 2);
					La2O3 = new La2O3();
					La2O3.setPosizioneLa2O3(j);
					La2O3.setPosizione(j);
					addOssido_lista_Ossidi(La2O3);
					addCation_lista_Cationi(La);
*/
				} else if (array1[j].equalsIgnoreCase("PbO")) {
					MineralPhase.activatePbO(j);

				} else if (array1[j].equalsIgnoreCase("ThO2")) {
					MineralPhase.activateThO2(j);

				} else if (array1[j].equalsIgnoreCase("UO2")) {
					MineralPhase.activateUO2(j);

				

				} else if (array1[j].equalsIgnoreCase("Pr2O3")) {
					MineralPhase.activatePr2O3(j);
/*					MineralPhase.setPr2O3_present(true);
					setTokenPr2O3(j - 2);
					Pr2O3 = new Pr2O3();
					Pr2O3.setPosizionePr2O3(j);
					Pr2O3.setPosizione(j);
					addOssido_lista_Ossidi(Pr2O3);
					// addCation_lista_Cationi(Pr);
*/
				} else if (array1[j].equalsIgnoreCase("Y2O3")) {
					MineralPhase.activateY2O3(j);
					/*MineralPhase.setY2O3_present(true);
					setTokenY2O3(j - 2);
					Y2O3 = new Y2O3();
					Y2O3.setPosizioneY2O3(j);
					Y2O3.setPosizione(j);
					addOssido_lista_Ossidi(Y2O3);
*/					// addCation_lista_Cationi(Y);

				} else if (array1[j].equalsIgnoreCase("Nd2O3")) {
					MineralPhase.activateNd2O3(j);
					/*			MineralPhase.setNd2O3_present(true);
					setTokenNd2O3(j - 2);
					Nd2O3 = new Nd2O3();
					Nd2O3.setPosizioneNd2O3(j);
					Nd2O3.setPosizione(j);
					addOssido_lista_Ossidi(Nd2O3);*/
					// addCation_lista_Cationi(Nd);

				} else if (array1[j].equalsIgnoreCase("Sm2O3")) {
					MineralPhase.activateSm2O3(j);
					/*MineralPhase.setSm2O3_present(true);
					setTokenSm2O3(j - 2);
					Sm2O3 = new Sm2O3();
					Sm2O3.setPosizioneSm2O3(j);
					Sm2O3.setPosizione(j);
					addOssido_lista_Ossidi(Sm2O3);
					*/// addCation_lista_Cationi(Sm);

				} else if (array1[j].equalsIgnoreCase("Ce2O3")) {
					MineralPhase.activateCe2O3(j);


				} else if (array1[j].equalsIgnoreCase("Gd2O3")) {
					MineralPhase.activateGd2O3(j);


				}else if (array1[j].equalsIgnoreCase("SO3")) {
					MineralPhase.activateSO3(j);


				}else if (array1[j].equalsIgnoreCase("NiO")) {
					MineralPhase.activateNiO(j);


				}else if (array1[j].equalsIgnoreCase("BaO")) {
					MineralPhase.activateBaO(j);

				}else if (array1[j].equalsIgnoreCase("SDUO2")||array1[j].equalsIgnoreCase("SDU")) {
					MineralPhase.setSDUO2_present(true);
					MineralPhase.activateSDUO2(j);
				}else if (array1[j].equalsIgnoreCase("SDThO2")||array1[j].equalsIgnoreCase("SDTh")) {
					MineralPhase.setSDThO2_present(true);
					MineralPhase.activateSDThO2(j);				
				}else if (array1[j].equalsIgnoreCase("SDPbO")||array1[j].equalsIgnoreCase("SDPb")) {
					MineralPhase.setSDPbO_present(true);
					MineralPhase.activateSDPbO(j);
				}else if (array1[j].equalsIgnoreCase("CoO")) {
				MineralPhase.activateCoO(j);
				}else if (array1[j].equalsIgnoreCase("ZrO2")) {
				MineralPhase.activateZrO2(j);
				}else if (array1[j].equalsIgnoreCase("Li2O")) {
				MineralPhase.activateLi2O(j);
				}else if (array1[j].equalsIgnoreCase("H2O")) {
				MineralPhase.activateH2O(j);
				}else if (array1[j].equalsIgnoreCase("Mn2O3")) {
				MineralPhase.activateMn2O3(j);
				}else if (array1[j].equalsIgnoreCase("Cr2O3")) {
				MineralPhase.activateCr2O3(j);
				}else if (array1[j].equalsIgnoreCase("F")) {
					//ID_COMP_I=40
					MineralPhase.activateF(j);
				}else if (array1[j].equalsIgnoreCase("Cl")) {
					//ID_COMP_I=40
					MineralPhase.activateCl(j);
				}else if (array1[j].equalsIgnoreCase("V2O3")) {
					//ID_COMP_I=41
					MineralPhase.activateV2O3(j);
				}

				else {
					java.lang.System.out
							.println(array1[j]
									+ " not found!, please check.....if sample or Mineral let it go ");
				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("OUT of BOUND ARRAY");
		}

		return;
	}


	private int countLines(File in) throws FileNotFoundException, IOException {
		// READS FROM INPUT FILE AND COUNTS NUMBER OF LINES (lineCount)
		BufferedReader inBuff = new BufferedReader(new FileReader(in));

		int lineCount = 0;
		try {
			while ((inBuff.readLine()) != null) {
				lineCount++;
			}
		} catch (EOFException e) {
			System.err.println("End of stream");
		}

		inBuff.close();
		return lineCount;
	}

	
	public ArrayList<MineralPhase> getMfsArrayList() {
		return mfsArrayList;
	}

	public static File getInputFile() {
		return inputFile;
	}

	public static void setInputFile(File inputFile) {
		AnalysisDataFile.inputFile = inputFile;
	}

	public int getNumOfAnalysis() {
		return numOfAnalysis;
	}

	public void setNumOfAnalysis(int numOfAnalysis) {
		AnalysisDataFile.numOfAnalysis = numOfAnalysis;
	}

	public void addMineralPhase2MineralPhaseArray() {
		mfsArrayList = new ArrayList<MineralPhase>();
		for (int i = 0; i < numOfAnalysis; i++) {
			MineralPhase mf = new MineralPhase();
			mfsArrayList.add(i, mf);
		}

	}

	static void setTokenSample(int j) {
		tokenSample = j;
		return;
	}

	static void setTokenMineral(int j) {
		tokenMineral = j;
		return;
	}


	public static int getTokenSample() {
		return tokenSample;
	}


	public void printResults() {
		for (MineralPhase min : mfsArrayList) {
			jMineralCalc.getConsole().println("Added Mineral Phase..." +min.getSampleS());
			
			}
	}

	public static void printError(String aString) {
		System.out.println("there is an error at: " + aString);

	}

	public boolean isParsableToDouble(String i, String[] array_linea)
			throws Exception {
		try {
			Double.parseDouble(i);

			mfsArrayList.add(new MineralPhase(array_linea, lista_Ossidi,
					lista_Cations, i));
			//Sample.
			
			return true;

		} catch (NumberFormatException nfe) {
			checkTypeOfMineralPhase(i, array_linea);

			return false;
		}
	}

	public void checkDL(){
		// todo
		
	}
	
	public void checkSD(){
		
		// todo
		
	}
	
	
	
}
