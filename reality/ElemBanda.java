package reality;

import java.util.ArrayList;
import java.util.Set;

import criteriosParticipantes.CriterioParticipante;

public abstract class ElemBanda {
	private String nombre;

	public ElemBanda(String nombre) {
		super();
		this.setNombre(nombre);
	}

	public abstract double getEdad();

	public abstract Set<String> getGenerosPreferencia();

	public abstract Set<String> getIdiomas();

	public abstract Set<String> getInstrumentos();

	public abstract ArrayList<ElemBanda> buscar(CriterioParticipante c);

	public boolean puedeInterpretarTema(ElemBanda e, TemaMusical t) {
		if (t.puedeInterpretar(e))
			return true;
		return false;
	}

	public boolean tieneGenero(String genero) {
		if (this.getGenerosPreferencia().contains(genero))
			return true;
		else
			return false;
	}

	public boolean tieneIdioma(String idioma) {
		if (this.getIdiomas().contains(idioma))
			return true;
		else
			return false;
	}

	public boolean tocaInstrumento(String instrumento) {
		if (this.getInstrumentos().contains(instrumento))
			return true;
		else
			return false;
	}

	public abstract int getCantParticipantesTocanInstrumento(String instrumento);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
