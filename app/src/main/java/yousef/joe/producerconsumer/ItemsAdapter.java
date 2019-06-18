package yousef.joe.producerconsumer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private ArrayList<Integer> itemsList = new ArrayList<>();
    private Context context;

    ItemsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TextView itemCounterTextView = (TextView) viewHolder.itemView;
        String itemCount = context.getString(R.string.item_count, position);
        itemCounterTextView.setText(itemCount);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public void addItem() {
        int itemCount = itemsList.size() + 1;
        itemsList.add(itemCount);
        // Refresh the adapter to show the new list
        notifyDataSetChanged();
    }

    public void removeItem() {
        int listSize = itemsList.size();
        // Remove the item only if there is an item to be removed
        if (listSize != 0) {
            int lastItemIndex = listSize - 1;
            itemsList.remove(lastItemIndex);
            // Refresh the adapter to show the new list
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View view) {
            super(view);
        }
    }
}
