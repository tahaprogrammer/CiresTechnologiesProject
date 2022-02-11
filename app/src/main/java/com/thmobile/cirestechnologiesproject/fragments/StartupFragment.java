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

public class StartupFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_startup, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewStartup);
        RecyclerListAdapter listAdapter = new RecyclerListAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);

        if (Utils.dataModels_Startup.isEmpty()) {
            DataRequestServer dataRequestServer = new DataRequestServer(getActivity());
            dataRequestServer.getAllOnlineData(Utils.BASE_URL_Startup, new OnDownloadFinished() {
                @Override
                public void onFinished(ArrayList<DataModel> dataModels) {
                    listAdapter.updateList(dataModels);
                    Utils.dataModels_Startup = dataModels;
                }
            });
        }else{
            listAdapter.updateList(Utils.dataModels_Startup);
        }

        return view;
    }
}