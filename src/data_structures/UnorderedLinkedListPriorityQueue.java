/* Author: Jason Kramer 
 * Class Acc: cssc0914
 */

package data_structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class UnorderedLinkedListPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {
	private class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			next = null;
		}
	}

	private int currentSize;
	private Node<E> head;

	public UnorderedLinkedListPriorityQueue() {
		currentSize = 0;
		LinkedList<E> list = new LinkedList<E>();
	}

	// Inserts a new object into the priority queue. Returns true if
	// the insertion is successful. If the PQ is full, the insertion
	// is aborted, and the method returns false.
	public boolean insert(E object) {
		Node<E> newNode = new Node<E>(object);
		Node<E> curr = head, prev = null;
		if (curr == null) {
			head = newNode;
			return true;
		}
		while (curr != null) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = newNode;
		currentSize++;
		return true;
	}

	// Removes the object of highest priority that has been in the
	// PQ the longest, and returns it. Returns null if the PQ is empty.
	public E remove() {
		if (isEmpty())
			return null;

		Node<E> curr = head, prev = null, prevHighest = head;

		while (curr != null) {
			prev = curr;
			curr = curr.next;
			if ((prevHighest.next.data).compareTo(curr.data) < 0) 
				prevHighest = prev;
		}
		
		E temp = prevHighest.next.data;
		prevHighest.next = prevHighest.next.next;
		
		currentSize--;
		return temp;
	}

	// Deletes all instances of the parameter obj from the PQ if found, and
	// returns true. Returns false if no match to the parameter obj is found.
	public boolean delete(E obj) {
		boolean found = false;
		Node<E> prev = null, curr = head;
		
		while (curr != null) {
			if (obj.compareTo(curr.data) == 0) {
				
				if (curr == head)
					head = head.next;
				else {
					prev.next = curr.next;
				}
				
				found = true;
				curr = curr.next; 
				currentSize--;
				continue;
			}
			prev = curr;
			curr = curr.next;
		}
		return found;
	}

	// Returns the object of highest priority that has been in the
	// PQ the longest, but does NOT remove it.
	// Returns null if the PQ is empty.
	public E peek() {
		if (isEmpty())
			return null;
		Node<E> curr = head, highest = head;

		while (curr != null) {
			curr = curr.next;
			if ((highest.data).compareTo(curr.data) < 0) {
				highest = curr;
			}
		}

		return highest.data;
	}

	// Returns true if the priority queue contains the specified element
	// false otherwise.
	public boolean contains(E obj) {
		Node<E> curr = head;
		while (curr != null) {
			curr = curr.next;
			if ((curr.data).compareTo(obj) == 0) {
				return true;
			}
		}

		return false;
	}

	// Returns the number of objects currently in the PQ.
	public int size() {
		return currentSize;
	}

	// Returns the PQ to an empty state.
	public void clear() {
		head = null;
		currentSize = 0;
	}

	// Returns true if the PQ is empty, otherwise false
	public boolean isEmpty() {
		return head == null;
	}

	// Returns true if the PQ is full, otherwise false. List based
	// implementations should always return false.
	public boolean isFull() {
		return false;
	}

	// Returns an iterator of the objects in the PQ, in no particular
	// order.
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

	class IteratorHelper implements Iterator<E> {
		private Node<E> IterPointer;

		public IteratorHelper() {
			IterPointer = head;
		}

		public boolean hasNext() {
			return IterPointer != null;
		}

		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E tmp = IterPointer.data;
			IterPointer = IterPointer.next;
			return tmp;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
