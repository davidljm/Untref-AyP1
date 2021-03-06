/*		TRABAJO PR?CTICO: ALGORITMO Y PROGRAMACI?N 1
 *		COMISI?N: Martes y Jueves (18:00-22:00)
 *		INTEGRANTES:
 *			- Andreoli, Maximiliano
 *			- Ramos, Andr?s
 */

package juego;

import static org.junit.Assert.*;
import org.junit.Test;

public class CuatroEnLineaTest {
	
	@Test (expected = Error.class)
	public void pruebaErrorEnCantidadDeFilas() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 2, 5, "Rojo", "Amarillo");
		//...
	}
	
	@Test (expected = Error.class)
	public void pruebaErrorEnCantidadDeColumnas() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 8, 3, "Rojo", "Amarillo");
		//...
	}
	
	@Test (expected = Error.class)
	public void pruebaErrorEnCantidadDeFilasYColumnas() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 3, 2, "Rojo", "Amarillo");
		//...
	}
	
	@Test(expected = Error.class)
	public void pruebaErrorPrimerJugadorVacio() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "", "Amarillo");
		//...
	}
	
	
	@Test(expected = Error.class)
	public void pruebaErrorPrimerYSegundoJugadorVacio() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "    ", " ");
		//...
	}
	
	@Test
	public void pruebaCreacionDelTablero() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		assertNotNull(juego);
	}
	
	@Test
	public void pruebaCantidadDeFilas() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		assertEquals( 4, juego.contarFilas() );
	}
	
	@Test
	public void pruebaCantidadDeColumnas() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		assertEquals( 4, juego.contarColumnas() );
	}
	
	@Test
	public void pruebaTableroVacio() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		for(int i=1; i<=juego.contarFilas(); i++){
			for(int j=1; j<=juego.contarColumnas(); j++){
				assertEquals( Casillero.VACIO, juego.obtenerCasillero(i,j) );
			}
		}
	}
	
	@Test (expected = Error.class)
	public void pruebaErrorEnSoltarFichaEnColumnaUno() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 5, 6, "Rojo", "Amarillo");
		juego.soltarFicha(7); // No existe la columna 7.
	}
	
	@Test (expected = Error.class)
	public void pruebaErrorEnSoltarFichaEnColumnaDos() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 5, 6, "Rojo", "Amarillo");
		juego.soltarFicha(-3); // No existe la columna -3.
	}
	
	@Test
	public void pruebaSoltarFichaSatisfactoriamente() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 5, 6, "Rojo", "Amarillo");
		juego.soltarFicha(5); // Jugador Rojo
		assertEquals( Casillero.ROJO, juego.obtenerCasillero(5,5) );
		juego.soltarFicha(3); // Jugador Amarillo
		assertEquals( Casillero.AMARILLO, juego.obtenerCasillero(5,3) );
		juego.soltarFicha(3); // Jugador Rojo
		assertEquals( Casillero.ROJO, juego.obtenerCasillero(4,3) );
	}
	
	@Test
	public void pruebaPartidaEnEmpate() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		juego.soltarFicha(1); // Jugador Rojo
		juego.soltarFicha(3); // Jugador Amarillo
		juego.soltarFicha(2); // Jugador Rojo
		juego.soltarFicha(4); // Jugador Amarillo
		juego.soltarFicha(3); // Jugador Rojo
		juego.soltarFicha(1); // Jugador Amarillo
		juego.soltarFicha(4); // Jugador Rojo
		juego.soltarFicha(2); // Jugador Amarillo
		juego.soltarFicha(1); // Jugador Rojo
		juego.soltarFicha(3); // Jugador Amarillo
		juego.soltarFicha(2); // Jugador Rojo
		juego.soltarFicha(4); // Jugador Amarillo
		juego.soltarFicha(3); // Jugador Rojo
		juego.soltarFicha(1); // Jugador Amarillo
		juego.soltarFicha(4); // Jugador Rojo
		juego.soltarFicha(2); // Jugador Amarillo
		juego.termino();
		assertFalse( juego.hayGanador() );
	}
	
	@Test
	public void pruebaQueHayGanador() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		juego.soltarFicha(1); // Jugador Rojo
		juego.soltarFicha(1); // Jugador Amarillo
		juego.soltarFicha(2); // Jugador Rojo
		juego.soltarFicha(2); // Jugador Amarillo
		juego.soltarFicha(3); // Jugador Rojo
		juego.soltarFicha(3); // Jugador Amarillo
		juego.soltarFicha(4); // Jugador Rojo
		juego.termino();
		assertTrue( juego.hayGanador() );
	}
	
	@Test
	public void pruebaGanadorRojoHorizontal() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		juego.soltarFicha(1); // Jugador Rojo
		juego.soltarFicha(1); // Jugador Amarillo
		juego.soltarFicha(2); // Jugador Rojo
		juego.soltarFicha(2); // Jugador Amarillo
		juego.soltarFicha(3); // Jugador Rojo
		juego.soltarFicha(3); // Jugador Amarillo
		juego.soltarFicha(4); // Jugador Rojo
		juego.termino();
		assertEquals( "Rojo", juego.obtenerGanador() );
	}
	
	@Test
	public void pruebaGanadorAmarilloVertical() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		juego.soltarFicha(1); // Jugador Rojo
		juego.soltarFicha(2); // Jugador Amarillo
		juego.soltarFicha(3); // Jugador Rojo
		juego.soltarFicha(2); // Jugador Amarillo
		juego.soltarFicha(4); // Jugador Rojo
		juego.soltarFicha(2); // Jugador Amarillo
		juego.soltarFicha(1); // Jugador Rojo
		juego.soltarFicha(2); // Jugador Amarillo
		juego.termino();
		assertEquals( "Amarillo", juego.obtenerGanador() );
	}
	
	@Test (expected = Error.class)
	public void pruebaErrorJuegoTerminado() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		juego.soltarFicha(1); // Jugador Rojo
		juego.soltarFicha(1); // Jugador Amarillo
		juego.soltarFicha(2); // Jugador Rojo
		juego.soltarFicha(2); // Jugador Amarillo
		juego.soltarFicha(3); // Jugador Rojo
		juego.soltarFicha(3); // Jugador Amarillo
		juego.soltarFicha(4); // Jugador Rojo
		assertTrue( juego.termino() );
		assertTrue( juego.hayGanador() );
		assertEquals( "Rojo", juego.obtenerGanador() );
		juego.soltarFicha(4); // No puede realizarse porque el juego ya termin?.
	}
	
	@Test
	public void pruebaGanadorAmarilloDiagonal() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		juego.soltarFicha(1); // Jugador Rojo
		juego.soltarFicha(1); // Jugador Amarillo
		juego.soltarFicha(1); // Jugador Rojo
		juego.soltarFicha(1); // Jugador Amarillo
		juego.soltarFicha(3); // Jugador Rojo
		juego.soltarFicha(2); // Jugador Amarillo
		juego.soltarFicha(2); // Jugador Rojo
		juego.soltarFicha(2); // Jugador Amarillo
		juego.soltarFicha(2); // Jugador Rojo
		juego.soltarFicha(3); // Jugador Amarillo
		juego.soltarFicha(3); // Jugador Rojo
		juego.soltarFicha(4); // Jugador Amarillo
		juego.termino();
		assertEquals( "Amarillo", juego.obtenerGanador() );
	}
	
	@Test
	public void pruebaGanadorRojoDiagonal() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 5, 8, "Rojo", "Amarillo");
		juego.soltarFicha(7); // Jugador Rojo
		juego.soltarFicha(7); // Jugador Amarillo
		juego.soltarFicha(8); // Jugador Rojo
		juego.soltarFicha(6); // Jugador Amarillo
		juego.soltarFicha(5); // Jugador Rojo
		juego.soltarFicha(8); // Jugador Amarillo
		juego.soltarFicha(6); // Jugador Rojo
		juego.soltarFicha(6); // Jugador Amarillo
		juego.soltarFicha(7); // Jugador Rojo
		juego.soltarFicha(8); // Jugador Amarillo
		juego.soltarFicha(8); // Jugador Rojo
		juego.termino();
		assertEquals( "Rojo", juego.obtenerGanador() );
	}
	
	@Test (expected = Error.class)
	public void pruebaSoltarFichaEnColumnaLlena() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		juego.soltarFicha(1); // Jugador Rojo
		juego.soltarFicha(1); // Jugador Amarillo
		juego.soltarFicha(1); // Jugador Rojo
		juego.soltarFicha(1); // Jugador Amarillo
		juego.soltarFicha(1); // Jugador Rojo (La columna 1 ya estaba llena, va a fallar...)
	}
	
	@Test
	public void pruebaQueJuegoNoTermino() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 4, "Rojo", "Amarillo");
		juego.soltarFicha(1);// Jugador Rojo
		juego.soltarFicha(3);// Jugador Amarillo
		juego.soltarFicha(2);// Jugador Rojo
		juego.soltarFicha(4);// Jugador Amarillo
		juego.soltarFicha(1);// Jugador Rojo
		juego.soltarFicha(3);// Jugador Amarillo
		assertFalse( juego.termino() );
	}
	
	@Test
	public void pruebaQueJuegoTermino() {
		
		CuatroEnLinea juego = new CuatroEnLinea( 4, 5, "Rojo", "Amarillo");
		juego.soltarFicha(2);// Jugador Rojo
		juego.soltarFicha(3);// Jugador Amarillo
		juego.soltarFicha(2);// Jugador Rojo
		juego.soltarFicha(3);// Jugador Amarillo
		juego.soltarFicha(2);// Jugador Rojo
		juego.soltarFicha(3);// Jugador Amarillo
		juego.soltarFicha(2);// Jugador Rojo
		assertTrue( juego.termino() );
	}
	
	@Test
	 public void obtenerGanadorAmarilloAPartirDeSuVictoriaVertical(){
	  CuatroEnLinea cuatroEnLinea = new CuatroEnLinea(4,4,"mati","nico");
	  cuatroEnLinea.soltarFicha(1);
	  cuatroEnLinea.soltarFicha(1);
	  cuatroEnLinea.soltarFicha(1);
	  cuatroEnLinea.soltarFicha(2);
	  cuatroEnLinea.soltarFicha(1);
	  cuatroEnLinea.soltarFicha(2);
	  cuatroEnLinea.soltarFicha(2);
	  cuatroEnLinea.soltarFicha(3);
	  cuatroEnLinea.soltarFicha(3);
	  cuatroEnLinea.soltarFicha(3);
	  cuatroEnLinea.soltarFicha(1);
	  cuatroEnLinea.termino();
	  assertEquals("nico",cuatroEnLinea.obtenerGanador());
	 }
}