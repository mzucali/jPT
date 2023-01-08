package tools;

import main.gui.Console;
import main.gui.jMineralCalc;
import minerals.MineralPhase;
import oxydes.Oxydes;
import sample.Sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class jpt2xls_formula {

	public Oxydes it;
	public File outFile;
	public PrintWriter printOUT;
	public DecimalFormat formatter = new DecimalFormat("##.00000");

	/**
	 * @throws Exception *************************/

	@SuppressWarnings("static-access")
	public jpt2xls_formula(MineralPhase mf) throws Exception {
		
		
		System.out.println("testing jpt2xls_formula(MineralPhase mf)");
		jMineralCalc.getConsole().println("file for XLS mineral calculation is ready in XLS_input_calc.xls (it will overwrite previous files)");
		/* testing*/
		mf.getListaOssidi();

		
		printOutValues(mf);
		tools.transposeTabFile.go(outFile); 
		
		}
		
		
		@SuppressWarnings("static-access")
		public void printOutValues(MineralPhase mf) throws IOException{
			
			
			/*******   *******/
			String dir = System.getProperty("user.dir");
			//File curfile = jMineralCalc.getCurFile();
			String parent_path = jMineralCalc.getCurFile().getParent();//path folder dati
			jMineralCalc.getConsole().println(parent_path+"/"+"XLS_export_tmp.xls");
			outFile = new File(parent_path+"/"+"XLS_export_tmp.xls");
			
			if (outFile.exists()) {

				printOUT = new PrintWriter(new FileWriter(outFile, true));

			} else {

				printOUT = new PrintWriter(new FileWriter(outFile, true));
				System.out.println(" headers to be written...");
				printOutHeader(printOUT, mf);

			}
			
			//Sample	an.	K2O	CaO	TiO2	Cr2O3	MnO	FeOt	NiO	Na2O	SiO2	Al2O3	MgO
			
			
			printOUT.write(mf.getSampleS());
			printOUT.write("\t" + mf.getMineralCodeString());
		//	printOUT.write("\tan.");
			
			if (mf.isK2O_present()) {
				printOUT.write("\t" + formatter.format(mf.K2O.getOxyVal()));
			} else {
				printOUT.write("\t0");
			}if (mf.isCaO_present()) {
			printOUT.write("\t"
					+ formatter.format(mf.CaO.getOxyVal()));
		} else {
			printOUT.write("\t0");
		}
		if (mf.isTiO2_present()) {
			printOUT.write("\t" + formatter.format(mf.TiO2.getOxyVal()));
		} else {
			printOUT.write("\t0");
		}
		if (mf.isCr2O3_present()) {
			printOUT.write("\t" + formatter.format(mf.Cr2O3.getOxyVal()));
		} else {
			printOUT.write("\t0");
		}
		if (mf.isMnO_present()) {
			printOUT.write("\t" + formatter.format(mf.MnO.getOxyVal()));
		} else {
			printOUT.write("\t0");
		}
		if (mf.isFeO_present()) {
			printOUT.write("\t" + formatter.format(mf.FeO.getOxyVal()));

		} else {
			printOUT.write("\t0");
		}
		if (mf.isNiO_present()) {
			printOUT.write("\t" + formatter.format(mf.NiO.getOxyVal()));
		} else {
			printOUT.write("\t0");
		}
		if (mf.isNa2O_present()) {
			printOUT.write("\t" + formatter.format(mf.Na2O.getOxyVal()));
		} else {
			printOUT.write("\t0");
		}
		if (mf.isSiO2_present()) {
			printOUT.write("\t" + formatter.format(mf.SiO2.getOxyVal()));
		} else {
			printOUT.write("\t0");
		}
		if (mf.isAl2O3_present()) {
			printOUT.write("\t" + formatter.format(mf.Al2O3.getOxyVal()));
		} else {
			printOUT.write("\t0");
		}
		if (mf.isMgO_present()) {
			printOUT.write("\t" + formatter.format(mf.MgO.getOxyVal()));
		} else {
			printOUT.write("\t0");
		}
		printOUT.write("\n");
		printOUT.close();

}

	public void printOutHeader(PrintWriter out3, MineralPhase mf) throws IOException {
		//Sample	an.	K2O	CaO	TiO2	Cr2O32	MnO	FeOt	NiO	Na2O	SiO2	Al2O3	MgO
		out3.write("Sample\tMin\tK2O\tCaO\tTiO2\tCr2O3\tMnO\tFeOt\tNiO\tNa2O\tSiO2\tAl2O3\tMgO\n");

		out3.close();
		printOutValues(mf);
	}

}
