package com.Huffman;




import java.util.Map;


public class CodeTable {
    String table;
    public void createTable(Map<Character, Integer> map){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("table/");
        stringBuilder.append('\n');
        for (Map.Entry entry : map.entrySet()) {
            stringBuilder.append(entry.getKey());
            stringBuilder.append("♟");
            stringBuilder.append(entry.getValue());
            stringBuilder.append('\n');
        }
        stringBuilder.append("exit/");
        this.table = stringBuilder.toString();
    }
    public Map<Character, Integer> createMap(){
        return null;
    }

    public String getTable() {
        return table;
    }
}
