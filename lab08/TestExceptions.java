public class TestExceptions {

	public static void main (String [ ] args) {
		//________________ ;
		int i = 1;


		Object obj = null;

		Object c = new Object();


		try {
			 obj.hashCode();

		} catch (NullPointerException e) {
			System.out.println ("got null pointer");
		}
		try {
			Object x[] = new String[3];
			x[0] = new Integer(0);

		} catch (ArrayStoreException e) {
			System.out.println ("got illegal array store");
		}
		try {
			System.out.println((String)c);

		} catch (ClassCastException e) {
			System.out.println ("got illegal class cast");
		}
	}

}
