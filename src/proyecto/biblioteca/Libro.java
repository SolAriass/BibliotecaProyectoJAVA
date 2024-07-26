package proyecto.biblioteca;

public class Libro {

	private Long ISBN;
	private String titulo;
	private Autor autor;
	private Integer nroPaginas;
	private TipoTapa tipoTapa;
	private Integer anioCreacion;
	private Genero genero;

	public Libro(Long ISBN, String titulo, Autor autor, Integer nroPaginas, TipoTapa tipoTapa, Integer anioCreacion, Genero genero) {
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.autor = autor;
		this.nroPaginas = nroPaginas;
		this.tipoTapa = tipoTapa;
		this.anioCreacion = anioCreacion;
		this.genero = genero;
	}

	public Long getISBN() {
		return ISBN;
	}

	public void setISBN(Long iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Integer getNroPaginas() {
		return nroPaginas;
	}

	public void setNroPaginas(Integer nroPaginas) {
		this.nroPaginas = nroPaginas;
	}

	public TipoTapa getTipoTapa() {
		return tipoTapa;
	}

	public void setTipoTapa(TipoTapa tipoTapa) {
		this.tipoTapa = tipoTapa;
	}

	public Integer getAnioCreacion() {
		return anioCreacion;
	}

	public void setAnioCreacion(Integer anioCreacion) {
		this.anioCreacion = anioCreacion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	
	
	
}
