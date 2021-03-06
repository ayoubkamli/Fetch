package com.tonyodev.fetch2sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.Fetch;
import com.tonyodev.fetch2.FetchListener;
import com.tonyodev.fetch2.Request;

/**
 * Created by tonyofrancis on 1/31/17.
 */

public class ProgressFragment extends Fragment implements FetchListener {

    private Request request;
    private ProgressBar progressBar;
    private TextView progressTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_progress,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressTextView = (TextView) view.findViewById(R.id.progressTextView);
        updateProgress(0);
    }



    @Override
    public void onResume() {
        super.onResume();
        updateProgress(0);
    }

    private void updateProgress(int progress) {

        progressBar.setProgress(progress);
        progressTextView.setText(getResources().getString(R.string.percent_progress,progress));
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public void onComplete(long id, int progress, long downloadedBytes, long totalBytes) {

    }

    @Override
    public void onAttach(Fetch fetch) {

    }

    @Override
    public void onDetach(Fetch fetch) {

    }

    @Override
    public void onError(long id, Error reason, int progress, long downloadedBytes, long totalBytes) {

    }

    @Override
    public void onProgress(long id, int progress, long downloadedBytes, long totalBytes) {
        if (id == getRequest().getId()) {

            updateProgress(progress);
        }
    }

    @Override
    public void onPause(long id, int progress, long downloadedBytes, long totalBytes) {

    }

    @Override
    public void onCancelled(long id, int progress, long downloadedBytes, long totalBytes) {

    }

    @Override
    public void onRemoved(long id, int progress, long downloadedBytes, long totalBytes) {

    }
}