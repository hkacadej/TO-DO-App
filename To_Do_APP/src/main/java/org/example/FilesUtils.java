package org.example;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FilesUtils {





    public static void WriteObjectToFile(List<ListItem> list,String filepath) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(list);
            objectOut.close();
            System.out.println("Lista u ruajt me sukses");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static List<ListItem>  ReadObjectFromFile(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            List<ListItem>  list = (List<ListItem>) objectIn.readObject();

            objectIn.close();
            return list;

        } catch (Exception e) {
            List<ListItem> list = new ArrayList<>();
            return list;
        }
    }
}
