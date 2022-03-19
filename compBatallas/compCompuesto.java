package compBatallas;

import java.util.Comparator;

import reality.ElemBanda;

public class compCompuesto implements Comparator<ElemBanda> {
	private Comparator<ElemBanda> c1;
	private Comparator<ElemBanda> c2;

	public compCompuesto(Comparator<ElemBanda> c1, Comparator<ElemBanda> c2) {
		super();
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public int compare(ElemBanda e1, ElemBanda e2) {
		int res = c1.compare(e1, e2);
		if (res == 0)
			return c2.compare(e1, e2);
		return res;
	}

}
