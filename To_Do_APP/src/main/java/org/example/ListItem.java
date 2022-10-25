package org.example;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ListItem implements Serializable {

    private LocalDateTime dataPerfundimit;
    private Boolean eKompletuar= false;
    private String pershkrimi;

    public ListItem( LocalDateTime dataPerfundimit,  String pershkrimi) {

        this.dataPerfundimit = dataPerfundimit;
        this.pershkrimi = pershkrimi;
    }
    public ListItem(){}



    public LocalDateTime getDataPerfundimit() {
        return dataPerfundimit;
    }


    public void setDataPerfundimit(LocalDateTime data) {

        this.dataPerfundimit = data;
    }

    public Boolean geteKompletuar() {
        return eKompletuar;
    }

    public void seteKompletuar(Boolean eKompletuar) {
        this.eKompletuar = eKompletuar;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                ", dataPerfundimit=" + dataPerfundimit +
                ", eKompletuar=" + eKompletuar +
                ", pershkrimi='" + pershkrimi + '\'' +
                '}';
    }
}
