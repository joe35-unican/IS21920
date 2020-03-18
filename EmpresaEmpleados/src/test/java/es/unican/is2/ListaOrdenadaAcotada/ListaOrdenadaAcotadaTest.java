package es.unican.is2.ListaOrdenadaAcotada;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListaOrdenadaAcotadaTest {

	private ListaOrdenadaAcotada<Integer> sut;
	
	@Before
	public void setUp() {
		this.sut=new ListaOrdenadaAcotada<Integer>(5);
	}
	
	
	@Test
	public void constructor() {
		ListaOrdenadaAcotada<Integer> sut2=new ListaOrdenadaAcotada<Integer>();
		assertTrue(sut2.size()==0);
	}
	@Test
	public void sizeTest() {
		assertTrue(sut.size()==0);
		sut.add(8);
		assertTrue(sut.size()==1);
		sut.add(1);
		sut.add(10);
		assertTrue(sut.size()==3);
		sut.add(10);
		sut.add(300);
		assertTrue(sut.size()==5);
	}
	
	@Test
	public void getTest() {
		//lista vacia
		try {
			sut.get(4);
			fail("No salto la excepcion caso get4-lista vacia");
		}catch (IndexOutOfBoundsException e) {
			
		}
		sut.add(8);
		try {
			assertTrue(sut.get(0)==8);
		}catch (IndexOutOfBoundsException e) {
			
		}
		sut.add(1);
		sut.add(10);
		try {
			assertTrue(sut.get(0)==1);
			assertTrue(sut.get(2)==10);
		}catch (IndexOutOfBoundsException e) {
			
		}
		sut.add(10);
		sut.add(300);
		try {
			assertTrue(sut.get(0)==1);
			assertTrue(sut.get(2)==10);
			assertTrue(sut.get(4)==300);
		}catch (IndexOutOfBoundsException e) {
			
		}
		try {
			sut.get(-1);
			fail("No salto la excepcion caso get-1");
		}catch (IndexOutOfBoundsException e) {
			
		}
		try {
			sut.get(10);
			fail("No salto la excepcion caso get10");
		}catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	@Test
	public void addTest() {
		sut.add(8);
		assertTrue(sut.get(0)==8);
		assertTrue(sut.size()==1);
		sut.add(1);
		sut.add(10);
		assertTrue(sut.get(2)==10);
		assertTrue(sut.size()==3);
		sut.add(10);
		sut.add(300);
		assertTrue(sut.get(4)==300);
		assertTrue(sut.size()==5);
		try {
			sut.add(33);
			fail("No se lanzo la excepcion add33");
		}catch (IllegalStateException e) {
			
		}
	}
	
	@Test
	public void removeTest() {
		try {
			assertTrue(sut.remove(0)==null);
			assertTrue(sut.remove(2)==null);
			assertTrue(sut.remove(4)==null);
			fail("No se lanzo excepcion al eliminar una posicion erronea");
		}catch (IndexOutOfBoundsException e) {
			
		}
		sut.add(8);
		try {
			assertTrue(sut.remove(0)==8);
			assertTrue(sut.size()==0);
		}catch (IndexOutOfBoundsException e) {
			
		}
		sut.add(8);
		sut.add(1);
		sut.add(10);
		try {
			assertTrue(sut.remove(2)==10);
			assertTrue(sut.remove(0)==1);
			assertTrue(sut.size()==1);
		}catch (IndexOutOfBoundsException e) {
			
		}
		sut.add(1);
		sut.add(10);
		sut.add(10);
		sut.add(300);
		try {
			assertTrue(sut.remove(4)==300);
			assertTrue(sut.remove(2)==10);
			assertTrue(sut.remove(0)==1);
			assertTrue(sut.size()==2);
		}catch (IndexOutOfBoundsException e) {
			
		}
		try {
			sut.remove(-1);
			fail("No salto la excepcion caso remove-1");
		}catch (IndexOutOfBoundsException e) {
			
		}
		try {
			sut.remove(10);
			fail("No salto la excepcion caso remove10");
		}catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	@Test
	public void clearTest() {
		sut.add(8);
		sut.clear();
		assertTrue(sut.size()==0);
		
		sut.add(8);
		sut.add(1);
		sut.add(10);
		sut.clear();
		assertTrue(sut.size()==0);
		
		sut.add(8);
		sut.add(1);
		sut.add(10);
		sut.add(10);
		sut.add(300);
		sut.clear();
		assertTrue(sut.size()==0);
	}
}
