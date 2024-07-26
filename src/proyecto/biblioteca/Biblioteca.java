package proyecto.biblioteca;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {

	private String nombreBiblioteca;
	private List<Libro> libros;
	private List<Persona> clientes;
	private Recepcionista recepcionista;

	public Biblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
		this.libros = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.recepcionista = null;
	}

	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}

	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
	}

	public void agregarLibroALaBiblioteca(Libro libro) {
		libros.add(libro);
		
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public void agregarClienteALaBiblioteca(Persona cliente) {
		clientes.add(cliente);
		
	}

	public List<Persona> getClientes() {
		return clientes;
	}

	public void setClientes(List<Persona> clientes) {
		this.clientes = clientes;
	}

	public void agregarRecepcionistaALaBiblioteca(Persona recepcionista) {
		this.recepcionista = (Recepcionista)recepcionista;
		
	}

	public Recepcionista getRecepcionista() {
		return recepcionista;
	}

	public void setRecepcionista(Recepcionista recepcionista) {
		this.recepcionista = recepcionista;
	}
	
	
	

	
	
}
