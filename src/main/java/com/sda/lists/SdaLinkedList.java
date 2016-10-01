package com.sda.lists;

public class SdaLinkedList {

    private SdaLinkedNode head, lastNode;

    public SdaLinkedList(String value) {
        this.head = new SdaLinkedNode(value);
        lastNode = head;
    }

    public void add(String value) {
    	SdaLinkedNode newNode = new SdaLinkedNode(value);
    	if(head == null) {
    		head = newNode;
    		lastNode = head;
    	} else {
    		lastNode.next = newNode;
        	lastNode = newNode;
    	}
    }

    public String get(int index) {
        if(index == 0) {
        	return head.value;
        } else {
        	SdaLinkedNode current = head;
        	int indexCounter = 0;
        	while(current.next != null || indexCounter!=index) {
        		current = current.next;
        		indexCounter++;
        	}
//        	current
        	return "";
        }
    }

    public void remove(String value) {
    	int size = 0;
    	SdaLinkedNode tmpNode = head;
    	while(tmpNode.next != null) {
    		
    	}
    	
    }
    
    public int size() {
    	int size = 0;
    	SdaLinkedNode tmpNode = head;
    	while(tmpNode.next != null) {
    		size++;
    		tmpNode = tmpNode.next;
    	}
        return size+1;
    }

    private static class SdaLinkedNode {

        private String value;
        private SdaLinkedNode next;

        public SdaLinkedNode(String node) {
            this.value = node;
        }
    }

}
