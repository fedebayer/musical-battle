package compBatallas;

import java.util.Comparator;

import reality.ElemBanda;

public class compGeneros implements Comparator<ElemBanda> {

	@Override
	public int compare(ElemBanda e1, ElemBanda e2) {
		return e1.getGenerosPreferencia().size() - e2.getGenerosPreferencia().size();
	}

}
