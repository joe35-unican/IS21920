package es.unican.is2.tienda;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class VendedorEnPracticasTest {
	
	private static vendedorEnPracticas sut;

	@Before
	public void setUp(){
		sut = new vendedorEnPracticas("Ana", "1");
	}
	
	@Test
	public void testConstructor() {
		assertEquals(sut.getId(), "1");
		assertEquals(sut.getNombre(), "Ana");
		assertTrue(sut.getTotalVentas()==0.0);
	}
	
	@Test
	public void testSetTotalVentas() {
		sut.setTotalVentas(100);
		assertTrue(sut.getTotalVentas()==100.0);
		
		sut.setTotalVentas(230);
		assertTrue(sut.getTotalVentas()==230.0);
		
		sut.setTotalVentas(0);
		assertTrue(sut.getTotalVentas()==0.0);
	}

	@Test
	public void testAnhadeVenta() {
		sut.anhadeImporte(200);
		assertTrue(sut.getTotalVentas() == 200.0);
		
		sut.anhadeImporte(300);
		assertTrue(sut.getTotalVentas() == 500.0);	
		
		sut.anhadeImporte(0);
		assertTrue(sut.getTotalVentas() == 500.0);
		
		
	}
	
	@Test
	public void testEquals() {
		vendedorEnPracticas igual = new vendedorEnPracticas("Ana", "1");
		vendedorEnPracticas distintoId = new vendedorEnPracticas("Ana", "2");
		vendedorEnPracticas distintoNombre = new vendedorEnPracticas("Pepe", "1");
		vendedorEnPracticas distinto = new vendedorEnPracticas("Pepe", "6");
		
		assertTrue(sut.equals(igual));
		assertFalse(sut.equals(distintoId));
		assertFalse(sut.equals(distintoNombre));
		assertFalse(sut.equals(distinto));
	}
	
	
	
}
