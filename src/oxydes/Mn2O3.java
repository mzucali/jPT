package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class Mn2O3 extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 35;
    private final Double PESO_MOLECOLARE_D = 157.874;
    private final int FATTORE_MOLTIPLICATIVO = 3;
    private final Double FATTORE_DIVISIONE_D = 0.666667;

    private final String oxyLabel= "Mn2O3";
    private final String catLabel = "Mn";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneMn2O3;

    public Mn2O3(){

    existsB = true;
    }

    public Mn2O3(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }

	public Integer getPosizioneMn2O3() {
		return posizioneMn2O3;
	}

	public void setPosizioneMn2O3(Integer posizioneMn2O3) {
		this.posizioneMn2O3 = posizioneMn2O3;
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