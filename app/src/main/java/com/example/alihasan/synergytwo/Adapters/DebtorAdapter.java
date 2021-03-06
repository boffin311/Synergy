package com.example.alihasan.synergytwo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alihasan.synergytwo.Assignments.BusinessActivity;
import com.example.alihasan.synergytwo.R;
import com.example.alihasan.synergytwo.api.model.Debtor;

import java.util.List;

public class DebtorAdapter extends RecyclerView.Adapter<DebtorAdapter.MyViewHolder> {

    Context context;
    List<Debtor> debtorList;
    static String userName;

    public DebtorAdapter(Context context, List<Debtor> debtorList, String userName) {
        this.context = context;
        this.debtorList = debtorList;
        this.userName = userName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.agent_card,viewGroup,false);
        MyViewHolder recycViewHolder = new MyViewHolder(view,context,debtorList);
        return recycViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Debtor debtor = debtorList.get(position);

        holder.caseNo.setText(debtor.getCaseNo());
        holder.applName.setText(debtor.getApplName());
        holder.altTele.setText(debtor.getAltTele());
        holder.address.setText(debtor.getAddress());
        holder.typeCase.setText(debtor.getTypeCase());
    }

    @Override
    public int getItemCount() {
        return debtorList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView caseNo, applName, altTele, address, typeCase;
        Context context;
        List<Debtor> data;

        public MyViewHolder(View itemView, Context context, List<Debtor> data) {
            super(itemView);
            this.data = data;
            this.context = context;

            caseNo = itemView.findViewById(R.id.caseNo);
            applName = itemView.findViewById(R.id.applName);
            altTele = itemView.findViewById(R.id.altTele);
            address = itemView.findViewById(R.id.address);
            typeCase = itemView.findViewById(R.id.caseType);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(typeCase.getText().toString().equals("BUSINESS")) {
                Intent intent = new Intent(this.context, BusinessActivity.class);
//                intent.putExtra("CASENO");
//                intent.putExtra("USERNAME",userName);

                SharedPreferences caseData = context.getSharedPreferences("CASEDATA", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = caseData.edit();
                editor.putString("CASENO", caseNo.getText().toString());
                editor.putString("ACTIVITY", "BUSINESS");
                editor.apply();

                context.startActivity(intent);
            }

            else if(typeCase.getText().toString().equals("PROPERTY")) {
                Intent intent = new Intent(this.context, BusinessActivity.class);
//                intent.putExtra("CASENO");
//                intent.putExtra("USERNAME",userName);

                SharedPreferences caseData = context.getSharedPreferences("CASEDATA", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = caseData.edit();
                editor.putString("CASENO", caseNo.getText().toString());
                editor.putString("ACTIVITY", "PROPERTY");
                editor.apply();

                context.startActivity(intent);
            }

            else if(typeCase.getText().toString().equals("RESIDENCE")) {
                Intent intent = new Intent(this.context, BusinessActivity.class);
//                intent.putExtra("CASENO");
//                intent.putExtra("USERNAME",userName);

                SharedPreferences caseData = context.getSharedPreferences("CASEDATA", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = caseData.edit();
                editor.putString("CASENO", caseNo.getText().toString());
                editor.putString("ACTIVITY", "RESIDENCE");
                editor.apply();

                context.startActivity(intent);
            }

            else if(typeCase.getText().toString().equals("EMPLOYMENT")) {
                Intent intent = new Intent(this.context, BusinessActivity.class);
//                intent.putExtra("CASENO");
//                intent.putExtra("USERNAME",userName);

                SharedPreferences caseData = context.getSharedPreferences("CASEDATA", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = caseData.edit();
                editor.putString("CASENO", caseNo.getText().toString());
                editor.putString("ACTIVITY", "EMPLOYMENT");
                editor.apply();

                context.startActivity(intent);
            }

            else
            {
                Toast.makeText(context, "BUSI/EMP/PROP/RESI????? ", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
