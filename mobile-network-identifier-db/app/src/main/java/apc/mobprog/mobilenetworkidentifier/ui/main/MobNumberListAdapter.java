package apc.mobprog.mobilenetworkidentifier.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import java.util.List;

import apc.mobprog.mobilenetworkidentifier.MobNumber;
import apc.mobprog.mobilenetworkidentifier.R;

public class MobNumberListAdapter
        extends RecyclerView.Adapter<MobNumberListAdapter.ViewHolder> {

    private int mobileNumberItemLayout;
    private List<MobNumber> mobNumberList;

    public MobNumberListAdapter(int layoutId) {
        this.mobileNumberItemLayout = layoutId;
    }

    public void setNumbersList(List<MobNumber> mobilenumbers) {
        mobNumberList = mobilenumbers;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mobNumberList == null ? 0 : mobNumberList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(mobileNumberItemLayout, parent, false);
        return new ViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView item = holder.item;
        item.setText(mobNumberList.get(listPosition).getMobNumPrefix());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView item;

        ViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.mobilenumber_row);
        }
    }
}