package es.unican.is2.tienda;


public class VendedorEnPlantilla extends Vendedor {
	
	private TipoVendedor tipo;
	private static final double PORCENTAJE_SENIOR = 0.01;
	private static final double PORCENTAJE_JUNIOR = 0.005;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String dni, TipoVendedor tipo) { //WMC=1 //Ccog=0
		super(nombre, dni);
		this.tipo = tipo;
	}
	
	public TipoVendedor tipo() { //WMC=1 //Ccog=0
		return tipo;
	}
	
	public void anhadeVenta(double importe) {//WMC=3 //Ccog=1
		double importeFinal = importe;
			switch (tipo()) { //Ccog=+1
			case JUNIOR:	//WMC=+1
				importeFinal += importeFinal * PORCENTAJE_JUNIOR;
				break;
			case SENIOR:	//WMC=+1
				importeFinal += importeFinal * PORCENTAJE_SENIOR;
				break;
			}
		}
		
}
