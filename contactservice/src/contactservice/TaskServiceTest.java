package contactservice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	private String id, name, description;
	 private String tooLongName, tooLongDescription;
	 
	 @BeforeEach
	  void setUp() {
	    id = "1234567890";
	    name = "This is Twenty Chars";
	    description = "The task object shall have a required description.";
	    tooLongName = "This is way too long to be a task name";
	    tooLongDescription =
	        "The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.";
	  }

	 //New Task Tests
	  @Test
	  void newTaskTest() {
		    TaskService service = new TaskService();
		    service.newTask();
		    Assertions.assertNotNull(service.getTaskList().get(0).getTaskId());
		    Assertions.assertNotEquals("INITIAL",
	                               service.getTaskList().get(0).getTaskId());
	  }

	  //Name
	  
	  @Test
	  void newTaskNameNullTest() {
		  	TaskService service = new TaskService();
		  	assertThrows(IllegalArgumentException.class, () -> service.newTask(null));
	  }
	  
	  @Test
	  void newTaskName10CharTest() {
		  TaskService service = new TaskService();
		  service.newTask(name);
		  Assertions.assertNotNull(service.getTaskList().get(0).getName());
		  Assertions.assertEquals(name, service.getTaskList().get(0).getName());
	  }
	  
	  @Test
	  void newShortTaskNameTest() {
		  TaskService service = new TaskService();
		  name = name.substring(0, 5);
		  service.newTask(name);
		  Assertions.assertNotNull(service.getTaskList().get(0).getName());
		  Assertions.assertEquals(name, service.getTaskList().get(0).getName());
	  }
	  
	  @Test
	  void newTaskTooLongNameTest() {
		  	TaskService service = new TaskService();
		    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> service.newTask(tooLongName));
	  }
	  
	  //Description
	  
	  @Test
	  void newTaskDescriptionNullTest() {
		  	TaskService service = new TaskService();
		  	assertThrows(IllegalArgumentException.class,
	                 () -> service.newTask(name, null));
	  }

	  @Test
	  void newTaskDescription50CharTest() {
		  TaskService service = new TaskService();
		  	description = tooLongDescription.substring(0, 50);
		    service.newTask(name, description);
		    Assertions.assertNotNull(service.getTaskList().get(0).getDescription());
		    Assertions.assertEquals(description,
		                            service.getTaskList().get(0).getDescription());
	  }
	  
	  @Test
	  void newShortTaskDescriptionTest() {
		  TaskService service = new TaskService();
		  	description = description.substring(0, 5);
		    service.newTask(name, description);
		    Assertions.assertNotNull(service.getTaskList().get(0).getDescription());
		    Assertions.assertEquals(description,
		                            service.getTaskList().get(0).getDescription());
	  }

	  @Test
	  void newTaskTooLongDescriptionTest() {
	  		TaskService service = new TaskService();
	  		assertThrows(IllegalArgumentException.class,
	                 () -> service.newTask(name, tooLongDescription));
	  }
	  
	  //Delete Tests

	  @Test
	  void deleteTaskTest() throws Exception {
		  	TaskService service = new TaskService();
		    service.newTask();
		    assertEquals(1, service.getTaskList().size());
		    service.deleteTask(service.getTaskList().get(0).getTaskId());
		    assertEquals(0, service.getTaskList().size());
	  }

	  @Test
	  void deleteTaskNotFoundTest() throws Exception {
		  	TaskService service = new TaskService();
		  	service.newTask();
		  	assertEquals(1, service.getTaskList().size());
		  	assertThrows(Exception.class, () -> service.deleteTask(id));
	    	assertEquals(1, service.getTaskList().size());
	  }
	  
	  //Update Name Tests
	  
	  @Test
	  void updateNameNotFoundTest() throws Exception {
		  	TaskService service = new TaskService();
		  	service.newTask();
		  	assertThrows(Exception.class, () -> service.updateName(id, name));
	  }

	  @Test
	  void updateNameTest() throws Exception {
		  	TaskService service = new TaskService();
		  	service.newTask();
		  	service.updateName(service.getTaskList().get(0).getTaskId(), name);
		  	assertEquals(name, service.getTaskList().get(0).getName());
	  }
	  
	  @Test
	  void updateNameTestShort() throws Exception {
		  	TaskService service = new TaskService();
		  	name = name.substring(0, 5);
		  	service.newTask();
		  	service.updateName(service.getTaskList().get(0).getTaskId(), name);
		  	assertEquals(name, service.getTaskList().get(0).getName());
	  }
	  
	  @Test
	  void updateNameTestNull() throws Exception {
		  	TaskService service = new TaskService();
		  	service.newTask();
		  	assertThrows(IllegalArgumentException.class, ()-> {
		  		service.updateName(service.getTaskList().get(0).getTaskId(), null);
		  	});
	  }
	  
	  @Test
	  void updateNameTestTooLong() throws Exception {
		  	TaskService service = new TaskService();
		  	service.newTask();
		  	assertThrows(IllegalArgumentException.class, ()-> {
		  		service.updateName(service.getTaskList().get(0).getTaskId(), tooLongName);
		  	});
	  }
	  
	  //Update Description Tests
	  
	  @Test
	  void updateDescriptionNotFoundTest() throws Exception {
		  	TaskService service = new TaskService();
		  	service.newTask();
		  	assertThrows(Exception.class,
	                 () -> service.updateDescription(id, description));
	  }

	  @Test
	  void updateDescriptionTest() throws Exception {
		  	TaskService service = new TaskService();
		  	service.newTask();
		  	service.updateDescription(service.getTaskList().get(0).getTaskId(),
	                              description);
		  	assertEquals(description, service.getTaskList().get(0).getDescription());
	  }  
	  
	  @Test
	  void updateDescriptionTestShort() throws Exception {
		  	TaskService service = new TaskService();
		  	description = description.substring(0, 5);
		  	service.newTask();
		  	service.updateDescription(service.getTaskList().get(0).getTaskId(), description);
		  	assertEquals(description, service.getTaskList().get(0).getDescription());
	  }
	  
	  @Test
	  void updateDescriptionTestNull() throws Exception {
		  	TaskService service = new TaskService();
		  	service.newTask();
		  	assertThrows(IllegalArgumentException.class, ()-> {
		  		service.updateDescription(service.getTaskList().get(0).getTaskId(), null);
		  	});
	  }
	  
	  @Test
	  void updateDescriptionTestTooLong() throws Exception {
		  	TaskService service = new TaskService();
		  	service.newTask();
		  	assertThrows(IllegalArgumentException.class, ()-> {
		  		service.updateDescription(service.getTaskList().get(0).getTaskId(), tooLongDescription);
		  	});
	  }

	  //Unique ID Test

	  @RepeatedTest(4)
	  void UuidTest() {
		  	TaskService service = new TaskService();
		    service.newTask();
		    service.newTask();
		    service.newTask();
		    assertEquals(3, service.getTaskList().size());
		    assertNotEquals(service.getTaskList().get(0).getTaskId(),
		                    service.getTaskList().get(1).getTaskId());
		    assertNotEquals(service.getTaskList().get(0).getTaskId(),
		                    service.getTaskList().get(2).getTaskId());
		    assertNotEquals(service.getTaskList().get(1).getTaskId(),
		                    service.getTaskList().get(2).getTaskId());
	  }
	}


