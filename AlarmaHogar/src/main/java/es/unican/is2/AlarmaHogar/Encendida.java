package es.unican.is2.AlarmaHogar;

public class Encendida extends AlarmaHogarEstado{
	
	public void alarmaOn(AlarmaHogar context){};
	public void alarmaOff(AlarmaHogar context,String c){};
	public void intruso(AlarmaHogar context){
		this.exitAction(context);
		AlarmaHogarEstado pe = getEstadoEsperandoDesactivacion();
		context.setState(pe);
		pe.entryAction(context);
		pe.doAction(context);
	};
	public void off(AlarmaHogar context){};
	public void entryAction(AlarmaHogar context){
		context.setNumpadActivado(false);
	};
	public void exitAction(AlarmaHogar context){
		context.getPiloto().encender();
		context.activarSensores();
	};
	public void doAction(AlarmaHogar context){};

}
