package feed;

import java.util.concurrent.Semaphore;

public class FeedingTrough {
    private int number = 1;
    protected static final boolean[] FEEDING_PLACES = new boolean[5];

    protected static final Semaphore SEMAPHORE = new Semaphore(5, true);

    public FeedingTrough() {
    }

    public void createAnimal() throws InterruptedException {

        new Thread(new Animal(this.number)).start();
        this.number++;
    }
}
