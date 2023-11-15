
public class Stack {
	private Object[] elements;
	private Integer length = 0;

	public Stack(int maximumElements) {
		elements = new Object[maximumElements];
	}

	public boolean isEmpty() {
		return this.length == 0;
	}

	public Integer length() {
		return this.length;
	}

	public void push(Object element) {
		if(this.length == elements.length) {
			throw new FullStackAddException("Não é possível adicionar um elemento, pois a pilha está cheia!");
		}
		
		this.elements[length] = element;
		this.length++;
	}

	public Object top() {
		return this.elements[length - 1];
	}

	public Object pop() {
		if(this.isEmpty()) {
			throw new EmptyStackRemoveException("Não é possível remover um elemento numa pilha vazia!");
		}
		
		Object removedElementFromTheStack = this.elements[length - 1];
		
		this.elements[length - 1] = null;
		this.length--;
		
		return removedElementFromTheStack;
	}

	

}
