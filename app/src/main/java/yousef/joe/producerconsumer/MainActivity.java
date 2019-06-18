package yousef.joe.producerconsumer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import yousef.joe.producerconsumer.models.Consumer;
import yousef.joe.producerconsumer.models.Producer;

public class MainActivity extends AppCompatActivity {
    int producerCount = 0;
    int consumerCount  = 0;
    TextView producerCountTextView, consumerCountTextView;
    ItemsAdapter itemsAdapter;
    Handler handler;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views
        Button addProducerButton = findViewById(R.id.btn_producer);
        Button addConsumerButton = findViewById(R.id.btn_consumer);
        producerCountTextView = findViewById(R.id.tv_producer_count);
        consumerCountTextView = findViewById(R.id.tv_consumer_count);
        recyclerView = findViewById(R.id.recycler_view);

        // Show default values
        consumerCountTextView.setText(getString(R.string.consumer_count, consumerCount));
        producerCountTextView.setText(getString(R.string.producer_count, producerCount));

        // Attach a handler to the UI thread, allowing other threads to post to the UI thread
        handler = new Handler();

        initRecyclerView();

        addProducerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newProducer();
            }
        });

        addConsumerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newConsumer();
            }
        });

    }

    private void newConsumer() {
        // Display the current count of the consumers
        consumerCount++;
        String consumerCountText = getString(R.string.consumer_count, consumerCount);
        consumerCountTextView.setText(consumerCountText);

        new Consumer(itemsAdapter, handler);
    }

    private void newProducer() {
        // Display the current count of the producers
        producerCount++;
        String producerCountText = getString(R.string.producer_count, producerCount);
        producerCountTextView.setText(producerCountText);

        new Producer(itemsAdapter, handler);
    }

    private void initRecyclerView() {
        // Set the adapter Layout to be vertical
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Attach the items adapter to the recyclerView
        itemsAdapter = new ItemsAdapter(this);
        recyclerView.setAdapter(itemsAdapter);
    }

}
