package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import es.unican.is2.AlarmaHogar.AlarmaHogar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimuladorEventos {

	private JFrame frmSimuladorEventos;
	private AlarmaHogar alarma;
	JLabel lblNewLabel = new JLabel("");


	/**
	 * Create the application.
	 * @param alarma 
	 */
	public SimuladorEventos(AlarmaHogar alarma) {
		
		initialize();
		this.alarma=alarma;
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
		
		JButton btnOff = new JButton("Off");
		btnOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				alarma.off();
			}
		});
		btnOff.setBounds(10, 20, 120, 30);
		frmSimuladorEventos.getContentPane().add(btnOff);
		
		JButton btnIntruso = new JButton("Intruso");
		btnIntruso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alarma.intruso();
			}
		});
		btnIntruso.setBounds(150, 20, 120, 30);
		frmSimuladorEventos.getContentPane().add(btnIntruso);
		
		
		lblNewLabel.setBounds(10, 60, 260, 14);
		frmSimuladorEventos.getContentPane().add(lblNewLabel);
	}
	public void addTexto(String s) {
		this.lblNewLabel.setText(s);
	}
}
