package compBatallas;

import java.util.Comparator;

import reality.ElemBanda;

public class compInverso implements Comparator<ElemBanda> {
	private Comparator<ElemBanda> c1;

	public compInverso(Comparator<ElemBanda> c1) {
		super();
		this.c1 = c1;
	}

	@Override
	public int compare(ElemBanda e1, ElemBanda e2) {
		return -c1.compare(e1, e2);
	}

}
