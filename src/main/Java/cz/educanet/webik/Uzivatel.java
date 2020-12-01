package cz.educanet.weebik2;

public class Uzivatel {
    private String jmeno;
    private String heslo;
    public Uzivatel(String jmeno, String heslo) {
        this.jmeno = jmeno;
        this.heslo = heslo;
    }
        public void setjmeno(String jmeno) {
            this.jmeno = jmeno;
        }

        public String getjmeno(){
            return jmeno;
        }

        public void setheslo(String heslo) {
            this.heslo = heslo;
        }

        public String getheslo() {
            return heslo;
        }

}
