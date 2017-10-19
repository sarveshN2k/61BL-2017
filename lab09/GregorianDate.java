public class GregorianDate extends Date {

    public static int[] monthLengths = {31, 28, 31, 30, 31, 30, 31,
        31, 30, 31, 30, 31};

    public GregorianDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    @Override
    public int dayOfYear() {
        int rtnValue = 0;
        for (int m = 0; m < month() - 1; m++) {
            rtnValue += monthLengths[m];
        }
        return rtnValue + dayOfMonth();
    }

    public Date nextDate() {
        if (this.dayOfYear() == 365) {
            return new GregorianDate(this.year() + 1, 1,1);
        }else if (this.dayOfMonth() == 31) {
            return new GregorianDate(this.year(), this.month() + 1, 1);
        }else if (this.dayOfMonth() == 30) {
            if (this.month() == 4||this.month() == 6||this.month() == 9||this.month() == 11){
                return new GregorianDate(this.year(), this.month() + 1, 1);
            }
            return new GregorianDate(this.year(), this.month(), this.dayOfMonth() + 1);
        }else if (this.dayOfMonth() == 28 && this.month() == 2) {
            return new GregorianDate(this.year(), this.month() + 1, 1);
        }else {
            return new GregorianDate(this.year(), this.month(), this.dayOfMonth() + 1);
        }
    }
    /*
    public static void main(String[] args) {
        GregorianDate d1 = new GregorianDate(1,1,31);
        System.out.println(d1.nextDate().toString());
        GregorianDate d2 = new GregorianDate(1,12,31);
        System.out.println(d2.nextDate().toString());

        FrenchRevolutionaryDate d3 = new FrenchRevolutionaryDate(1,1,30);
        System.out.println(d3.nextDate().toString());
        FrenchRevolutionaryDate d4 = new FrenchRevolutionaryDate(1,13,5);
        System.out.println(d4.nextDate().toString());



    }
    */

}
