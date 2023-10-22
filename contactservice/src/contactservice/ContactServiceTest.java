package contactservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	@Test
	 public void testMethodAddPass() {
		 ContactService cs = new ContactService();
		 Contact c1 = new Contact("Test1", "Steve", "Young", "0987654321","8 Victory Pl,");
		 Contact c2 = new Contact("Test2", "Ronnie", "Lott", "1234509876", "49 Niner Way");
		 Contact c3 = new Contact("Test3", "Jerry", "Rice", "4567890123", "1 GOAT Dr.");
		 
		 assertEquals(true, cs.addContact(c1));
		 assertEquals(true, cs.addContact(c2));
		 assertEquals(true, cs.addContact(c3));
	}
	
	@Test
	public void testMethodAddFail() {
		ContactService cs = new ContactService();
		Contact c1 = new Contact("Test1", "Steve", "Young", "0987654321","8 Victory Pl,");
		Contact c2 = new Contact("Test2", "Ronnie", "Lott", "1234509876", "49 Niner Way");
		Contact c3 = new Contact("Test3", "Jerry", "Rice", "4567890123", "1	GOAT Dr.");
		
		assertEquals(true, cs.addContact(c1));
		assertEquals(false, cs.addContact(c1));
		assertEquals(true, cs.addContact(c3));
		assertEquals(true, cs.addContact(c2));
	}
	
	@Test
	public void testMethodDeletePass() {
		ContactService cs = new ContactService();
		Contact c1 = new Contact("Test1", "Steve", "Young", "0987654321","8 Victory Pl,");
		Contact c2 = new Contact("Test2", "Ronnie", "Lott", "1234509876", "49 Niner Way");
		Contact c3 = new Contact("Test3", "Jerry", "Rice", "4567890123", "1	GOAT Dr.");
				
		assertEquals(true, cs.addContact(c1));
		assertEquals(true, cs.addContact(c2));
		assertEquals(true, cs.addContact(c3));
		assertEquals(true, cs.deleteContact("Test1"));
		assertEquals(true, cs.deleteContact("Test2"));
	}
	
	@Test
	public void testMethodDeleteFail() {
		ContactService cs = new ContactService();
		Contact c1 = new Contact("Test1", "Steve", "Young", "0987654321","8 Victory Pl,");
		Contact c2 = new Contact("Test2", "Ronnie", "Lott", "1234509876", "49 Niner Way");
		Contact c3 = new Contact("Test3", "Jerry", "Rice", "4567890123", "1	GOAT Dr.");
		
		assertEquals(true, cs.addContact(c1));
		assertEquals(true, cs.addContact(c3));
		assertEquals(true, cs.addContact(c2));
		assertEquals(false, cs.deleteContact("Test4"));
		assertEquals(true, cs.deleteContact("Test2"));
	}
	
	@Test
	public void testUpdatePass() {
		ContactService cs = new ContactService();
		Contact c1 = new Contact("Test1", "Steve", "Young", "0987654321","8 Victory Pl,");
		Contact c2 = new Contact("Test2", "Ronnie", "Lott", "1234509876", "49 Niner Way");
		Contact c3 = new Contact("Test3", "Jerry", "Rice", "4567890123", "1	GOAT Dr.");
		
		assertEquals(true, cs.addContact(c1));
		assertEquals(true, cs.addContact(c3));
		assertEquals(true, cs.addContact(c2));
		assertEquals(true, cs.updateContact("Test2", "Ronnie", "Lott", "4242424242", "1 GOAT Dr."));
		assertEquals(true, cs.updateContact("Test3", "Jerry", "Rice", "8080808080", "49 Niner Way"));
	}
	@Test
	public void testUpdateFail() {
		ContactService cs = new ContactService();
		Contact c1 = new Contact("Test1", "Steve", "Young", "0987654321","8 Victory Pl,");
		Contact c2 = new Contact("Test2", "Ronnie", "Lott", "1234509876", "49 Niner Way");
		Contact c3 = new Contact("Test3", "Jerry", "Rice", "4567890123", "1	GOAT Dr.");
		
		assertEquals(true, cs.addContact(c1));
		assertEquals(true, cs.addContact(c3));
		assertEquals(true, cs.addContact(c2));
		assertEquals(false, cs.updateContact("Test4", "Fred", "Warner", "1111100000", "123 Any St."));
		assertEquals(true, cs.updateContact("Test2", "Joe", "Montana", "1616161616", "4 Superbowl Ln."));
	}
}
