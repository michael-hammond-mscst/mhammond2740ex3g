package mhammond2740ex3g;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PayrollForm extends JFrame {
	
	//private Information employee;
	private Payroll payroll;

	private JPanel contentPane;
	private JList employeeList;
	private JTextField hoursTextField;
	private JLabel totalHoursLabel;
	private JLabel grossPayLabel;
	private DefaultListModel employeeListModel;
	private JTextField empIdTextField;
	private JTextField empNameTextField;
	private JTextField payRateTextField;
	private JButton plusButton;
	private JButton btnClear;
	private JButton updateButton;
	private PayrollObjMapper payrollObjMapper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollForm frame = new PayrollForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PayrollForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				do_this_windowClosing(arg0);
			}
		});
		setTitle("MHammond 2740 Ex3G");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectEmployee = new JLabel("Select employee:");
		lblSelectEmployee.setBounds(26, 11, 107, 14);
		contentPane.add(lblSelectEmployee);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(73, 36, 383, 94);
		contentPane.add(scrollPane);
		
//		employeeListModel = new DefaultListModel();
//		employeeListModel.addElement(new Payroll(101, "David Johnson", 10.0));
//		employeeListModel.addElement(new Payroll(102, "Patti Waigand", 20.0));
//		employeeListModel.addElement(new Payroll(103, "Lyle Stelter", 30.0));
//		employeeListModel.addElement(new Payroll(104, "Neva Burdick", 40.0));
//		employeeListModel.addElement(new Payroll(105, "Lisa Laing", 50.0));
		payrollObjMapper = new PayrollObjMapper("exercise3g.txt");
		employeeListModel = payrollObjMapper.getAllPayroll();
		
		employeeList = new JList(employeeListModel);
		employeeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_employeeList_mouseClicked(arg0);
			}
		});
		employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(employeeList);
		
		JLabel lblEmployeeId = new JLabel("Employee ID(>100):");
		lblEmployeeId.setBounds(26, 152, 144, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee name:");
		lblEmployeeName.setBounds(26, 192, 144, 14);
		contentPane.add(lblEmployeeName);
		
		JLabel lblPayRate = new JLabel("Pay rate(7.25 - 100):");
		lblPayRate.setBounds(26, 228, 171, 14);
		contentPane.add(lblPayRate);
		
		JLabel lblEnterHours = new JLabel("Enter hours(0.1 - 20.0):");
		lblEnterHours.setBounds(26, 253, 171, 14);
		contentPane.add(lblEnterHours);
		
		hoursTextField = new JTextField();
		hoursTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_hoursTextField_focusGained(arg0);
			}
		});
		hoursTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		hoursTextField.setText("0.00");
		hoursTextField.setBounds(207, 250, 86, 20);
		contentPane.add(hoursTextField);
		hoursTextField.setColumns(10);
		
		JLabel lblTotalHours = new JLabel("Total hours:");
		lblTotalHours.setBounds(26, 278, 77, 14);
		contentPane.add(lblTotalHours);
		
		totalHoursLabel = new JLabel("0.00");
		totalHoursLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalHoursLabel.setBounds(207, 281, 86, 14);
		contentPane.add(totalHoursLabel);
		
		JLabel lblGrossPay = new JLabel("Gross pay:");
		lblGrossPay.setBounds(26, 303, 77, 14);
		contentPane.add(lblGrossPay);
		
		grossPayLabel = new JLabel("$0.00");
		grossPayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		grossPayLabel.setBounds(207, 306, 86, 14);
		contentPane.add(grossPayLabel);
		
		JButton btnClearForm = new JButton("Clear Form");
		btnClearForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnClearForm_actionPerformed(e);
			}
		});
		btnClearForm.setBounds(314, 332, 118, 23);
		contentPane.add(btnClearForm);
		
		plusButton = new JButton("+");
		plusButton.setEnabled(false);
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_plusButton_actionPerformed(arg0);
			}
		});
		plusButton.setBounds(303, 249, 41, 23);
		contentPane.add(plusButton);
		
		btnClear = new JButton("Clear");
		btnClear.setEnabled(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnClear_actionPerformed(e);
			}
		});
		btnClear.setBounds(354, 249, 89, 23);
		contentPane.add(btnClear);
		
		empIdTextField = new JTextField();
		empIdTextField.setText("000");
		empIdTextField.setBounds(207, 149, 86, 20);
		contentPane.add(empIdTextField);
		empIdTextField.setColumns(10);
		
		empNameTextField = new JTextField();
		empNameTextField.setBounds(207, 189, 167, 20);
		contentPane.add(empNameTextField);
		empNameTextField.setColumns(10);
		
		payRateTextField = new JTextField();
		payRateTextField.setText("7.25");
		payRateTextField.setBounds(207, 225, 86, 20);
		contentPane.add(payRateTextField);
		payRateTextField.setColumns(10);
		
		updateButton = new JButton("Update");
		updateButton.setEnabled(false);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_updateButton_actionPerformed(arg0);
			}
		});
		updateButton.setBounds(144, 332, 89, 23);
		contentPane.add(updateButton);
	}
	
	protected void do_employeeList_mouseClicked(MouseEvent arg0) {
		Payroll payroll = (Payroll) employeeList.getSelectedValue();
		this.empIdTextField.setText(Integer.toString((payroll.getId())));
		this.empNameTextField.setText(payroll.getName());
		DecimalFormat dollarFmt = new DecimalFormat("$#.00");
		this.payRateTextField.setText(dollarFmt.format(payroll.getPayRate()));
		this.hoursTextField.setText("0.00");
		this.grossPayLabel.setText("$0.00");
		this.hoursTextField.requestFocus();
		this.plusButton.setEnabled(true);
		this.btnClear.setEnabled(true);
		this.updateButton.setEnabled(true);
	}
	protected void do_plusButton_actionPerformed(ActionEvent arg0) {	
		Payroll payroll = (Payroll) employeeList.getSelectedValue();
		double hours = Double.parseDouble(this.hoursTextField.getText());
		
		if (payroll.addHours(hours)) {
		DecimalFormat hoursFmt = new DecimalFormat("##0.00");
		this.totalHoursLabel.setText(hoursFmt.format(payroll.getHours()));
		DecimalFormat dollarFmt = new DecimalFormat("$#,##0.00");
		this.grossPayLabel.setText(dollarFmt.format(payroll.calcGrossPay()));
		this.hoursTextField.setText("0.00");
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid hours.  \nMust be in range 0.1 - 20.0");
		}
		this.hoursTextField.requestFocus();
	}
	protected void do_btnClear_actionPerformed(ActionEvent e) {
		//Payroll payroll = <get selected payroll object>
		Payroll payroll = (Payroll) employeeList.getSelectedValue();
		//set payroll object's hours to 0
		payroll.setHours(0);
		//Display 0.00 in totalHoursLabel, grossPayLabel, and hoursTextField
		this.totalHoursLabel.setText("0.00");
		this.grossPayLabel.setText("$0.00");
		this.hoursTextField.setText("0.00");
		this.hoursTextField.requestFocus();
	}
	protected void do_btnClearForm_actionPerformed(ActionEvent e) {
		//Set labels and textField back to initial values
		this.totalHoursLabel.setText("0.00");
		this.empNameTextField.setText("");
		this.empIdTextField.setText("0");
		this.hoursTextField.setText("0.00");
		this.grossPayLabel.setText("$0.00");
		this.payRateTextField.setText("$0.00");
		this.hoursTextField.requestFocus();
		this.employeeList.clearSelection();
		this.plusButton.setEnabled(false);
		this.btnClear.setEnabled(false);
		this.updateButton.setEnabled(false);
	}
	protected void do_hoursTextField_focusGained(FocusEvent arg0) {
		hoursTextField.selectAll();
	}
	protected void do_updateButton_actionPerformed(ActionEvent arg0) {
		int id = Integer.parseInt(empIdTextField.getText());
		double rate = Double.parseDouble(payRateTextField.getText());
		String name = empNameTextField.getText();
		Payroll payroll = (Payroll) employeeList.getSelectedValue();

		if (!payroll.setId(id)) {
		    JOptionPane.showMessageDialog(null, "Invalid employee ID. \nMust be > 100");
			empIdTextField.setText("101");
			empIdTextField.requestFocus();
		}
		if (!payroll.setPayRate(rate)) {
			JOptionPane.showMessageDialog(null, "Invalid pay rate. \nMust be inbetween 7.25 and 100.0");
			payRateTextField.setText("7.25");
			payRateTextField.requestFocus();
		}
		if (payroll.setName(name)) {
		    JOptionPane.showMessageDialog(null, "Invalid Name. \nMust Name is required");
			empNameTextField.setText("");
			empNameTextField.requestFocus();
		}
		employeeList.repaint();
	}
	protected void do_this_windowClosing(WindowEvent arg0) {
		if (payrollObjMapper != null)
			payrollObjMapper.writeAllPayroll(employeeListModel);
	}
}