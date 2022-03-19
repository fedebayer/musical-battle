package criteriosParticipantes;

import reality.ElemBanda;

public class CriterioIdioma extends CriterioParticipante {
	private String idioma;

	public CriterioIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public boolean cumple(ElemBanda e) {
		return e.tieneIdioma(idioma);
	}
}
