package es.unican.is2.tienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores y que permite
 * llevar la gestión de las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como parámetro al crear la tienda
 */
public class Tienda {

	private LinkedList<Vendedor> lista = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;
	private String datos;

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) { //WMC=1 //Ccog=0
		this.datos = datos;
		lista=creaLista();
	}

	/**
	 * Retorna la dirección de la tienda
	 * @return Dirección de la tienda
	 */
	public String direccion() { //WMC=1 //Ccog=0
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() { //WMC=1 //Ccog=0
		return nombre;
	}

	/**
	 * Añade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya había un vendedor con el mismo id
	 */
	public boolean anhadeVendedor(Vendedor nuevoVendedor) throws IOException { //WMC=2 Ccog=1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) {	//WMC=+1 //Ccog=+1
			return false;
		}
		lista.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo dni se pasa como parámetro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ningún vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException { //WMC=2 //Ccog=1
		Vendedor v = buscaVendedor(id);
		if (v == null) {				//WMC=+1 //Ccog=+1
			return false;
		}
		lista.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * Añade una venta a un vendedor
	 * 
	 * @param id
	 *            Id del vendedor
	 * @param importe
	 *            Importe de la venta
	 * @return true si se añade la venta false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws IOException { //WMC=2 //Ccog=1
		Vendedor v = buscaVendedor(id);
		if (v == null) {								//WMC=+1 //Ccog=+1
			return false;
		}
		v.anhadeVentaComision(importe);
		vuelcaDatos();
		return true;
	}

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id
	 *            Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) { //WMC=2 //Ccog=3
		for (Vendedor v : lista) {			//WMC=+1 //Ccog=+1
			if (v.getId().equals(id)) {		//WMC=+1 //Ccog=+2
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda
	 * 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() { //WMC=1 //Ccog=0
		return lista;
	}

	private LinkedList<Vendedor> creaLista() {		//WMC=7 //Ccog=5
		LinkedList<Vendedor> listaaux = new LinkedList<Vendedor>();
		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			// lee los vendedores junior
			while (in.hasNext() && !in.next().equals("Junior")) { //WMC=+2 //Ccog=+1
				listaaux.add(devuelveVendedor(in,TipoVendedor.SENIOR));
			}
			// lee los vendedores en practicas
			while (in.hasNext() && !in.next().equals("Prácticas")) { //WMC=+2 //Ccog=+1
				listaaux.add(devuelveVendedor(in,TipoVendedor.JUNIOR));
			}
			//lee los vendedores senior
			while (in.hasNext()) { //WMC=+1 //Ccog=+1
				in.next();
				listaaux.add(devuelveVendedor(in,null));
			}
		} catch (FileNotFoundException e) { //WMC=+1 //Ccog=+1

		} finally {
			if (in != null) {	//WMC=+1 //Ccog=+1
				in.close();
			}
		}
		return listaaux;
	}

	/**
	 * Método que genera el fichero datosTienda.txt con los datos actualizados de
	 * los vendedores
	 * @param parameterObject TODO
	 */
	private void vuelcaDatos() throws IOException { //WMC=2 //Ccog=2
		PrintWriter out = null;
		ListasVendedores listas = new ListasVendedores();
		for (Vendedor v : lista) {								//WMC=+1 //Ccog=+1
			listas.clasificaVendedor(v);
		}
		try {
			out = new PrintWriter(new FileWriter(datos));
			out.println(nombre);
			out.println(direccion);
			out.println();
			listas.printSenior(out);
			listas.printJunior(out);
			listas.printPracticas(out);
		} finally {
			if (out != null)									//WMC=+1 //Ccog=+1
				out.close();
		}
	}

	//Crea vendedor
	private Vendedor devuelveVendedor(Scanner in,TipoVendedor tipo) { //WMC=2 //Ccog=1
		Vendedor v = null;
		String nombre = in.next();
		in.next();
		String id = in.next();
		in.next();
		double totalVentas = in.nextDouble();
		
		if (tipo!=null) {v = new VendedorEnPlantilla(nombre, id, tipo);} //WMC=+1 //Ccog=+1
		else {v = new vendedorEnPracticas(nombre, id);}
		v.setTotalVentas(totalVentas);
		return v;
	}
	
	public List<Vendedor> vendedorDelMes(){			//WMC=4 //Ccog=5
		List<Vendedor> resultado = new LinkedList<Vendedor>();
		double maxVentas = 0.0;
		for (Vendedor v : lista) {					//WMC=+1 //Ccog=+1
			if (v.getTotalVentas() > maxVentas) {		//WMC=+1 //Ccog=+2
				maxVentas = v.getTotalVentas();
				resultado.clear();
				resultado.add(v);
			} else if (v.getTotalVentas() == maxVentas) {//WMC=+1 //Ccog=+2
				resultado.add(v);
			}
		}
		return resultado;
	}

	public List<Vendedor> vendedoresOrd() {			//WMC=3 //Ccog=2
		List<Vendedor> listaOrd = lista;
		Collections.sort(listaOrd, new Comparator<Vendedor>() {
			public int compare(Vendedor o1, Vendedor o2) {
				if (o1.getTotalVentas()>o2.getTotalVentas())//WMC=+1 //Ccog=+1
					return 1;
				else if (o1.getTotalVentas()<o2.getTotalVentas())//WMC=+1 //Ccog=+1
					return -1;
				return 0;
			}			
		});
		return listaOrd;
	}
	
}
