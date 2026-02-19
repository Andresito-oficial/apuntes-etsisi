import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        while (true) {
            int value = random.nextInt(100);
            if (value < 70) {
                System.out.format("%d is lower than 70 %n", value);
            } else if (value < 90) {
                System.out.format("%d is lower than 90 %n", value);
            } else {
                System.out.format("%d is higher than 90 %n", value);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
