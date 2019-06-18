package yousef.joe.producerconsumer.models;

import android.os.Handler;

import yousef.joe.producerconsumer.ItemsAdapter;

public class Consumer extends User {
    private ItemsAdapter itemsAdapter;

    public Consumer(ItemsAdapter itemsAdapter, Handler handler) {
        super(handler,4000);
        this.itemsAdapter = itemsAdapter;
    }

    @Override
    public void updateList() {
        itemsAdapter.removeItem();
    }
}
