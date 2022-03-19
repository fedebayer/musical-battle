package criteriosParticipantes;

import reality.ElemBanda;

public class CriterioGeneroPreferencia extends CriterioParticipante {
	private String genero;

	public CriterioGeneroPreferencia(String genero) {
		this.genero = genero;
	}

	@Override
	public boolean cumple(ElemBanda e) {
		return e.tieneGenero(genero);
	}
}
