package oxydes;


import java.io.Serializable;



//package JPT02rc1;
/**
 *
 * @author miki
 */
//public abstract class Ossido_abstract
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Oxydes implements Comparable, Serializable {

    /**
     *
     *              * //System.out.println("posizione ossidi in oxides[]: [0] SiO2; [1] TiO2, [2] Al2O3, [3]
             * Cr2O3, [4] FeO, [5] Fe2O3, [6] MnO, [7] MgO, [8] ZnO, [9] CaO,
             * [10] Na2O, [11] K2O, [12] P2O5, [13] B2O3, [14] SrO, [15]
             * La2O3, [16] Ce2O3 [17] Nd2O3, [18] SO3
     */
    private static final long serialVersionUID = 1L;
    
    private int ID_COMP_I;// = 1000; //ID DA USARE per >CompareTo, quindi per ordinare ossidi
    boolean existsB;
    
    
    public  Double PESO_MOLECOLARE_D;// = 0.01;
    public  int FATTORE_MOLTIPLICATIVO;// = 1; NUMERO DI OSSIGENI x Molecola
    public  Double FATTORE_DIVISIONE_D; // = 0.5; rapporto Catione/Ossigeni x Molecola

    public  Integer posizione;



    public String oxyLabel;
    public String catLabel;
    
    public Double oxyVal;
    public Double catVal;
    
    
    
    public Double moleProportion;
    public Double atomProportion;
    public Double anionsProportion;
    
   

public double SD; // % - //standard deviation (error in the analytical measures)
public int tokenSD;


        /** Creates a new instance of Element */
    public Oxydes() {
        existsB = false;
       // System.out.println("posizione  : "+posizione);
    }

    public Oxydes(String oxyLabel, double oxyValue){
        setOxyLabel(oxyLabel);
        setOxyVal(oxyVal);
        existsB = false;
System.out.println("posizione  : "+posizione);
    }


    private void init() {
		
	}




    // getters and setters


        public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public int getID_COMP_I() {
        return getIdCompI();
    }



    public  Double getFATTORE_DIVISIONE_D() {
        return FATTORE_DIVISIONE_D;
    }

    public  int getFATTORE_MOLTIPLICATIVO() {
        return FATTORE_MOLTIPLICATIVO;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

        public  Double getPESO_MOLECOLARE_D() {
        return PESO_MOLECOLARE_D;
    }	
    


    public Double getCatVal() {
        return catVal;
    }

    public void setCatVal(Double catVal) {
        this.catVal = catVal;
    }

    public boolean isExistsB() {
        return existsB;
    }

    public void setExistsB(boolean existsB) {
        this.existsB = existsB;
    }

    public Double getOxyVal() {
        return oxyVal;
    }
    
    public void setOxyVal(Double oxyval) {
        oxyVal = oxyval;
        return;
    }

    public void setOxyLabel(String string) {
        oxyLabel = string;
    //    return;
    }
    public String getOxyLabel() {
        return oxyLabel;
    }









    public int compareTo(Object o) {

        Oxydes e = (Oxydes) o;
        if (getIdCompI() < e.getIdCompI()) {
            return -1;
        }
        if (getIdCompI() > e.getIdCompI()) {
            return 1;
        }
        return 0;
    }

	public  int getIdCompI() {
		return ID_COMP_I;
	}

	public Double getMoleProportion() {
		return moleProportion;
	}

	public void setMoleProportion(Double moleProportion) {
		this.moleProportion = moleProportion;
	}


	public void setAtomProportion(double d) {
			atomProportion = d; 
	}
	public Double getAtomProportion() {
		return atomProportion;
	}

	public String getCatLabel() {
		return catLabel;
	}

	public void setAnions(double d) {
anionsProportion = d;

	}

	public Double getAnionsProportion() {
		return anionsProportion;
	}

	public void setAnionsProportion(Double anionsProportion) {
		this.anionsProportion = anionsProportion;
	}

	public double getSD() {
		return SD;
	}

	public void setSD(double sD) {
		SD = sD;
	}

	public int getTokenSD() {
		return tokenSD;
	}

	public void setTokenSD(int tokenSD) {
		this.tokenSD = tokenSD;
	}


	

  
}
