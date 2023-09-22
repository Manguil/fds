package annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Refactorings {
	Refactoring[] value();
}

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Repeatable(Refactorings.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Refactoring {
	String nomReviseur() default "équipe révision";
	RefactoringName nomRefactoring();
	String commentaire();
	boolean existeDansEclipse();
	int nbCasApplication();
}


