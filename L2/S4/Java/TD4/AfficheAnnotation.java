import java.util.Arrays;

public class AfficheAnnotation{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Personne.class.getDeclaredAnnotations()));
        
    }
}