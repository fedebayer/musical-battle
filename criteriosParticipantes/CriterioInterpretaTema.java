package criteriosParticipantes;

import reality.ElemBanda;
import reality.TemaMusical;

public class CriterioInterpretaTema extends CriterioParticipante {
	private TemaMusical tema;

	public CriterioInterpretaTema(TemaMusical tema) {
		super();
		this.tema = tema;
	}

	@Override
	public boolean cumple(ElemBanda e) {
		return tema.puedeInterpretar(e);
	}

}
