package oxydes;

import atoms.Periodic_Table;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class Na2O extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 10;
    private  final Double PESO_MOLECOLARE_D = 61.98;
    private  final int FATTORE_MOLTIPLICATIVO = 1;
    private  final Double FATTORE_DIVISIONE_D = 2.00;

    private  final String oxyLabel= "Na2O";
    private  final String catLabel = "Na";

    private Double oxyVal;
    private Double catVal;

     private Integer posizioneNa2O;


    public Na2O(){
    	
    existsB = true;
    }

    public Na2O(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }
	public  int getIdCompI() {
		return ID_COMP_I;
	}

	public Integer getPosizioneNa2O() {
		return posizioneNa2O;
	}

	public void setPosizioneNa2O(Integer posizioneNa2O) {
		this.posizioneNa2O = posizioneNa2O;
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



	public Double getOxyVal() {
		return oxyVal;
	}

	public void setOxyVal(Double oxyVal) {
		this.oxyVal = oxyVal;
	}

	public Double getCatVal() {
		return catVal;
	}

	public void setCatVal(Double catVal) {
		this.catVal = catVal;
	}

	public String getOxyLabel() {
		return oxyLabel;
	}

	public String getCatLabel() {
		return catLabel;
	}
}