package org.example;



import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListUtils {

    public static void printoListen(List<ListItem> lista){
        if (lista.isEmpty()){
            System.out.println("Ju nuk keni asje Item ne liste");
        } else {
            int i = 1;

            for (ListItem item : lista) {
                System.out.println("ITEM " + "" + i);
                System.out.println("Pershkrimi : " + item.getPershkrimi());
                System.out.println("Data e perfundimit : " + item.getDataPerfundimit());
                if (item.geteKompletuar()) {
                    System.out.println("E kompletuar");
                } else {
                    System.out.println("E Pa Perfunduar");
                }
                System.out.println("____________________");
                i++;
            }
        }
    }

    public static ListItem shtoListItem(){
        String s = "";

        Scanner scanner = new Scanner(System.in);
        ListItem item = new ListItem();


        System.out.println("Jep pershkrimin :");

        item.setPershkrimi(scanner.nextLine());

        LocalDateTime localDateTime = null;

        while (localDateTime==null) {
            try {

                System.out.println("Jep daten e perfundimit ne formatin : yyyy-MM-dd");
                s=scanner.next();
                System.out.println("Jep Oren e perfundimit ne formatin HH:MM");
                s+="T"+scanner.next();
                localDateTime = LocalDateTime.parse(s);
                item.setDataPerfundimit(localDateTime);

            } catch (DateTimeParseException e) {
                System.out.println("Ke fut daten ose oren gabim");
            }

        }

        return item;
    }

    public static void hiqListItem(List<ListItem> list){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Jep numrin e item qe do te fshish :");

        int numri = scanner.nextInt()-1;

        list.remove(numri);
    }
    public static void updateListItem(List<ListItem> list){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Jep numrin e item qe do ti ndryshosh statusin :");

        int numri = scanner.nextInt()-1;

        list.get(numri).seteKompletuar(!list.get(numri).geteKompletuar());
    }

    public static void init(){
        String filePath = "files/ListFiles.txt";

        List <ListItem> list = FilesUtils.ReadObjectFromFile(filePath);

        Controller controller = new Controller(list);

        FilesUtils.WriteObjectToFile(list,filePath);
    }
}
