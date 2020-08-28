package duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
	@Test
	public void testToString() {
		Deadline deadline = new Deadline("submit essay", "2020-08-29");
		assertEquals("[D][\u2718] submit essay (by: SATURDAY, Aug 29 2020)", deadline.toString());
	}

	@Test
	public void testCompleteTask() {
		Deadline deadline = new Deadline("pay bills", "tomorrow");
		deadline = deadline.completeTask();
		assertEquals("[D][\u2713] pay bills (by: tomorrow)", deadline.toString());
	}

	@Test
	public void testGetData() {
		Deadline deadline = new Deadline("finish tutorial 1", "2020-08-27");
		assertEquals("DEADLINE#finish tutorial 1#false#2020-08-27", deadline.getData());
	}
}
