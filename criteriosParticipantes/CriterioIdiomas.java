package criteriosParticipantes;

import java.util.ArrayList;

import reality.ElemBanda;

public class CriterioIdiomas extends CriterioParticipante {
	private ArrayList<String> idiomas;

	public CriterioIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}

	@Override
	public boolean cumple(ElemBanda e) {
		for (String i : idiomas) {
			if (!e.tieneIdioma(i))
				return false;
		}
		return true;
	}

}
