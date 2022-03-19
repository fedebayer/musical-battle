package criteriosParticipantes;

import reality.ElemBanda;

public class CriterioInstrumento extends CriterioParticipante {
	private String instrumento;

	public CriterioInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	@Override
	public boolean cumple(ElemBanda e) {
		return e.tocaInstrumento(instrumento);
	}
}