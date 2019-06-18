package yousef.joe.producerconsumer.models;

import android.os.Handler;
import yousef.joe.producerconsumer.ItemsAdapter;

public class Producer extends User {
    private ItemsAdapter itemsAdapter;

    public Producer(ItemsAdapter itemsAdapter, Handler handler) {
        super(handler,3000);
        this.itemsAdapter = itemsAdapter;
    }

    @Override
    public void updateList() {
        itemsAdapter.addItem();
    }
}
