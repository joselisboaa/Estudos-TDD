import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {
	
	private Stack stack;
	
	@BeforeEach
	public void initializeStack() {
		stack = new Stack(10);
	}

	@Test
	public void voidStack() {			
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.length());
	}
	
	@Test
	public void pileOneElementOnTheStack() {
		stack.push("first element");
		
		assertFalse(stack.isEmpty());
		assertEquals(1, stack.length());
		assertEquals("first element", stack.top());
	}
	
	@Test
	public void pileTwoElementsOnTheStackAndUnstackOneElement() {	
		stack.push("first element");
		stack.push("second element");
		
		assertEquals(2, stack.length());
		assertEquals("second element", stack.top());

		Object stackTop = stack.pop();
		
		assertEquals(1, stack.length());
		assertEquals("second element", stackTop);
		assertEquals("first element", stack.top());
	}

	@Test
	public void removeFromEmptyStack() {
		EmptyStackRemoveException exception = assertThrows(EmptyStackRemoveException.class, () -> stack.pop());		
	
		assertEquals(exception.getMessage(), "Não é possível remover um elemento numa pilha vazia!");
	}
	
	@Test
	public void addInAFullStack() {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		try {
			stack.push("Full stack");
			fail();
		} catch (FullStackAddException e) {}

	}
}
