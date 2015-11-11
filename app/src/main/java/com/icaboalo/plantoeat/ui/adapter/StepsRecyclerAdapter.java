package com.icaboalo.plantoeat.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.icaboalo.plantoeat.R;
import com.icaboalo.plantoeat.domain.Steps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icaboalo on 10/23/2015.
 */
public class StepsRecyclerAdapter extends RecyclerView.Adapter<StepsRecyclerAdapter.MyStepsViewHolder> {

    Context mContext;
    List<Steps> mStepsList = new ArrayList<>();
    LayoutInflater mInflater;

    public StepsRecyclerAdapter(Context context, List<Steps> stepsList) {
        mContext = context;
        mStepsList = stepsList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyStepsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_row_steps_list, parent, false);
        MyStepsViewHolder viewHolder = new MyStepsViewHolder(view, R.id.step_description, R.id.step_number);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyStepsViewHolder holder, int position) {
        Steps steps = mStepsList.get(position);
        holder.setStepNumber(position + 1);
        holder.setStepDescription(steps.getStepDescription());
    }

    @Override
    public int getItemCount() {
        return mStepsList.size();
    }

    public void setData(List<Steps> newList){
        mStepsList = newList;
    }

    public void addData(String stepDescription){
        mStepsList.add(new Steps(stepDescription));
        notifyDataSetChanged();
    }

    public class MyStepsViewHolder extends RecyclerView.ViewHolder{

        TextView mStepDescription, mStepNumber;

        public MyStepsViewHolder(View itemView, int stepDescriptionId, int stepNumberId) {
            super(itemView);
            mStepDescription = (TextView) itemView.findViewById(stepDescriptionId);
            mStepNumber = (TextView) itemView.findViewById(stepNumberId);
        }

        public void setStepDescription(String stepDescription) {
            mStepDescription.setText(stepDescription);
        }

        public void setStepNumber(int stepNumber) {
            mStepNumber.setText(stepNumber + "");
        }
    }
}
