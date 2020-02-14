package es.unican.is2.AlarmaHogar;

public class EsperandoDesactivacion extends AlarmaHogarEstado{
	
	public void alarmaOn(AlarmaHogar context){};
	public void alarmaOff(AlarmaHogar context, String c){
		if (c.equals(context.getCodigo()) && context.getIntentos()<AlarmaHogar.INTENTOS) {
			this.exitAction(context);
			AlarmaHogarEstado pe = getEstadoApagada();
			context.setState(pe);
			pe.entryAction(context);
			pe.doAction(context);
		}else {
			context.incrementoIntentos();
		}
	};
	public void intruso(AlarmaHogar context){};
	public void off(AlarmaHogar context){};
	public void entryAction(AlarmaHogar context){
		//TIMER
		context.desactivarSensores();
	};
	public void exitAction(AlarmaHogar context){};
	public void doAction(AlarmaHogar context){};

}
