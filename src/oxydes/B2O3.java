package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class B2O3 extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 13;
    private  final Double PESO_MOLECOLARE_D = 69.62;
    private  final int FATTORE_MOLTIPLICATIVO = 3;
    private  final Double FATTORE_DIVISIONE_D = 0.666667;

    private  final String oxyLabel= "B2O3";
    private  final String catLabel = "B";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneB2O3;

  //  private static final Double PESO_MOLECOLARE_D = 0.01;

    public B2O3(){

    existsB = true;
    }

    public B2O3(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }
	public  int getIdCompI() {
		return ID_COMP_I;
	}


	public Integer getPosizioneB2O3() {
		return posizioneB2O3;
	}

	public void setPosizioneB2O3(Integer posizioneB2O3) {
		this.posizioneB2O3 = posizioneB2O3;
	}
//	public  Double getPESO_MOLECOLARE_D() {
//		return PESO_MOLECOLARE_D;
//	}

    public String getOxyLabel(){
        return oxyLabel;
    }
	public String getCatLabel(){
	return catLabel;
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
}