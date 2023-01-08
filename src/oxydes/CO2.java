package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class CO2 extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 19;
    private  final Double PESO_MOLECOLARE_D = 44.00;
    private  final int FATTORE_MOLTIPLICATIVO = 2;
    private  final Double FATTORE_DIVISIONE_D = 0.50;

    private static final String oxyLabel= "CO2";
    private static final String catLabel = "C";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneCO2;


    public CO2(){

    existsB = true;
    }

    public CO2(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }
    public String getOxyLabel(){
        return oxyLabel;
    }
	public  int getIdCompI() {
		return ID_COMP_I;
	}
	public Integer getPosizioneCO2() {
		return posizioneCO2;
	}

	public void setPosizioneCO2(Integer posizioneCO2) {
		this.posizioneCO2 = posizioneCO2;
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
}