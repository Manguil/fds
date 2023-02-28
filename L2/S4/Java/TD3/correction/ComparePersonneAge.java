package genericiteBornee;

import java.util.Comparator;

public class ComparePersonneAge implements Comparator<Personne> {

	@Override
	public int compare(Personne o1, Personne o2) {
		if (o1.getAge() < o2.getAge())
			return  -1;
		else if (o1.getAge() > o2.getAge())		
			return 1;
		else return 0;
	}

}
