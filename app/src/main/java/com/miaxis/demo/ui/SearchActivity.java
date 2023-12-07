package com.miaxis.demo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.miaxis.demo.PensionApplication;

import com.miaxis.demo.R;
import com.miaxis.demo.data.remote.response.PensionData;
import com.miaxis.demo.databinding.ActivitySearchBinding;
import com.miaxis.demo.ui.adapters.PensionListAdapter;
import com.miaxis.demo.util.DataState;
import com.miaxis.demo.viewmodel.SearchListViewModel;

import javax.inject.Inject;

public class SearchActivity extends AppCompatActivity  implements PensionListAdapter.OnItemClickListener {
    private static final String TAG = SearchActivity.class.getSimpleName();
    private ActivitySearchBinding binding;

    @Inject
    SearchListViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ((PensionApplication) getApplicationContext()).getAppComponent().inject(this);
        binding.userSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                binding.btnSearch.setEnabled(query.trim().length() != 0);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                binding.btnSearch.setEnabled(newText.trim().length() != 0);
                return false;
            }
        });



        binding.btnSearch.setOnClickListener(v->{

        viewModel.getUsers(binding.userSearchView.getQuery().toString())
                .observe(this, listDataState -> {
            if (listDataState.getStatus() == DataState.Status.SUCCESS) {
                Log.d(TAG, "getUsers Success: " + listDataState.getData().size());
                binding.shimmerViewContainer.setVisibility(View.GONE);
                if(listDataState.getData().size()==0){
                    binding.tvMessage.setVisibility(View.VISIBLE);
                    binding.tvMessage.setText(R.string.no_content_available);
                }
                PensionListAdapter listAdapter = new PensionListAdapter(listDataState.getData(), this);
                binding.rvPensionList.setHasFixedSize(true);
                binding.rvPensionList.setLayoutManager(new LinearLayoutManager(this));
                binding.rvPensionList.setAdapter(listAdapter);
            } else if (listDataState.getStatus() == DataState.Status.ERROR) {
                binding.shimmerViewContainer.setVisibility(View.GONE);
                binding.tvMessage.setVisibility(View.VISIBLE);
                binding.tvMessage.setText(String.format("Oops something went wrong. %s",listDataState.getErrorMessage() ));
                Log.e(TAG, "getUsers: Failure " + listDataState.getErrorMessage());
            } else {
                binding.shimmerViewContainer.setVisibility(View.VISIBLE);
                Log.i(TAG, "getUsers: Loading "+listDataState.getStatus());
            }
        });
        });
    }


    void gotoRegisterPage(PensionData user) {

        Intent vIntent = new Intent(this, RegisterBiometricActivity.class);
        vIntent.putExtra("data", user);
        startActivity(vIntent);
    }

    @Override
    public void onItemClick(PensionData item) {
        gotoRegisterPage(item);
//        Toast.makeText(this,String.valueOf(item.getName()), Toast.LENGTH_SHORT).show();
    }
}