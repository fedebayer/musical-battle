package criteriosParticipantes;

import reality.ElemBanda;

public class CriterioParticipanteAnd extends CriterioParticipante {
	private CriterioParticipante c1;
	private CriterioParticipante c2;

	public CriterioParticipanteAnd(CriterioParticipante c1, CriterioParticipante c2) {
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public boolean cumple(ElemBanda e) {
		return c1.cumple(e) && c2.cumple(e);
	}

}
