package com.wirvsvirus.vbay.data;

import java.io.Serializable;

public class Eintrag implements Serializable {

    private Integer nrEintrag;
    private String menge;
    private String bezeichnung;


    public Integer getNrEintrag() {
        return nrEintrag;
    }

    public void setNrEintrag(Integer nrEintrag) {
        this.nrEintrag = nrEintrag;
    }

    public String getMenge() {
        return menge;
    }

    public void setMenge(String menge) {
        this.menge = menge;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
}
