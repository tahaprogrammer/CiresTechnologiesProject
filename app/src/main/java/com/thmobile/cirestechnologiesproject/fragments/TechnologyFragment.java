package com.thmobile.cirestechnologiesproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thmobile.cirestechnologiesproject.R;
import com.thmobile.cirestechnologiesproject.adapters.RecyclerListAdapter;
import com.thmobile.cirestechnologiesproject.utils.DataModel;
import com.thmobile.cirestechnologiesproject.utils.DataRequestServer;
import com.thmobile.cirestechnologiesproject.utils.OnDownloadFinished;
import com.thmobile.cirestechnologiesproject.utils.Utils;

import java.util.ArrayList;

public class TechnologyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_technology, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewTechnology);
        RecyclerListAdapter listAdapter = new RecyclerListAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);

        //Check if the user already downloaded the data from server
        //if the data already downloaded call it from the static variable
        if (Utils.dataModels_Technology.isEmpty()) {
            DataRequestServer dataRequestServer = new DataRequestServer(getActivity());
            dataRequestServer.getAllOnlineData(Utils.BASE_URL_Technology, new OnDownloadFinished() {
                @Override
                public void onFinished(ArrayList<DataModel> dataModels) {
                    listAdapter.updateList(dataModels);
                    Utils.dataModels_Technology = dataModels;
                }
            });
        }else{
            listAdapter.updateList(Utils.dataModels_Technology);
        }

        return view;
    }
}