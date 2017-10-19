/**
 * Created by Ray on 7/6/2017.
 */
public class ResizableList extends FixedSizeList {

    public ResizableList() {
        super(0);
    }

    public void decrementSize() {
        int[] decrementedValues = new int[this.values.length - 1];
        for (int i = 0; i < this.values.length - 1; i++) {
            decrementedValues[i] = this.values[i];
        }
        this.values = decrementedValues;
    }
    public void incrementSize() {
        int[] incrementedValues = new int[this.values.length + 1];
        for (int i = 0; i < this.values.length; i++) {
            incrementedValues[i] = this.values[i];
        }
        this.values = incrementedValues;
    }

    @Override
    public void add(int i, int k) {
        this.incrementSize();
        super.add(i,k);
    }

    @Override
    public void add(int k) {
        this.incrementSize();
        super.add(k);
    }

    @Override
    public void remove(int k) {
        super.remove(k);
        this.decrementSize();
    }

    @Override
    public void removeIndex(int i) {
        super.removeIndex(i);
        this.decrementSize();
    }

    public void printout() {
        for (int i = 0; i < this.values.length; i++) {
            System.out.print(this.values[i] + ", ");
        }
        System.out.println(":: Size :: " + this.size() + " " + this.count);


    }

    public static void main(String[] args) {
        ResizableList list = new ResizableList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printout();

        list.remove(1);
        list.printout();

        list.remove(3);
        list.printout();

        list.removeIndex(1);
        list.printout();

        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }

}
