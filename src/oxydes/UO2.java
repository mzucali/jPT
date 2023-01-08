package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class UO2 extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 22;
    private  final Double PESO_MOLECOLARE_D = 270.027;
    private  final int FATTORE_MOLTIPLICATIVO = 2;
    private  final Double FATTORE_DIVISIONE_D = 0.50;

    private static final String oxyLabel= "UO2";
    private static final String catLabel = "U";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneUO2;
private double SD;

    public UO2(){

    existsB = true;
    }

    public UO2(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }
    public String getOxyLabel(){
        return oxyLabel;
    }
	public  int getIdCompI() {
		return ID_COMP_I;
	}
	public Integer getPosizioneUO2() {
		return posizioneUO2;
	}

	public void setPosizioneUO2(Integer posizioneUO2) {
		this.posizioneUO2 = posizioneUO2;
	}
	public  Double getPESO_MOLECOLARE_D() {
		return PESO_MOLECOLARE_D;
	}

	public int getFATTORE_MOLTIPLICATIVO() {
		return FATTORE_MOLTIPLICATIVO;
	}

	public Double getFATTORE_DIVISIONE_D() {
		return FATTORE_DIVISIONE_D;
	}
	public String getCatLabel() {
		return catLabel;
	}
	public void setSD(double sD) {
		SD = sD;
	}
	public double getSD() {
		return SD;
	}
}