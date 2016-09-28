package com.sda.lists;

public class SdaLinkedList {

    private SdaLinkedNode head;

    public SdaLinkedList(String value) {
        this.head = new SdaLinkedNode(value);
    }

    public void add(String value) {
        // Zaimplementuj mnie
    }

    public String get(int index) {
        // Zaimplementuj mnie
        return "";
    }

    public void remove(String value) {
        // Zaimplementuj mnie
    }
    
    public int size() {
        // Zaimplementuj mnie
        return 0;
    }

    private static class SdaLinkedNode {

        String value;

        public SdaLinkedNode(String node) {
            this.value = node;
        }

    }

}
