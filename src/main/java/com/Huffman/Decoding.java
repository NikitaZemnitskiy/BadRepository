package com.Huffman;

import com.Huffman.BinaryTree.BinaryTree;
import com.Huffman.BinaryTree.TreeNode;
import com.Huffman.Util.ReaderFile;
import com.Huffman.Util.ReaderHfFile;
import com.Huffman.Util.Writer;
import com.Huffman.Util.Reader;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.Externalizable;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.List;


public class Decoding  {
    File file;
    LinkedHashMap<Character, Integer> map;
    Reader reader;
    Writer writer;
    Decoding(File file, Reader reader, Writer writer){
        this.file = file;
        this.reader = reader;
        this.writer = writer;
    }
    public void decode(){
        CodeTable codeTable = new CodeTable();
        codeTable.readTable();
        map = codeTable.getMap();
        System.out.println(map);

        BinaryTree binaryTree = new BinaryTree(map);
        binaryTree.createBinaryTree();
        ReaderHfFile reader = new ReaderHfFile();

        BitSet bitSet = reader.read(file);
        List<Boolean> boolList = new ArrayList<>();
        //TODO переделать этот ужас

        for(int i = 7; i<bitSet.size(); i = i+8){
            boolList.add(bitSet.get(i));
            boolList.add(bitSet.get(i-1));
            boolList.add(bitSet.get(i-2));
            boolList.add(bitSet.get(i-3));
            boolList.add(bitSet.get(i-4));
            boolList.add(bitSet.get(i-5));
            boolList.add(bitSet.get(i-6));
            boolList.add(bitSet.get(i-7));
        }

        TreeNode currentNode = binaryTree.getFirstNode();

        StringBuilder stringBuilder = new StringBuilder();
        ///////////////////////////////////////////////////////
        System.out.println(currentNode.getStr());
        currentNode = currentNode.getRight();
        System.out.println(currentNode.getStr());
        currentNode = currentNode.getLeft();
        System.out.println(currentNode.getStr());
        currentNode = currentNode.getLeft();
        System.out.println(currentNode.getStr());
        currentNode = currentNode.getLeft();
        System.out.println(currentNode.getStr());
        currentNode = currentNode.getLeft();
        System.out.println(currentNode.getStr());
        currentNode = currentNode.getLeft();
        System.out.println(currentNode.getStr());
        currentNode = currentNode.getLeft();
        System.out.println(currentNode.getStr());
        currentNode = currentNode.getLeft();
        System.out.println(currentNode.getStr());
        currentNode = currentNode.getRight();
        System.out.println(currentNode.getStr());


        //////////////////////////////////////////////////////

        for(int i =0; i<boolList.size(); i++){
            if(currentNode.isLast()){
                System.out.println("Ласт");
                stringBuilder.append(currentNode.getStr());
                currentNode = binaryTree.getFirstNode();

            }
            else if(!boolList.get(0)){
                System.out.println("Право");
                currentNode = currentNode.getRight();
            }
            else if(boolList.get(0)){
                System.out.println("Лево");
                currentNode = currentNode.getLeft();
            }
        }
        System.out.println(stringBuilder + " -наша строка");





    }

}
