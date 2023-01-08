package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class H2O extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 32;
    private  final Double PESO_MOLECOLARE_D = 18.01528;
    private  final int FATTORE_MOLTIPLICATIVO = 1;
    private  final Double FATTORE_DIVISIONE_D = 2.0;

    private static final String oxyLabel= "H2O";
    private static final String catLabel = "OH";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneH2O;

  //  private static final Double PESO_MOLECOLARE_D = 0.01;

    public H2O(){

    existsB = true;
    }

    public H2O(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }



	public Integer getPosizioneH2O() {
		return posizioneH2O;
	}

	public void setPosizioneH2O(Integer posizioneH2O) {
		this.posizioneH2O = posizioneH2O;
	}
	
	// GETTERS & SETTERS GENERICI
	public  int getIdCompI() {
		return ID_COMP_I;
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

    
	public String getOxyLabel(){
        return oxyLabel;
    }

	public String getCatLabel() {
		return catLabel;
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


}