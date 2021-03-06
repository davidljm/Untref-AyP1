import static org.junit.Assert.*;

import org.junit.Test;


public class PlaylistTest {

	@Test
	public void seteoDeCanciones() {
		Playlist playlist = new Playlist(5);
		playlist.setCancion("WIEE", 90);
		assertEquals("WIEE",playlist.getTitulo(5));
	}
	@Test
	public void seteoDeDosOMasCanciones() {
		Playlist playlist = new Playlist(5);
		playlist.setCancion("WIEE", 90);
		assertEquals("WIEE",playlist.getTitulo(5));
		playlist.setCancion("Sun is never going down", 90);
		playlist.setCancion("Spotless", 60);
		assertEquals("Sun is never going down",playlist.getTitulo(4));
		assertEquals("Spotless",playlist.getTitulo(3));
	}
	@Test(expected = Error.class)
	public void seLLenoLaLista(){
		Playlist playlist = new Playlist(2);
		playlist.setCancion("WIEE", 90);
		playlist.setCancion("Sun is never going down", 90);
		playlist.setCancion("Spotless", 60);	
	}
	@Test
	public void probarCantidadDeCanciones() {
		Playlist playlist = new Playlist(5);
		playlist.setCancion("WIEE", 90);
		playlist.setCancion("Sun is never going down", 90);
		playlist.setCancion("Spotless", 60);
		assertEquals(3,playlist.cantidadDeCancionesTotales());
	}
	@Test
	public void probarDuracionTotal() {
		Playlist playlist = new Playlist(5);
		playlist.setCancion("WIEE", 90);
		playlist.setCancion("Sun is never going down", 90);
		playlist.setCancion("Spotless", 60);
		assertEquals(240,playlist.duracionTotalEnSegundos());
	}
	

}
