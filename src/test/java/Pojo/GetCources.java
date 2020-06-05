package Pojo;

public class GetCources {
	
	private String url;
	private String services;
	private String expertise;
	//private String Cources;
	private String instructor;
	private String linkedin;
	private Cources Cources;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public Pojo.Cources getCources() {
		return Cources;
	}
	public void setCources(Pojo.Cources cources) {
		Cources = cources;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	
	

}
