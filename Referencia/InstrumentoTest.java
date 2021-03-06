import static org.junit.Assert.*;

import org.junit.Test;


public class InstrumentoTest {

	@Test

	public void asignarInstrumento() {

	Instrumento guitarra = new Instrumento("Guitarra el?ctrica");

	assertEquals("Guitarra el?ctrica", guitarra.getNombre());

	Musico juan = new Musico("Juan P.");

	assertEquals("Juan P.", juan.getNombre());

	juan.setInstrumento(guitarra);

	assertEquals(guitarra, juan.getInstrumento());

	assertEquals(juan, guitarra.getMusico());

	guitarra.setNombre("Guitarra acustica");

	assertEquals("Guitarra acustica", juan.getInstrumento().getNombre());

	// #uno

	Musico lucas = new Musico("Lucas I");

	Instrumento bateria = new Instrumento("Bateria");

	Instrumento bajo = new Instrumento("Bajo");

	lucas.setInstrumento(bateria);

	assertEquals(bateria, lucas.getInstrumento());

	lucas.setInstrumento(null);

	assertEquals(null, lucas.getInstrumento());

	// #dos

	lucas.setInstrumento(bajo);

	assertEquals(bajo, lucas.getInstrumento());

	// #tres

	}

	

}
