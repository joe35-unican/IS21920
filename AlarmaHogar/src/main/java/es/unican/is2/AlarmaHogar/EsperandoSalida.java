package es.unican.is2.AlarmaHogar;

import java.util.TimerTask;

public class EsperandoSalida extends AlarmaHogarEstado{
	protected PasarEncendidoTask encender;
	@Override
	public void alarmaOn(AlarmaHogar context){};
	public void alarmaOff(AlarmaHogar context,String c){
		if (c.equals(context.getCodigo())) {
			this.exitAction(context);
			encender.cancel();
			AlarmaHogarEstado pe = getEstadoApagada();
			context.setState(pe);
			pe.entryAction(context);
			pe.doAction(context);
		}
	};
	public void intruso(AlarmaHogar context){};
	public void off(AlarmaHogar context){};
	@Override
	public void entryAction(AlarmaHogar context){
		context.setNumpadActivado(true);
		encender = new PasarEncendidoTask(context);
		temp.schedule(encender, context.getIntervaloSalida());
	};
	public void exitAction(AlarmaHogar context){};
	public void doAction(AlarmaHogar context){};
	
	
	public class PasarEncendidoTask extends TimerTask {
		
		private AlarmaHogar context;
		public PasarEncendidoTask (AlarmaHogar context) { this.context=context;}
		@Override
		public void run() {
			getEstadoEsperandoSalida().exitAction(context);
			AlarmaHogarEstado pe = getEstadoEncendida();
			context.setState(pe);
			pe.entryAction(context);
			pe.doAction(context);
		}
		
	}

}
