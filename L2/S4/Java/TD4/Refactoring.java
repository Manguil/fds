import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Refactorings.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
public @interface Refactoring {
    String nomPersonne(); 
    RefactoringName nomRefactoring();
    String Commentaire();
    String Chemin() default "/";
}
