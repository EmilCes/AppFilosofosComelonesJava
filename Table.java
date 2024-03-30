public class Table {
     
    private boolean[] forks;
     
    public Table(int numForks){
        this.forks = new boolean[numForks];
    }
     
    public int leftForks(int i){
        return i;
    }
     
    public int rightForks(int i){
        if(i == 0){
            return this.forks.length - 1;
        }else{
            return i - 1;
        }
    }

    public synchronized void pickFork(int diner){
         
        while(forks[leftForks(diner)] || forks[rightForks(diner)]){
            try {   
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getStackTrace());
            }
        }
         
        forks[leftForks(diner)] = true;
        forks[rightForks(diner)] = true;
    }
     
    public synchronized void leftFork(int diner){
        forks[leftForks(diner)] = false;
        forks[rightForks(diner)] = false;
        notifyAll();
    }
}


