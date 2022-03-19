package criteriosParticipantes;

import reality.ElemBanda;

public class CriterioCantMinParticipantesInstrumento extends CriterioParticipante {
	private int cant;
	private String instrumento;

	public CriterioCantMinParticipantesInstrumento(int cant, String instrumento) {
		super();
		this.cant = cant;
		this.instrumento = instrumento;
	}

	@Override
	public boolean cumple(ElemBanda e) {
		return e.getCantParticipantesTocanInstrumento(instrumento) >= cant;
	}

}
