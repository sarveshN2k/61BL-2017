import java.util.*;

public class PhoneBook {
    // TODO Add any instance variables necessary
    HashMap<Person, PhoneNumber> pb = new HashMap<>();

    /*
     * Adds a person with this name to the phone book and associates 
     * with the given PhoneNumber.
     */
    public void addEntry(Person personToAdd, PhoneNumber numberToAdd){
    	// TODO Add your own code
        pb.put(personToAdd, numberToAdd);
    }

    /*
     * Access an entry in the phone book. 
     */
    public PhoneNumber getNumber(Person personToLookup){
        PhoneNumber nll = pb.get(personToLookup);
        if (nll == null) {
            throw new IllegalArgumentException("not in phonebook");
        }
    	return pb.get(personToLookup);
    }

}
