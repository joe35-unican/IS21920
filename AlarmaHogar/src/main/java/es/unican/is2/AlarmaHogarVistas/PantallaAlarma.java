package es.unican.is2.AlarmaHogarVistas;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;


import java.awt.Font;

@SuppressWarnings("serial")
public class PantallaAlarma extends JFrame {

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
	private SimuladorEventos sim;
	private JButton digit1,digit2,digit3,digit4,digit5,digit6,digit7,digit8,digit9,btnAlarmaOn,btnAlarmaOff;

	/**
	 * Create the application.
	 */
	public PantallaAlarma() {
		initialize();
		this.frmAlarmaHogar.setVisible(true);
		sim = new SimuladorEventos();
		
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
		pantallaMensajes.setText("Alarma Apagada");
		pantallaMensajes.setBackground(Color.BLACK);
		pantallaMensajes.setEditable(false);
		pantallaMensajes.setBounds(30, 10, 150, 50);
		pantallaMensajes.setBorder(new LineBorder(new Color(100, 20, 50), 2));
		frmAlarmaHogar.getContentPane().add(pantallaMensajes);
		
		digit1 = new JButton("1");
		digit1.setBounds(numpadPosX, numpadPosY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit1);
		digit2 = new JButton("2");
		digit2.setBounds(numpadPosX+numpadTamX, numpadPosY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit2);
		digit3 = new JButton("3");
		digit3.setBounds(numpadPosX+2*numpadTamX, numpadPosY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit3);
		digit4 = new JButton("4");
		digit4.setBounds(numpadPosX, numpadPosY+numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit4);
		digit5 = new JButton("5");
		digit5.setBounds(numpadPosX+numpadTamX, numpadPosY+numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit5);
		digit6 = new JButton("6");
		digit6.setBounds(numpadPosX+2*numpadTamX, numpadPosY+numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit6);
		digit7 = new JButton("7");
		digit7.setBounds(numpadPosX, numpadPosY+2*numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit7);
		digit8 = new JButton("8");
		digit8.setBounds(numpadPosX+numpadTamX, numpadPosY+2*numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit8);
		digit9 = new JButton("9");
		digit9.setBounds(numpadPosX+2*numpadTamX, numpadPosY+2*numpadTamY, numpadTamY, numpadTamY);
		frmAlarmaHogar.getContentPane().add(digit9);
		btnAlarmaOn = new JButton("On");
		btnAlarmaOn.setBounds(numpadPosX, numpadPosY+3*numpadTamY, numpadTam2X, numpadTamY);
		frmAlarmaHogar.getContentPane().add(btnAlarmaOn);
		btnAlarmaOff = new JButton("Off");
		btnAlarmaOff.setBounds(numpadPosX+numpadTam2X, numpadPosY+3*numpadTamY, numpadTam2X, numpadTamY);
		frmAlarmaHogar.getContentPane().add(btnAlarmaOff);
		
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.RED);
		panel.setBounds(ledPosX, ledPosY, ledTam, ledTam);
		frmAlarmaHogar.getContentPane().add(panel);
		
		
	}
	
	public boolean isIntrCodigo() {
		return intrCodigo;
	}

	public void setIntrCodigo(boolean intrCodigo) {
		this.intrCodigo = intrCodigo;
	}

	public boolean isNumpadactivado() {
		return numpadactivado;
	}

	public JTextPane getPantallaMensajes() {
		return pantallaMensajes;
	}

	public void setLed (boolean encender) {
		if (encender) {
			panel.setBackground(Color.GREEN);
		}else{
			panel.setBackground(Color.RED);
		}
	}

	public void setNumPadActivado(boolean npad) {
		// TODO Auto-generated method stub
		this.numpadactivado=npad;
	}
	public SimuladorEventos getSim() {
		return this.sim;
	}

	public JButton getDigit1() {
		return digit1;
	}

	public JButton getDigit2() {
		return digit2;
	}

	public JButton getDigit3() {
		return digit3;
	}

	public JButton getDigit4() {
		return digit4;
	}

	public JButton getDigit5() {
		return digit5;
	}

	public JButton getDigit6() {
		return digit6;
	}

	public JButton getDigit7() {
		return digit7;
	}

	public JButton getDigit8() {
		return digit8;
	}

	public JButton getDigit9() {
		return digit9;
	}

	public JButton getBtnAlarmaOn() {
		return btnAlarmaOn;
	}

	public JButton getBtnAlarmaOff() {
		return btnAlarmaOff;
	}
	
	
}
