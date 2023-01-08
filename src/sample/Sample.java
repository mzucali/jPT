package sample;


import java.io.Serializable;
import java.util.ArrayList;

import main.gui.jMineralCalc;
import minerals.MineralPhase;

import datafiles.AnalysisDataFile;

public class Sample implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sample_id;
	private String sample_name;
	// private Date sample_date;
	private String sample_typeOfAnalysis;
	private static int num_analysis_data_file = 0;
	private ArrayList<AnalysisDataFile> analysis_data_sets;
	
	public static ArrayList<MineralPhase> elencoMineralPhaseSample;
	private String foo;

	public Sample() {

		//System.out.println("from sample.java");
		System.out.println("creating a new sample.....");
		setSample_name("Sample_X");
		//System.out.println("automatic adding a DataFile.....");

		// num_analysis_data_file=0;

		analysis_data_sets = new ArrayList<AnalysisDataFile>();
		addAnalysisDataFile();
	
		printSampleName();

	}

	
	// UESTO è quello che viene utiizzato da jMineralCalc.java
	public Sample(String aSampleName, String aAnalysisDataFileName)
			throws Exception {

	//	System.out.println("FROM sample.java, creating a new sample.....and automatic adding a DataFile.....");

		setSample_name(aSampleName);
		// qui gli farie leggere gli headers da AnalysisDataFile
		// prima di fargli calcolare tutto
		analysis_data_sets = new ArrayList<AnalysisDataFile>();
		addAnalysisDataFile(aAnalysisDataFileName);
		elencoMineralPhaseSample = new ArrayList<MineralPhase>();
		

		
		printSampleName();



	}

	public void addAnalysisDataFile() {
		jMineralCalc.getConsole().println("adding a new DataFile.....");
		num_analysis_data_file++;
		analysis_data_sets.add(new AnalysisDataFile());
		// data[num_analysis_data_file] = new AnalysisDataFile();

		jMineralCalc.getConsole().println("added a new DataFile.....");
	}

	// UESTO è quello che viene utiizzato da Sample dopo jMineralCalc.java
	
	public void addAnalysisDataFile(String aAnalysisDataFileName)
			throws Exception {
		
//		System.out.println("adding the DataFile....." + aAnalysisDataFileName
//				+ " to sample: " + getSample_name());

		AnalysisDataFile adf = new AnalysisDataFile(aAnalysisDataFileName);

		// legge i dati da aAnalysisDataFileName
		// adf.mintabAnalysisDataFile_readAll(aAnalysisDataFileName);

		num_analysis_data_file++;
		analysis_data_sets.add(adf);

		jMineralCalc.getConsole().println("done.....addAnalysisDataFile(String aAnalysisDataFileName) in sample.java");

	}

	public void printSampleName() {
		System.out.println("SAMPLE name: " + sample_name);

	}

	public void setFoo(String s) {
		foo = s;
	}

	public String getFoo() {
		return foo;
	}

	public static int getNum_analysis_data_file() {
		return num_analysis_data_file;
	}

	public static void setNum_analysis_data_file(int numAnalysisDataFile) {
		num_analysis_data_file = numAnalysisDataFile;
	}

	public String getSample_name() {
		return sample_name;
	}

	public void setSample_name(String sampleName) {
		sample_name = sampleName;
	}

	public ArrayList<AnalysisDataFile> getAnalysis_data_sets() {
		return analysis_data_sets;
	}

	public void setAnalysis_data_sets(
			ArrayList<AnalysisDataFile> analysisDataSets) {
		analysis_data_sets = analysisDataSets;
	}

}
