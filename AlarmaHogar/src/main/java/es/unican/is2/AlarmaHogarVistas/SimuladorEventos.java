package es.unican.is2.AlarmaHogarVistas;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SimuladorEventos {

	private JFrame frmSimuladorEventos;
	private JLabel lblNewLabel = new JLabel("");
	private JButton btnOff,btnIntruso;


	/**
	 * Create the application.
	 * @param alarma 
	 */
	public SimuladorEventos() {
		
		initialize();
		this.frmSimuladorEventos.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimuladorEventos = new JFrame();
		frmSimuladorEventos.setTitle("Simulador Eventos");
		frmSimuladorEventos.setBounds(350, 100, 300, 120);
		frmSimuladorEventos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSimuladorEventos.getContentPane().setLayout(null);
		
		btnOff = new JButton("Off");
		btnOff.setBounds(10, 20, 120, 30);
		frmSimuladorEventos.getContentPane().add(btnOff);
		
		btnIntruso = new JButton("Intruso");
		btnIntruso.setBounds(150, 20, 120, 30);
		frmSimuladorEventos.getContentPane().add(btnIntruso);
		
		lblNewLabel.setBounds(10, 60, 260, 14);
		frmSimuladorEventos.getContentPane().add(lblNewLabel);
	}
	public void addTexto(String s) {
		this.lblNewLabel.setText(s);
	}

	public JButton getBtnOff() {
		return btnOff;
	}

	public JButton getBtnIntruso() {
		return btnIntruso;
	}
}
