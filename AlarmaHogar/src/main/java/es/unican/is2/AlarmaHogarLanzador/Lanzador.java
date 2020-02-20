package es.unican.is2.AlarmaHogarLanzador;

import es.unican.is2.AlarmaHogarControlador.AlarmaHogarControlador;
import es.unican.is2.AlarmaHogarModelo.AlarmaHogar;
import es.unican.is2.AlarmaHogarVistas.PantallaAlarma;

public class Lanzador {

	public static void main(String[] args) {
		
		PantallaAlarma vistaAlarma= new PantallaAlarma();
		AlarmaHogar alarma=new AlarmaHogar();
		new AlarmaHogarControlador(vistaAlarma,alarma);
	}

}
