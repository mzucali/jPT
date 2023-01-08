package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class K2O extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 11;
    private final Double PESO_MOLECOLARE_D = 94.196;
    private final int FATTORE_MOLTIPLICATIVO = 1;
    private final Double FATTORE_DIVISIONE_D = 2.00;

    private final String oxyLabel= "K2O";
    private final String catLabel = "K";


    private Integer posizioneK2O;


    public K2O(){

    existsB = true;
    }

    public K2O(Double aOxValueDouble){
        setOxyVal(aOxValueDouble);
        existsB = true;
    }
 
	public  int getIdCompI() {
		return ID_COMP_I;
	}
	public Integer getPosizioneK2O() {
		return posizioneK2O;
	}

	public void setPosizioneK2O(Integer posizioneK2O) {
		this.posizioneK2O = posizioneK2O;
	}
	public Double getPESO_MOLECOLARE_D() {
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
}