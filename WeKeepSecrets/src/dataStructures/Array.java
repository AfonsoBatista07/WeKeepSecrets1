package dataStructures;

public interface Array<E> {

	void inserLast(E e);
	
	void insertAt(E e, int pos);
	
	void removeLast();
	
	void removeAt(int pos);
	
	boolean searchForward(E e);
	
	boolean searchBackward(E e);
}
