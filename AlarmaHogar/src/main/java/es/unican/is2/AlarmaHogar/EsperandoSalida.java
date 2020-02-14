package es.unican.is2.AlarmaHogar;

public class EsperandoSalida extends AlarmaHogarEstado{
	
	public void alarmaOn(AlarmaHogar context){};
	public void alarmaOff(AlarmaHogar context,String c){
		if (c.equals(context.getCodigo())) {
			this.exitAction(context);
			AlarmaHogarEstado pe = getEstadoApagada();
			context.setState(pe);
			pe.entryAction(context);
			pe.doAction(context);
		}
	};
	public void intruso(AlarmaHogar context){};
	public void off(AlarmaHogar context){};
	public void entryAction(AlarmaHogar context){
		//TIMER
	};
	public void exitAction(AlarmaHogar context){};
	public void doAction(AlarmaHogar context){};

}
