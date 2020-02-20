package es.unican.is2.AlarmaHogar;

public class Apagada extends AlarmaHogarEstado{

	@Override
	public void alarmaOn(AlarmaHogar context){
		this.exitAction(context);
		AlarmaHogarEstado pe = getEstadoEsperandoSalida();
		context.getPiloto().parpadear();
		context.setState(pe);
		pe.entryAction(context);
		pe.doAction(context);
	};
	
	public void alarmaOff(AlarmaHogar context,String c){};
	public void intruso(AlarmaHogar context){};
	public void off(AlarmaHogar context){};
	@Override
	public void entryAction(AlarmaHogar context){
		context.setMen("Alarma Apagada");
		context.setNumpadActivado(false);
		context.getPiloto().apagar();
		context.setIntentos(0);
	};
	public void exitAction(AlarmaHogar context){};
	public void doAction(AlarmaHogar context){};
}
