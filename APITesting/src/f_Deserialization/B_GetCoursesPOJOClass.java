package f_Deserialization;

import java.util.List;

//the setter method is used for Serialization and
//getter method is ued for De-serialziation.

public class B_GetCoursesPOJOClass {
	//select the change return type to list as Course has an arrays of element
	// refer - referenceMaterial.PNG
	private List<B1_WebAutomationGetCoursePOJOClass> webAutomation;
	private List<B2_APIGetCoursePOJOClass> api;
	private List<B3_MobileGetCoursePOJOClass> mobile;

	public List<B1_WebAutomationGetCoursePOJOClass> getWebAutomation() {
		return webAutomation;
	}

	public void setWebAutomation(List<B1_WebAutomationGetCoursePOJOClass> webAutomation) {
		this.webAutomation = webAutomation;
	}

	public List<B2_APIGetCoursePOJOClass> getApi() {
		return api;
	}

	public void setApi(List<B2_APIGetCoursePOJOClass> api) {
		this.api = api;
	}

	public List<B3_MobileGetCoursePOJOClass> getMobile() {
		return mobile;
	}

	public void setMobile(List<B3_MobileGetCoursePOJOClass> mobile) {
		this.mobile = mobile;
	}
}
