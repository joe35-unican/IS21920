package es.unican.is2.AlarmaHogarModelo;

public class Apagada extends AlarmaHogarEstado{

	@Override
	public void alarmaOn(AlarmaHogar context){
		this.exitAction(context);
		AlarmaHogarEstado pe = getEstadoEsperandoSalida();
		context.getPiloto().parpadear();
		context.getChsupp().firePropertyChange("numpad","",1);
		context.setState(pe);
		pe.entryAction(context);
		pe.doAction(context);
	};
	
	@Override
	public void entryAction(AlarmaHogar context){
		context.getChsupp().firePropertyChange("texto","","Alarma Apagada");
		context.getChsupp().firePropertyChange("texto2","","");
		context.getChsupp().firePropertyChange("numpad","",0);
		context.getPiloto().apagar();
		context.setIntentos(0);
	};

}
