package f_Deserialization;

// the setter method is used for Serialization and
// getter method is ued for De-serialziation.

public class A_MainPOJOClass {
	private String url;
	private String services;
	private String expertise;  
	//private String courses;	
	//private String dashboard;
	private String instructor; 
	private String linkedIn;
	
	/*
	 * Now after creating B_GetCoursesPOJOClass.java class we need to tell the return type of the course variable is not a String instead it's Class. 
	 * So, change the return type of course from String to CoursePOJO class as Course has mini JSOn i.e. inject child element into main class 
	 * private String courses;
	 */
	
	// here no list as Courses does not have array.
	// refer - referenceMaterial.PNG
	private B_GetCoursesPOJOClass courses;	//i.e course has a mini Json
	
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

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	/* Change the return type below method with POJO class as it has Mini JSOn
	 * public String getCourses() { return courses; }
	 * 
	 * public void setCourses(String courses) { this.courses = courses; }
	 * 
	 * public String getDashboard() { return dashboard; }
	 * 
	 * public void setDashboard(String dashboard) { this.dashboard = dashboard; }
	 */
	
	public B_GetCoursesPOJOClass getCourses() {
		return courses;
	}

	public void setCourses(B_GetCoursesPOJOClass courses) {
		this.courses = courses;
	}	
}
