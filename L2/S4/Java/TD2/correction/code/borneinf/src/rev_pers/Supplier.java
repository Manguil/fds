package rev_pers;

public class Supplier {

	// public et package seraient trop permissif
	// protected est inapproprié car on n'est pas dans un cadre d'héritage
	// mais toutes les méthodes des classes du package auront accès
	// on ne peut pas faire mieux
	
	// on peut ne pas les autoriser car sinon un des deux serait accessible alors qu'on de devrait pas
	private void supply() {}
	private void retailerList() {}

}
