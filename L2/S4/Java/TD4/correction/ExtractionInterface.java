package introspection;

import java.lang.reflect.*;
import java.util.ArrayList;

public class ExtractionInterface {
	
	public static void main(String[] s) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		System.out.println(extraitInterface("introspection.Appartement"));
		System.out.println(extraitInterface("introspection.AppartementResidence"));
	}

	public static String extraitInterface(String nomClasse) 
			throws ClassNotFoundException, IllegalArgumentException, 
		         IllegalAccessException, NoSuchFieldException, SecurityException{
		         
	  Class<?> c = Class.forName(nomClasse);	
	  String itf = "public interface I"+c.getSimpleName();
	  
	  Class<?>[] interfaces = c.getInterfaces();
	  Class<?> superclasse = c.getSuperclass();
	  
	  itf += " implements "+"I"+superclasse.getSimpleName();
	  
	  for (Class<?> i : interfaces)
	  {
		  itf += ", "+i.getSimpleName();
	  }
				
	  itf += "{\n";
	  
	  Method[] methSuperClasse = c.getSuperclass().getMethods();
	  ArrayList<String> signaturesMethSuperClasse = new ArrayList<String> ();
	  for (Method ms : methSuperClasse) {
		  String sig = "";
		  if (Modifier.isPublic(ms.getModifiers()) 
			        && !Modifier.isStatic(ms.getModifiers())){ 
			  	sig = "  "+ms.getReturnType().getSimpleName()+" "; 
			  	sig += ms.getName()+"("; 
			    for (int i=0; i < ms.getParameterTypes().length; i++){  
			        	  sig += ms.getParameterTypes()[i].getSimpleName()+" p"+i;    
			             if (i<ms.getParameterTypes().length-1) sig +=","; 
			     }
			     sig += ");\n"; 
			     signaturesMethSuperClasse.add(sig);
		  }
	  }
	  
	  //System.out.println("signatures methodes heritee"+signaturesMethSuperClasse);
	  
	  for (Method m : c.getDeclaredMethods()) {
		  String sig = "";
	      if (Modifier.isPublic(m.getModifiers()) 
	        && !Modifier.isStatic(m.getModifiers())){ 
	          sig += "  "+m.getReturnType().getSimpleName()+" "; 
	          sig += m.getName()+"("; 
	          for (int i=0; i < m.getParameterTypes().length; i++){  
	        	  sig += m.getParameterTypes()[i].getSimpleName()+" p"+i;    
	             if (i<m.getParameterTypes().length-1) sig +=","; 
	          }
	          sig += ");\n"; 
	          if (! signaturesMethSuperClasse.contains(sig))
	        	  itf += sig;
	    	  //System.out.println(signaturesMethSuperClasse.contains(sig));
	      }
	  }
	   return itf+"}\n";
	}
}
