package contactservice;

public class Contact {
	private String contactID; 
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact(String cid, String fn, String ln, String pn, String addr) {
		// CR 2023-09-17 - Corrected conditional logic and fixed indentations.
		if(cid == null || cid.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID - null or length > 10");
		}
		else if(fn == null || fn.length() > 10) {
			throw new IllegalArgumentException("Invalid first name - null or length > 10");
		} 
		else if(ln == null || ln.length() > 10) {
			throw new IllegalArgumentException("Invalid last name - null or length > 10");
		} 
		// CR 2023-09-17 - Phone Number must be exactly 10 digits, check was checking for more than 10.
		else if(pn == null || pn.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number - null or length > 10");
		} 
		else if(addr == null || addr.length() > 30) {
			throw new IllegalArgumentException("Invalid address - null or length > 30");
		}
			this.contactID = fn.substring(0,3) + ln.substring(0,2) +pn.substring(2,5) + addr.substring(0,2);
			this.contactID = cid;
			this.firstName = fn;
			this.lastName = ln;
			this.phoneNumber = pn;
			this.address = addr;
	}
	
	public String getContactID() {
		return this.contactID;
	}
	
	public String getFirstName(){
		return this.firstName;
		
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
		
	}
	
	public String getAddress() {
		return this.address;
	}
	
	// CR 2023-09-17 - Should not be able to update this. Added exception.
	public void setContactID(String cid) {
		//this.contactID = cid;
		throw new IllegalArgumentException("ContactID cannot be changed!");
	}
	
	
	public void setFirstName(String fn) {
		this.firstName = fn;
	}
	
	public void setLastName(String ln) {
		this.lastName = ln;
	}
	
	public void setPhoneNumber(String pn) {
		this.phoneNumber = pn;
	}
	
	public void setAddress(String addr) {
		this.address = addr;
	}
	
	public static void main(String args[]) {
		// CR 2023-09-17 - Instantiation of test obj was missing contactID parameter. Added a temp ID of COP1
		Contact c = new Contact("COP1", "Chance","OPants","7145555555","123 fake st springfield");
		System.out.println(c.getContactID());
		System.out.println(c.getFirstName());
		System.out.println(c.getLastName());
		System.out.println(c.getPhoneNumber());
		System.out.println(c.getAddress());
	}		
}