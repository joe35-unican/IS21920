package es.unican.is2.AlarmaHogarModelo;

public class Piloto extends Thread{
	private AlarmaHogar context;
	private boolean parpadeo = true;
		public Piloto(AlarmaHogar context) {
			this.context=context;
			this.start();
	}

		public void parpadear() {
			this.resume();
			
		}
		
		public void encender() {
			this.suspend();
			context.getChsupp().firePropertyChange("piloto","",1);
		}

		public void apagar() {
			this.suspend();
			context.getChsupp().firePropertyChange("piloto","",0);
		}
		
		public void run() {
			try {
				while(parpadeo) {
					context.getChsupp().firePropertyChange("piloto","",1);
					Thread.sleep(250);
					context.getChsupp().firePropertyChange("piloto","",0);
					Thread.sleep(250);
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
		
}
