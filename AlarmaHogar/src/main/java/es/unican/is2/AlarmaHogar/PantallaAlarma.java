package es.unican.is2.AlarmaHogar;

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
import java.awt.Font;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Insets;
import java.awt.Point;

public class PantallaAlarma {

	private JFrame frmAlarmaHogar;
	private int numpadPosY = 65;
	private int numpadPosX = 30;
	private int numpadTamY = 40;
	private int numpadTamX = 40;
	private int numpadTam2X = 60;
	private int ledPosX = 77;
	private int ledPosY = 228;
	private int ledTam = 26;
	

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlarmaHogar = new JFrame();
		frmAlarmaHogar.setTitle("Alarma");
		frmAlarmaHogar.setBounds(100, 100, 200, 300);
		frmAlarmaHogar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlarmaHogar.getContentPane().setLayout(null);
		
		JButton digit1 = new JButton("1");
		digit1.setBounds(numpadPosX, numpadPosY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit1);
		JButton digit2 = new JButton("2");
		digit2.setBounds(numpadPosX+numpadTamX, numpadPosY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit2);
		JButton digit3 = new JButton("3");
		digit3.setBounds(numpadPosX+2*numpadTamX, numpadPosY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit3);
		JButton digit4 = new JButton("4");
		digit4.setBounds(numpadPosX, numpadPosY+numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit4);
		JButton digit5 = new JButton("5");
		digit5.setBounds(numpadPosX+numpadTamX, numpadPosY+numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit5);
		JButton digit6 = new JButton("6");
		digit6.setBounds(numpadPosX+2*numpadTamX, numpadPosY+numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit6);
		JButton digit7 = new JButton("7");
		digit7.setBounds(numpadPosX, numpadPosY+2*numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit7);
		JButton digit8 = new JButton("8");
		digit8.setBounds(numpadPosX+numpadTamX, numpadPosY+2*numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit8);
		JButton digit9 = new JButton("9");
		digit9.setBounds(numpadPosX+2*numpadTamX, numpadPosY+2*numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit9);
		JButton btnAlarmaOn = new JButton("On");
		btnAlarmaOn.setBounds(numpadPosX, numpadPosY+3*numpadTamY, numpadTam2X, numpadTamY);
		frmAlarmaHogar.getContentPane().add(btnAlarmaOn);
		JButton btnAlarmaOff = new JButton("Off");
		btnAlarmaOff.setBounds(numpadPosX+numpadTam2X, numpadPosY+3*numpadTamY, numpadTam2X, numpadTamY);
		frmAlarmaHogar.getContentPane().add(btnAlarmaOff);
		
		JTextPane pantallaMensajes = new JTextPane();
		pantallaMensajes.setFont(new Font("Tahoma", Font.BOLD, 14));
		pantallaMensajes.setForeground(new Color(0, 128, 0));
		pantallaMensajes.setText("Mensajes");
		pantallaMensajes.setBackground(Color.BLACK);
		pantallaMensajes.setEditable(false);
		pantallaMensajes.setBounds(30, 10, 120, 50);
		pantallaMensajes.setBorder(new LineBorder(new Color(100, 20, 50), 2));
		frmAlarmaHogar.getContentPane().add(pantallaMensajes);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.GREEN);
		panel.setBounds(ledPosX, ledPosY, ledTam, ledTam);
		frmAlarmaHogar.getContentPane().add(panel);
		
		
	}
}
