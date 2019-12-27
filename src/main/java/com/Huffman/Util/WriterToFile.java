package com.Huffman.Util;

import com.Huffman.CodeTable;

import java.io.*;
import java.util.BitSet;

public class WriterToFile implements Writer<File, BitSet> {


    @Override
    public void write(File file, BitSet bitSet) {

        try(FileOutputStream fos = new FileOutputStream("Test.hf"))
        {

            byte[] buffer = bitSet.toByteArray();
            System.out.println(buffer.length);
           fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
