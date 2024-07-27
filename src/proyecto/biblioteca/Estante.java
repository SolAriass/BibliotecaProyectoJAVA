package proyecto.biblioteca;

public class Estante {

	private Integer codigo;
	private Genero genero;
	private Libro libro;
	private Boolean lugarOcupado;

	public Estante(Integer codigo, Genero genero) {
		this.codigo = codigo;
		this.genero = genero;
		this.libro = null;
		this.lugarOcupado = false;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Boolean getLugarOcupado() {
		return lugarOcupado;
	}

	public void setLugarOcupado(Boolean lugarOcupado) {
		this.lugarOcupado = lugarOcupado;
	}

	public Boolean agregarLibro(Libro libro) {
		Boolean agregado = false;
		if(libro.getGenero().equals(this.getGenero())) {
			this.libro = libro;
			this.setLugarOcupado(true);
			agregado = true;
		}
		
		return agregado;
	}
	
	
	
	

}
