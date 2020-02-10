import java.util.Arrays;

/**
 * Person class must be clonable and clone() must be overridden
 * to clone mutable objects and arrays manually
 */

public class Person implements Cloneable {
    public String name; // immutable so auto-clone ok
    public int age; // primitive so auto-clone ok
    private Address mainAddress; // mutable Object so must be clone manually
    private String[] cards; // array must be clone manually

    public Person(String name, int age, Address mainAddress, String[] cards) {
        this.name = name;
        this.age = age;
        this.mainAddress = mainAddress;
        this.cards = cards;
    }

    @Override
    protected Person clone() {
        try {
            Person person = (Person) super.clone();
            // We must clone non-primitives and mutable object fields manually,
            // or original address will be corrupted on clone modification
            person.setMainAddress(mainAddress.clone());
            person.setCards(cards.clone());
            return person;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new AssertionError();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(Address mainAddress) {
        this.mainAddress = mainAddress;
    }

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mainAddress=" + mainAddress +
                ", cards=" + Arrays.toString(cards) +
                '}';
    }

}
