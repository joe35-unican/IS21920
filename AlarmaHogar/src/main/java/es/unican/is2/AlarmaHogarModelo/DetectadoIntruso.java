package es.unican.is2.AlarmaHogarModelo;

public class DetectadoIntruso extends AlarmaHogarEstado{
	
	@Override
	public void off(AlarmaHogar context){
		this.exitAction(context);
		AlarmaHogarEstado pe = getEstadoApagada();
		context.setState(pe);
		pe.entryAction(context);
		pe.doAction(context);
	};
	@Override
	public void entryAction(AlarmaHogar context){
		context.notificarCentralita();
	};

}
