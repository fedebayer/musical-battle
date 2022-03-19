package reality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import criteriosParticipantes.CriterioOK;
import criteriosParticipantes.CriterioParticipante;

public class Coach {
	private String nombre, apellido;
	private int edad;
	private ArrayList<ElemBanda> participantes;
	private CriterioParticipante comport;

	public Coach(String nombre, String apellido, int edad) {
		this(nombre, apellido, edad, new CriterioOK());
	}

	public Coach(String nombre, String apellido, int edad, CriterioParticipante comport) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.participantes = new ArrayList<>();
		this.comport = comport;
	}

	public boolean addParticipante(ElemBanda p) {
		if (comport.cumple(p)) {
			this.participantes.add(p);
			return true;
		}
		return false;
	}

	public ArrayList<ElemBanda> getListaParticipantes(Comparator<ElemBanda> comp) {
		ArrayList<ElemBanda> lista = new ArrayList<>(participantes);
		Collections.sort(lista, comp);
		Collections.reverse(lista);
		return lista;
	}

	public ArrayList<ElemBanda> buscarParticipantes(CriterioParticipante criterio) {
		ArrayList<ElemBanda> participantesEspecificos = new ArrayList<>();
		for (ElemBanda p : participantes)
			participantesEspecificos.addAll(p.buscar(criterio));
		return participantesEspecificos;
	}

	public Set<String> getInstrumentosEquipo() {
		Set<String> instrumentos = new HashSet<String>();
		for (ElemBanda p : participantes)
			instrumentos.addAll(p.getInstrumentos());
		return instrumentos;
	}

	public Set<String> getIdiomasEquipo() {
		Set<String> idiomas = new HashSet<String>();
		for (ElemBanda p : participantes)
			idiomas.addAll(p.getIdiomas());
		return idiomas;
	}

	public ArrayList<String> getGenerosPreferenciaEquipo() {
		Set<String> generos = new HashSet<String>();
		for (ElemBanda p : participantes)
			generos.addAll(p.getGenerosPreferencia());
		ArrayList<String> generosOrdAlf = new ArrayList<>(generos);
		Collections.sort(generosOrdAlf);
		return generosOrdAlf;
	}

	public double getPromedioEdadEquipo() {
		if (participantes.isEmpty())
			return 0;
		double contador = 0.0;
		for (ElemBanda p : participantes)
			contador += p.getEdad();
		return (double) (contador / participantes.size());
	}

	public void setComport(CriterioParticipante comport) {
		this.comport = comport;
	}

	@Override
	public boolean equals(Object o) {
		try {
			Coach other = (Coach) o;
			return this.getNombre().equals(other.getNombre()) && this.getApellido().equals(other.getApellido())
					&& this.getEdad() == (other.getEdad());
		} catch (Exception e) {
			return false;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Coach [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
	}

}
