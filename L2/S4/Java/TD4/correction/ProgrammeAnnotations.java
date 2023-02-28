package annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.lang.reflect.*;

public class ProgrammeAnnotations {

	public static void main(String[] args) {
		Personne p = new Personne();
		Annotation[] tabAnn = p.getClass().getAnnotations();
		
		for (Annotation ann : tabAnn)
		{
			System.out.println(ann);
			// exemple d'affichage d'un champ
			System.out.println(((Refactoring)ann).nbCasApplication());			
		}
		
		for (Method m : p.getClass().getMethods())
			for (Annotation ann : m.getAnnotations())
				System.out.println(ann);	
		
		for (Field m : p.getClass().getFields())
			for (Annotation ann : m.getAnnotations())
				System.out.println(ann);			

	}

}
