package dataStructures;

import documents.AccessesOfficial;
import users.User;

public class ArrayClass<E> implements Array<E> {
	private static final int SIZE = 50, GROW_FACTOR=2;
	
	private E[] elems;
	private int counter;
	
	@SuppressWarnings("unchecked")
	public ArrayClass() {
		elems = (E[]) new Object[SIZE];
		counter = 0;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayClass(int dimension) {
		elems = (E[]) new Object[dimension];
		counter = 0;
	}
	
	public void inserLast(E e) {
		if ( counter == elems.length) resize();
		elems[counter++] = e;
	}
	
	public void insertAt(E e, int pos) {
		for( int i = counter-1; i>= pos; i--)
			elems[i+1] = elems[i];
		elems[pos] = e;
		counter++;
	}
	
	public void removeLast() {
		elems[--counter] = null;
	}
	
	public void removeAt(int pos) {
		for(int i = pos; i < counter -1; i++)
			elems[i] = elems[i+1];
		elems[--counter] = null;
	}
	
	public boolean searchForward(E e) {
	    return searchIndex(e) != -1;
	}
	
	public boolean searchBackward(E e) {
		return false;												//Completar
	}
	
	private int searchIndex(E e) {
        int i = 0;
        while ((i < counter)) {
            if (elems[i].equals(e)) {
                return i;
            }
            i++;
        }
        return -1;
    }
	
	private void resize() {
		E[] sl = (E[]) new Object[GROW_FACTOR * elems.length];
		for (int i = 0; i < counter; i++)
			sl[i] = elems[i];
		elems = sl;
	}
	
	
	
}
