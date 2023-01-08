package oxydes;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miki
 */

public class TiO2 extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int ID_COMP_I = 1;
    private  final Double PESO_MOLECOLARE_D = 79.88;
    private  final int FATTORE_MOLTIPLICATIVO = 2;
    private  final Double FATTORE_DIVISIONE_D = 0.5;

    private final String oxyLabel= "TiO2";
    private final String catLabel = "Ti";

    private Double oxyVal;
    private Double catVal;
    private Integer posizioneTiO2;
 

    public TiO2(){

    existsB = true;
    }

    public TiO2(Double aOxValueDouble){
        oxyVal = aOxValueDouble;
        existsB = true;
    }

    public String getOxyLabel(){
        return oxyLabel;
    }
	public String getCatLabel(){
	return catLabel;
}


//	public  int getIdCompI() {
//		return ID_COMP_I;
//	}


		public Integer getPosizioneTiO2() {
			return posizioneTiO2;
		}

		public void setPosizioneTiO2(Integer posizioneTiO2) {
			this.posizioneTiO2 = posizioneTiO2;
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