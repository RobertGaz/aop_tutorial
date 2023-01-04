package orlanda;

public class Main {
    public static void main(String[] args) throws Exception {
        printName("Robert");
        printName("Alina");
        printName("Rustam");

        makeOperation("Rob");

//        crash();

    }

    public static void printName(String s) {
        System.out.println(s);
    }

    public static int makeOperation(String clientName) {
        System.out.println("Doing operation on " + clientName + " ...");
        return 5;
    }

    public static int crash() throws Exception {
        throw new Exception("aaa");
    }
}