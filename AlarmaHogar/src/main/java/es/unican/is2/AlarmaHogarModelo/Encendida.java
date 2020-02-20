package es.unican.is2.AlarmaHogarModelo;

public class Encendida extends AlarmaHogarEstado{
	
	@Override
	public void intruso(AlarmaHogar context){
		this.exitAction(context);
		AlarmaHogarEstado pe = getEstadoEsperandoDesactivacion();
		context.setState(pe);
		pe.entryAction(context);
		pe.doAction(context);
	};

	@Override
	public void entryAction(AlarmaHogar context){
		context.getPiloto().encender();
		context.activarSensores();
		context.getChsupp().firePropertyChange("numpad","",1);
	};

}
