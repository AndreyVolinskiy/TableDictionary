package model;

/**
 * @author Igor Hnes on 2/9/18.
 */
public class Translate {
    private String ukr;
    private String eng;

    public Translate() {
    }

    public Translate(String ukr, String eng) {
        this.ukr = ukr;
        this.eng = eng;
    }

    public String getUkr() {
        return ukr;
    }

    public void setUkr(String ukr) {
        this.ukr = ukr;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }
}
