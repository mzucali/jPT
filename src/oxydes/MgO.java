package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class MgO extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 7;
    private  final Double PESO_MOLECOLARE_D = 40.30;
    private  final int FATTORE_MOLTIPLICATIVO = 1;
    private  final Double FATTORE_DIVISIONE_D = 1.0;

    private final String oxyLabel= "MgO";
    private final String catLabel = "Mg";

//    private Double oxyVal;
//    private Double catVal;

    private Integer posizioneMgO;


    public MgO(){

    existsB = true;
    }

    public MgO(Double aOxValueDouble){
        setOxyVal(aOxValueDouble);// = aOxValueDouble;
        existsB = true;
    }
	public  int getIdCompI() {
		return ID_COMP_I;
	}

	public Integer getPosizioneMgO() {
		return posizioneMgO;
	}

	public void setPosizioneMgO(Integer posizioneMgO) {
		this.posizioneMgO = posizioneMgO;
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

	public  String getOxyLabel() {
		return oxyLabel;
	}

	public  String getCatLabel() {
		return catLabel;
	}

	
}