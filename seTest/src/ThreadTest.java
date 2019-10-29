import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static util.TimeUtil.getNowTime;

public class ThreadTest {

    public static LinkedList<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
        queue.add("f");
        queue.add("g");

        Runnable clearRunnable = () -> {
            if(queue != null && queue.size() != 0){
                String entity = queue.poll();
                System.out.println(getNowTime() + ":" + entity + "-" + Thread.currentThread().getName());
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        executor.scheduleAtFixedRate(clearRunnable, 3, 5, TimeUnit.SECONDS);
    }
}
