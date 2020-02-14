package es.unican.is2.AlarmaHogar;

public class DetectadoIntruso extends AlarmaHogarEstado{
	
	public void alarmaOn(AlarmaHogar context){};
	public void alarmaOff(AlarmaHogar context, String c){};
	public void intruso(AlarmaHogar context){};
	public void off(AlarmaHogar context){
		this.exitAction(context);
		AlarmaHogarEstado pe = getEstadoApagada();
		context.setState(pe);
		pe.entryAction(context);
		pe.doAction(context);
	};
	public void entryAction(AlarmaHogar context){
		context.notificarCentralita();
	};
	public void exitAction(AlarmaHogar context){};
	public void doAction(AlarmaHogar context){};

}
