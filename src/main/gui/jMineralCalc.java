package main.gui;

import datafiles.AnalysisDataFile;
import minerals.MineralPhase;
import oxydes.Oxydes;
import sample.Sample;
import tools.XLSfile;
import tools.jpt2AX;
import tools.printAnalysesALL;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class jMineralCalc extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("apple.laf.AquaLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuBar jMenuBar_jpt;
	private JMenuItem load_data;
	private JButton jButtonCalcALL;
	private JPanel jPanel1;
	private JMenuItem analysis;
	private JMenuItem general;
	private JMenu jPreferences;
	private AbstractAction openInfoPanle;
	private AbstractAction openInfo;
	private AbstractAction ActionOpenFileChooser;
	private JFileChooser jFileChooser1;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem2;
	private AbstractAction abstractActionClose;
	private AbstractAction abstractActionEXIT;
	private AbstractAction closeAboutAction;
	private JMenu jMenu2;
	private JMenu jMenu1;

	public Sample sample;
	/**
	 * Auto-generated main method to display this JFrame
	 */
	private static Console console;
	private static Export exportGUI;
	private AbstractAction export2AX;
	private JButton jButtonOpenTAB;
	private JPanel panel;
	private JMenuItem printAnalyses;
	private JTextArea textArea;
	private JTextPane txtpnCiaoATutti;
	private JPanel panel_2;
	private JRadioButton radioButton_1;
	private JRadioButton rdbtnAmph;
	private JRadioButton rdbtnAx;
	private JPanel panel_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton radioButton_3;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JRadioButton radioButton_4;
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private static File current_file;
	private JRadioButton rdbtnSi;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				jMineralCalc inst = new jMineralCalc();
				// inst.setLocationRelativeTo(null);
				// inst.setLocation(500, 0);
				inst.setVisible(true);
				inst.setResizable(false);

				console = new Console();
				console.setLocationRelativeTo(null);
				console.setLocation(800, 0);
				console.setVisible(true);
				console.getTitle();

				// console.println("test on console");
				console.println("Starting jPT version ........!");
				
				
	/*	SPOSTATO nel tasto export	
	 * 			exportGUI = new export();
	 * 			exportGUI.setLocationRelativeTo(null);
				exportGUI.setLocation(800, 500);
				exportGUI.setVisible(true);
				exportGUI.getTitle();
		*/	
				}
		});
	}

	public jMineralCalc() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			// GroupLayout thisLayout = new
			// GroupLayout((JComponent)getContentPane());

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("jPTgui v2015.1 - generic mineral formula calculation - by Michele Zucali_@_unimi.it");
			this.setLocation(new java.awt.Point(0, 0));
			CardLayout thisLayout1 = new CardLayout();
			getContentPane().setLayout(thisLayout1);
			getContentPane().add(getJPanel1(), "jTable1");
			{
				jMenuBar_jpt = new JMenuBar();
				setJMenuBar(jMenuBar_jpt);
				{
					jMenu1 = new JMenu();
					jMenuBar_jpt.add(jMenu1);
					jMenu1.setText("File");
					{
						load_data = new JMenuItem();
						jMenu1.add(load_data);
						jMenu1.add(getPrintAnalyses());
						jMenu1.add(getJPreferences());
						jMenu1.add(getJMenuItem4());
						load_data.setText("\n");
						load_data.setAction(getActionOpenFileChooser());
					}
				}
				{
					jMenu2 = new JMenu();
					FlowLayout jMenu2Layout = new FlowLayout();
					jMenu2.setLayout(jMenu2Layout);
					jMenuBar_jpt.add(jMenu2);
					jMenu2.setText("Help");
					jMenu2.add(getJMenuItem2());
					jMenu2.add(getJMenuItem3());
				}
			}
			pack();
			pack();
			pack();
			pack();
			pack();
			this.setSize(749, 569);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public JMenuBar getjMenuBar_jpt() {
		return jMenuBar_jpt;
	}

	public void setjMenuBar_jpt(JMenuBar jMenuBarJpt) {
		jMenuBar_jpt = jMenuBarJpt;
	}

	private AbstractAction getAbstractActionEXIT() {
		if (abstractActionEXIT == null) {
			abstractActionEXIT = new AbstractAction("Exit", null) {
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					
					
					//XLSfile xlsfile = new XLSfile();
					//xlsfile.addALine();
					
					System.exit(0);
					
					

				}
			};
		}
		return abstractActionEXIT;
	}

	@SuppressWarnings("serial")
	private AbstractAction getAbstractActionClose() {
		if (abstractActionClose == null) {
			abstractActionClose = new AbstractAction("close", null) {
				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
				}
			};
		}
		return abstractActionClose;
	}

	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			jMenuItem2.setText("List of available minerals");
		}
		return jMenuItem2;
	}

	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Info");
			jMenuItem3.setAction(getOpenInfoPanle());

		}
		return jMenuItem3;
	}

	private JMenuItem getJMenuItem4() {
		if (jMenuItem4 == null) {
			jMenuItem4 = new JMenuItem();
			jMenuItem4.setText("Exit");
			jMenuItem4.setAction(getAbstractActionEXIT());
		}
		return jMenuItem4;
	}

	public JFileChooser getJFileChooser1() {
		if (jFileChooser1 == null) {
			jFileChooser1 = new JFileChooser();
		}
		return jFileChooser1;
	}


	
	@SuppressWarnings("serial")
	public AbstractAction getActionOpenFileChooser() {
		if (ActionOpenFileChooser == null) {
			ActionOpenFileChooser = new AbstractAction("Load Analysis", null) {

				public void actionPerformed(ActionEvent evt) {

					String curDir = System.getProperty("user.dir");
					
					JFileChooser fc = new JFileChooser(curDir);

					fc.showOpenDialog(null);
					File curFile = fc.getSelectedFile();

					console.println("selected file: " + curFile);
					console.println("selected file get Absolute Path: "+ curFile.getAbsolutePath());

					String name = curFile.getAbsolutePath();

					String nomeFile = "default.txt";

					if (name == null) {
						try {
							new Sample("sample1", nomeFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						try {
							sample = new Sample("sample1", name);
							// new Sample("sample1", name);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						console.println("Finished with jPT ........!");
					}

					

						
					
				
				}
			};
		}
		return ActionOpenFileChooser;
	}
	
	
	
	
	
	
	
	protected AbstractButton getJListMineralPhases() {
	// TODO Auto-generated method stub
	return null;
}

	public static Console getConsole() {
		return console;
	}

	public static void setConsole(Console console) {
		jMineralCalc.console = console;
	}

	protected void setCurFile(File curFile) {
		current_file = curFile;
		
	}

	public static File getCurFile(){
		return current_file;
	}
	
	@SuppressWarnings("serial")
	private AbstractAction getOpenInfoPanle() {
		if (openInfoPanle == null) {
			openInfoPanle = new AbstractAction("Info", null) {
				public void actionPerformed(ActionEvent evt) {
					InfoPanel info = new InfoPanel();
					info.setLocationRelativeTo(null);
					info.setLocation(800, 400);
					info.setVisible(true);

				}
			};
		}
		return openInfoPanle;
	}

	private JMenu getJPreferences() {
		if (jPreferences == null) {
			jPreferences = new JMenu();
			jPreferences.setText("Preferences");
			jPreferences.setBounds(-98, 0, 98, 21);
			jPreferences.add(getGeneral());
			jPreferences.add(getAnalysis());
		}
		return jPreferences;
	}

	private JMenuItem getGeneral() {
		if (general == null) {
			general = new JMenuItem();
			general.setText("general");
		}
		return general;
	}

	private JMenuItem getAnalysis() {
		if (analysis == null) {
			analysis = new JMenuItem();
			analysis.setText("analysis");
		}
		return analysis;
	}

	// non ho idea se questo serva piu' a qualcosa
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setPreferredSize(new Dimension(749, 520));
			jPanel1.setSize(485, 800);
			jPanel1.setLayout(null);
			jPanel1.add(getPanel_2());
			jPanel1.add(getPanel());
			jPanel1.add(getPanel_1());
			jPanel1.add(getJButtonCalcALL());
			
			// 23 novembre 2011 funziona bene ma da implementare per 
			// avere una lista di analisi
			JButton list_data_button = new JButton("list");
			
			list_data_button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ArrayList<AnalysisDataFile> analisi = getSample().getAnalysis_data_sets();
					
					System.out.println("TEST da JMineralCalc");
					for (AnalysisDataFile an : analisi) {
						ArrayList<MineralPhase> minerals = an.getMfsArrayList();
						getConsole().println("");
						for (MineralPhase min : minerals) {
							System.out.println("TEST POSIZIONI e valori da ListaOssidi contains & indexOf");
							System.out.println("mineral sample: "+min.getSampleS());

							if (min.getListaOssidi().contains(min.FeO)){
								int position=min.getListaOssidi().indexOf(min.FeO);
								System.out.println("\t index FeO: "+position);
								System.out.println("Value FeO: "+min.getListaOssidi().get(position).getOxyLabel()+" = "
										+min.getListaOssidi().get(position).getOxyVal());
								
							}
							
							
							
//							System.out.println("CONTROLLO DA OSSIDI");
//							System.out.println("SiO2 = "+min.getSiO2().getOxyVal());
//							System.out.println("SiO2 = " + min.SiO2.getOxyVal());
//							System.out.println("FeO = " + min.FeO.getOxyVal());
//							System.out.println("MgO = " + min.MgO.getOxyVal());
//							System.out.println("Al2O3 = " + min.Al2O3.getOxyVal());
//							System.out.println("TiO2 = " + min.TiO2.getOxyVal());
							
							getConsole().println("OUTPUT");
							getConsole().println(min.getMineralNameString());
							getConsole().println(min.getSampleS());
							for (Oxydes ox: min.getListaOssidi()){
							//	getConsole().println("Label: "+ox.getOxyLabel() +" posizione: "
							//			+ox.getPosizione() );
								getConsole().println(ox.getOxyLabel()+ " = "
										+ox.getOxyVal());
							}
						
							
							
						}
					} 
				}
			});
			list_data_button.setBounds(633, 412, 95, 29);
			jPanel1.add(list_data_button);

		
		}
		return jPanel1;
	}

	private JButton getJButtonCalcALL() {
		if (jButtonCalcALL == null) {
			jButtonCalcALL = new JButton();
			jButtonCalcALL.setBounds(640, 441, 75, 29);
			jButtonCalcALL.setText("exit");
			jButtonCalcALL.setAction(getAbstractActionEXIT());
		}
		return jButtonCalcALL;
	}

	public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}



	@SuppressWarnings("serial")
	private AbstractAction getExport2AX() {
		if (export2AX == null) {
			export2AX = new AbstractAction("export2AX", null) {
				public void actionPerformed(ActionEvent evt) {
					String curDir = System.getProperty("user.dir");
					JFileChooser fc = new JFileChooser(curDir);

					fc.showOpenDialog(null);
					File curFile = fc.getSelectedFile();

					// System.out.println("selected file: "+curFile);
					// System.out.println("selected file get Absolute Path: "+curFile.getAbsolutePath());

					String name = curFile.getAbsolutePath();

					// String nomeFile = "default.txt";

					// if(name==null){
					// try {
					// new Sample("sample1", nomeFile);
					// } catch (Exception e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					// }else{
					try {
						jpt2AX newax = new jpt2AX();
						newax.jpt2AXcalc(name);
						// new Sample("sample1", name);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// }
			};
		}
		return export2AX;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(6, 5, 722, 400);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(getTxtpnCiaoATutti(), GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE)
						.addGap(40)
						.addComponent(getTextArea(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(getTextArea(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(407))
					.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(getTxtpnCiaoATutti(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(59, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
		}
		return panel;
	}
	private JMenuItem getPrintAnalyses() {
		if (printAnalyses == null) {
			printAnalyses = new JMenuItem("Save Analysis..non funziona");
			printAnalyses.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						int i = Sample.getNum_analysis_data_file();
						for (int j=0; j<i; j++){
							for (MineralPhase mfs: sample.getAnalysis_data_sets().get(j).getMfsArrayList()){
						
								 new printAnalysesALL(mfs);
							}
							}
					} catch (Exception e) {
						e.printStackTrace();
					}
					 
				}
			});
		}
		return printAnalyses;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JTextPane getTxtpnCiaoATutti() {
		if (txtpnCiaoATutti == null) {
			txtpnCiaoATutti = new JTextPane();
			txtpnCiaoATutti.setBackground(Color.LIGHT_GRAY);
			txtpnCiaoATutti.setForeground(Color.BLACK);
			txtpnCiaoATutti.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			txtpnCiaoATutti.setText("ciao a tutti, ci sto ancora lavorando.....\npercio' dovete avere pazienza.\n\n1) INPUT FILE: \nyou may find an example (input_format.txt). It must be a text file with TAB as separator. Those exported from excel are perfect. \nThe input file NEEDS as first column the variable Sample, as second Mineral. Sample is a text string defining the analysis while mineral may be text or number (double). All further columns are free and correspond to analyzed oxides. No specific orderd are requested if you put unrecognized oxides, don't worry the application will work but those oxides are skipped. \n\n1b) The list of mineral labels is in the file Mineral_Labels (probably not up to date). Commonly upper or lower cases are allowed. If some labels are missing please send me an e-mail (michele.zucali@uninmi.it) \n\n2) OUTPUT: dopo aver caricato i dati nel formato input (select & run), il programma vi butta fuori in automatico i risultati, PRIMA di selezionare il file INPUT potete selezionare dei formati di esportazione (XLS, KANEKO, AX, AMPH). Questo vi permette di ottenere i file INPUT in vari formati utili, almeno per me...\n\n2b) tipi di esportazioni:\n-2AX: legge il file di input e lo esporta nel formato per AX (thermocalc, HP)\n-2XLS: esporta il file di input già caricato per i fogli di calcolo di EXCEL\n-2WinAmph: esporta nel formato di input di WinAmph\n-2Kaneko: esporta nel formato richiesto dal foglio di excel per il termobaro di Kaneko\n\n3) Potete fare piu' cicli di calcolo senza chiudere il programma..credo\n\nciao\nMZ\n2/4/2015\n");
		}
		return txtpnCiaoATutti;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(479, 417, 136, 67);
			panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "calc", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JButton btnNewButton = new JButton("Mineral Recalc");
			btnNewButton.setToolTipText("select the input file and run the calculation");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					

					String curDir = System.getProperty("user.dir");
					JFileChooser fc = new JFileChooser(curDir);

					fc.showOpenDialog(null);
					File curFile = fc.getSelectedFile();
					setCurFile(curFile);
					
					System.out.println("selected file: " + curFile);
					System.out.println("selected file get Absolute Path: "
							+ curFile.getAbsolutePath());

					String name = curFile.getAbsolutePath();
					console.println("absolute path: " + curFile.getAbsolutePath());//path file dati
					
					console.println("parent path: " + curFile.getParent());//path folder dati
					
					console.println("user dir :"+System.getProperty("user.dir"));// path applicazione
					
					String nomeFile = "default.txt";
	//				console.println("\nXLS: "+MineralPhase.isXLSexport()+"\n");
					if (name == null) {
						try {
							new Sample("sample1", nomeFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						try {
							sample = new Sample("sample1", name);// legge file e aggiunge sample1
							// new Sample("sample1", name);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					console.println("FINITO");
					console.println("Results are in nomefile**_OUT_.LABEL**.xls");
					console.println(".......................");
					console.println("Michele.Zucali@unimi.it");
				}
			});
			panel_2.add(btnNewButton);
		}
		return panel_2;
	}


	
	private JRadioButton getRdbtnAmph() {
		if (rdbtnAmph == null) {
			rdbtnAmph = new JRadioButton("SI");
			buttonGroup_2.add(rdbtnAmph);

			rdbtnAmph.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MineralPhase.setAMPHexport(true);
					console.println("AMPH export: "+MineralPhase.isAMPHexport());
				}
			});
			rdbtnAmph.setBounds(224, 62, 43, 23);
		}
		return rdbtnAmph;
	}
	
	
	private JRadioButton getRdbtnAx() {
		if (rdbtnAx == null) {
			rdbtnAx = new JRadioButton("SI...");
			rdbtnAx.setToolTipText("boohhh");
		//	rdbtnAx = new JRadioButton("nuovo");
			rdbtnAx.setBounds(114, 27, 80, 23);
			rdbtnAx.setAction(getExport2AX());
			buttonGroup_1.add(rdbtnAx);
			rdbtnAx.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MineralPhase.setAXexport(true);
					console.println("AX export: "+MineralPhase.isAXexport());
				}
			});
		}
		return rdbtnAx;
	}
	
	private JRadioButton getRdbtnSi() {
		if (rdbtnSi == null) {
			rdbtnSi = new JRadioButton("SI");
			rdbtnSi.setBounds(114, 43, 98, 23);
			rdbtnSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MineralPhase.setAXexport(true);
					console.println("AX export: "+MineralPhase.isAXexport());
				}
			});
			rdbtnSi.setAction(getExport2AX());
		}
		return rdbtnSi;
	}
	
	
	
	
	
	
	
	
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setToolTipText("select the preferred file format exporting tools ");
			panel_1.setBorder(new TitledBorder(null, "Export", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(16, 403, 451, 95);
			panel_1.setLayout(null);
			
			JRadioButton rdbtnXlsSI = new JRadioButton("si");
			buttonGroup.add(rdbtnXlsSI);

			rdbtnXlsSI.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MineralPhase.setXLSexport(true);
					console.println("XLS export: "+MineralPhase.isXLSexport());
				}
			});
			JRadioButton rdbtnXlsNO = new JRadioButton("no");
			buttonGroup.add(rdbtnXlsNO);

			rdbtnXlsNO.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MineralPhase.setXLSexport(false);
					console.println("XLS export: "+MineralPhase.isXLSexport());
				}
			});			
			
			rdbtnXlsSI.setBounds(6, 27, 43, 23);
			rdbtnXlsNO.setBounds(54, 27, 48, 23);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.RED);
			separator.setBounds(114, 6, -20, 86);
			panel_1.add(separator);
			panel_1.add(rdbtnXlsSI);
			panel_1.add(rdbtnXlsNO);
			
			JRadioButton radioButton = new JRadioButton("si");
			radioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MineralPhase.setKANEKOexport(true);
					console.println("KANEKO export: "+MineralPhase.isKANEKOexport());
					
				}
			});
			buttonGroup_3.add(radioButton);
			
			
			radioButton.setBounds(334, 27, 48, 23);
			panel_1.add(radioButton);
			panel_1.add(getRdbtnAmph());
			
			JLabel lblXls = new JLabel("XLS");
			lblXls.setBounds(38, 15, 29, 16);
			panel_1.add(lblXls);
			
			JLabel lblAx = new JLabel("AX export");
			lblAx.setBounds(136, 15, 64, 16);
			panel_1.add(lblAx);
			
			JLabel lblAmph = new JLabel("AMPH");
			lblAmph.setBounds(255, 15, 61, 16);
			panel_1.add(lblAmph);
			
			JLabel lblKaneko = new JLabel("KANEKO");
			lblKaneko.setBounds(358, 15, 61, 16);
			panel_1.add(lblKaneko);
			panel_1.add(getSeparator_1());
			panel_1.add(getSeparator_2());
			panel_1.add(getSeparator_3());
			
			JRadioButton rdbtnBasta = new JRadioButton("NO");
			buttonGroup_1.add(rdbtnBasta);
			rdbtnBasta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MineralPhase.setAXexport(false);
					console.println("AX export: "+MineralPhase.isAXexport());
				}
			});
			rdbtnBasta.setBounds(114, 62, 86, 23);
			panel_1.add(rdbtnBasta);
			panel_1.add(getRadioButton_3());
			panel_1.add(getRadioButton_4());
			
			JButton btnExport = new JButton("options");
			btnExport.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					exportGUI = new Export();
					exportGUI.setLocationRelativeTo(null);
					exportGUI.setLocation(800, 500);
					exportGUI.setVisible(true);
					exportGUI.getTitle();
				}
			});
			btnExport.setBounds(0, 61, 117, 29);
			panel_1.add(btnExport);
			panel_1.add(getRdbtnAx());
			panel_1.add(getRdbtnSi());
			
			

		}
		return panel_1;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setOrientation(SwingConstants.VERTICAL);
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(212, 6, 18, 86);
		}
		return separator_1;
	}
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setOrientation(SwingConstants.VERTICAL);
			separator_2.setForeground(Color.BLACK);
			separator_2.setBounds(106, 6, 18, 86);
		}
		return separator_2;
	}
	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
			separator_3.setOrientation(SwingConstants.VERTICAL);
			separator_3.setForeground(Color.BLACK);
			separator_3.setBounds(328, 6, 18, 86);
		}
		return separator_3;
	}
	private JRadioButton getRadioButton_3() {
		if (radioButton_3 == null) {
			radioButton_3 = new JRadioButton("no");
			radioButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MineralPhase.setAMPHexport(false);
					console.println("AMPH export: " +MineralPhase.isAMPHexport());
				}
			});
			buttonGroup_2.add(radioButton_3);
			radioButton_3.setBounds(266, 62, 48, 23);
		}
		return radioButton_3;
	}
	private JRadioButton getRadioButton_4() {
		if (radioButton_4 == null) {
			radioButton_4 = new JRadioButton("no");
			radioButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MineralPhase.setKANEKOexport(false);
					console.println("KANEKO export: " +MineralPhase.isKANEKOexport());
				}
			});
			buttonGroup_3.add(radioButton_4);
			radioButton_4.setBounds(390, 27, 61, 23);
		}
		return radioButton_4;
	}
	
}
