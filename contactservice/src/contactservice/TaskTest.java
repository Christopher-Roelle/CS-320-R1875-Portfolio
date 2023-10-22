package contactservice;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TaskTest {
	 private String id, name, description;
	  private String tooLongId, tooLongName, tooLongDescription;

	  @BeforeEach
	  void setUp() {
	    id = "1234567890";
	    name = "This is Twenty Chars";
	    description = "The task object shall have a required description.";
	    tooLongId = "111222333444555666777888999";
	    tooLongName = "This is way too long to be a task name";
	    tooLongDescription =
	        "The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.";
	  }

	  //Task ID tests
	  @Test
	  void uniqueIdTest() {
		  Task task1 = new Task(id);
		  Task task2 = new Task(id.substring(0,id.length()-1));
		  Task task3 = new Task(id.substring(0,id.length()-2));
		  
		  String task1ID = task1.getTaskId();
		  String task2ID = task2.getTaskId();
		  String task3ID = task3.getTaskId();
		  
		  //Verify the tasks are not the same obj
		  assertNotEquals(task1, task2);
		  assertNotEquals(task1, task3);
		  assertNotEquals(task2, task3);
		  
		  //Verify the IDs are unique
		  assertNotEquals(task1ID, task2ID);
		  assertNotEquals(task1ID, task3ID);
		  assertNotEquals(task2ID, task3ID);
	  }
	  
	  @Test
	  void getTaskIdTest() {
	    Task task = new Task(id);
	    Assertions.assertEquals(id, task.getTaskId());
	  }
	  
	  @Test
	  void TaskIdNullTest() {
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> new Task(null));
	  }
	  
	  @Test
	  void TaskIdLessThan10() {
		  String testId = id.substring(0, 5);
		  
		  //Verify less than 10
		  if(!(testId.length() < 10)) {
			  fail("Test expected less than 10 characters!");
		  }
		  
		  try{
			  new Task(testId);
		  } catch(Exception e) {
			  fail("Test expected less than 10 characters!" + e);
		  }
	  }
	  
	  @Test
	  void TaskIdEquals10() {
		  String testId = id;
		  
		  //Verify less than 10
		  if(testId.length() != 10) {
			  fail("Test expected exactly 10 characters!");
		  }
		  
		  try{
			  new Task(testId);
		  } catch(Exception e) {
			  fail("Test expected exactly 10 characters!" + e);
		  }
	  }
	  
	  @Test
	  void TaskIdMoreThan10() {
		  String testId = tooLongId;
		  
		  //Verify less than 10
		  if(!(testId.length() > 10)) {
			  fail("Test expected more than 10 characters!");
		  }
		  
		  Assertions.assertThrows(IllegalArgumentException.class, () ->
		  {new Task(testId);});
	  }
	  
	  //Task Name test

	  @Test
	  void getNameTest() {
	    Task task = new Task(id, name);
	    Assertions.assertEquals(name, task.getName());
	  }
	  
	  @Test
	  void setNameTest() {
	    Task task = new Task();
	    task.setName(name);
	    Assertions.assertEquals(name, task.getName());
	  }
	  
	  @Test
	  void TaskNameNullTest() {
	    Task task = new Task();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> task.setName(null));
	  }
	  
	  @Test
	  void TaskNameLessThan20() {
		  String testName = name.substring(0, 5);
		  
		  //Verify less than 10
		  if(!(testName.length() < 20)) {
			  fail("Test expected less than 20 characters!");
		  }
		  
		  try{
			  Task task = new Task();
			  task.setName(testName);
			  
		  } catch(Exception e) {
			  fail("Test expected less than 20 characters!" + e);
		  }
	  }
	  
	  @Test
	  void TaskIdEquals20() {
		  String testName = name;
		  
		  //Verify less than 10
		  if(testName.length() != 20) {
			  fail("Test expected exactly 20 characters!");
		  }
		  
		  try{
			  Task task = new Task();
			  task.setName(testName);
		  } catch(Exception e) {
			  fail("Test expected exactly 20 characters!" + e);
		  }
	  }
	  
	  @Test
	  void TaskNameMoreThan20() {
		  String testName = tooLongName;
		  
		  //Verify less than 10
		  if(!(testName.length() > 20)) {
			  fail("Test expected more than 20 characters!");
		  }
		  
		  Assertions.assertThrows(IllegalArgumentException.class, () ->
		  {	Task task = new Task();
		  	task.setName(testName);
		  });
	  }
	  
	  //Test Description Tests
	  
	  @Test
	  void getDescriptionTest() {
	    Task task = new Task(id, name, description);
	    Assertions.assertEquals(description, task.getDescription());
	  }

	  @Test
	  void setDescriptionTest() {
	    Task task = new Task();
	    task.setDescription(description);
	    Assertions.assertEquals(description, task.getDescription());
	  }

	  @Test
	  void TaskDescriptionNullTest() {
	    Task task = new Task();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> task.setDescription(null));
	  }
	  
	  @Test
	  void TaskDescriptionLessThan50() {
		  String testDescription = description.substring(0, 5);
		  
		  //Verify less than 10
		  if(!(testDescription.length() < 50)) {
			  fail("Test expected less than 50 characters!");
		  }
		  
		  try{
			  Task task = new Task();
			  task.setDescription(testDescription);
			  
		  } catch(Exception e) {
			  fail("Test expected less than 50 characters!" + e);
		  }
	  }
	  
	  @Test
	  void TaskDescriptionEquals50() {
		  String testDescription = tooLongDescription.substring(0, 50);
		  
		  //Verify less than 10
		  if(testDescription.length() != 50) {
			  fail("Test expected exactly 50 characters!");
		  }
		  
		  try{
			  Task task = new Task();
			  task.setDescription(testDescription);
		  } catch(Exception e) {
			  fail("Test expected exactly 50 characters!" + e);
		  }
	  }
	  
	  @Test
	  void TaskDescriptionMoreThan50() {
		  String testDescription = tooLongDescription;
		  
		  //Verify less than 10
		  if(!(testDescription.length() > 50)) {
			  fail("Test expected more than 50 characters!");
		  }
		  
		  Assertions.assertThrows(IllegalArgumentException.class, () ->
		  {	Task task = new Task();
		  	task.setDescription(testDescription);
		  });
	  }
	}



