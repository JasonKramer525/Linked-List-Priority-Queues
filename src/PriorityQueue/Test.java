package PriorityQueue;

import java.util.Iterator;

import data_structures.OrderedLinkedListPriorityQueue;
import data_structures.PriorityQueue;
import data_structures.UnorderedLinkedListPriorityQueue;

public class Test {
	
	
	public Test() {
		
		System.out.println("ORDERED");
		System.out.println("-------");
		test(new OrderedLinkedListPriorityQueue<Integer>(),
			new OrderedLinkedListPriorityQueue<Integer>(),
			new OrderedLinkedListPriorityQueue<Integer>());
		
		System.out.println("\n-------------------------------\n");
		
		System.out.println("UNORDERED");
		System.out.println("-------");
		test(new UnorderedLinkedListPriorityQueue<Integer>(),
			new UnorderedLinkedListPriorityQueue<Integer>(),
			new UnorderedLinkedListPriorityQueue<Integer>());
		
	}
	
	
	//testing method that calls all the tests
	private void test(PriorityQueue<Integer> defaultQueue,
							PriorityQueue<Integer> zeroQueue,
							PriorityQueue<Integer> tenQueue) {
		
		System.out.println("TEST 1:  " + testEmpty(defaultQueue));
		System.out.println("TEST 2:  " + testEmpty(tenQueue));
		
		System.out.println("TEST 3:  " + testZeroEmpty(zeroQueue));
		
		System.out.println("TEST 4:  " + test10Full(tenQueue));
		
		System.out.println("TEST 5:  " + testClear(tenQueue));
		
		System.out.println("TEST 6:  " + testSize(tenQueue));
		System.out.println("TEST 7:  " + testSize(defaultQueue));
		
		System.out.println("TEST 8:  " + testContains(tenQueue));
		System.out.println("TEST 9:  " + testContains(defaultQueue));
		
		System.out.println("TEST 9:  " + testPeek(tenQueue));
		System.out.println("TEST 10: " + testPeek(defaultQueue));
		
		System.out.println("TEST 11: " + testDelete(tenQueue));
		
	}
	
	
	
	//Tests size and is empty
	private boolean testEmpty(PriorityQueue<Integer> queue) {
		if (queue.size() != 0)
			return false;
		if (!queue.isEmpty())
			return false;
		queue.insert(new Integer(4));
		if (queue.size() != 1)
			return false;
		if (queue.isEmpty())
			return false;
		queue.clear();
		return true;
	}
	
	
	//Tests queue when the size is 0
	private boolean testZeroEmpty(PriorityQueue<Integer> queue) {
		if (queue.size() != 0) {
			System.out.println("1");
			return false;
		}
		if (!queue.isEmpty()) {
			System.out.println("2");
			return false; }
		if (queue.insert(new Integer(4))) {
			System.out.println("3");
			return false; }
		if (queue.size() != 0) {
			System.out.println("4");
			return false; }
		if (!queue.isEmpty()) {
			System.out.println("5");
			return false; }
		queue.clear();
		return true;
	}

	
	//Test if queue is full with 10 elements
	private boolean test10Full(PriorityQueue<Integer> queue) {
		for (int i = 0; i < 10; i++)
			queue.insert(new Integer(i));
		if (!queue.isFull())
			return false;
		queue.clear();
		return true;
	}
	
	
	//Test clear function
	private boolean testClear(PriorityQueue<Integer> queue) {
		queue.insert(new Integer(1));
		queue.insert(new Integer(2));
		queue.insert(new Integer(3));
		queue.insert(new Integer(4));
		queue.insert(new Integer(5));
		if (queue.size() != 5)
			return false;
		queue.clear();
		if (queue.size() != 0)
			return false;
		if (!queue.isEmpty())
			return false;
		queue.clear();
		return true;
	}

	
	//Tests size
	private boolean testSize(PriorityQueue<Integer> queue) {
		for (int i = 0; i < 5; i++)
			queue.insert(new Integer(i));
		if (queue.size() != 5)
			return false;
		queue.clear();
		return true;
	}
	
	
	//Tests contains
	private boolean testContains(PriorityQueue<Integer> queue) {
		if (queue.contains(new Integer(5)))
			return false;
		for (int i = 0; i < 10; i++)
			queue.insert(new Integer(i));
		if (queue.contains(new Integer(10)))
			return false;
		if (!queue.contains(new Integer(0)))
			return false;
		if (!queue.contains(new Integer(9)))
			return false;
		queue.clear();
		return true;
	}
	
	
	//Tests peek with delete
	private boolean testPeek(PriorityQueue<Integer> queue) {
		if (queue.peek() != null)
			return false;
		queue.insert(new Integer(5));
		if (!queue.peek().equals(new Integer(5)))
			return false;
		if (!queue.peek().equals(new Integer(5)))
			return false;
		if (queue.size() != 1)
			return false;
		queue.insert(new Integer(6));
		if (!queue.peek().equals(new Integer(5)))
			return false;
		queue.insert(new Integer(4));
		if (!queue.peek().equals(new Integer(4)))
			return false;
		queue.insert(new Integer(4));
		if (!queue.peek().equals(new Integer(4)))
			return false;
		queue.delete(new Integer(5));
		if (!queue.peek().equals(new Integer(4)))
			return false;
		queue.delete(new Integer(4));
		if (!queue.peek().equals(new Integer(6)))
			return false;
		queue.clear();
		return true;
	}
	
	
	//Tests simple delete at both ends
	private boolean testDelete(PriorityQueue<Integer> queue) {
		//0 1 2 3 4 5 6 7 0 0      8
		for (int i = 0; i < 8; i++)
			queue.insert(new Integer(i));
		queue.insert(new Integer(0));
		queue.insert(new Integer(0));
		queue.delete(new Integer(0));
		if (queue.size() != 7)
			return false;
		queue.insert(new Integer(7));
		queue.insert(new Integer(7));
		queue.insert(new Integer(7));
		queue.delete(new Integer(7));
		if (queue.size() != 6)
			return false;
		queue.clear();
		return true;
	}
	
	
	public static void testOrdered2() {
		
		OrderedLinkedListPriorityQueue<Integer> queue = new OrderedLinkedListPriorityQueue<Integer>();
		
		System.out.println(queue.isEmpty());
		System.out.println("SIZE: " + queue.size());
		
		System.out.println(queue.insert(new Integer(5)));
		System.out.println(queue.insert(new Integer(4)));
		System.out.println(queue.insert(new Integer(4)));
		System.out.println(queue.insert(new Integer(4)));
		System.out.println(queue.insert(new Integer(4)));
		System.out.println(queue.insert(new Integer(4)));
		System.out.println(queue.insert(new Integer(3)));
		
		System.out.println("SIZE: " + queue.size());
		
		System.out.println("DELETE: " + queue.delete(new Integer(4)));
		
		System.out.println("SIZE: " + queue.size());
		
		Iterator iter = queue.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	
	
	
	public static void testUnordered6() {
		
		UnorderedLinkedListPriorityQueue<Integer> queue = new UnorderedLinkedListPriorityQueue<Integer>();
		
		System.out.println(queue.isEmpty());
		
		System.out.println(queue.insert(new Integer(5)));
		
		System.out.println("\nINSERTING");
		for (int i = 0; i < 10; i++) {
			System.out.println(queue.insert(new Integer(i)));
		}
		
		System.out.println(queue.size());
		
		System.out.println("\nREMOVING");
		for (int i = 0; i < 11; i++) {
			System.out.println(queue.remove());
		}
		
	}
	
	public static void testUnordered2() {
		
		UnorderedLinkedListPriorityQueue<Integer> queue = new UnorderedLinkedListPriorityQueue<Integer>();
		
		queue.insert(new Integer(5));
		queue.insert(new Integer(5));
		queue.insert(new Integer(5));
		queue.insert(new Integer(4));
		queue.insert(new Integer(5));
		queue.insert(new Integer(7));
		queue.insert(new Integer(8));
		queue.insert(new Integer(5));
		queue.insert(new Integer(5));
		queue.insert(new Integer(5));
		queue.insert(new Integer(9));
		queue.insert(new Integer(5));
		queue.insert(new Integer(5));
		queue.insert(new Integer(3));
		queue.insert(new Integer(5));
		queue.insert(new Integer(5));
		queue.insert(new Integer(5));
		
		//4 5 7 8 5 5 9 5 3
		
		
		Iterator iter = queue.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next().toString() + " , ");
		}
		
		System.out.println("\n" + queue.size());
		
		System.out.println(queue.delete(new Integer(5)));
		
		System.out.println(queue.size());
		
		iter = queue.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next().toString() + " , ");
		}
	}
	
	
	public static void testUnordered3() {
		
		UnorderedLinkedListPriorityQueue<Integer> queue = new UnorderedLinkedListPriorityQueue<Integer>();
		
		System.out.println(queue.isEmpty());
		System.out.println("SIZE: " + queue.size());
		
		//System.out.println(queue.insert(new Integer(5)));
		System.out.println(queue.insert(new Integer(4)));
		System.out.println(queue.insert(new Integer(4)));
		System.out.println(queue.insert(new Integer(4)));
		System.out.println(queue.insert(new Integer(4)));
		System.out.println(queue.insert(new Integer(4)));
		System.out.println(queue.insert(new Integer(4)));
		
		System.out.println("SIZE: " + queue.size());
		
		System.out.println("DELETE: " + queue.delete(new Integer(6)));
		
		System.out.println("SIZE: " + queue.size());
		
		Iterator iter = queue.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	
	public static void main(String[] args) {	
		
		Test test = new Test();
		
	}

}
