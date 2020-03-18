package es.unican.is2.EmpleadosGUI;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;


public class EmpleadosGUITest {
	
	private FrameFixture demo;
	private LocalDate datenow;
	
	@Before
	public void setUp() {
		EmpleadosGUI gui = new EmpleadosGUI();
		datenow=LocalDate.now();
		demo = new FrameFixture(gui);
		gui.setVisible(true);
	}
	
	@After 
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void testBotonCalcular() {
		demo.button("btnCalcular").requireText("CALCULAR");
	}
	
	@Test
	public void testCaso1() {
		demo.comboBox().selectItem(0);
		String day = Integer.toString(datenow.getDayOfMonth());
		String month = Integer.toString(datenow.getMonthValue());
		String year = Integer.toString(datenow.getYear()-1);
		if (day.length()==1) {
			day= "0"+day;
		}
		if (month.length()==1) {
			month= "0"+month;
		}
		String fecha = day + "/" + month + "/" + year;
		demo.textBox("txtFechaContratacion").setText(fecha);
		demo.radioButton().click();
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("1125.0");
	}
	
	@Test
	public void testCaso2() {
		demo.comboBox().selectItem(1);
		String day = Integer.toString(datenow.getDayOfMonth());
		String month = Integer.toString(datenow.getMonthValue());
		String year = Integer.toString(datenow.getYear()-1);
		if (day.length()==1) {
			day= "0"+day;
		}
		if (month.length()==1) {
			month= "0"+month;
		}
		String fecha = day + "/" + month + "/" + year;
		demo.textBox("txtFechaContratacion").setText(fecha);
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("1200.0");
	}
	
	@Test
	public void testCaso3() {
		demo.comboBox().selectItem(2);
		String day = Integer.toString(datenow.getDayOfMonth());
		String month = Integer.toString(datenow.getMonthValue());
		String year = Integer.toString(datenow.getYear()-20);
		if (day.length()==1) {
			day= "0"+day;
		}
		if (month.length()==1) {
			month= "0"+month;
		}
		String fecha = day + "/" + month + "/" + year;
		demo.textBox("txtFechaContratacion").setText(fecha);
		demo.radioButton().click();
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("825.0");
	}
	
	@Test
	public void testFechaErronea() {
		demo.comboBox().selectItem(2);
		String day = Integer.toString(datenow.getDayOfMonth());
		String month = Integer.toString(datenow.getMonthValue());
		String year = Integer.toString(datenow.getYear()+1);
		if (day.length()==1) {
			day= "0"+day;
		}
		if (month.length()==1) {
			month= "0"+month;
		}
		String fecha = day + "/" + month + "/" + year;
		demo.textBox("txtFechaContratacion").setText(fecha);
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("Fecha Erronea!");
	}

}
