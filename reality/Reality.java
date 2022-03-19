package reality;

import java.util.ArrayList;
import java.util.Comparator;

public class Reality {
	private String nombre;
	private ArrayList<Coach> coaches;
	private ArrayList<TemaMusical> temasMusicalesPosibles;
	private Comparator<ElemBanda> criterioBatalla;
	// Los ejemplos de criterios de batalla de x condicion y si empata calcular por
	// y condicion y hace infinitamente se puede hacer el con comparador compuesto
	// dentro de otro y asi.

	public Reality(String nombre, Comparator<ElemBanda> criterioBatalla) {
		this(nombre, new ArrayList<>(), new ArrayList<>(), criterioBatalla);
	}

	public Reality(String nombre, ArrayList<Coach> coaches, ArrayList<TemaMusical> temasMusicalesPosibles,
			Comparator<ElemBanda> criterioBatalla) {
		super();
		this.nombre = nombre;
		this.coaches = new ArrayList<>(coaches);
		this.temasMusicalesPosibles = new ArrayList<>(temasMusicalesPosibles);
		this.setCriterioBatalla(criterioBatalla);
	}

	public String batallaCoaches(Coach c1, Coach c2) {
		ArrayList<ElemBanda> equipo1 = c1.getListaParticipantes(criterioBatalla);
		ArrayList<ElemBanda> equipo2 = c2.getListaParticipantes(criterioBatalla);
		ElemBanda participante1 = equipo1.get(0);
		ElemBanda participante2 = equipo2.get(0);
		int result = this.batalla(participante1, participante2);
		String coachWinner = null;
		if (result > 0) {
			coachWinner = c1.getNombre();
		} else if (result < 0) {
			coachWinner = c2.getNombre();
		} else
			coachWinner = "Empate";
		return coachWinner;
	}

	public int batalla(ElemBanda e1, ElemBanda e2) {
		return criterioBatalla.compare(e1, e2);
	}

	public String batallaCoachesPorPuntos(Coach c1, Coach c2) {
		ArrayList<ElemBanda> equipo1 = c1.getListaParticipantes(criterioBatalla);
		ArrayList<ElemBanda> equipo2 = c2.getListaParticipantes(criterioBatalla);
		int c1Points = 0;
		int c2Points = 0;
		for (int i = 0; i < equipo1.size() && i < equipo2.size(); i++) {
			ElemBanda participante1 = equipo1.get(i);
			ElemBanda participante2 = equipo2.get(i);
			int result = this.batalla(participante1, participante2);
			if (result > 0) {
				c1Points++;
			} else if (result < 0) {
				c2Points++;
			}
		}
		String coachWinner = null;
		if (c1Points > c2Points)
			coachWinner = c1.getNombre();
		else if (c2Points > c1Points)
			coachWinner = c2.getNombre();
		else
			coachWinner = "Empate";
		return coachWinner;
	}

	public void setCriterioBatalla(Comparator<ElemBanda> criterioBatalla) {
		this.criterioBatalla = criterioBatalla;
	}

	public void addTemaMusicalPosible(TemaMusical t) {
		if (!temasMusicalesPosibles.contains(t))
			this.temasMusicalesPosibles.add(t);
	}

	public void addCoach(Coach c) {
		if (!coaches.contains(c))
			this.coaches.add(c);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Comparator<ElemBanda> getCriterioBatalla() {
		return criterioBatalla;
	}

}
