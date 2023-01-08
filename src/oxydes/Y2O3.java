package oxydes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class Y2O3 extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 24;
    private  final Double PESO_MOLECOLARE_D = 225.809;
    private  final int FATTORE_MOLTIPLICATIVO = 3;
    private  final Double FATTORE_DIVISIONE_D = 0.666667;

    private  final String oxyLabel= "Y2O3";
    private  final String catLabel = "Y";

    private Double oxyVal;
    private Double catVal;

    private Integer posizioneY2O3;

  //  private static final Double PESO_MOLECOLARE_D = 0.01;

    public Y2O3(){
    existsB = true;
    }

    public Y2O3(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }



	public Integer getPosizioneY2O3() {
		return posizioneY2O3;
	}

	public void setPosizioneY2O3(Integer posizioneY2O3) {
		this.posizioneY2O3 = posizioneY2O3;
	}
//	public  Double getPESO_MOLECOLARE_D() {
//		return PESO_MOLECOLARE_D;
//	}

	public  int getIdCompI() {
		return ID_COMP_I;
	}


	
//	public int getFATTORE_MOLTIPLICATIVO() {
//		return FATTORE_MOLTIPLICATIVO;
//	}

	public Double getPESO_MOLECOLARE_D() {
		return PESO_MOLECOLARE_D;
	}

	public int getFATTORE_MOLTIPLICATIVO() {
		return FATTORE_MOLTIPLICATIVO;
	}

	public Double getFATTORE_DIVISIONE_D() {
		return FATTORE_DIVISIONE_D;
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

	public String getOxyLabel() {
		return oxyLabel;
	}

	public String getCatLabel() {
		return catLabel;
	}

	
}