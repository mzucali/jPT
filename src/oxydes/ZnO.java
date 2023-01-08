package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class ZnO extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 8;
    private  final Double PESO_MOLECOLARE_D = 81.38;
    private  final int FATTORE_MOLTIPLICATIVO = 1;
    private final Double FATTORE_DIVISIONE_D = 1.00;

    private  final String oxyLabel= "ZnO";
    private  final String catLabel = "Zn";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneZnO;


    public ZnO(){

    existsB = true;
    }

    public ZnO(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }
	public  int getIdCompI() {
		return ID_COMP_I;
	}
    
    
    public String getOxyLabel(){
        return oxyLabel;
    }

	public Integer getPosizioneZnO() {
		return posizioneZnO;
	}

	public void setPosizioneZnO(Integer posizioneZnO) {
		this.posizioneZnO = posizioneZnO;
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