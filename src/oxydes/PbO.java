package oxydes;


public class PbO extends Oxydes {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 20;
    private  final Double PESO_MOLECOLARE_D = 223.199;
    private  final int FATTORE_MOLTIPLICATIVO = 1;
    private  final Double FATTORE_DIVISIONE_D = 1.00;

    private final String oxyLabel= "PbO";
    private final String catLabel = "Pb";

    private double SD;
    private Integer posizionePbO;

    public PbO(){

    existsB = true;
    }

    public PbO(Double aOxValueDouble){
        setOxyVal(aOxValueDouble);// = aOxValueDouble;
        existsB = true;
    }
    public String getOxyLabel(){
        return oxyLabel;
    }
    

	public Integer getPosizionePbO() {
		return posizionePbO;
	}

	public void setPosizionePbO(Integer posizionePbO) {
		this.posizionePbO = posizionePbO;
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
	public void setSD(double sD) {
		SD = sD;
	}
	public double getSD() {
		return SD;
	}
}
