package com.Huffman;

import com.Huffman.Util.ReaderFile;
import com.Huffman.Util.WriterToFile;

import java.io.File;


public class Main {
    public static void main(String[] args) {
        if (args.length>1){
            System.out.println("Введены неправильные аргументы");
            System.exit(0);
        }
        File file = new File(args[0]);
        if(file.getName().contains(".hf")){
            Decoding decoding = new Decoding();
        }
        else {
            Encoding encoding = new Encoding(new ReaderFile(file), file, new WriterToFile());
            encoding.treeCreating();
        }
    }
}
