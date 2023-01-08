package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class Cr2O3 extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 3;
    private final Double PESO_MOLECOLARE_D = 151.9904;
    private final int FATTORE_MOLTIPLICATIVO = 3;
    private final Double FATTORE_DIVISIONE_D = 0.666667;

    private final String oxyLabel= "Cr2O3";
    private final String catLabel = "Cr";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneCr2O3;

    public Cr2O3(){

    existsB = true;
    }

    public Cr2O3(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }
    public String getOxyLabel(){
        return oxyLabel;
    }
	public  int getIdCompI() {
		return ID_COMP_I;
	}
	public Integer getPosizioneCr2O3() {
		return posizioneCr2O3;
	}

	public void setPosizioneCr2O3(Integer posizioneCr2O3) {
		this.posizioneCr2O3 = posizioneCr2O3;
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
}