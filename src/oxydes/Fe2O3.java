package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class Fe2O3 extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 5;
    private final Double PESO_MOLECOLARE_D = 159.69;
    private final int FATTORE_MOLTIPLICATIVO = 3;
    private final Double FATTORE_DIVISIONE_D = 0.666667;

    private final String oxyLabel= "Fe2O3";
    private final String catLabel = "Fe3";

//    private Double oxyVal;
//    private Double catVal;

    private Integer posizioneFe2O3;

    public Fe2O3(){

    existsB = true;
    }

    public Fe2O3(Double aOxValueDouble){
        setOxyVal(aOxValueDouble);// = aOxValueDouble;
        existsB = true;
    }
    public String getOxyLabel(){
        return oxyLabel;
    }
	public  int getIdCompI() {
		return ID_COMP_I;
	}
	public Integer getPosizioneFe2O3() {
		return posizioneFe2O3;
	}

	public void setPosizioneFe2O3(Integer posizioneFe2O3) {
		this.posizioneFe2O3 = posizioneFe2O3;
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

	public String getOxylabel() {
		return oxyLabel;
	}

	public String getCatLabel() {
		return catLabel;
	}
}