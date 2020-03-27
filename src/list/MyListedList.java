package list;

public class MyListedList extends MyAbstractList {
    private Node first, last;

    public MyListedList() {
        // TODO Auto-generated constructor stub
    }

    public MyListedList(Object[] objects) {
        super(objects);
        // TODO Auto-generated constructor stub
    }

    public void addFirst(Object o) {
        Node newNode = new Node(o);
        newNode.next = first;
        first = newNode;

        size++;

        if (last == null) {
            last = first;
        }
    }

    public void addLast(Object o) {
        Node newNode = new Node(o);
        if (last == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public Object getFirst() {
        if (size == 0)
            return null;
        return first.element;
    }

    public Object getLast() {
        if (size == 0)
            return null;
        return last.element;
    }

    public Object removeFirst() {
        return null;
    }

    public Object removeLast() {
        return null;
    }

    @Override
    public void add(int index, Object o) {
        if (index == 0) {
            addFirst(o);
        } else if (index >= size) {
            addLast(o);
        } else {
            //Node newNode = new Node(o);
            Node current = first;
			/*for (int i = 0; i <= index; i++) {
				current = current.next;
				if (i == index - 1) {
					Node oldIndexNode = current.next;
					Node newIndexNode = new Node(o);
					newIndexNode.next = oldIndexNode;
					current.next = newIndexNo
					de;
				}
			
			}*/
            int j = 0;//index from loop
            while (j < index) {
                current = current.next;
                j++;
            }
            //after loop, current is in index-1
            Node oldIndexNode = current.next;
            Node newIndexNode = new Node(o);
            newIndexNode.next = oldIndexNode;
            current.next = newIndexNode;
            size++;
        }

    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        first = last = null;
    }

    @Override
    public Object get(int index) {
        if (index > size)
            return null;
        if (index == 0)
            return first;
        if (index == size)
            return last;
        Node current = first;
        int j = 0;//index from loop
        while (j < index) {
            current = current.next;
            j++;
        }
        if (j > size || current == null) {
            throw new IndexOutOfBoundsException("index in a wrong number");
        }
        return current.element;
    }

    @Override
    public int indexOf(Object o) {
        if (first == null)
            return -1;
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.element.equals(o)) {
                break;
            } else {
                current = current.next;
            }

            index++;
        }
        if (current == null) {
            return -1;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object set(int index, Object o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        if (first == null) {
            return "MyListedList first is null";
        } else if (first.element == null) {
            return "MyListedList has first but null";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("MyListedList has : ");
        Node current = first;
        while (current != null) {
            if (current.element == null) {
                sb.append("null" + " , ");
            } else {
                sb.append(current.element.toString() + " , ");
            }
            current = current.next;
        }
        return sb.toString();
    }

}
