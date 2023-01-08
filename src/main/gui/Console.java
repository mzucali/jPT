package main.gui;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("unused")
public class Console extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea jTextArea_output;
	private JScrollPane jScrollPane1;

	/**
	* Auto-generated main method to display this JFrame
	*/
/*	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Console inst = new Console();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public Console() {
		super();
		initGUI();
		this.setLocationRelativeTo(null);
		this.setLocation(800, 0);
		this.setVisible(true);
		this.getTitle();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("jPT output terminal SVenSVensson");
			this.setLocation(new java.awt.Point(0, 44));
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 278));
				{
					jTextArea_output = new JTextArea();
					jTextArea_output.setLineWrap(true);
					jScrollPane1.setViewportView(jTextArea_output);
					jTextArea_output.setEditable(false);
				}
			}
			pack();
			this.setSize(580, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void println(String aString){
		jTextArea_output.append(aString);
		jTextArea_output.append("\n");
//        jTextArea1.setEditable(false);
        //jTextArea1.setText(string);
       // jTextArea1.append(string);
    //    jTextArea1.append("string2" + "\n"+string);
      //  jTextArea1.append("\n");
        return;
	}


}
