import java.util.Random;

public class Philosopher extends Thread {
     
    private Table table;
    private int diner;
    private int dinerIndex;
    private Random random = new Random();
     
    public Philosopher(Table table, int diner){
        this.table = table;
        this.diner = diner;
        this.dinerIndex = diner - 1;
    }
     
    public void run(){
         
        while(true){
            this.thinking();
            System.out.println("Filosofo " + diner + " se prepara para comer...");
            this.table.pickFork(this.dinerIndex);
            int forkToTake = random.nextInt(2); // 0 para izquierdo, 1 para derecho
            if (forkToTake == 0) {
                System.out.println("Filosofo " + diner + " toma su tenedor izquierdo...");
            } else {
                System.out.println("Filosofo " + diner + " toma su tenedor derecho...");
            }
            this.eating();
            System.out.println("Filosofo " + diner + " deja de comer...");
            this.table.leftFork(this.dinerIndex);
        }
    }
     
    public void thinking(){
        
        System.out.println("Filosofo " + diner + " esta pensando...");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) { }
         
    }
     
    public void eating(){
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) { }
    }
}