package cache;

import java.util.HashMap;
import java.util.Map;

class Node {
	int key;
	String value;
	Node next;
	Node prev;

	Node(int key, String value) {
		this.key = key;
		this.value = value;
	}
	@Override
	public String toString() {
		return "cache.Node [key=" + key + ", value=" + value +"]";
	}
	
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;
	final int LIMIT=5;

	DoublyLinkedList() {
		head = tail = null;
		size = 0;
	}

	void pushFront(Node n) {
		n.next = n.prev = null;
		if (head == null) {
			head = tail = n;
		} else {
			n.next = head;
			head.prev = n;
			head = n;
		}
		size++;
	}

	void pushBack(Node n) {
		n.next = n.prev = null;
		if (tail == null) {
			head = tail = n;
		} else {
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
		size++;
	}

	Node popFront() {
		Node n = head;
		if (head != null) {
			head = head.next;
			if (head != null)
				head.prev = null;
		}
		size--;
		return n;
	}

	Node popBack() {
		Node n = tail;
		if (tail != null) {
			tail = tail.prev;
			if (tail != null)
				tail.next = null;
		}
		size--;
		return n;
	}

	void updateToEnd(Node n) {
		if (tail == n && size == 1) {
			return;
		} else if (head == n) {
			head = head.next;
			head.prev = null;
			size--;
			pushBack(n);
		} else {
			n.prev.next = n.next;
			n.next.prev = n.prev;
			size--;
			pushBack(n);
		}
	}

	void displayList() {
		Node i = head;
		System.out.println("--cache.Cache Data---\nCurrent size =" + size);
		int j = 0;
		while (i != null) {
			System.out.println(i.key + " -> " + i.value);
			i = i.next;
			j++;
			if (j > 6)
				break;
		}
		System.out.println("--cache.Cache Data END ---");

	}
}

public class Cache {
	DoublyLinkedList dll;
	Map<Integer, Node> map;
	int hit;
	int miss;

	Node[]arr=new Node[]{
			new Node(0, "zero"),
			new Node(1, "one"),
			new Node(2, "two"),
			new Node(3, "three"),
			new Node(4, "four"),
			new Node(5, "five"),
			new Node(6, "six"),
			new Node(7, "seven"),
			new Node(8, "eight")
	};
	
	Cache() {
		dll = new DoublyLinkedList();
		map = new HashMap<Integer, Node>();
		hit=0;
		miss=0;
	}

	void insert(Node n) {
		if(dll.size==dll.LIMIT){
			Node f = dll.popFront();
			map.remove(f.key);
		}
		dll.pushBack(n);
		map.put(n.key, n);
	}

	void update(Node n){
		dll.updateToEnd(n);
	}

	Node search(int key){
		Node n = map.get(key);
		if (n != null) {
		    hit++;
			System.out.println("cache.Cache Hit "+ n);
			update(n);
		} else {
			miss++;
			insert(arr[key]);
			System.out.println("cache.Node Not Found. Inserted from DB " + map.get(key));
		}
		return n;
	}
	
	void displayCache(){
		System.out.println("Hit=" + hit+", Miss="+miss);
		dll.displayList();
	}
}