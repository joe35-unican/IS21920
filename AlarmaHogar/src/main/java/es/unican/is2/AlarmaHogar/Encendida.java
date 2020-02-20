package es.unican.is2.AlarmaHogar;

public class Encendida extends AlarmaHogarEstado{
	
	public void alarmaOn(AlarmaHogar context){};
	public void alarmaOff(AlarmaHogar context,String c){};
	@Override
	public void intruso(AlarmaHogar context){
		this.exitAction(context);
		AlarmaHogarEstado pe = getEstadoEsperandoDesactivacion();
		context.setState(pe);
		pe.entryAction(context);
		pe.doAction(context);
	};
	public void off(AlarmaHogar context){};
	@Override
	public void entryAction(AlarmaHogar context){
		context.getPiloto().encender();
		context.activarSensores();
		context.setNumpadActivado(false);
	};
	@Override
	public void exitAction(AlarmaHogar context){};
	public void doAction(AlarmaHogar context){};

}
