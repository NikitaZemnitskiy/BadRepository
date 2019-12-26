package com.Huffman.Util;

import java.io.*;

public class ReaderFile implements Reader {
    File file;

    public ReaderFile(File file) {
        this.file = file;
    }

    public String read() {
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            int c;
            while(reader.ready()){

                stringBuilder.append(reader.readLine());
                stringBuilder.append('\n');
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        return stringBuilder.toString();
    }
}
