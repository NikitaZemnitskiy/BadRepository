package com.Huffman;

import java.io.*;
import java.util.BitSet;

public class Test {
    public static void main(String[] args) throws IOException {
        String cs = "11010101";
        byte value = (byte) 0b1101_0101;

        // 10 -> 2
        /////////////////////////////////////////////////////////////

        BitSet bs = new BitSet(16*8);

        BitSet bitSet = BitSet.valueOf(new byte[] {value});
        byte[] result = bitSet.toByteArray();
        OutputStream os = null;
        os.write(result);
        StringBuilder byteBuilder = new StringBuilder();
        byte[] ba = cs.getBytes();
        byte b1 = 1;
        int a = 0;



        if (cs.charAt(0) == 1){
            b1 = (byte) (b1*-1);
        }
     ///////////////////////////////////////////////////////
        System.out.println(b1);
       StringBuilder stringBuilder = new StringBuilder();


        boolean isPositiv = true;
      while (true){

          if (b1<0){
              isPositiv = false;
              b1 = (byte) (b1*-1);
          }
        if (b1 == 0){
            break;
        }
          if(b1%2 == 0){
                stringBuilder.append(0);
          }
          else {
              stringBuilder.append(1);
          }
          b1 = (byte) (b1>>1);
        }
      if(isPositiv){
          stringBuilder.append(0);
      }
      else {
          stringBuilder.append(1);
      }

        System.out.println(stringBuilder.reverse());



        //////////////////////////////////////////////////////////////////////////




    }
    public static String binar(int a) { return Integer.toString(a, 2); }
}
