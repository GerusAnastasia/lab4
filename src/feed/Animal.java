package feed;

public class Animal implements Runnable{
    private int animalNNumber;

    public Animal(int number) {
        this.animalNNumber = number;
    }

    @Override
    public void run() {
        System.out.printf("Животное №%d подошло к кормушке.\n", animalNNumber);
        try {

            FeedingTrough.SEMAPHORE.acquire();

            int feedingNumber = -1;


            synchronized (FeedingTrough.FEEDING_PLACES){
                for (int i = 0; i < 5; i++)
                    if (!FeedingTrough.FEEDING_PLACES[i]) {
                        FeedingTrough.FEEDING_PLACES[i] = true;
                        feedingNumber = i;
                        System.out.printf("Животное №%d ест. Номер у кормушки %d.\n", animalNNumber, i+1);
                        break;
                    }
            }

            Thread.sleep(5000);

            synchronized (FeedingTrough.FEEDING_PLACES) {
                FeedingTrough.FEEDING_PLACES[feedingNumber] = false;
            }

            FeedingTrough.SEMAPHORE.release();
            System.out.printf("Животное №%d поело.\n", animalNNumber);
        } catch (InterruptedException e) {
            System.out.println("Что-то пошло не так.\n");
        }
    }
}



