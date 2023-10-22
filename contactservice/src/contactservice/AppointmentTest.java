package contactservice;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class AppointmentTest {
	private String id, description;
	  private String tooLongId, tooLongDescription;
	  private Date date, pastDate;

	  @SuppressWarnings("deprecation")
	  @BeforeEach
	  void setUp() {
	    id = "1234567890";
	    description = "The appt object shall have a required description.";
	    date = new Date(3021, Calendar.JANUARY, 1);
	    tooLongId = "111222333444555666777888999";
	    tooLongDescription =
	        "This description is too long for the appointment requirements but good for testing.";
	    pastDate = new Date(0);
	  }
	  
	  //Appt ID tests

	  @Test
	  void testUpdateAppointmentIdNull() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class,
	                 () -> appt.updateAppointmentId(null));
	  }
	  
	  @Test
	  void testUpdateAppointmentIdShort() {
	    Appointment appt = new Appointment();
	    String shortId = id.substring(0,5);
	    appt.updateAppointmentId(shortId);
	    assertEquals(shortId, appt.getAppointmentId());
	  }
	  
	  @Test
	  void testUpdateAppointmentIdExact() {
	    Appointment appt = new Appointment();
	    appt.updateAppointmentId(id);
	    assertEquals(id, appt.getAppointmentId());
	  }
	  
	  @Test
	  void testUpdateAppointmentLong() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class,
	                 () -> appt.updateAppointmentId(tooLongId));
	  }

	  @Test
	  void testGetAppointmentId() {
	    Appointment appt = new Appointment(id);
	    assertNotNull(appt.getAppointmentId());
	    assertEquals(appt.getAppointmentId().length(), 10);
	    assertEquals(id, appt.getAppointmentId());
	  }
	  
	  //Date Tests

	  @Test
	  void testUpdateDateNull() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class, () -> appt.updateDate(null));
	  }
	  
	  @Test
	  void testUpdateDateBefore() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class,
	                 () -> appt.updateDate(pastDate));
	  }
	  
	  @Test
	  void testUpdateDateCurrent() {
	    Appointment appt = new Appointment();
	    Date curDate = new Date();
	    appt.updateDate(curDate);
	    assertEquals(curDate, appt.getAppointmentDate());
	  }
	  
	  @Test
	  void testUpdateDateFuture() {
	    Appointment appt = new Appointment();
	    appt.updateDate(date);
	    assertEquals(date, appt.getAppointmentDate());
	  }

	  @Test
	  void testGetAppointmentDate() {
	    Appointment appt = new Appointment(id, date);
	    assertNotNull(appt.getAppointmentDate());
	    assertEquals(date, appt.getAppointmentDate());
	  }

	  //Description Tests
	  @Test
	  void testUpdateDescriptionNull() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class,
	                 () -> appt.updateDescription(null));
	  }
	  
	  @Test
	  void testUpdateDescriptionShort() {
	    Appointment appt = new Appointment();
	    String shortDesc = description.substring(0, 20);
	    appt.updateDescription(shortDesc);
	    assertEquals(shortDesc, appt.getDescription());
	  }
	  
	  @Test
	  void testUpdateDescriptionExact() {
		  Appointment appt = new Appointment();
		    String exactDesc = tooLongDescription.substring(0, 50);
		    appt.updateDescription(exactDesc);
		    assertEquals(exactDesc, appt.getDescription());
	  }
	  
	  @Test
	  void testUpdateDescriptionTooLong() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class,
	                 () -> appt.updateDescription(tooLongDescription));
	  }

	  @Test
	  void testGetDescription() {
	    Appointment appt = new Appointment(id, date, description);
	    assertNotNull(appt.getDescription());
	    assertTrue(appt.getDescription().length() <= 50);
	    assertEquals(description, appt.getDescription());
	  }
}
