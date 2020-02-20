package es.unican.is2.AlarmaHogar;

public class AlarmaHogar {
	
	private AlarmaHogarEstado state;
	private int intervaloSalida = 10;
	private	int intervaloDesactivacion = 10;
	private int nintentos = 0;
	static final int INTENTOS = 3;
	private String codigoDesactivacion = "1111";
	private Piloto piloto;
	private PantallaAlarma vista;
	

	
	public AlarmaHogar(PantallaAlarma vista) {
		this.vista=vista;
		this.piloto=new Piloto(vista);
		state = AlarmaHogarEstado.init(this);
		
	}
	
	public void notificarCentralita() {
		vista.setMensaje("Se�al centralita");
	}
	
	public void desactivarSensores() {
		vista.setMensaje("Sensores Desactivados");
	}
	
	public void activarSensores() {
		vista.setMensaje("Sensores Activados");
		
	}
	
	public void alarmaOn() {
		state.alarmaOn(this);
		vista.setMensaje("Activandose");
	}
	
	public void alarmaOff(String c) {
		state.alarmaOff(this,c);		
	}
	
	public void intruso() {
		state.intruso(this);
		setNumpadActivado(true);
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
	
	public void setNumpadActivado(boolean npad) {
		vista.setNumPadActivado(npad);
	}
	
	public void setMen(String s) {
		vista.setMensaje(s);
	}
}
