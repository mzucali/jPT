package minerals;

import java.io.PrintWriter;
import java.util.ArrayList;

import oxydes.Oxydes;
import cations.Cations;
import datafiles.AnalysisDataFile;

public class Monazite extends MineralPhase {

	public static int ideal_cation_sum = 8; // <-- DROOP
	public static Double mineralOssigeniI = 4.00; // totale ossigeni TEORICI
	// per il ricalcolo del
	// mineral
	public static String mineralNameString = "monazite";

	double Pbcalc;
	double age;

	final double agemax = 4600000000.0;
	final double step = 100000;

	final static double constantth232 = 4.9475 * Math.pow(10, -11);
	final static double constantu238 = 1.55125 * Math.pow(10, -10);
	final static double constantu235 = 9.8485 * Math.pow(10, -10);
	double thpart;
	double u238part;
	double u235part;
	// double SDPb;// =
	// listaOssidi.get(AnalysisDataFile.getTokenSDPb()).getSD();
	// double SDTh;// =
	// listaOssidi.get(AnalysisDataFile.getTokenSDTh()).getSD();
	// double SDU;// = listaOssidi.get(AnalysisDataFile.getTokenSDU()).getSD();
	// double SDPbO;

	private double age_older;
	private double age_younger;
	// private double thppm_sd;
	// private double uppm_sd;
	// private double pbppm_sd;
	private double Pbcalc_y;

	/*******************/

	public Monazite() {

	}

	public Monazite(String[] tokenizedLineStrings,
			ArrayList<Oxydes> listaOxTmp, ArrayList<Cations> listaCat)
			throws Exception {
		super(tokenizedLineStrings, listaOxTmp, listaCat);

	}

	public void checkSites() {

	}

	@Override
	protected void calcAdditionalValues() {
		super.calcAdditionalValues();
		calcAgeUThPb();

		calcAgeUThPb_younger();
		calcAgeUThPb_older();

		testing();
	}

	public void calcAgeUThPb() {
		if (isPbO_present() && isThO2_present() && isUO2_present()) {
			System.out.println("calculating ages for MONAZITE");

//			thppm = listaOssidi.get(AnalysisDataFile.getTokenThO2())
//					.getOxyVal() * 10000;
//			System.out.println("ThO2ppm: " + thppm);
//			thppm = (thppm / 264.036) * 232.038;
//			System.out.println("Thppm: " + thppm);
//			uppm = listaOssidi.get(AnalysisDataFile.getTokenUO2()).getOxyVal() * 10000;
//			System.out.println("UO2ppm: " + uppm);
//			uppm = (uppm / 270.027) * 238.028;
//			System.out.println("Uppm: " + uppm);
//			pbppm = listaOssidi.get(AnalysisDataFile.getTokenPbO()).getOxyVal() * 10000;
//			System.out.println("PbOppm: " + pbppm);
//			pbppm = (pbppm / 223.199) * 207.199;
//			System.out.println("Pbppm: " + pbppm);
			age = 0.00;
			Pbcalc = 0.00;
		//	System.out.println("constant232 :" + getConstantth232());
			while (Pbcalc < pbppm && age < agemax) {

				thpart = (((thppm / 232) * (Math.exp(constantth232 * age) - 1)) * 208);
				u238part = ((uppm / 238.04) * 0.9928
						* (Math.exp(constantu238 * age) - 1) * 206);
				u235part = ((uppm / 235) * 0.0072
						* (Math.exp(constantu235 * age) - 1) * 207);
				Pbcalc = thpart + u238part + u235part;
				age = age + step;

			}
			System.out.println("age from Oxides ppm: " + age);
			setAge(age);

		}
	}

	public void calcAgeUThPb_younger() {

		System.out.println("calculating YOUNGER ages for MONAZITE");
		// USARE Math......

//		thppm = listaOssidi.get(AnalysisDataFile.getTokenThO2()).getOxyVal() * 10000;
//		System.out.println("ThO2ppm: " + thppm);
//		thppm = (thppm / 264.036) * 232.038;
//		System.out.println("Thppm: " + thppm);
//		uppm = listaOssidi.get(AnalysisDataFile.getTokenUO2()).getOxyVal() * 10000;
//		System.out.println("UO2ppm: " + uppm);
//		uppm = (uppm / 270.027) * 238.028;
//		System.out.println("Uppm: " + uppm);
//		pbppm = listaOssidi.get(AnalysisDataFile.getTokenPbO()).getOxyVal() * 10000;
//		System.out.println("PbOppm: " + pbppm);
//		pbppm = (pbppm / 223.199) * 207.199;
//		System.out.println("Pbppm: " + pbppm);

		/*
		 * SDPbO = listaOssidi.get(AnalysisDataFile.getTokenPbO()).getSD();
		 * System.out.println("SDPb: "+SDPb); SDTh =
		 * listaOssidi.get(AnalysisDataFile.getTokenThO2()).getSD();
		 * System.out.println("SDTh: "+SDTh); SDU =
		 * listaOssidi.get(AnalysisDataFile.getTokenUO2()).getSD();
		 * System.out.println("SDU: "+SDU);
		 */

//		SDThO2_ppm = thppm * SDThO2 / 100;
//		System.out.println("Thppm_sd: " + SDThO2_ppm);
//		SDUO2_ppm = uppm * SDUO2 / 100;
//		System.out.println("Uppm_sd: " + SDUO2_ppm);
//		SDPbO_ppm = pbppm * SDPbO / 100;
//		System.out.println("Pbppm_sd: " + SDPbO_ppm);

		age_younger = 0.00;

		Pbcalc_y = 0.00;

		while (Pbcalc_y < (pbppm + SDPbO_ppm) && age_younger < agemax) {

			thpart = ((((thppm - SDThO2_ppm) / 232) * (Math.exp(constantth232
					* age_younger) - 1)) * 208);
			u238part = (((uppm - SDUO2_ppm) / 238.04) * 0.9928
					* (Math.exp(constantu238 * age_younger) - 1) * 206);
			u235part = (((uppm - SDUO2_ppm) / 235) * 0.0072
					* (Math.exp(constantu235 * age_younger) - 1) * 207);
			Pbcalc_y = thpart + u238part + u235part;
			age_younger = age_younger + step;

		}
		System.out.println("age_younger: " + age_younger);
		setAge_younger(age_younger);

	}

	public void calcAgeUThPb_older() {


		System.out.println("calculating OLDER ages for MONAZITE");
		// USARE Math......
 
		
		age_older = 0.00;
		Pbcalc = 0.00;
		// Pbcalc = 0
		//System.out.println("constant232 :" + getConstantth232());
		while (Pbcalc < (pbppm - SDPbO_ppm) && age_older < agemax) {

			thpart = ((((thppm + SDThO2_ppm) / 232) * (Math.exp(constantth232* age_older) - 1)) * 208);
			u238part = (((uppm + SDUO2_ppm) / 238.04) * 0.9928* (Math.exp(constantu238 * age_older) - 1) * 206);
			u235part = (((uppm + SDUO2_ppm) / 235) * 0.0072* (Math.exp(constantu235 * age_older) - 1) * 207);
			Pbcalc = thpart + u238part + u235part;
			age_older = age_older + step;
			// System.out.println("inner age_older: "+age_older);
		}
		System.out.println("age_older: " + age_older);
		setAge_older(age_older);

	}

	@Override
	public void printSupplementaryHeaders(PrintWriter outWr) {
		super.printSupplementaryHeaders(outWr);
		outWr
				.write("\tAge(years)\tplus_years\tminus_years\tSDPbO\tSDThO2\tSDUO2\tPb_calc\tPbppm_meas\tThppm_meas\tUppm_meas");
	}

	@Override
	public void printSupplemetaryValues(PrintWriter out) {
		out = new PrintWriter(out);

		System.out.println("SD PbO % = " + SDPbO);
		System.out.println("SD ThO2 % = " + SDThO2);
		System.out.println("SD UO2 % = " + SDUO2);

		out.write("\t" + getAge() + "\t" + formatter.format(getAge_older())
				+ "\t" + formatter.format(getAge_younger()) + "\t" + SDPbO
				+ "\t" + SDThO2 + "\t" + SDUO2 + "\t" + getPbcalc() + "\t"
				+ getPbppm() + "\t" + getThppm() + "\t" + getUppm());
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
		return ".mnz";
	}

	public double getPbcalc() {
		return Pbcalc;
	}

	public void setPbcalc(double pbcalc) {
		Pbcalc = pbcalc;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public double getThppm() {
		return thppm;
	}

	public void setThppm(double thppm) {
		this.thppm = thppm;
	}

	public double getUppm() {
		return uppm;
	}

	public void setUppm(double uppm) {
		this.uppm = uppm;
	}

	public double getPbppm() {
		return pbppm;
	}

	public void setPbppm(double pbppm) {
		this.pbppm = pbppm;
	}

	public double getThpart() {
		return thpart;
	}

	public void setThpart(double thpart) {
		this.thpart = thpart;
	}

	public double getU238part() {
		return u238part;
	}

	public void setU238part(double u238part) {
		this.u238part = u238part;
	}

	public double getU235part() {
		return u235part;
	}

	public void setU235part(double u235part) {
		this.u235part = u235part;
	}

	public double getConstantth232() {
		return constantth232;
	}

	public double getConstantu238() {
		return constantu238;
	}

	public double getConstantu235() {
		return constantu235;
	}

	public double getAge_older() {
		return age_older;
	}

	public void setAge_older(double ageOlder) {
		age_older = ageOlder;
	}

	public double getAge_younger() {

		return age_younger;
	}

	private void setAge_younger(double ageYounger) {
		age_younger = ageYounger;

	}


	void testing(){
		System.out.println("\ntesting from Monazite \n");
		System.out.println("SiO2: " + listaOssidi.get(getTokenSiO2()).getOxyVal());
		System.out.println("ThO2: " + listaOssidi.get(getTokenThO2()).getOxyVal());
		System.out.println("SDThO2: " + listaOssidi.get(getTokenThO2()).getSD());
		System.out.println("SiO2 from SiO2: "+SiO2.getOxyVal());
		System.out.println("SDThO2 from SDThO2: "+SDThO2);
		
		System.out.println("\n fine testing monazite");
	}
	
	
}
