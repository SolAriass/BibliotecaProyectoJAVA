package proyecto.biblioteca;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {

	private String nombreBiblioteca;
	private List<Libro> libros;
	private List<Persona> clientes;
	private Recepcionista recepcionista;
	private List<Estante> estantes;
	private List<Renta> rentas;

	public Biblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
		this.libros = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.recepcionista = null;
		this.estantes = new ArrayList<>();
		this.rentas = new ArrayList<>();
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

	public void agregarEstanteALaBiblioteca(Estante estante) {
		estantes.add(estante);
		
	}

	public List<Estante> getEstantes() {
		return estantes;
	}

	public void setEstantes(List<Estante> estantes) {
		this.estantes = estantes;
	}


	public Boolean agregarLibroAlEstante(Estante estante, Libro libro) {
		Boolean agregado = false;
		if(!estante.getLugarOcupado() && libro != null) {
			if(estante.agregarLibro(libro)) {
				agregado = true;
			}
		}
		return agregado;
	}

	public void rentarLibro(Persona recepcionista, Persona cliente, Genero genero, String nombreLibro) {
		Boolean clienteEncontrado = this.buscarClientePorDni(cliente.getDni());
		List<Estante> estantesDeGenero = this.buscarEstantesPorGenero(genero);
		Libro encontrado = this.buscarLibroEntreEstantesDeGeneroEspecifico(estantesDeGenero, nombreLibro);
		
		if(clienteEncontrado && encontrado != null && recepcionista != null) {
			Estante estanteEspecifico = this.buscarEstanteQueContengaElLibroBuscado(estantesDeGenero, nombreLibro);
			if(estanteEspecifico.getLugarOcupado() == true) {
				Renta renta = ((Recepcionista) recepcionista).crearRenta(estanteEspecifico, (Cliente) cliente, encontrado);
				rentas.add(renta);
			}
			
		}
		
	}

	private Estante buscarEstanteQueContengaElLibroBuscado(List<Estante> estantesDeGenero, String nombreLibro) {
		Estante encontrado = null;
		for(Estante estante : estantesDeGenero) {
			if(estante.getLibro().getTitulo().equals(nombreLibro)) {
				encontrado = estante;
			}
		}
		
		return encontrado;
	}

	private Libro buscarLibroEntreEstantesDeGeneroEspecifico(List<Estante> estantesDeGenero, String nombreLibro) {
		Libro encontrado = null;
		for(Estante estante : estantesDeGenero) {
			if(estante.getLibro().getTitulo().equals(nombreLibro)) {
				encontrado = estante.getLibro();
			}
		}
		return encontrado;
	}

	private List<Estante> buscarEstantesPorGenero(Genero genero) {
		List<Estante> estantesConseguidos = new ArrayList<>();
		
		for(Estante estante : this.estantes) {
			if(estante.getGenero().equals(genero)) {
				estantesConseguidos.add(estante);
			}
		}
		
		return estantesConseguidos;
	}

	private Boolean buscarClientePorDni(Integer dni) {
		Boolean seEncontro = false;
		
		for(Persona cliente : this.clientes) {
			if(cliente.getDni().equals(dni)) {
				seEncontro = true;
			}
		}
		
		
		return seEncontro;
	}

	public List<Renta> getRentas() {
		return rentas;
	}

	public void setRentas(List<Renta> rentas) {
		this.rentas = rentas;
	}
	
	
	

	
	
}
