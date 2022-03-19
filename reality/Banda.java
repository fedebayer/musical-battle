package reality;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import criteriosParticipantes.CriterioParticipante;

public class Banda extends ElemBanda {
	private ArrayList<ElemBanda> miembros;

	public Banda(String nombre) {
		super(nombre);
		this.miembros = new ArrayList<>();
	}

	public void addMiembro(ElemBanda nuevo) {
		miembros.add(nuevo);
	}

	@Override
	public ArrayList<ElemBanda> buscar(CriterioParticipante c) {
		ArrayList<ElemBanda> result = new ArrayList<>();
		if (c.cumple(this))
			result.add(this);
		else {
			for (ElemBanda m : miembros) {
				result.addAll(m.buscar(c));
			}
		}
		return result;
	}

	@Override
	public double getEdad() {
		if (miembros.isEmpty())
			return 0;
		double promedio = 0.0;
		for (ElemBanda m : miembros)
			promedio += m.getEdad();
		return (double) (promedio / miembros.size());
	}

	@Override
	public Set<String> getGenerosPreferencia() {
		Set<String> generos = new HashSet<>();
		ElemBanda m = miembros.get(0);
		for (String g : m.getGenerosPreferencia()) {
			boolean cumple = true;
			int i = 0;
			while (i < miembros.size() && cumple) {
				ElemBanda m2 = miembros.get(i);
				if (!m2.tieneGenero(g)) {
					cumple = false;
				}
				i++;
			}
			if (cumple)
				generos.add(g);
		}
		return generos;
	}

	@Override
	public Set<String> getIdiomas() {
		Set<String> idiomas = new HashSet<>();
		for (ElemBanda m : miembros) {
			idiomas.addAll(m.getIdiomas());
		}
		return idiomas;
	}

	@Override
	public Set<String> getInstrumentos() {
		Set<String> instrumentos = new HashSet<>();
		for (ElemBanda m : miembros) {
			instrumentos.addAll(m.getInstrumentos());
		}
		return instrumentos;
	}

	public int getCantParticipantesTocanInstrumento(String instrumento) {
		int cant = 0;
		for (ElemBanda m : miembros) {
			cant += m.getCantParticipantesTocanInstrumento(instrumento);
		}
		return cant;
	}

	@Override
	public String toString() {
		return "Banda " + this.getNombre() + " [miembros=" + miembros + "]" + "\n";
	}

}
