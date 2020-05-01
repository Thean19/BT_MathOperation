package com.bokor.bt_mathoperation.Activity.Go_to.Adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Capacity.Lets_start_capacity;
import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Capacity.Lets_start_capacity_2;
import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Capacity.Lets_start_capacity_3;
import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Decimal.Lets_start_decimal;
import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Decimal.Lets_start_decimal_2;
import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Decimal.Lets_start_decimal_3;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;

public class Adapter_RecyclerView_Deci extends RecyclerView.Adapter<Adapter_RecyclerView_Deci.ViewHolder> {

    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    Context context;

    public Adapter_RecyclerView_Deci(Context applicationContext, ArrayList<String> id, ArrayList<String> title) {

        this.context = applicationContext;
        this.id = id;
        this.title = title;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView idTextView;
        public TextView titleTextView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            idTextView = itemView.findViewById(R.id.textViewName);
            idTextView.setBackgroundResource(R.drawable.gradient_decimal);
            titleTextView = itemView.findViewById(R.id.textViewVersion);
            cardView = itemView.findViewById(R.id.card_view);
//            PushDownAnim.setPushDownAnimTo(cardView).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent go = new Intent(context, Lets_start_decimal.class);
//                    go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(go);
//                }
//            });
        }
    }

    @Override
    public Adapter_RecyclerView_Deci.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_list, parent, false);

        Adapter_RecyclerView_Deci.ViewHolder viewHolder = new Adapter_RecyclerView_Deci.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.idTextView.setText(id.get(position));
        holder.titleTextView.setText(title.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position == 0) {
                    Intent go = new Intent(context, Lets_start_decimal.class);
                    go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(go);
//                    Toast.makeText(context,"position 1",Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Intent go = new Intent(context, Lets_start_decimal_2.class);
                    go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(go);
//                    Toast.makeText(context,"position 2",Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Intent go = new Intent(context, Lets_start_decimal_3.class);
                    go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(go);
//                    Toast.makeText(context,"position 3",Toast.LENGTH_SHORT).show();
                }
            }
        });
        PushDownAnim.setPushDownAnimTo(holder.cardView);
    }

    @Override
    public int getItemCount() {
        return id.size();
    }
}