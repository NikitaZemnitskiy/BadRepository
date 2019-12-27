package com.Huffman;

import com.Huffman.BinaryTree.BinaryTree;
import com.Huffman.BinaryTree.TreeNode;
import com.Huffman.Util.Reader;
import com.Huffman.Util.Writer;


import java.io.File;
import java.util.Comparator;
import java.util.*;
import java.util.stream.Stream;


public class Encoding {
    private File file;
    private String text;
    private Writer writer;
    char EOF = '∡';
    CodeTable table = new CodeTable();


    public Encoding(Reader reader, File file, Writer writer) {
        this.text = reader.read(file).toString();
        this.writer = writer;
        this.file = file;
    }
    public void treeCreating(){
         text.concat(Character.toString(EOF));
         char[] charsArr = text.toCharArray();
         Set<Character> charSet = new HashSet<>();
         for(char c: charsArr){
             charSet.add(c);
         }


        Map< Character, Integer> charMap = new TreeMap<>();

        for(char c:charSet) {
                int count = 0;
                for (char ch : charsArr) {
                    if (c == ch) {
                        count++;
                }
            }
                charMap.put(c,count);
        }
        Map<Character, Integer> result = new LinkedHashMap<>();
        Stream<Map.Entry<Character, Integer>> st = charMap.entrySet().stream();
        st.sorted(Comparator.comparing(e -> e.getValue())).forEach(e -> result.put(e.getKey(), e.getValue()));

        table = CodeTable.createTable((LinkedHashMap<Character, Integer>) result);
        table.writeTable();

        BinaryTree binaryTree = new BinaryTree((LinkedHashMap) result);
        binaryTree.createBinaryTree();
        transformToBinaryCode(binaryTree);

    }
    public void transformToBinaryCode (BinaryTree binaryTree){
       BitSet bitSet = new BitSet();
        StringBuilder stringBuilder = new StringBuilder();
        char[]charsArray = text.toCharArray();
        int pos = 0;
        for(char c: charsArray){
            if (c == EOF){
                break;
            }
            TreeNode currentNode = binaryTree.getFirstNode();

            while (true) {
                if(currentNode.isLast()){
                    break;
                }
                if(currentNode.getLeft().getStr().contains(Character.toString(c))){
                    stringBuilder.append(0);
                    System.out.println();
                    currentNode = currentNode.getLeft();
                }
                else if(currentNode.getRight().getStr().contains(Character.toString(c))) {
                    stringBuilder.append(1);
                    bitSet.set(pos);
                    currentNode = currentNode.getRight();
                }
                else{
                    throw new IllegalStateException("Буквы нет в дереве, буква '" + c+ "' отсутствует");
                }
                pos++;
            }
        }
        System.out.println(stringBuilder + " -CтрингБилдер");
        System.out.println("bitSet|");
        System.out.println(bitSet);
        TestTestTest.bitTest = bitSet;

      writer.write(file, bitSet);
    }

}
