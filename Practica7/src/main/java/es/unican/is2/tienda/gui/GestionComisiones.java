package es.unican.is2.tienda.gui;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import es.unican.is2.tienda.Tienda;
import es.unican.is2.tienda.Vendedor;
import fundamentos.Menu;
import fundamentos.Lectura;
import fundamentos.Mensaje;

/**
 * Gestión de las comisiones de vendedores de una tienda
 * 
 * @author MP
 * @version feb-13
 */
public class GestionComisiones {
	final static int NUEVA_VENTA = 0;
	final static int VENDEDOR_DEL_MES = 1;
	final static int VENDEDORES = 2;
	/**
	 * Programa principal basado en menu
	 */
	public static void main(String[] args) { //WMC=2 //Ccog=1

		

		// crea la ventana de menu
		Menu menu = new Menu("Comisiones tienda");
		menu.insertaOpcion("Añadir venta", NUEVA_VENTA);
		menu.insertaOpcion("Vendedor del mes", VENDEDOR_DEL_MES);
		menu.insertaOpcion("Vendedores por ventas", VENDEDORES);
		int opcion;

		// lazo de espera de comandos del usuario
		while (true) {											//WMC=+1 //Ccog=+1
			opcion = menu.leeOpcion();

			// realiza las acciones dependiendo de la opcion elegida
			seleccionOpcion(opcion);
		}
	}

	private static void seleccionOpcion(int opcion) { //WMC=4 //Ccog=1
		// crea la tienda
		Tienda tienda = new Tienda("datosTienda.txt");
		List<Vendedor> vendedores;
		vendedores = tienda.vendedores();
		switch (opcion) {									 		//Ccog=+1
		case NUEVA_VENTA:									//WMC=+1
			nuevaVenta(tienda);
			break;

		case VENDEDOR_DEL_MES:								//WMC=+1

			vendedorDelMes(vendedores);
			break;

		case VENDEDORES:									//WMC=+1
			
			vendedores(vendedores);
			break;
		}
	}

	private static void vendedores(List<Vendedor> vendedores) { //WMC=4 //Ccog=3
		String msj;
		System.out.println(vendedores.size());
		Collections.sort(vendedores, new Comparator<Vendedor>() {
			public int compare(Vendedor o1, Vendedor o2) {
				if (o1.getTotalVentas()>o2.getTotalVentas())//WMC=+1 //Ccog=+1
					return 1;
				else if (o1.getTotalVentas()<o2.getTotalVentas())//WMC=+1 //Ccog=+1
					return -1;
				return 0;
			}			
		});
		msj = "";
		for (Vendedor vn : vendedores) {				//WMC=+1 //Ccog=+1
			msj += vn.getNombre() + " " + vn.getId() + "\n";
		}
		mensaje("VENDEDORES", msj);
	}

	private static void vendedorDelMes(List<Vendedor> vendedores) { //WMC=5 //Ccog=6
		List<Vendedor> resultado;
		String msj;
		resultado = new LinkedList<Vendedor>();
		double maxVentas = 0.0;
		for (Vendedor v : vendedores) {					//WMC=+1 //Ccog=+1
			if (v.getTotalVentas() > maxVentas) {		//WMC=+1 //Ccog=+2
				maxVentas = v.getTotalVentas();
				resultado.clear();
				resultado.add(v);
			} else if (v.getTotalVentas() == maxVentas) {//WMC=+1 //Ccog=+2
				resultado.add(v);
			}
		}

		msj = "";
		for (Vendedor vn : resultado) {					//WMC=+1 //Ccog=+1
			msj += vn.getNombre() + "\n";
		}
		mensaje("VENDEDORES DEL MES", msj);
	}

	private static void nuevaVenta(Tienda tienda) { //WMC=3 //Ccog=2
		String dni;
		Lectura lect;
		lect = new Lectura("Datos Venta");
		lect.creaEntrada("DNI Vendedor", "");
		lect.creaEntrada("Importe", "");
		lect.esperaYCierra();
		dni = lect.leeString("DNI Vendedor");
		double importe = lect.leeDouble("Importe");
		try {
			if (!tienda.anhadeVenta(dni, importe)) {	//WMC=+1 //Ccog=+1
				mensaje("ERROR", "El vendedor no existe");
			}
		} catch (IOException e) { 						//WMC=+1 //Ccog=+1
			mensaje("ERROR", "No se pudo guardar el cambio");
		}
	}

	/**
	 * Metodo auxiliar que muestra un ventana de mensaje
	 * 
	 * @param titulo
	 *            titulo de la ventana
	 * @param txt
	 *            texto contenido en la ventana
	 */
	private static void mensaje(String titulo, String txt) { //WMC=+1 //Ccog=0
		Mensaje msj = new Mensaje(titulo);
		msj.escribe(txt);

	}

}
