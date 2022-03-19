package compBatallas;

import java.util.Comparator;

import reality.ElemBanda;

public class compEdad implements Comparator<ElemBanda> {

	@Override
	public int compare(ElemBanda e1, ElemBanda e2) {
		return (int) (e1.getEdad() - e2.getEdad());
	}

}
