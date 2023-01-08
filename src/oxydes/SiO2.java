package oxydes;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class SiO2 extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 0;
    private  static final Double PESO_MOLECOLARE_D = 60.08;
    private  static final int FATTORE_MOLTIPLICATIVO = 2;
    private  static final Double FATTORE_DIVISIONE_D = 0.5;

    private String oxyLabel= "SiO2";
    private String catLabel = "Si";

   // private Double oxyVal;
   // private Double catVal;

    private  Integer posizioneSiO2;


    public SiO2(){
    	//init();
    	//setPESO_MOLECOLARE_D(60.08); //PESO_MOLECOLARE_D = 60.08;	
    existsB = true;
    }


	public SiO2(Double aOxValueDouble){
   //     oxyVal = aOxValueDouble;
        existsB = true;
    }

public SiO2(Oxydes aSiO2oxyde){
	existsB = true;
}

	public Integer getPosizioneSiO2() {
		return posizioneSiO2;
	}

	public  void setPosizioneSiO2(Integer posizioneSiO2_i) {
		posizioneSiO2 = posizioneSiO2_i;
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


	public void setOxyLabel(String oxyLabel) {
		this.oxyLabel = oxyLabel;
	}


	public void setCatLabel(String catLabel) {
		this.catLabel = catLabel;
	}


	public String getOxyLabel() {
		return oxyLabel;
	}


	public String getCatLabel() {
		return catLabel;
	}
//	public  int getIdCompI() {
//		return ID_COMP_I;
//	}






}
