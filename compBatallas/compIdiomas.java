package compBatallas;

import java.util.Comparator;

import reality.ElemBanda;

public class compIdiomas implements Comparator<ElemBanda> {

	@Override
	public int compare(ElemBanda e1, ElemBanda e2) {
		return e1.getIdiomas().size() - e2.getIdiomas().size();
	}

}
