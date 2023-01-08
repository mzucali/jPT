package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class ThO2 extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 21;
    private  final Double PESO_MOLECOLARE_D = 264.036;
    private  final int FATTORE_MOLTIPLICATIVO = 2;
    private  final Double FATTORE_DIVISIONE_D = 0.50;

    private static final String oxyLabel= "ThO2";
    private static final String catLabel = "Th";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneThO2;
private double SD;

    public ThO2(){

    existsB = true;
    }

    public ThO2(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }
    public String getOxyLabel(){
        return oxyLabel;
    }
	public  int getIdCompI() {
		return ID_COMP_I;
	}
	public Integer getPosizioneThO2() {
		return posizioneThO2;
	}

	public void setPosizioneThO2(Integer posizioneThO2) {
		this.posizioneThO2 = posizioneThO2;
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