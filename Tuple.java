public class Tuple {
    private int m0;
    private int m1;
    private int c0;
    private int c1;
    public Tuple(int m0, int c0, int m1, int c1){
        this.m0=m0;
        this.m1=m1;
        this.c0=c0;
        this.c1=c1;
    }

    public int getC0() {
        return c0;
    }

    public int getC1() {
        return c1;
    }

    public int getM0() {
        return m0;
    }

    public int getM1() {
        return m1;
    }

    public void setC0(int c0) {
        this.c0 = c0;
    }

    public void setM0(int m0) {
        this.m0 = m0;
    }

    public void setM1(int m1) {
        this.m1 = m1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    @Override
    public String toString() {
        return "((" + this.m0 + "," + this.c0 + "),(" + this.m1 + "," + this.c1 +"))";
    }
}
