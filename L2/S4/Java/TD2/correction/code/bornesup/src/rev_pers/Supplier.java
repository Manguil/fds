package rev_pers;

public class Supplier {

	// public serait trop permissif
	// private pas assez
	// protected est inapproprié car on n'est pas dans un cadre d'héritage
	// mais toutes les méthodes des classes du package auront accès
	// on ne peut pas faire mieux
	
	void supply() {}
	void retailerList() {}

}
