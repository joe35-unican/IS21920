package es.unican.is2.AlarmaHogarControlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import es.unican.is2.AlarmaHogarModelo.AlarmaHogar;
import es.unican.is2.AlarmaHogarVistas.PantallaAlarma;

public class AlarmaHogarControlador implements PropertyChangeListener{
	
	private PantallaAlarma vista;
	private AlarmaHogar modelo;
	
	public AlarmaHogarControlador(PantallaAlarma v, AlarmaHogar m) {
		this.vista=v;
		this.modelo=m;
		modelo.addPropertyChangeListener(this);
		vista.getDigit1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("1");}});
		vista.getDigit2().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("2");}});
		vista.getDigit3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("3");}});
		vista.getDigit4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("4");}});
		vista.getDigit5().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("5");}});
		vista.getDigit6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("6");}});
		vista.getDigit7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("7");}});
		vista.getDigit8().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("8");}});
		vista.getDigit9().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {MeterCodigo("9");}});
		vista.getBtnAlarmaOn().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {modelo.alarmaOn();}});
		vista.getBtnAlarmaOff().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modelo.alarmaOff(vista.getPantallaMensajes().getText());
				vista.setIntrCodigo(false);}});
		vista.getSim().getBtnIntruso().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {modelo.intruso();}});
		vista.getSim().getBtnOff().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {modelo.off();}});
	}
	
	

	public void propertyChange(PropertyChangeEvent e) {
		if (e.getPropertyName().equals("piloto")) {
			Integer piloto = (Integer) e.getNewValue();
			switch (piloto) {
			case 0:
				vista.setLed (false);
				break;
			case 1:
				vista.setLed(true);
				break;
			default:
				break;
			}
		}else if (e.getPropertyName().equals("texto")) {
			String texto = (String) e.getNewValue();
			vista.getPantallaMensajes().setText(texto);
		}else if (e.getPropertyName().equals("textosim")) {
			String texto = (String) e.getNewValue();
			vista.getSim().addTexto(texto);
		}else if (e.getPropertyName().equals("numpad")) {
			Integer numpad = (Integer) e.getNewValue();
			switch (numpad) {
			case 0:
				vista.setNumPadActivado(false);
				break;
			case 1:
				vista.setNumPadActivado(true);
			default:
				break;
			}
		}else if (e.getPropertyName().equals("intrcod")) {
			Integer intrcod = (Integer) e.getNewValue();
			switch (intrcod) {
			case 0:
				vista.setIntrCodigo(false);
				break;
			case 1:
				vista.setIntrCodigo(true);
			default:
				break;
			}
		}
		
	}
	
	public void MeterCodigo(String digit) {
		if(vista.isNumpadactivado()) {
			if (vista.isIntrCodigo()) {
				String t = vista.getPantallaMensajes().getText();
				vista.getPantallaMensajes().setText(t+digit);
			}else {
				vista.getPantallaMensajes().setText(digit);
				vista.setIntrCodigo(true);
			}
		}
	}

}
