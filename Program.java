public class Program {
     
    public static void main(String[] args) {
        Table table = new Table(5);
        for (int i = 1; i <= 5; i++) {
            Philosopher f = new Philosopher(table, i);
            f.start();
        }
    }
}