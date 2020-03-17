package es.unican.is2.EmpresaEmpleados;
import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Test;

public class EmpleadoTest {
	
	private Empleado empleado;
	
	@Test
	public void testContructor() {
		try {
			empleado = new Empleado("Luis Fernandez",LocalDate.now(),Empleado.categorias.DIRECTIVO);
		} catch (Exception e) {
			fail("Fallo del Test Fecha correcta");
		}
		try {
			LocalDate f = LocalDate.now().plusDays(1);
			empleado = new Empleado("Luis Fernandez",f,Empleado.categorias.DIRECTIVO);
			fail("Fallo del Test Fecha correcta");
		} catch (Exception e) {
			//Se lanza la excepcion
		}
	}
	
	@Test
	public void testDarDeBaja() {
		try {
			empleado = new Empleado("Luis Fernandez",LocalDate.now(),Empleado.categorias.DIRECTIVO);
			empleado.darDeBaja();
			assertTrue(empleado.isBaja()==true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDarDeAlta() {
		try {
			empleado = new Empleado("Luis Fernandez",LocalDate.now(),Empleado.categorias.DIRECTIVO);
			empleado.darDeBaja();
			empleado.darDeAlta();
			assertTrue(empleado.isBaja()==false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSueldoBruto() {
		try {
			empleado = new Empleado("Luis Fernandez",LocalDate.now().minusYears(3),Empleado.categorias.DIRECTIVO);
			empleado.darDeBaja();
			assertTrue(empleado.sueldoBruto()==1125);
			
			empleado = new Empleado("Luis Fernandez",LocalDate.now(),Empleado.categorias.GESTOR);
			assertTrue(empleado.sueldoBruto()==1200);
			
			empleado = new Empleado("Luis Fernandez",LocalDate.now().minusYears(5),Empleado.categorias.OBRERO);
			empleado.darDeBaja();
			assertTrue(empleado.sueldoBruto()==750);
			
			empleado = new Empleado("Luis Fernandez",LocalDate.now().minusYears(8),Empleado.categorias.DIRECTIVO);
			assertTrue(empleado.sueldoBruto()==1550);
			
			empleado = new Empleado("Luis Fernandez",LocalDate.now().minusYears(6),Empleado.categorias.GESTOR);
			empleado.darDeBaja();
			assertTrue(empleado.sueldoBruto()==937.5);
			
			empleado = new Empleado("Luis Fernandez",LocalDate.now().minusYears(10),Empleado.categorias.OBRERO);
			assertTrue(empleado.sueldoBruto()==1050);
			
			empleado = new Empleado("Luis Fernandez",LocalDate.now().minusYears(13),Empleado.categorias.DIRECTIVO);
			empleado.darDeBaja();
			assertTrue(empleado.sueldoBruto()==1200);
			
			empleado = new Empleado("Luis Fernandez",LocalDate.now().minusYears(11),Empleado.categorias.GESTOR);
			assertTrue(empleado.sueldoBruto()==1300);
			
			empleado = new Empleado("Luis Fernandez",LocalDate.now().minusYears(20),Empleado.categorias.OBRERO);
			empleado.darDeBaja();
			assertTrue(empleado.sueldoBruto()==825);
			
			empleado = new Empleado("Luis Fernandez",LocalDate.now().minusYears(50),Empleado.categorias.DIRECTIVO);
			assertTrue(empleado.sueldoBruto()==1700);
			
			empleado = new Empleado("Luis Fernandez",LocalDate.now().minusYears(21),Empleado.categorias.GESTOR);
			empleado.darDeBaja();
			assertTrue(empleado.sueldoBruto()==1050);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
