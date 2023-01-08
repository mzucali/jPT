package main.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

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
@SuppressWarnings("serial")
public class InfoPanel extends javax.swing.JFrame {
	private JPanel jPanelInfo;
	private JTextPane jTextPaneInfo;
	private JButton jButtonclose;
	private AbstractAction close;
	private JEditorPane jEditorPaneInfo;
	private JTextArea jTextAreaInfo;

	/**
	* Auto-generated main method to display this JFrame
	*/
	
		public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			InfoPanel info = new InfoPanel();
			info.setLocationRelativeTo(null);
			info.setVisible(true);
		}
	});
}
	
	
	
	public InfoPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("jMineralCalc Info");
			{
				jPanelInfo = new JPanel();
				getContentPane().add(jPanelInfo, BorderLayout.CENTER);
				{
					jTextPaneInfo = new JTextPane();
					jPanelInfo.add(jTextPaneInfo);
					jTextPaneInfo.setText("http://users.unimi.it/mzucali/jMineralCalc");
					jTextPaneInfo.setPreferredSize(new java.awt.Dimension(357, 50));
				}
				{
					jTextAreaInfo = new JTextArea();
					jPanelInfo.add(jTextAreaInfo);
					jTextAreaInfo.setText("http://users.unimi.it/mzucali/jMineralCalc");
					jTextAreaInfo.setPreferredSize(new java.awt.Dimension(163, 61));
				}
				{
					jEditorPaneInfo = new JEditorPane();
					jPanelInfo.add(jEditorPaneInfo);
					jPanelInfo.add(getJButtonclose());
					jEditorPaneInfo.setText("http://users.unimi.it/mzucali/jMineralCalc");
					jEditorPaneInfo.setPreferredSize(new java.awt.Dimension(176, 41));
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getClose() {
		if(close == null) {
			close = new AbstractAction("close", null) {
				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
				}
			};
		}
		return close;
	}
	
	private JButton getJButtonclose() {
		if(jButtonclose == null) {
			jButtonclose = new JButton();
			jButtonclose.setText("close");
			jButtonclose.setAction(getClose());
		}
		return jButtonclose;
	}

}
