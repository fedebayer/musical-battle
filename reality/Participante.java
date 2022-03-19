package reality;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import criteriosParticipantes.CriterioParticipante;

public class Participante extends ElemBanda {
	private String apellido;
	private int edad;
	private ArrayList<String> generosPreferencia;
	private ArrayList<String> idiomas;
	private ArrayList<String> instrumentos;

	public Participante(String nombre, String apellido, int edad) {
		this(nombre, apellido, edad, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
	}

	public Participante(String nombre, String apellido, int edad, ArrayList<String> generosPreferencia,
			ArrayList<String> idiomas, ArrayList<String> instrumentos) {
		super(nombre);
		this.apellido = apellido;
		this.edad = edad;
		this.generosPreferencia = new ArrayList<>(generosPreferencia);
		this.idiomas = new ArrayList<>(idiomas);
		this.instrumentos = new ArrayList<>(instrumentos);
	}

	@Override
	public ArrayList<ElemBanda> buscar(CriterioParticipante c) {
		ArrayList<ElemBanda> result = new ArrayList<>();
		if (c.cumple(this))
			result.add(this);
		return result;
	}

	@Override
	public int getCantParticipantesTocanInstrumento(String instrumento) {
		if (this.tocaInstrumento(instrumento))
			return 1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "Participante [nombre=" + super.getNombre() + ", apellido=" + apellido + ", edad=" + edad
				+ ", generosMusicalesPreferencia=" + generosPreferencia + ", idiomas=" + idiomas + ", instrumentos="
				+ instrumentos + "]" + "\n";
	}

	public void addGeneroMusicalPreferido(String genero) {
		if (!this.generosPreferencia.contains(genero))
			this.generosPreferencia.add(genero);
	}

	public void addIdioma(String idioma) {
		if (!this.idiomas.contains(idioma))
			this.idiomas.add(idioma);
	}

	public void addInstrumento(String instrumento) {
		if (!this.instrumentos.contains(instrumento))
			this.instrumentos.add(instrumento);
	}

	public String getApellido() {
		return apellido;
	}

	public double getEdad() {
		return edad;
	}

	public Set<String> getGenerosPreferencia() {
		return new HashSet<>(generosPreferencia);
	}

	public Set<String> getIdiomas() {
		return new HashSet<>(idiomas);
	}

	public Set<String> getInstrumentos() {
		return new HashSet<>(instrumentos);
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
