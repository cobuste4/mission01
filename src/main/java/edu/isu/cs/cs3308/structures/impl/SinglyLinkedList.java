package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;

/**
 * @author Steve Coburn
 * DueDate: 18 January 2019
 * ISUCourse: CS3308
 * Instructor: Isaac Griffith
 * Description: This class impliments a singly linked list to use with the rest of this example
 */

// Interfacing source: https://www.geeksforgeeks.org/interfaces-in-java/

public class SinglyLinkedList<E> implements List<E> {

    // Code example from our textbook, pages 126-7
    // Create a Node class with getters and setters
    private static class Node<E> {
        private E contents;
        private Node<E> next;

        public Node(E data, Node<E> n) {
            contents = data;
            next = n;
        }

        // Getters and setters
        public E getElement() {
            return contents;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public E getData() {
            return contents;
        }

        public void setData() {
            this.contents = contents;
        }
    }

    // Code example from our textbook, page 126-7
    // Instance variables of the Singly Linked List
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    // CONSTURCTOR
    public SinglyLinkedList() {
    }

    // METHODS
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E element) {
        if (element != null) {
            Node nd = new Node<>(element, head);
            head = nd;
            if (size == 0) {
                tail = head;
            }
            size++;
        }
    }

    public void addLast(E element) {
        if (element != null) {
            Node<E> newest = new Node<>(element, null);
            if (isEmpty()) {
                head = newest;
            } else {
                tail.setNext(newest);
            }
            tail = newest;
            size++;
        }
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E temp = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return temp;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E toRemove = tail.getElement();
        tail = head;
        for (int i = 1; i < size; i++) {
            tail = tail.getNext();
        }
        tail.setNext(null);
        size--;
        return toRemove;
    }

    // Insert node at index -1 so that it becomes the index
    public void insert(E element, int index) {
        if (element != null && index > 0) {
            // If the index is greater than the array, add node to the end
            if (index >= size) {
                addLast(element);
            } else {
                Node<E> toInsert = new Node<>(element, null);
                Node<E> temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.getNext();
                }
                toInsert.setNext(temp.getNext());
                temp.setNext(toInsert);
                size++;
            }
        }
    }

    // In-class example. Removes the node AFTER the index given
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        Node<E> toRemove = current.getNext();
        current.setNext(toRemove.getNext());
        toRemove.setNext(null);
        size--;
        return toRemove.getData();
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<E> toReturn = head;
        for (int i = 0; i < index; i++) {
            toReturn = toReturn.getNext();
        }
        return toReturn.getData();
    }

    public void printList() {
        String stringToOutput = "";
        Node<E> tempNode = head;
        for (int i = 0; i < size; i++) {
            stringToOutput += tempNode.getData().toString();
            stringToOutput += "\n";
            tempNode = tempNode.getNext();
        }
        System.out.println(stringToOutput);
    }
}