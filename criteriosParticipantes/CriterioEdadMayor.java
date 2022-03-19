package criteriosParticipantes;

import reality.ElemBanda;

public class CriterioEdadMayor extends CriterioParticipante {
	private int edad;

	public CriterioEdadMayor(int edad) {
		this.edad = edad;
	}

	@Override
	public boolean cumple(ElemBanda e) {
		return e.getEdad() > edad;
	}
}
