package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class P2O5 extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 12;
    private  final Double PESO_MOLECOLARE_D = 141.94;
    private  final int FATTORE_MOLTIPLICATIVO = 5;
    private  final Double FATTORE_DIVISIONE_D = 0.4;

    private  final String oxyLabel= "P2O5";
    private final String catLabel = "P";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneP2O5;


    public P2O5(){

    existsB = true;
    }

    public P2O5(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }
	public  int getIdCompI() {
		return ID_COMP_I;
	}
	public Integer getPosizioneP2O5() {
		return posizioneP2O5;
	}

	public void setPosizioneP2O5(Integer posizioneP2O5) {
		this.posizioneP2O5 = posizioneP2O5;
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