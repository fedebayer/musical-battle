package reality;

import java.util.ArrayList;

import criteriosParticipantes.CriterioParticipante;

public class TemaMusical {
	private String titulo;
	private String idioma;
	private ArrayList<String> generosPertenencia;
	private ArrayList<String> instrumentosNecesariosConcurso;
	private CriterioParticipante requisitoInterpretacion;
	// Los temas no finales tendrian el criterioOK que devuelve siempre true.
	// Los temas finales tienen este criterio con el
	// criterioCantMinParticipantesInstrumento(cantidad, instrumento)

	public TemaMusical(String titulo, String idioma, ArrayList<String> generosMusicalesPertenencia,
			CriterioParticipante requisito) {
		this(titulo, idioma, generosMusicalesPertenencia, new ArrayList<>(), requisito);
	}

	public TemaMusical(String titulo, String idioma, ArrayList<String> generosPertenencia,
			ArrayList<String> instrumentosNecesariosConcurso, CriterioParticipante requisito) {
		super();
		this.titulo = titulo;
		this.idioma = idioma;
		this.generosPertenencia = new ArrayList<>(generosPertenencia);
		this.instrumentosNecesariosConcurso = new ArrayList<>(instrumentosNecesariosConcurso);
		this.requisitoInterpretacion = requisito;
	}

	public boolean puedeInterpretar(ElemBanda e) {
		if (e.tieneIdioma(this.idioma) && tieneAlgunGenero(e) && requisitoInterpretacion.cumple(e))
			return true;
		else
			return false;
	}

	private boolean tieneAlgunGenero(ElemBanda e) {
		for (String g : generosPertenencia) {
			if (e.tieneGenero(g))
				return true;
		}
		return false;
	}

	public CriterioParticipante getRequisitoInterpretacion() {
		return requisitoInterpretacion;
	}

	public void setRequisitoInterpretacion(CriterioParticipante requisitoInterpretacion) {
		this.requisitoInterpretacion = requisitoInterpretacion;
	}

	@Override
	public boolean equals(Object o) {
		try {
			TemaMusical other = (TemaMusical) o;
			return this.getTitulo().equals(other.getTitulo()) && this.getIdioma().equals(other.getIdioma());
		} catch (Exception e) {
			return false;
		}
	}

	public void addGeneroPertenencia(String genero) {
		if (!this.generosPertenencia.contains(genero))
			this.generosPertenencia.add(genero);
	}

	public void addInstrumento(String instrumento) {
		if (!this.instrumentosNecesariosConcurso.contains(instrumento))
			this.instrumentosNecesariosConcurso.add(instrumento);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public void setGenerosMusicalesPertenencia(ArrayList<String> generosMusicalesPertenencia) {
		this.generosPertenencia = generosMusicalesPertenencia;
	}

	public void setInstrumentosNecesariosConcurso(ArrayList<String> instrumentosNecesariosConcurso) {
		this.instrumentosNecesariosConcurso = instrumentosNecesariosConcurso;
	}

}
