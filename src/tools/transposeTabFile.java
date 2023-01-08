package tools;

import tools.ArrayTranspose;

import java.io.*;
import java.util.Date;
import java.text.*;

import main.gui.jMineralCalc;
import minerals.MineralPhase;

public class transposeTabFile {

	 private static File input;

	PrintWriter out;

     DecimalFormat formatter;

     double sumOfOxides;

     SimpleDateFormat formatterDate;

     MineralPhase minPhase;

     
     
     
	public transposeTabFile(File fileOut) throws Exception{
	
//	void printToTabFile(File fileOut) throws Exception {
		// BufferedReader in = new BufferedReader(new FileReader(minPhase
		// .getOutPutFile()));
		// FileWriter in = new FileWriter(minPhase.getOutPutFile());
		// File inF = minPhase.getOutPutFile();
		Date date = new Date();
		formatterDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm");
		String s = formatterDate.format(date);
		// DateTime dt = new DateTime();
		// String date2 = System.currentTimeMillis();
		// String name = date+".tab";
		
		// NOME CAMBIATO 3/12/2011
		//		String name = input + "_tab_"+s + ".xls";
		String name = input + "_tab_" + ".xls";
		// String name = dt+".tab";
		String[][] Matrix = readTabFile(fileOut);
		String[][] MatrixT;
		// ArrayTranspose trans = new ArrayTranspose();
		MatrixT = ArrayTranspose.transpose(Matrix);
		PrintWriter outTab = new PrintWriter(new FileWriter(name));
		// PrintWriter outTab = new PrintWriter(new FileWriter("outTab.tab"));
		for (int row = 0; row < MatrixT.length; row++) {
		    for (int col = 0; col < MatrixT[0].length; col++) {
			outTab.print(MatrixT[row][col] + "\t");
		    }
		    outTab.println();
		}
		outTab.close();
	    }

	
	
	
	    public String[][] readTabFile(File inFile) throws Exception {
	    	
		BufferedReader in = new BufferedReader(new FileReader(inFile));
		
//			.getOutPutFile()));

		int lineCount = 0;
		while ((in.readLine()) != null)
		    System.out.println("line: " + lineCount++);

		in.close();
		int totalLines = lineCount;

		BufferedReader in1 = new BufferedReader(new FileReader(inFile));
	//		.getOutPutFile()));
		String s = in1.readLine();
		String[] array = s.split("\\t");
		int totalCols = array.length;
		in1.close();

		BufferedReader in2 = new BufferedReader(new FileReader(inFile));
		//	.getOutPutFile()));
		String[][] Matrix1 = new String[totalLines][totalCols];
		String[] array1 = new String[totalCols];

		for (int lines = 0; lines < totalLines; lines++) {

		    // for (int rows = 0; rows < totalRows; rows++) {
		    String s1 = in2.readLine();

		    array1 = s1.split("\\t");
		    for (int i = 0; i < array1.length; i++) {
			Matrix1[lines][i] = array1[i];
			// System.out.println("Matrix["+lines+"]["+i+"] = " +
	                // Matrix1[lines][i]);
		    }
		    // }

		}
		return Matrix1;
	    }
	
	
	 public static void go(File file) throws Exception{
		 input = file;
		jMineralCalc.getConsole().println("go transposing file "+file);
		new transposeTabFile(file);
	}
	
	
	
}
