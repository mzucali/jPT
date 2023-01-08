package oxydes;

public class SrO extends Oxydes {
	
	
	private static final long serialVersionUID = 1L;
	private static final int ID_COMP_I = 14;
    private  final Double PESO_MOLECOLARE_D = 103.619;
    private  final int FATTORE_MOLTIPLICATIVO = 1;
    private final Double FATTORE_DIVISIONE_D = 1.00;

    private  final String oxyLabel= "SrO";
    private final String catLabel = "Sr";


    private Integer posizioneSrO;

    public SrO(){

    existsB = true;

    }

    
    public SrO(Double aOxValueDouble){
        setOxyVal(aOxValueDouble);// = aOxValueDouble;
        existsB = true;
    }
    
	public  int getIdCompI() {
		return ID_COMP_I;
	}
    
    


    public String getOxyLabel(){
        return oxyLabel;
    }
    

	public Integer getPosizioneSrO() {
		return posizioneSrO;
	}

	public void setPosizioneSrO(Integer posizioneSrO) {
		this.posizioneSrO = posizioneSrO;
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
    
