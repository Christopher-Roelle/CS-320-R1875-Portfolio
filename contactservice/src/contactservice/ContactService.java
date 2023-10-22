package contactservice;
import java.util.*;

public class ContactService {
	private ArrayList<Contact> listOfContacts;
	public ContactService() {
		listOfContacts = new ArrayList<>();
	}
	
	public boolean addContact(Contact c) {
		boolean contactExist = false;
		
		//Loop through all contacts, if contact matches, set flag...
		for(Contact l:listOfContacts) {
			if(l.equals(c)) {
				contactExist = true;
			}
			// CR 2023-09-17 - Missing semicolon.
		}
			
		//If flag is not set, add contact and return true, else false, and add nothing.
		if(!contactExist) {
			listOfContacts.add(c);
			return true;
		}
		else { 
			return false;
		}
	}
	
			
		
	public boolean deleteContact(String cid) {
		for(Contact l:listOfContacts) {
			if(l.getContactID().equals(cid)) {
				listOfContacts.remove(l);
				return true;
				
			}
		}
		return false;
	}



	public boolean updateContact(String cid, String fn, String ln, String pn, String addr) {
		for(Contact l:listOfContacts) {
			if(l.getContactID().equals(cid)) {
				if(!fn.equals("") && !(fn.length() > 10)) {
					l.setFirstName(fn);
				}
				if(!ln.equals("") && !(ln.length() > 10)) {
					l.setLastName(ln);
				}
				if(!pn.equals("") && !(pn.length() > 10)) {
					l.setPhoneNumber(pn);
				}
				if(!addr.equals("") && !(addr.length() > 30)) {
					l.setAddress(addr);
				}
				return true;
			}
		}
		return false;
		
	}
}
	


