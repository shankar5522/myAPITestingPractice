package f_pojoconcept;

//the setter method is used for Serialization and
//getter method is ued for De-serialziation.


public class C_DashboardPOJOClass {
	
	private String purchaseAmount;
	private String website;
	
	public String getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

}
