public class ModNCounter {

	private int myCount;
	private int wrap;

	public ModNCounter(int wrapBy) {
		myCount = 0;
		wrap = wrapBy;
	}

	public void increment() {
		myCount++;
		myCount %= wrap;
	}

	public void reset() {
		myCount = 0;
	}

	public int value() {
		return myCount;
	}

}
