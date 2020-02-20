package es.unican.is2.AlarmaHogar;

import Vistas.PantallaAlarma;

public class Piloto {
	private PantallaAlarma vista;

		public Piloto(PantallaAlarma vista) {
		this.vista=vista;
	}

		public void parpadear() {
			
		}
		
		public void encender() {
			
			// Cambiar por enviar un mensaje al listener
			vista.setLed(true);
		}

		public void apagar() {
			// Cambiar por enviar un mensaje al listener
			vista.setLed(false);
		}
		
}
