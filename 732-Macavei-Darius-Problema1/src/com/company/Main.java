package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File f=new File("kundendaten.txt");
        Scanner scanner=new Scanner(f);
        List<Kunden> kunden=new ArrayList<>();
        String data;
        String[] kunden_line;
        while(scanner.hasNext())
        {

            data=scanner.nextLine();
            kunden_line=data.split(",");
            Kunden kunde=new Kunden(Integer.parseInt(kunden_line[0]),kunden_line[1],Kunden.Unternehmensgrosse.valueOf(kunden_line[2]),Integer.parseInt(kunden_line[3]),Float.parseFloat(kunden_line[4]),kunden_line[5]);
            kunden.add(kunde);
        }
        kunden.sort(new Comparator<Kunden>() {
            @Override
            public int compare(Kunden o1, Kunden o2) {
                return o2.getAnzahl_mitarbeiter() - o1.getAnzahl_mitarbeiter();
            }
        });
        FileWriter fileWriter1=new FileWriter("kundensortiert.txt");
        for(Kunden k:kunden)
        {
            String string=k.getId()+","+k.getUnternehmensname()+","+k.getUnternehmensgrosse()+","+k.getAnzahl_mitarbeiter()+","+ (int) k.getEinkommen_kunde() +","+k.getOrt()+"\n";
            fileWriter1.write(string);
        }
        fileWriter1.close();
        FileWriter fileWriter2=new FileWriter("statistik.txt");
        kunden.sort(new Comparator<Kunden>() {
            @Override
            public int compare(Kunden o1, Kunden o2) {
                return (int) (o2.getEinkommen_kunde()-o1.getEinkommen_kunde());
            }
        });
        for(Kunden k:kunden)
        {
            String string=k.getOrt()+": "+(int) k.getEinkommen_kunde()+"\n";
            fileWriter2.write(string);
        }
        fileWriter2.close();
    }
}
