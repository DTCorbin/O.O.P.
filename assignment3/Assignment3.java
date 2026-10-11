/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.assignment3;

/**
 *
 * @author DTC
 */

import java.io.*;
import java.util.Arrays;

//string builder would work here
//for each line parse for html elements
//concateate the string into a buffer
//write the buffer to the file



        
public class Assignment3 {
    
    static class HTML {
        String tag;
        String attribute;
        String attributeValue;
        String content;
    }
    //maybe add...
    static class htmlBuilder {
        char[] buffer;
        int ptr = 0;
        
        public void initBuffer (String token){
            char[] temp = token.toCharArray();
            buffer = new char[temp.length];
        }
        public String getHTML(){
            String html = new String(buffer, 0, 64);
            return html;
        }
        
        public void appendTabs(int tabs){
            for (int i = ptr; i < tabs; i++) {
                buffer[i] = '\t';
                ptr++;
            }
        }
        public void appendText(String html) {
            char[] tag = (html.toCharArray());
            int txtptr = 0;
            for (int i = ptr; i < buffer.length; i++) {
                buffer[i] = tag[txtptr];
                txtptr++;
                ptr++;
            }
        }
        
        public int getLength(){
            return buffer.length;
        }
    }
    
    public static int countLines(File source){
        int count = 0;
        try ( FileReader fr = new FileReader(source);
             BufferedReader content = new BufferedReader(fr);) {
            while(content.readLine() != null)count++;
        } catch(IOException e){
                System.out.println("Error: There was an error reading from the file.");
        }
        return count;
    }
    
    public static int countRows(File source){
        int count = 0;
        try ( FileReader fr = new FileReader(source);
             BufferedReader content = new BufferedReader(fr);) {
            String test;
            
            while((test = content.readLine()) != null) {
                if (test.startsWith("Row")) {
                    count++;
                }
            }
        } catch(IOException e){
                System.out.println("Error: There was an error reading from the file.");
        }
        return count;
    }
    
    
    public static HTML lineParse(char[] line, HTML add){
        int index = 0; 
        char[] tagBuffer = new char[16];
        char[] contentBuffer = new char[64];
        while (index < line.length) {
            if (line[index] == ':') break;
            tagBuffer[index] = line[index];
            index++;
        }
        int colonPos = index;
        String tag =new String(tagBuffer, 0, (colonPos));
        index = 0;
        if (line.length > colonPos){
            for (int i = colonPos; i < line.length; i++) {
                 contentBuffer[index] = line[i];
                 index++;
             }
            
            String cont = new String(contentBuffer, 2, index - 2);
            if (tag.equalsIgnoreCase("color")) {   
                add.tag = "";
                add.attribute = tag;
                add.attributeValue = cont;
            } else {
                add.tag = tag;
            }
            add.content = cont;
            //System.out.printf("Tag: %s Attribute: %s Attribute Value: %s Content: %s\n", add.tag, add.attribute, add.attributeValue, add.content);
        } else {
            add.tag = tag;
        }
        return add;
    }
    
    public static int writeLine(HTML line, int tabs, int tableRows, int parsedRows){
        File dest = new File("C:\\Users\\DTC\\Documents\\Slippery Rock assignments\\Object-oriented programming\\Assignment 3\\Assignment3\\src\\main\\java\\com\\mycompany\\assignment3\\assignment3.html");
        try (FileWriter fw = new FileWriter(dest, true);
        BufferedWriter content = new BufferedWriter(fw);){
            htmlBuilder write = new htmlBuilder();
            String tok;
            String test;
            if (line.tag.equals("")) return tabs;  
            switch(line.tag){
                case "Start":
                    tok = "<!DOCTYPE html>\n<html>\n<head>\n" +
                          "</head>\n<body style=\"text-align: center;\">\n";
                    write.initBuffer(tok);
                    write.appendText(tok);
                    test = new String(write.buffer, 0, write.buffer.length);
                    content.write(test);
                    break;
                case "Title":
                    tok = String.format("<caption>%s</caption>\n", line.content);
                    write.initBuffer(tok);
                    write.appendText(tok);
                    test = new String(write.buffer, 0, write.buffer.length);
                    content.write(test);
                    break;
                case "Table":
                    tok = "<table border=\"1\" width=\"100%\">\n";
                    write.initBuffer(tok);
                    write.appendText(tok);
                    test = new String(write.buffer, 0, write.getLength());
                    content.write(test);
                    break;
                case "Row":
                    
                    String[] td = line.content.split("\\s*, \\s*");
                    System.out.println(Arrays.toString(td));
                    
                    if (tableRows == parsedRows){
                        tok = String.format("<tr style=\"%s: %s;\">\n<td>%s</td>\n<td>%s</td>\n<td>%s</td>\n</tr>\n</table>\n",
                                            line.attribute.toLowerCase(), line.attributeValue, td[0], td[1], td[2]);
                    } else{
                        tok = String.format("<tr style=\"%s: %s;\">\n<td>%s</td>\n<td>%s</td>\n<td>%s</td>\n</tr>\n",
                                            line.attribute.toLowerCase(), line.attributeValue, td[0], td[1], td[2]);
                    }
                    write.initBuffer(tok);
                    write.appendText(tok);
                    test = new String(write.buffer, 0, write.getLength());
                    content.write(test);
                    break;
                case "End":
                    tok = "</body>\n</html>\n";
                    write.initBuffer(tok);
                    write.appendText(tok);
                    test = new String(write.buffer, 0, write.buffer.length);
                    content.write(test);
                    break;
                default:
                    tok = "<shgkjdhgkh>\n";
                    write.initBuffer(tok);
                    write.appendText(tok);
                    test = new String(write.buffer, 0, write.buffer.length);
                    content.write(test);
                    break;
            }
            
        } catch (IOException e){
            System.out.println("Error: There was an error writing to the file.");
        }
        return tabs;
}
    
    public static void main(String[] args) {
        File src = new File("C:\\Users\\DTC\\Documents\\Slippery Rock assignments\\Object-oriented programming\\Assignment 3\\Assignment3\\src\\main\\java\\com\\mycompany\\assignment3\\assignment_input.txt");
            try (FileReader fr = new FileReader(src);
            BufferedReader content = new BufferedReader(fr);) {
                int lines = countLines(src);
                HTML add = new HTML();
                int tabs = 0;
                int tableRow = countRows(src);
                int parsedRow = 0;
                for (int i = 0; i < lines; i++){
                    char[] line = (content.readLine().toCharArray());
                    HTML parsed = lineParse(line, add);
                    if (parsed.tag.equals("Row") && parsed.tag != null){
                        parsedRow++;
                    }

                    tabs = writeLine(parsed, tabs, tableRow, parsedRow);
                }
            } catch(IOException e){
                System.out.println("Error: There was an error reading from the file.");
        }
    }
}
