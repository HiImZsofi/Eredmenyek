package hu.petrik.versenyeredmenyek;

public class Eredemny implements Comparable<Eredemny>{
    private String reszIdo;
    private String nev;

    public Eredemny(String reszIdo, String nev) {
        this.reszIdo = reszIdo;
        this.nev = nev;
    }

    public String getReszIdo() {
        return reszIdo;
    }

    public String getNev() {
        return nev;
    }


    @Override
    public int compareTo(Eredemny other) {
        String[] thisReszidok = this.reszIdo.split(":");
        String[] otherReszidok = other.reszIdo.split(":");
        Integer thisperc = Integer.parseInt(thisReszidok[0]);
        Integer thismasodperc = Integer.parseInt(thisReszidok[1]);
        Integer otherperc = Integer.parseInt(otherReszidok[0]);
        Integer othermasodperc = Integer.parseInt(otherReszidok[1]);

        if(thisperc.compareTo(otherperc) == 0){
            return thismasodperc.compareTo(othermasodperc);
        }
        return thisperc.compareTo(otherperc);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.nev, this.reszIdo);
    }
}
