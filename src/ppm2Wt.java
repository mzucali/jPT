//import java.awt.Label;

//import java.awt.*;
//import java.awt.event.*;

import atoms.Periodic_Table;
import JSci.chemistry.*;
//import JSci.chemistry.periodictable.*;

public class ppm2Wt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ppm 2 Wt%
		// ppm/10000 = Wt%
		//
		
		String elemName = "iron";
		Element elem = JSci.chemistry.PeriodicTable.getElement(elemName);
		double e = Periodic_Table.Al.getWeight();
		
		
		System.out.println(elem);
		System.out.println("Al:"+ e);
        System.out.println("Atomic Number:" +String.valueOf(elem.getAtomicNumber()));
        
        System.out.println("Mass Number:" +String.valueOf(elem.getMassNumber()));
        
        String elemento= "Al";
        double a = Periodic_Table.Al.getWeight();
        
        
        double wt;
        double ppm;
        //w =23.34;
        ppm = 150;
        wt = ppm2Wt(ppm);
        System.out.println("weight of "+ppm+" is: "+wt);
	}

	private static double wt_perc;
	
	
	public ppm2Wt(){
		return;
		
	}

	public static double ppm2Wt(double ppm){
		wt_perc = ppm/10000;
		return wt_perc;
	}
	
	public void checkElement(String element){
		

		
		
	}
	
	
}
