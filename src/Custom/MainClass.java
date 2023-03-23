package Custom;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainClass {
	
	public static void main(String[] args) {
		
	}
	
}

class CustomArrayList<T>{
	
	private T[] myArray;
	private int size;
	
	@SuppressWarnings("unchecked")
	public CustomArrayList() {
		myArray = (T[])new Object[0];
	}
	
	public void add(T elm) {
		myArray = Arrays.copyOf(myArray, size+1);
		myArray[size] = elm;
		size++;
	}
	
	public String toString() {
		
		if(size == 0) {
			return "[]";
		}
		
		StringBuffer sb = new StringBuffer("");
		sb.append("[");
		for(int i = 0 ; i < size-1 ; i++) {
			sb.append(myArray[i]+", ");
		}
		sb.append(myArray[size-1]+"]");
		return sb.toString();
	}
	
	public int size() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public void pop() {
		int count = 0;
		T[] temp = (T[])new Object[myArray.length-1];
		for(int i = 0 ; i < size-1; i++) {
			temp[i] = myArray[i];
		}
		size -= 1;
		myArray = temp;

	}
	
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(T elm) {
		for(int i = 0 ; i < size ; i++) {
			if(myArray[i].equals(elm)) {
				return true;
			}
		}
		return false;
	}
	
	public T get(int index) {
		return myArray[index];
	}
	
	public int indexOf(T elm) {
		
		int index = 0;
		if(!(contains(elm))) {
			return -1;
		}
		
		for(int i = 0 ; i < size ; i++) {
			if(myArray[i].equals(elm)) {
				return index;
			}
			index++;
		}
		
		return 0;
	}
	
	public void sortMyArray() {
		Arrays.sort(myArray);
	}
	
	@SuppressWarnings("unchecked")
	public void remove(int index) {
		get(index);
		int count = 0;
		T[] temp = (T[])new Object[myArray.length-1];
		for(int i = 0 ; i < size ;i++) {
			if(i != index) {
				temp[count] = myArray[i];
				count++;
			}
		}
		size--;
		myArray = temp;
		
	}
	
	public void removeElement(T element) {
		int index = indexOf(element);
		remove(index);
	}
	
	@SuppressWarnings("unchecked")
	public void clearAll() {
		myArray = (T[])new Object[0];
		size = 0;
	}
	
	public void set(int index, T elm) {
		myArray[index] = elm;
	}
	
	public void replaceAll(T elemToBeReplaced ,T element) {
		for(int i = 0 ; i < size ; i++) {
			if(myArray[i].equals(elemToBeReplaced)) {
				myArray[i] = element;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void unShift(T element) {
		T[] temp = (T[])new Object[myArray.length+1];
		temp[0] = element;
		for(int i = 0 ; i < size ; i++) {
			temp[i+1] = myArray[i];
		}
		size++;
		myArray = temp;
	}
	

	@SuppressWarnings("unchecked")
	public void removeAll(T element) {
		int count = 0;
		int copyCount = 0;
		for(int i = 0 ; i < size ; i++) {
			if(myArray[i].equals(element)) {
				count++;
			}
		}
		T[] temp = (T[])new Object[myArray.length-count];
		
		for(int i = 0 ; i < myArray.length ; i++) {
			if(!(myArray[i].equals(element))) {
				temp[copyCount] = myArray[i];
			}
		}
		size -= count;
		myArray = temp;
	}
	
	@SuppressWarnings("unchecked")
	public void shift() {
		int count = 0;
		T[] temp = (T[])new Object[myArray.length-1];
		for(int i = 0 ; i < size-1 ; i++) {
			temp[i] = myArray[i+1];
		}
		size -= 1;
		myArray = temp;
	}

	@SuppressWarnings("unchecked")
	public int lastIndexOf(T elem) {
		int i = 0;
		for(i = size-1; i >= 0 ; i--) {
			if(myArray[i].equals(elem)) {
				break;
			}
		}
		
		return i;
	}
	
}