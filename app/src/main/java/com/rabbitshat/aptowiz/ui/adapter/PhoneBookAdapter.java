package com.rabbitshat.aptowiz.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rabbitshat.aptowiz.R;
import com.rabbitshat.aptowiz.model.PhoneBook;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class PhoneBookAdapter extends RecyclerView.Adapter<PhoneBookAdapter.ViewHolder> {

    private List<PhoneBook> listPhoneBook = new ArrayList<PhoneBook>();
    private Context context;

    public PhoneBookAdapter(List<PhoneBook> listPhonebook, Context context) {
        this.listPhoneBook = listPhonebook;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_phonebook, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PhoneBook item = listPhoneBook.get(position);
        String name = item.getName();
        if (name != null) {
            holder.tvFullName.setText(name);
            if (name.length() > 0)
                holder.tvHeader.setText(name.toString().
                        toUpperCase().charAt(0) + "");

        }

    }

    public int randInt() {


        Random rn = new Random();
        int answer = rn.nextInt(255);

        return answer;
    }

    @Override
    public int getItemCount() {
        return listPhoneBook.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView tvHeader;
        TextView tvFullName;
        View layoutHeader;

        public ViewHolder(View itemView) {
            super(itemView);

            tvHeader = (TextView) itemView.findViewById(R.id.tv_header_item_phoneBook);
            tvFullName = (TextView) itemView.findViewById(R.id.tv_name_item_phoneBook);

            layoutHeader = itemView.findViewById(R.id.name_layout_item_phoneBook);

        }
    }
}
