package es.unican.is2.AlarmaHogarModelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AlarmaHogar {
	
	private AlarmaHogarEstado state;
	private int intervaloSalida = 10*1000;
	private	int intervaloDesactivacion = 10*1000;
	private int nintentos = 0;
	static final int INTENTOS = 3;
	private String codigoDesactivacion = "1111";
	private Piloto piloto;
	private PropertyChangeSupport chsupp = new PropertyChangeSupport(this);
	

	
	public AlarmaHogar() {
		piloto = new Piloto(this);
		state = AlarmaHogarEstado.init(this);
		
	}
	
	public void notificarCentralita() {
		chsupp.firePropertyChange("texto","","Señal Centralita");
		chsupp.firePropertyChange("textosim","","Señal Centralita");
	}
	
	public void desactivarSensores() {
		chsupp.firePropertyChange("texto","","Sensores Desactivados");
		chsupp.firePropertyChange("textosim","","");
	}
	
	public void activarSensores() {
		chsupp.firePropertyChange("texto","","Sensores Activados");
		
	}
	
	public void alarmaOn() {
		state.alarmaOn(this);
		chsupp.firePropertyChange("texto","","Activandose");
	}
	
	public void alarmaOff(String c) {
		state.alarmaOff(this,c);		
	}
	
	public void intruso() {
		state.intruso(this);
		chsupp.firePropertyChange("textosim","","Intruso Detectado");
		chsupp.firePropertyChange("numpad","",1);
	}
	
	public void off() {
		state.off(this);
	}
	
	public void setState (AlarmaHogarEstado s) {
		this.state = s;
	}
	
	public void setIntervaloSalida (int t) {
		this.intervaloSalida = t;
	}
	
	public void setIntervaloDesactivacion (int t) {
		this.intervaloDesactivacion = t;
	}
	
	public void setIntentos (int i) {
		this.nintentos = i;
	}
	
	public void incrementoIntentos () {
		this.nintentos++;
	}
	
	public void setCodigoDesactivacion(String c) {
		this.codigoDesactivacion = c;
	}

	public Piloto getPiloto() {
		return this.piloto;
		
	}

	public String getCodigo() {
		return this.codigoDesactivacion;
	}

	public int getIntentos() {
		// TODO Auto-generated method stub
		return this.nintentos;
	}
	
	// Mover al controlador todas las llamadas a esta funcion y borrala
	//public void setNumpadActivado(boolean npad) {
		//vista.setNumPadActivado(npad);
	//}
	
	// Se hace con el listener -> Borrar
	// Comprobar que se pone "" en todos los casos necesarios
	//public void setMen(String s) {
		//vista.setMensaje(s);
		//if (vista.getSim()!=null) {
			//vista.getSim().addTexto("");
		//}
	//}

	public int getIntervaloSalida() {
		// TODO Auto-generated method stub
		return this.intervaloSalida;
	}
	public int getIntervaloDesactivacion() {
		// TODO Auto-generated method stub
		return this.intervaloDesactivacion;
	}
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		chsupp.addPropertyChangeListener(listener);
	}

	public PropertyChangeSupport getChsupp() {
		return chsupp;
	}
}
