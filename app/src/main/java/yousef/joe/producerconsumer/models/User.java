package yousef.joe.producerconsumer.models;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

public abstract class User {

    public abstract void updateList();

     User(final Handler handler, int timeInMilliseconds ){

         // Task to be executed after a period of time
         TimerTask timerTask = new TimerTask() {
             @Override
             public void run() {
                 // Run the code on the UI thread
                 handler.post(new Runnable() {
                     @Override
                     public void run() {
                         updateList();
                     }
                 });

             }
         };

         // Schedule the task to be executed repeatedly after @timeInMilliseconds
      new Timer().scheduleAtFixedRate(timerTask, 0, timeInMilliseconds);

    }

}
