package dataStructures;

import java.util.NoSuchElementException;

/**
 * Linked list implementation of the <tt>List</tt> interface. Implements all
 * list operations, and permits all elements (including <tt>null</tt>).
 * 
 * @author Triona Doyle
 */

public class LinkedList<E> implements List<E> {

    private final ListNode<E> head = new ListNode<E>(null, null, null);
    private int size;

    public LinkedList() {
        head.next = head.prev = head;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        ListNode<E> node = head.next;
        while (node != head) {
            ListNode<E> next = node.next;
            node.next = node.prev = null;
            node.element = null;
            node = next;
        }

        head.next = head.prev = head;
        size = 0;
    }

    @Override
    public void add(E element) {
        addBefore(element, head);

    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                    + size);

        if (index == size) {
            addBefore(element, head);
        } else {
            addBefore(element, getNode(index));
        }

    }

    @Override
    public boolean remove(E element) {
        if (element == null) {
            for (ListNode<E> node = head.next; node != head; node = node.next) {
                if (node.element == null) {
                    remove(node);
                    return true;
                }
            }
        } else {
            for (ListNode<E> node = head.next; node != head; node = node.next) {
                if (element.equals(node.element)) {
                    remove(node);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        return remove(getNode(index));
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        ListNode<E> node = getNode(index);

        E oldVal = node.element;
        node.element = element;

        return oldVal;
    }

    @Override
    public int indexOf(E element) {
        int index = -1;
        int i = 0;

        if (element == null) {
            for (ListNode<E> node = head.next; node != head; node = node.next) {
                if (node.element == null) {
                    index = i;
                    break;
                }
                i++;
            }
        } else {
            for (ListNode<E> node = head.next; node != head; node = node.next) {
                if (element.equals(node.element)) {
                    index = i;
                    break;
                }
                i++;
            }
        }
        return index;
    }

    public String toString() {
        StringBuffer list = new StringBuffer();

        ListNode<E> current = head;

        list.append("[");

        for (int i = 0; i <= size - 2; i++) {
            list.append(current.next + ", ");
            current = current.next;
        }

        list.append(current.next + "]");

        return list.toString();
    }

    private ListNode<E> addBefore(E e, ListNode<E> node) {
        ListNode<E> newNode = new ListNode<E>(e, node, node.prev);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        size++;

        return newNode;
    }

    private E remove(ListNode<E> node) {
        if (node == head)
            throw new NoSuchElementException();

        E result = node.element;
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = node.prev = null;
        node.element = null;

        size--;

        return result;
    }

    private ListNode<E> getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                    + size);
        ListNode<E> node = head;
        if (index < (size / 2)) {
            for (int i = 0; i <= index; i++)
                node = node.next;
        } else {
            for (int i = size; i > index; i--)
                node = node.prev;
        }
        return node;
    }

    private static final class ListNode<E> {
        E element;
        ListNode<E> next;
        ListNode<E> prev;

        ListNode(E element, ListNode<E> next, ListNode<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public String toString() {
            return element.toString();
        }
    }
}