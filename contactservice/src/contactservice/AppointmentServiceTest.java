package contactservice;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class AppointmentServiceTest {
	private String id, description, tooLongDescription;
	  private Date date, pastDate;

	  @SuppressWarnings("deprecation")
	  @BeforeEach
	  void setUp() {
	    id = "1234567890";
	    description = "The appt object shall have a required description.";
	    date = new Date(3021, Calendar.JANUARY, 1);
	    tooLongDescription =
	        "This description is too long for the appointment requirements but good for testing.";
	    pastDate = new Date(0);
	  }

	  //New Appointment Tests
	  @Test
	  void testNewAppointmentUniqueIds() {
	    AppointmentService service = new AppointmentService();

	    service.newAppointment();
	    assertNotNull(service.getAppointmentList().get(0).getAppointmentId());

	    service.newAppointment(date);
	    assertNotNull(service.getAppointmentList().get(1).getAppointmentId());

	    service.newAppointment(date, description);
	    assertNotNull(service.getAppointmentList().get(2).getAppointmentId());

	    assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
	                    service.getAppointmentList().get(1).getAppointmentId());
	    assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
	                    service.getAppointmentList().get(2).getAppointmentId());
	    assertNotEquals(service.getAppointmentList().get(1).getAppointmentId(),
	                    service.getAppointmentList().get(2).getAppointmentId());
	  }
	  
	  @Test
	  void testNewAppointmentNullDate() {
	    AppointmentService service = new AppointmentService();

	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newAppointment(null));
	  }
	  
	  @Test
	  void testNewAppointmentPastDate() {
		    AppointmentService service = new AppointmentService();

		    assertThrows(IllegalArgumentException.class,
		                 () -> service.newAppointment(pastDate));
	  }
	  
	  @Test
	  void testNewAppointmentCurDate() {
		    AppointmentService service = new AppointmentService();
		    
		    Date curDate = new Date();

		    service.newAppointment(curDate);
		    
		    assertEquals(curDate, service.getAppointmentList().get(0).getAppointmentDate());
	  }
	  
	  @Test
	  void testNewAppointmentFutureDate() {
		  	AppointmentService service = new AppointmentService();

		    service.newAppointment(date);
		    
		    assertEquals(date, service.getAppointmentList().get(0).getAppointmentDate());
	  }
	  
	  //Delete Tests

	  @Test
	  void deleteAppointmentNotExists() throws Exception {
	    AppointmentService service = new AppointmentService();

	    service.newAppointment();
	    service.newAppointment();
	    service.newAppointment();

	    String firstId = service.getAppointmentList().get(0).getAppointmentId();
	    String secondId = service.getAppointmentList().get(1).getAppointmentId();
	    String thirdId = service.getAppointmentList().get(2).getAppointmentId();

	    assertNotEquals(firstId, secondId);
	    assertNotEquals(firstId, thirdId);
	    assertNotEquals(secondId, thirdId);
	    assertNotEquals(id, firstId);
	    assertNotEquals(id, secondId);
	    assertNotEquals(id, thirdId);

	    assertThrows(Exception.class, () -> service.deleteAppointment(id));
	  }
	  
	  @Test
	  void deleteAppointment() throws Exception {
	    AppointmentService service = new AppointmentService();

	    service.newAppointment();
	    service.newAppointment();
	    service.newAppointment();

	    String firstId = service.getAppointmentList().get(0).getAppointmentId();
	    String secondId = service.getAppointmentList().get(1).getAppointmentId();
	    String thirdId = service.getAppointmentList().get(2).getAppointmentId();

	    assertNotEquals(firstId, secondId);
	    assertNotEquals(firstId, thirdId);
	    assertNotEquals(secondId, thirdId);
	    assertNotEquals(id, firstId);
	    assertNotEquals(id, secondId);
	    assertNotEquals(id, thirdId);

	    service.deleteAppointment(firstId);
	    assertNotEquals(firstId,
	                    service.getAppointmentList().get(0).getAppointmentId());
	  }
	  
	  @Test
	  void deleteDupeAppointment() throws Exception {
	    AppointmentService service = new AppointmentService();

	    service.newAppointment();

	    String firstId = service.getAppointmentList().get(0).getAppointmentId();

	    service.deleteAppointment(firstId);
	    
	    //Check zero size
	    assertEquals(0,
	                    service.getAppointmentList().size());
	    assertThrows(Exception.class, () -> service.deleteAppointment(firstId));
	  }

}
