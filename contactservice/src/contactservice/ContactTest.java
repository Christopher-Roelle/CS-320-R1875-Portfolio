package contactservice;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
	protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,addressTest;
	protected String tooLongContactId, tooLongFirstName, tooLongLastName,tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;
	
	
	@BeforeEach
	void setUp() {
		contactId = "1029F847A6";
		firstNameTest = "John";
		lastNameTest = "Smith";
		phoneNumberTest = "5553331234";
		addressTest = "1 Audrey Jersey City NJ 07305";
		tooLongContactId = "112233445566778899";
		tooLongFirstName = "John Jacob Jingle";
		tooLongLastName = "-heimer Schmidt";
		tooLongPhoneNumber = "55512341234";
		tooShortPhoneNumber = "1234567";
		tooLongAddress = "1 Audrey Zapp Drive, Jersey City, NJ 07305"; 
	}
	
	//ContactID tests
	@Test
	void TestNullContactID() {
		assertThrows(IllegalArgumentException.class, 
				() -> {new Contact(null, firstNameTest, lastNameTest, phoneNumberTest, addressTest);});
	}
	
	@Test
	void TestContactIDLessThan10() {
		
		String shortContactId = "Test6";
		
		Contact newContact = new Contact(shortContactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
		
		assertTrue(newContact != null);
	}
	
	@Test
	void TestContactID10Characters() {
		
		Contact newContact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);

		assertTrue(newContact != null);
	}
	
	@Test
	void TestContactIDLongerThan10() {
		assertThrows(IllegalArgumentException.class, 
				() -> {new Contact(tooLongContactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);});
	}
	
	@Test
	void TestUpdateContactIDException() {
		Contact testContact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
		assertThrows(IllegalArgumentException.class, 
				() -> {testContact.setContactID("newID");});
	}
	
	//FirstName tests
	@Test
	void TestNullFirstName() {
		assertThrows(IllegalArgumentException.class, 
				() -> {new Contact(contactId, null, lastNameTest, phoneNumberTest, addressTest);});
	}
	
	@Test
	void TestFirstNameLessThan10() {
		
		String shortFname = "Chris";
		
		Contact newContact = new Contact(contactId, shortFname, lastNameTest, phoneNumberTest, addressTest);

		assertTrue(newContact != null);
	}
	
	@Test
	void TestFirstName10Characters() {
		
		String fName10Char = "Christophe";
		
		Contact newContact = new Contact(contactId, fName10Char, lastNameTest, phoneNumberTest, addressTest);

		assertTrue(newContact != null);
	}
	
	@Test
	void TestFirstNameLongerThan10() {
		assertThrows(IllegalArgumentException.class, 
				() -> {new Contact(contactId, tooLongFirstName, lastNameTest, phoneNumberTest, addressTest);});
	}
	
	//LastName tests
	@Test
	void TestNullLastName() {
		assertThrows(IllegalArgumentException.class, 
				() -> {new Contact(contactId, firstNameTest, null, phoneNumberTest, addressTest);});
	}
	
	@Test
	void TestLastNameLessThan10() {
		
		String shortLname = "Roelle";
		
		Contact newContact = new Contact(contactId, firstNameTest, shortLname, phoneNumberTest, addressTest);

		assertTrue(newContact != null);
	}
	
	@Test
	void TestLastName10Characters() {
		
		String lName10Char = "Christophe";
		
		Contact newContact = new Contact(contactId, firstNameTest, lName10Char, phoneNumberTest, addressTest);

		assertTrue(newContact != null);
	}
	
	@Test
	void TestLastNameLongerThan10() {
		assertThrows(IllegalArgumentException.class, 
				() -> {new Contact(contactId, firstNameTest, tooLongLastName, phoneNumberTest, addressTest);});
	}
	
	//PhoneNumber tests
	@Test
	void TestNullPhoneNumber10Digits() {
		assertThrows(IllegalArgumentException.class, 
				() -> {new Contact(contactId, firstNameTest, lastNameTest, null, addressTest);});
	}
	
	@Test
	void TestPhoneNumberTooLong() {
		assertThrows(IllegalArgumentException.class, 
				() -> {new Contact(contactId, firstNameTest, lastNameTest, tooLongPhoneNumber, addressTest);});
	}
	
	@Test
	void TestPhoneNumberTooShort() {
		assertThrows(IllegalArgumentException.class, 
				() -> {new Contact(contactId, firstNameTest, lastNameTest, tooShortPhoneNumber, addressTest);});
	}
	
	//Address tests
	@Test
	void TestNullAddress() {
		assertThrows(IllegalArgumentException.class, 
				() -> {new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, null);});
	}
	
	@Test
	void TestAddressLessThan30() {
		
		String shortAddress = "1123 Main St";
		
		Contact newContact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, shortAddress);

		assertTrue(newContact != null);
	}
	
	@Test
	void TestAddress30Characters() {
		
		String address30 = tooLongAddress.substring(0, 30);
		
		Contact newContact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, address30);

		assertTrue(newContact != null);
	}
	
	@Test
	void TestAddressLongerThan30() {
		assertThrows(IllegalArgumentException.class, 
				() -> {new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, tooLongAddress);});
	}
	
}
