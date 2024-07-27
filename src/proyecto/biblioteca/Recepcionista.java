package proyecto.biblioteca;

public class Recepcionista extends Persona {

	public Recepcionista(Integer dni, String nombre, String apellido, Integer edad) {
		super(dni, nombre, apellido, edad);
		// TODO Auto-generated constructor stub
	}

	

	public Renta crearRenta(Estante estanteEspecifico, Cliente cliente, Libro encontrado) {
		Renta nuevaRenta = new Renta(cliente, encontrado);
		estanteEspecifico.setLugarOcupado(false);
		
		return nuevaRenta;
	}
	
}
