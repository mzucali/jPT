package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class NiO extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 30;
    private  final Double PESO_MOLECOLARE_D = 74.692;
    private  final int FATTORE_MOLTIPLICATIVO = 1;
    private  final Double FATTORE_DIVISIONE_D = 1.00;

    private  final String oxyLabel= "NiO";
    private final String catLabel = "Ni";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneNiO;



    public NiO(){

    existsB = true;
    }

    public NiO(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }
    
	public  int getIdCompI() {
		return ID_COMP_I;
	}

	public Integer getPosizioneNiO() {
		return posizioneNiO;
	}

	public void setPosizioneNiO(Integer posizioneNiO) {
		this.posizioneNiO = posizioneNiO;
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