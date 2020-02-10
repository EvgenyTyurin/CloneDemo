/**
 * Clone mechanism demo: mutable objects and arrays must be cloned manually
 */

public class CloneDemo {

    public static void main(String[] args) {
        Person person = new Person("John", 22,
                new Address("Beverli Hills, 66"),
                new String[]{"312312312312312,321312312312"});
        System.out.println("Original: " + person); // John from Beverly Hills
        Person person2 = person.clone();
        System.out.println("Clone: " + person2); // Another John from Beverly Hills
        person2.name = "XXXXXXXXX";
        person2.age = -666;
        person2.getMainAddress().setAddressStr("XXXXXXXXXXXXX");
        person2.getCards()[0] = "xxxxxxxxxxxxxx";
        System.out.println("Clone modified: " + person2); // Evil clone: Jack from Malholland drive
        System.out.println("Original after cloning: " + person); // But original not corrupted
    }

}
