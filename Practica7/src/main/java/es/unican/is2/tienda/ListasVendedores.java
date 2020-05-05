package es.unican.is2.tienda;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class ListasVendedores {
	
	List<Vendedor> senior = new LinkedList<Vendedor>();
	List<Vendedor> junior = new LinkedList<Vendedor>();
	List<Vendedor> practicas = new LinkedList<Vendedor>();
	
	public void clasificaVendedor(Vendedor v) {				//WMC=3 //Ccog=4
		if (v instanceof vendedorEnPracticas) {				//WMC=+1 //Ccog=+1
			practicas.add(v);
		} else if (v instanceof VendedorEnPlantilla) {		//WMC=+1 //Ccog=+1
			VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
			if (vp.tipo().equals(TipoVendedor.JUNIOR))		//WMC=+1 //Ccog=+2
				junior.add(vp);
			else
				senior.add(vp);
		}
	}
	
	public void printSenior (PrintWriter out) {		//WMC=1 //Ccog=1
		out.println("    Senior");
		for (Vendedor v1 : senior)							//WMC=+1 //Ccog=+1
			out.println("      Nombre: " + v1.getNombre() + "   Id: " + v1.getId() + "   TotalVentasMes: "
					+ v1.getTotalVentas());
		out.println();
	}
	
	public void printJunior (PrintWriter out) {	//WMC=1 //Ccog=1
		out.println("    Junior");
		for (Vendedor v2 : junior)							//WMC=+1 //Ccog=+1
			out.println("      Nombre: " + v2.getNombre() + "   Id: " + v2.getId() + "   TotalVentasMes: "
					+ v2.getTotalVentas());
		out.println();
	}
	
	public void printPracticas (PrintWriter out) {	//WMC=1 //Ccog=1
		out.println("    Prácticas");
		for (Vendedor v3 : practicas)						//WMC=+1 //Ccog=+1
			out.println("      Nombre: " + v3.getNombre() + "   Id: " + v3.getId() + "   TotalVentasMes: "
					+ v3.getTotalVentas());
	}
}