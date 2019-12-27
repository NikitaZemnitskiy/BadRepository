package com.Huffman.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class ReaderHfFile implements Reader<File,BitSet> {
    @Override
    public BitSet read(File file) {
        List<Byte> list = new ArrayList<>();
        BitSet bitSet = new BitSet();
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
            {

                byte b1 = (byte) reader.read();
                list.add(b1);

            }
            byte[] arr = new byte[list.size()];
            for(int i = 0; i<list.size(); i++){
                arr[i] = list.get(i);
            }
            bitSet = BitSet.valueOf(arr);
            System.out.println("bitSet |");


        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return bitSet;
    }
}
