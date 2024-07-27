package proyecto.biblioteca;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBiblioteca {

	@Test
	public void queSePuedaCrearUnaBiblioteca() {
		
		String nombreBiblioteca = "Aurora Literaria";
		Biblioteca biblioteca = new Biblioteca(nombreBiblioteca);
		
		assertNotNull(biblioteca);
		
		String nombreEsperado = "Aurora Literaria";
		assertEquals(nombreEsperado, biblioteca.getNombreBiblioteca());
		
	}
	
	@Test
	public void conociendoQueExisteUnaBibliotecaAgregarLibrosALaMisma() {
		
		Biblioteca biblioteca = new Biblioteca("Aurora Literaria");
		
		Persona autor = new Autor(23456789, "Andrea", "Tomé Yáñez", 29);
		
		Libro libro1 = new Libro(8416820864L, "Desayuno En Júpiter", (Autor)autor, 440, TipoTapa.BLANDA, 2017, Genero.FICCION);
		
		biblioteca.agregarLibroALaBiblioteca(libro1);
		
		Long ISBN = 8416820864L;
		
		assertEquals(ISBN, libro1.getISBN());
		assertEquals(1, biblioteca.getLibros().size());
		
	}
	
	@Test
	public void conociendoQueExisteUnaBibliotecaAgregarClientesALaMisma() {
		
		Biblioteca biblioteca = new Biblioteca("Aurora Literaria");
		
		Persona cliente = new Cliente(34567890, "Julian", "Perez", 39);
		
		biblioteca.agregarClienteALaBiblioteca(cliente);
	
		assertEquals(1, biblioteca.getClientes().size());
		
	}
	
	@Test
	public void conociendoQueExisteUnaBibliotecaAgregarUnaRecepcionistaAlMismo() {
		
		Biblioteca biblioteca = new Biblioteca("Aurora Literaria");
		
		Persona recepcionista = new Recepcionista(34567890, "Julian", "Perez", 39);
		
		biblioteca.agregarRecepcionistaALaBiblioteca(recepcionista);
	
		Persona recepcionistaEsperada = new Recepcionista(34567890, "Julian", "Perez", 39);
		
		assertEquals(recepcionistaEsperada, biblioteca.getRecepcionista());
	
	}
	
	@Test
	public void conociendoQueExisteUnaBibliotecaAgregarEstantesALaMisma() {
		
		Biblioteca biblioteca = new Biblioteca("Aurora Literaria");
		
		Estante estante1 = new Estante(001, Genero.PARANORMAL);
		
		biblioteca.agregarEstanteALaBiblioteca(estante1);
		
		assertEquals(1, biblioteca.getEstantes().size());
	
	}
	

	@Test
	public void conociendoQueExisteUnaBibliotecaConEstantesAgregarUnLibroEnElEstanteConGeneroIgualAlDelLibro() {
		
		Biblioteca biblioteca = new Biblioteca("Aurora Literaria");
		
		Estante estante1 = new Estante(001, Genero.FICCION);
		
		biblioteca.agregarEstanteALaBiblioteca(estante1);
		
		Persona autor = new Autor(23456789, "Andrea", "Tomé Yáñez", 29);
		
		Libro libro1 = new Libro(8416820864L, "Desayuno En Júpiter", (Autor)autor, 440, TipoTapa.BLANDA, 2017, Genero.FICCION);
		
		biblioteca.agregarLibroALaBiblioteca(libro1);
		
		Boolean agregado = biblioteca.agregarLibroAlEstante(estante1, libro1);
		
		Libro esperado = new Libro(8416820864L, "Desayuno En Júpiter", (Autor)autor, 440, TipoTapa.BLANDA, 2017, Genero.FICCION);
		
		assertTrue(agregado);
		assertEquals(esperado, estante1.getLibro());
	}
	
	@Test
	public void conociendoQueExisteUnaBibliotecaConEstantesConLibrosQueLaRecepcionistaCreeUnRegistroYSeVacieElEstanteCuandoUnClienteRenteUnLibro() {
		
		Biblioteca biblioteca = new Biblioteca("Aurora Literaria");
		Estante estante1 = new Estante(001, Genero.FICCION);
		Persona autor = new Autor(23456789, "Andrea", "Tomé Yáñez", 29);
		Libro libro1 = new Libro(8416820864L, "Desayuno En Júpiter", (Autor)autor, 440, TipoTapa.BLANDA, 2017, Genero.FICCION);
		Persona cliente = new Cliente(34567890, "Julian", "Perez", 39);
		Persona recepcionista = new Recepcionista(43227800, "Lorenzo", "Dominguez", 55);
		
		biblioteca.agregarEstanteALaBiblioteca(estante1);
		biblioteca.agregarLibroALaBiblioteca(libro1);
		biblioteca.agregarLibroAlEstante(estante1, libro1);
		biblioteca.agregarClienteALaBiblioteca(cliente);
		biblioteca.agregarRecepcionistaALaBiblioteca(recepcionista);
		
		Genero genero = Genero.FICCION;
		String nombreLibro = "Desayuno En Júpiter";
		
		biblioteca.rentarLibro(recepcionista, cliente, genero, nombreLibro);
		
		Integer totalDeRentasEsperadas = 1;
		Integer rentasTotales = biblioteca.getRentas().size();
		
		assertEquals(totalDeRentasEsperadas, rentasTotales);
		
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
