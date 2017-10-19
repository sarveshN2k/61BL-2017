public class Time {

    private int myHours;
    private int myMinutes;
    
    public Time (String s) {
        if (s == null) {
            System.out.println("null time"); // null
            throw new IllegalArgumentException();
        }
        int colonPos = s.indexOf (":");
        if (colonPos == -1) {
            System.out.println(s + " no colon");// :x
            throw new IllegalArgumentException();
        } else if (colonPos == 0) {
            System.out.println(s + " leading colon");
        } else if (s.substring(0,1) == "0") {
            System.out.println(s + " leading 0");
        } else if (s.substring(0,1) == " " ) {
            System.out.println(s + " leading space");
        } else if (s.indexOf(":") == s.length() - 1) {
            System.out.println(s + " ends with :");
            throw new IllegalArgumentException();
        } else if (s.substring(colonPos + 1).length() != 2) {
            System.out.println(s + " length after colon != 2");
            throw new IllegalArgumentException();
        } else if (s.substring(colonPos - 1, colonPos) == " ") {
            System.out.println(s + " space before colon");
            throw new IllegalArgumentException();
        } else if (s.substring(colonPos + 1, colonPos + 2) == " ") {
            System.out.println(s + " space after colon");
            throw new IllegalArgumentException();
        }
        myHours = Integer.parseInt (s.substring (0, colonPos));
        myMinutes = Integer.parseInt (s.substring (colonPos+1));
    }
    
    public Time (int hours, int minutes) {
        myHours = hours;
        myMinutes = minutes;
    }

    public boolean equals (Object obj) {
        Time t = (Time) obj;
        return myHours == t.myHours && myMinutes == t.myMinutes;
    }

    public String toString() {
        if (myMinutes < 10) {
            return myHours + ":0" + myMinutes;
        } else {
            return myHours + ":" + myMinutes;
        }
    }

}
