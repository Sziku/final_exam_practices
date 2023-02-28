package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRowRotater {
    private String filePath;
    private List<String> allLoadRows;
    private List<String> rotatedRows;

    public FileRowRotater(String filePath) {
        this.filePath = filePath;
    }

    public void rotateRows(){
        load();
        rotatedRows = new ArrayList<>();
        for(String row : allLoadRows){
            char[] charArray = row.toCharArray();
            int capitalLetterindex = getCapitalLetterindex(charArray);
            rotatedRows.add(row.substring(capitalLetterindex) + row.substring(0, capitalLetterindex));
        }
        save();
    }

    private static int getCapitalLetterindex(char[] charArray) {
        int capitalLetterindex = 0;
        for (int i = 0; i < charArray.length; i++){
            if(Character.isUpperCase(charArray[i])){
                capitalLetterindex = i;
                break;
            }
        }
        return capitalLetterindex;
    }

    private void save(){
        String newFilePath = filePath.split("\\.")[0].concat(".rotated.txt");
        File file = new File(newFilePath);
        try{
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for(String row : rotatedRows){
                bw.write(row+"\n");
            }

            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private  void load(){

        allLoadRows = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String st = br.readLine();
            while (st != null) {
                allLoadRows.add(st);
                st = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
