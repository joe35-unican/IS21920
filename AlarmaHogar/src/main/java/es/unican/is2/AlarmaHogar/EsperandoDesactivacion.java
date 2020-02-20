package es.unican.is2.AlarmaHogar;

import java.util.TimerTask;

import es.unican.is2.AlarmaHogar.EsperandoSalida.PasarEncendidoTask;


public class EsperandoDesactivacion extends AlarmaHogarEstado{
	
	protected IntrusoTask intruso;
	
	public void alarmaOn(AlarmaHogar context){};
	@Override
	public void alarmaOff(AlarmaHogar context, String c){
		if (c.equals(context.getCodigo()) && context.getIntentos()<AlarmaHogar.INTENTOS) {
			this.exitAction(context);
			intruso.cancel();
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
	@Override
	public void entryAction(AlarmaHogar context){
		intruso = new IntrusoTask(context);
		temp.schedule(intruso, context.getIntervaloSalida());
		context.desactivarSensores();
	};
	public void exitAction(AlarmaHogar context){};
	public void doAction(AlarmaHogar context){};

	
public class IntrusoTask extends TimerTask {
		
		private AlarmaHogar context;
		public IntrusoTask (AlarmaHogar context) { this.context=context;}
		@Override
		public void run() {
			getEstadoEsperandoDesactivacion().exitAction(context);
			AlarmaHogarEstado pe = getEstadoDetectadoIntruso();
			context.setState(pe);
			pe.entryAction(context);
			pe.doAction(context);
		}
		
	}
}
