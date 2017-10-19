public class Measurement {
	public int numInches;
	/**
	 * Constructor: initialize this object to be a measurement of 0 feet, 0
	 * inches
	 */
	public Measurement() {
		this.numInches = 0;
	}

	/**
	 * Constructor: takes a number of feet as its single argument, using 0 as
	 * the number of inches
	 */
	public Measurement(int feet) {
		this.numInches = 12 * feet;
	}

	/**
	 * Constructor: takes the number of feet in the measurement and the number
	 * of inches as arguments (in that order), and does the appropriate
	 * initialization
	 */
	public Measurement(int feet, int inches) {
		this.numInches = 12 * feet + inches;

	}

	/**
	 * Returns the number of feet in in this Measurement. For example, if the
	 * Measurement has 1 foot and 6 inches, this method should return 1.
	 */
	public int getFeet() {
		int feet = 0;
		int inLeft = this.numInches;
		while (inLeft >= 12) {
			inLeft -= 12;
			feet += 1;// provided to allow the file to compile
		}
		return feet;
	}

	/**
	 * Returns the number of inches in this Measurement. For example, if the
	 * Measurement has 1 foot and 6 inches, this method should return 6.
	 */
	public int getInches() {return this.numInches % 12;
	}

	/** Adds the argument m2 to the current measurement */
	public Measurement plus(Measurement m2) {
		Measurement added =  new Measurement();
		added.numInches = this.numInches + m2.numInches;
		return added;
	}

	/**
	 * Subtracts the argument m2 from the current measurement. You may assume
	 * that m2 will always be smaller than the current measurement.
	 */
	public Measurement minus(Measurement m2) {
		Measurement subtracted = new Measurement();
		subtracted.numInches = this.numInches - m2.numInches;
		return subtracted;
	}

	/**
	 * Takes a nonnegative integer argument n, and returns a new object that
	 * represents the result of multiplying this object's measurement by n. For
	 * example, if this object represents a measurement of 7 inches, multiple
	 * (3) should return an object that represents 1 foot, 9 inches.
	 */
	public Measurement multiple(int multipleAmount) {

		Measurement scaled = new Measurement(); // provided to allow the file to compile
		scaled.numInches = this.numInches * multipleAmount;
		return scaled;
	}

	/**
	 * toString should return the String representation of this object in the
	 * form f'i" that is, a number of feet followed by a single quote followed
	 * by a number of inches less than 12 followed by a double quote (with no
	 * blanks).
	 */
	@Override
	public String toString() {
		return new String(this.getFeet() + "'" + this.getInches() + '"'); // provided to allow the file to compile
	}

}
