package introspection;

public class AppartementResidence extends Appartement{
	private String services = "aucun service";
	AppartementResidence(){}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
    public String feuilleLoyer(){return super.feuilleLoyer()+"\nen résidence";}
}
