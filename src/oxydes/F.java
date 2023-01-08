package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class F extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 39;
    private  final Double PESO_MOLECOLARE_D = 18.998;
    private  final int FATTORE_MOLTIPLICATIVO = 1;
    private  final Double FATTORE_DIVISIONE_D = 1.00;

    private  final String oxyLabel= "F";
    private final String catLabel = "F";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneF;



    public F(){

    existsB = true;
    }

    public F(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }
    
	public  int getIdCompI() {
		return ID_COMP_I;
	}

	public Integer getPosizioneF() {
		return posizioneF;
	}

	public void setPosizioneF(Integer posizioneF) {
		this.posizioneF = posizioneF;
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

	public String getOxyLabel() {
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