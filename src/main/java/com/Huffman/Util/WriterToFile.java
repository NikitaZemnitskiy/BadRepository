package com.Huffman.Util;

import com.Huffman.CodeTable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile implements Writer<File, String> {


    @Override
    public void write(File file, String str, CodeTable codeTable) {

        try(FileOutputStream fos = new FileOutputStream(file))
        {
            // перевод строки в байты
        //    String text = codeTable.getTable()+str;
            String text = str+'\n'+"=================================================";
            byte[] buffer = text.getBytes();

            fos.write(buffer);
           fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        String name = file.getName()+".hf";
    }

}
