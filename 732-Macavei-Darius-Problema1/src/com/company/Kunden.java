package com.company;

public class Kunden {
    public enum Unternehmensgrosse{Small,Medium,Large};
    private int id;
    private String unternehmensname;
    private Unternehmensgrosse unternehmensgrosse;
    private int anzahl_mitarbeiter;
    private float einkommen_kunde;
    private String ort;

    public Kunden(int id, String unternehmensname, Unternehmensgrosse unternehmensgrosse, int anzahl_mitarbeiter, float einkommen_kunde, String ort) {
        this.id = id;
        this.unternehmensname = unternehmensname;
        this.unternehmensgrosse = unternehmensgrosse;
        this.anzahl_mitarbeiter = anzahl_mitarbeiter;
        this.einkommen_kunde = einkommen_kunde;
        this.ort = ort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnternehmensname() {
        return unternehmensname;
    }

    public void setUnternehmensname(String unternehmensname) {
        this.unternehmensname = unternehmensname;
    }

    public Unternehmensgrosse getUnternehmensgrosse() {
        return unternehmensgrosse;
    }

    public void setUnternehmensgrosse(Unternehmensgrosse unternehmensgrosse) {
        this.unternehmensgrosse = unternehmensgrosse;
    }

    public int getAnzahl_mitarbeiter() {
        return anzahl_mitarbeiter;
    }

    public void setAnzahl_mitarbeiter(int anzahl_mitarbeiter) {
        this.anzahl_mitarbeiter = anzahl_mitarbeiter;
    }

    public float getEinkommen_kunde() {
        return einkommen_kunde;
    }

    public void setEinkommen_kunde(float einkommen_kunde) {
        this.einkommen_kunde = einkommen_kunde;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "Kunden{" +
                "id=" + id +
                ", unternehmensname='" + unternehmensname + '\'' +
                ", unternehmensgrosse=" + unternehmensgrosse +
                ", anzahl_mitarbeiter=" + anzahl_mitarbeiter +
                ", einkommen_kunde=" + einkommen_kunde +
                ", ort='" + ort + '\'' +
                '}';
    }
}
