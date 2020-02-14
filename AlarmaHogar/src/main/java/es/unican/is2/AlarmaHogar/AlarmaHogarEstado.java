package es.unican.is2.AlarmaHogar;

public abstract class AlarmaHogarEstado {
	
	
	private static Apagada estadoApagada = new Apagada();
	private static Encendida estadoEncendida = new Encendida();
	private static EsperandoSalida estadoEsperandoSalida = new EsperandoSalida();
	private static EsperandoDesactivacion estadoEsperandoDesactivacion = new EsperandoDesactivacion();
	private static DetectadoIntruso estadoDetectadoIntruso = new DetectadoIntruso();

	public static AlarmaHogarEstado init(AlarmaHogar context) {
		estadoApagada.entryAction(context);
		return estadoApagada;
	}
	
	public void alarmaOn(AlarmaHogar context){};
	public void alarmaOff(AlarmaHogar context, String c){};
	public void intruso(AlarmaHogar context){};
	public void off(AlarmaHogar context){};
	public void entryAction(AlarmaHogar context){};
	public void exitAction(AlarmaHogar context){};
	public void doAction(AlarmaHogar context){};
	
	public AlarmaHogarEstado getEstadoApagada() {
		return estadoApagada;
	}
	public AlarmaHogarEstado getEstadoEncendida() {
		return estadoEncendida;
	}
	public AlarmaHogarEstado getEstadoEsperandoSalida() {
		return estadoEsperandoSalida;
	}
	public AlarmaHogarEstado getEstadoEsperandoDesactivacion() {
		return estadoEsperandoDesactivacion;
	}
	public AlarmaHogarEstado getEstadoDetectadoIntruso() {
		return estadoDetectadoIntruso;
	}
	

}
