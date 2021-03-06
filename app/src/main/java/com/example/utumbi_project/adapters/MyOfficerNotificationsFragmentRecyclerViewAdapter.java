package com.example.utumbi_project.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.utumbi_project.OfficerNotificationsFragment.OnListFragmentInteractionListener;
import com.example.utumbi_project.R;
import com.example.utumbi_project.dummy.DummyContent.DummyItem;

import java.util.List;

public class MyOfficerNotificationsFragmentRecyclerViewAdapter extends RecyclerView.Adapter<MyOfficerNotificationsFragmentRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyOfficerNotificationsFragmentRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_officernotifications_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = mValues.get(position);

        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;

        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);

            mView = view;
            mIdView =  view.findViewById(R.id.item_number);
            mContentView =  view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
