package main.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridLayout;

import javax.swing.SpringLayout;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;

public class Export extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Export dialog = new Export();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Export() {
		setTitle("export tab");
		setBounds(100, 100, 599, 285);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 224, 599, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("done");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 599, 223);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		String excel[]= {"yes", "no"};
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Excel Spreadsheet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(189, 6, 151, 76);
		panel.add(panel_1);
		panel_1.setLayout(null);
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_1 = new JComboBox(excel);
		comboBox_1.setBounds(6, 43, 139, 27);
		panel_1.add(comboBox_1);
		
		String ax[]= {"yes", "no"};	
		JPanel panel_ax = new JPanel();
		panel_ax.setBorder(new TitledBorder(null, "AX TC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_ax.setBounds(352, 6, 151, 76);
		panel.add(panel_ax);
		panel_ax.setLayout(null);
		JComboBox comboBox_ax = new JComboBox(ax);
		comboBox_ax.setBounds(6, 43, 139, 27);
		panel_ax.add(comboBox_ax);
		

		String kaneko[]= {"yes", "no"};	
		JPanel panel_kaneko = new JPanel();
		panel_kaneko.setBorder(new TitledBorder(null, "KANEKO Spreadsheet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_kaneko.setBounds(26, 94, 151, 76);
		panel.add(panel_kaneko);
		panel_kaneko.setLayout(null);
		JComboBox comboBox_kaneko = new JComboBox(kaneko);
		comboBox_kaneko.setBounds(6, 43, 139, 27);
		panel_kaneko.add(comboBox_kaneko);
		
		
		String amph[]= {"yes", "no"};	
		JPanel panel_amph = new JPanel();
		panel_amph.setBorder(new TitledBorder(null, "WINAMPH Spreadsheet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_amph.setBounds(26, 6, 151, 76);
		panel.add(panel_amph);
		panel_amph.setLayout(null);
		JComboBox comboBox_amph = new JComboBox(amph);
		comboBox_amph.setBounds(6, 43, 139, 27);
		panel_amph.add(comboBox_amph);	
		
		String unk01[]= {"yes", "no"};	
		JPanel panel_unk01 = new JPanel();
		panel_unk01.setBorder(new TitledBorder(null, "UNK01 Spreadsheet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_unk01.setBounds(189, 94, 151, 76);
		panel.add(panel_unk01);
		panel_unk01.setLayout(null);
		JComboBox comboBox_unk01 = new JComboBox(unk01);
		comboBox_unk01.setBounds(6, 43, 139, 27);
		panel_unk01.add(comboBox_unk01);		
		
		String unk02[]= {"yes", "no"};	
		JPanel panel_unk02 = new JPanel();
		panel_unk02.setBorder(new TitledBorder(null, "UNK02 Spreadsheet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_unk02.setBounds(352, 94, 151, 76);
		panel.add(panel_unk02);
		panel_unk02.setLayout(null);
		JComboBox comboBox_unk02 = new JComboBox(unk02);
		comboBox_unk02.setBounds(6, 43, 139, 27);
		panel_unk02.add(comboBox_unk02);		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(396, 177, 161, 29);
		panel.add(tglbtnNewToggleButton);
		
		JList list = new JList();
		list.setBounds(214, 182, 146, 29);
		panel.add(list);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(36, 182, 124, 28);
		panel.add(spinner);
	}
}
