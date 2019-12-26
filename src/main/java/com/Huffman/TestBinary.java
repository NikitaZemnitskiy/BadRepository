package com.Huffman;

import java.util.BitSet;

public class TestBinary {
    public static void main(String[] args) {
        String string = "1010";

        BitSet bitSet = new BitSet();
        bitSet.set(0);
        bitSet.set(3);
        bitSet.set(4);
        bitSet.set(5);
        bitSet.set(7);
        byte[] bytes = bitSet.toByteArray();
        byte b1 = bytes[0];

        System.out.println(b1);
        BitSet bitSet1 = new BitSet();
        System.out.println(Integer.toBinaryString(b1));


    }
}
