package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class CaO extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 9;
    private  final Double PESO_MOLECOLARE_D = 56.08;
    private  final int FATTORE_MOLTIPLICATIVO = 1;
    private  final Double FATTORE_DIVISIONE_D = 1.00;

    private final String oxyLabel= "CaO";
    private final String catLabel = "Ca";


    private Integer posizioneCaO;

    public CaO(){

    existsB = true;
    }

    public CaO(Double aOxValueDouble){
        setOxyVal(aOxValueDouble);// = aOxValueDouble;
        existsB = true;
    }
    public String getOxyLabel(){
        return oxyLabel;
    }
    

	public Integer getPosizioneCaO() {
		return posizioneCaO;
	}

	public void setPosizioneCaO(Integer posizioneCaO) {
		this.posizioneCaO = posizioneCaO;
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

	public int getIdCompI() {
		return ID_COMP_I;
	}
}