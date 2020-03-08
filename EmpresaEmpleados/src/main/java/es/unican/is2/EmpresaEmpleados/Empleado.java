package es.unican.is2.EmpresaEmpleados;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Empleado {

	private String nombre;
	private LocalDate fechaContratacion;
	private boolean baja=false;
	private categorias categoria;
	enum categorias {DIRECTIVO,GESTOR,OBRERO}

	public Empleado(String n, LocalDate f,categorias c) throws Exception{
		this.nombre=n;
		if (f.isBefore(LocalDate.now()) | f.isEqual(LocalDate.now())) {
			this.fechaContratacion=f;
		}else {
			throw new Exception();
		}
		this.categoria=c;
	}

	public double sueldoBruto() {
		double sueldo = 0;
		switch (this.categoria) {
		case DIRECTIVO:
			sueldo=1500;
			break;
		case GESTOR:
			sueldo=1200;
			break;
		case OBRERO:
			sueldo=1000;
			break;
		default:
			break;
		}
		
		long antiguedad = this.fechaContratacion.until(LocalDate.now(), ChronoUnit.YEARS);
		if (antiguedad>20) {
			sueldo+=200;
		}else if (antiguedad>10) {
			sueldo+=100;
		}else if (antiguedad>5) {
			sueldo+=50;
		}
		
		if (baja) {
			sueldo=sueldo*0.75;
		}
		return sueldo;
	}
	
	public boolean darDeAlta() {
		this.baja=false;
		return baja;
	}
	
	public boolean darDeBaja() {
		this.baja=true;
		return baja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(categorias categoria) {
		this.categoria = categoria;
	}
	
}
