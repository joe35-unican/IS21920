package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import es.unican.is2.AlarmaHogar.AlarmaHogar;

import java.awt.Font;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaAlarma {

	private JFrame frmAlarmaHogar;
	private int numpadPosY = 65;
	private int numpadPosX = 30;
	private int numpadTamY = 50;
	private int numpadTamX = 50;
	private int numpadTam2X = 75;
	private int ledPosX = 92;
	private int ledPosY = 268;
	private int ledTam = 26;
	private boolean numpadactivado = false;
	JTextPane pantallaMensajes = new JTextPane();
	JPanel panel = new JPanel();
	private boolean intrCodigo = false;
	private static AlarmaHogar alarma;
	private SimuladorEventos sim;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAlarma window = new PantallaAlarma();
					window.frmAlarmaHogar.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaAlarma() {
		initialize();
		alarma=new AlarmaHogar(this);
		sim = new SimuladorEventos(alarma);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlarmaHogar = new JFrame();
		frmAlarmaHogar.setTitle("Alarma");
		frmAlarmaHogar.setBounds(100, 100, 230, 340);
		frmAlarmaHogar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlarmaHogar.getContentPane().setLayout(null);
		
		
		pantallaMensajes.setFont(new Font("Tahoma", Font.BOLD, 14));
		pantallaMensajes.setForeground(new Color(0, 128, 0));
		pantallaMensajes.setText("Mensajes");
		pantallaMensajes.setBackground(Color.BLACK);
		pantallaMensajes.setEditable(false);
		pantallaMensajes.setBounds(30, 10, 150, 50);
		pantallaMensajes.setBorder(new LineBorder(new Color(100, 20, 50), 2));
		frmAlarmaHogar.getContentPane().add(pantallaMensajes);
		
		JButton digit1 = new JButton("1");
		digit1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("1");}});
		digit1.setBounds(numpadPosX, numpadPosY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit1);
		JButton digit2 = new JButton("2");
		digit2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("2");}});
		digit2.setBounds(numpadPosX+numpadTamX, numpadPosY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit2);
		JButton digit3 = new JButton("3");
		digit3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("3");}});
		digit3.setBounds(numpadPosX+2*numpadTamX, numpadPosY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit3);
		JButton digit4 = new JButton("4");
		digit4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("4");}});
		digit4.setBounds(numpadPosX, numpadPosY+numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit4);
		JButton digit5 = new JButton("5");
		digit5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("5");}});
		digit5.setBounds(numpadPosX+numpadTamX, numpadPosY+numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit5);
		JButton digit6 = new JButton("6");
		digit6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("6");}});
		digit6.setBounds(numpadPosX+2*numpadTamX, numpadPosY+numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit6);
		JButton digit7 = new JButton("7");
		digit7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("7");}});
		digit7.setBounds(numpadPosX, numpadPosY+2*numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit7);
		JButton digit8 = new JButton("8");
		digit8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("8");}});
		digit8.setBounds(numpadPosX+numpadTamX, numpadPosY+2*numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit8);
		JButton digit9 = new JButton("9");
		digit9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("9");}});
		digit9.setBounds(numpadPosX+2*numpadTamX, numpadPosY+2*numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit9);
		JButton btnAlarmaOn = new JButton("On");
		btnAlarmaOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {alarma.alarmaOn();}});
		btnAlarmaOn.setBounds(numpadPosX, numpadPosY+3*numpadTamY, numpadTam2X, numpadTamY);
		frmAlarmaHogar.getContentPane().add(btnAlarmaOn);
		JButton btnAlarmaOff = new JButton("Off");
		btnAlarmaOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				alarma.alarmaOff(pantallaMensajes.getText());
				intrCodigo=false;}});
		btnAlarmaOff.setBounds(numpadPosX+numpadTam2X, numpadPosY+3*numpadTamY, numpadTam2X, numpadTamY);
		frmAlarmaHogar.getContentPane().add(btnAlarmaOff);
		
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.RED);
		panel.setBounds(ledPosX, ledPosY, ledTam, ledTam);
		frmAlarmaHogar.getContentPane().add(panel);
		
		
	}
	
	public void MeterCodigo(String digit) {
		if(numpadactivado) {
			if (intrCodigo) {
				String t = pantallaMensajes.getText();
				pantallaMensajes.setText(t+digit);
			}else {
				pantallaMensajes.setText(digit);
				intrCodigo = true;
			}
		}
	}
	
	public void setLed (boolean encender) {
		if (encender) {
			panel.setBackground(Color.GREEN);
		}else{
			panel.setBackground(Color.RED);
		}
	}
	
	public void setMensaje(String s) {
		pantallaMensajes.setText(s);
	}

	public void setNumPadActivado(boolean npad) {
		// TODO Auto-generated method stub
		this.numpadactivado=npad;
	}
	public SimuladorEventos getSim() {
		return this.sim;
	}
}
