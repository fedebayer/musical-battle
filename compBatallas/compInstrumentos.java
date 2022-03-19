package compBatallas;

import java.util.Comparator;

import reality.ElemBanda;

public class compInstrumentos implements Comparator<ElemBanda> {

	@Override
	public int compare(ElemBanda e1, ElemBanda e2) {
		return e1.getInstrumentos().size() - e2.getInstrumentos().size();
	}

}
