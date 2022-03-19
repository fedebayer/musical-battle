package criteriosParticipantes;

import reality.ElemBanda;

public class CriterioParticipanteNot extends CriterioParticipante {
	private CriterioParticipante c1;

	public CriterioParticipanteNot(CriterioParticipante c1) {
		this.c1 = c1;
	}

	@Override
	public boolean cumple(ElemBanda e) {
		return !c1.cumple(e);
	}

}
