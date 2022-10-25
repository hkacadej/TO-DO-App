package org.example;

import java.util.List;
import java.util.Scanner;

public class Controller {

    List <ListItem> list ;
    String doVazhdosh = "";
    public Controller( List <ListItem> list ){

        this.list=list;
        System.out.println("PERSHENDETJE");

        Scanner scanner= new Scanner(System.in);

        while (!doVazhdosh.equals("jo")) {
            System.out.println(
                    "PRINTO LISTEN : 1 \n" +
                            "SHTO ITEM : 2 \n"+
                            "FSHIJ ITEM : 3\n"+
                            "NDRYSHO STATUSIN : 4\n"+
                            "MBYLL APLIKACIONIN DHE RUAJ LISTEN: 5"
            );
            veprimet(zgjidhVeprim());
        }
    }

    public Integer zgjidhVeprim(){
        Scanner scanner = new Scanner(System.in);
        Integer veprimi = null;
        while (veprimi==null){
            System.out.println("Zgjidh Veprim :");
            try {
                int vep = Integer.parseInt(scanner.nextLine());
                if ((vep > 0) && (vep < 6)) {
                    veprimi=vep;
                }else {throw new Exception();}
            }catch (Exception e){
                System.out.println("Keni futur veprim te paligjshem!");
            }
        }
        return veprimi;
    }

    public List<ListItem> getList() {
        return list;
    }

    public void setList(List<ListItem> list) {
        this.list = list;
    }
    public void veprimet(Integer veprimi){
        switch (veprimi) {
            case 1 -> ListUtils.printoListen(this.list);
            case 2 -> list.add(ListUtils.shtoListItem());
            case 3 -> ListUtils.hiqListItem(this.list);
            case 4 -> ListUtils.updateListItem(this.list);
            case 5 -> this.doVazhdosh="jo";
        }
    }
}
