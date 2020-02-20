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
	
	@Override
	public void entryAction(AlarmaHogar context){
		context.setMen("Alarma Apagada");
		
		// Mover esto al controlador al pulsar Off desde centralita 
		//con estado DetectadoIntruso o Off con codigo correcto y menos 
		//de 3 intentos con estado EsperandoDesactivacion
		context.setNumpadActivado(false);
		
		context.getPiloto().apagar();
		context.setIntentos(0);
	};

}
