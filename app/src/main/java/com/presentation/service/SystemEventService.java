package com.presentation.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.presentation.dataholder.ApplicationDataHolder;
import com.presentation.internal.ComponentHolder;
import com.presentation.network.NetWorkType;
import com.presentation.utils.LogUtils;

import javax.inject.Inject;

public class SystemEventService extends Service {

    @Inject
    ApplicationDataHolder applicationDataHolder;

    @Override
    public void onCreate() {
        super.onCreate();
        ComponentHolder.getApplicationComponent().inject(this);

        initNetWorkMonitor();
    }

    private void initNetWorkMonitor() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        NetworkRequest request = builder.build();
        connectivityManager.registerNetworkCallback(request, networkCallback);
    }


    ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
        @Override
        public void onAvailable(@NonNull Network network) {
            super.onAvailable(network);
            Log.d("TAG", "onAvailable: ");
            applicationDataHolder.netWorkAvailable().postValue(true);
        }

        @Override
        public void onLosing(@NonNull Network network, int maxMsToLive) {
            super.onLosing(network, maxMsToLive);
            applicationDataHolder.netWorkAvailable().postValue(false);
            Log.d("TAG", "onLosing: ");
        }

        @Override
        public void onLost(@NonNull Network network) {
            super.onLost(network);
            Log.d("TAG", "onLost: ");
            applicationDataHolder.netWorkAvailable().postValue(false);
        }

        @Override
        public void onUnavailable() {
            super.onUnavailable();
            Log.d("TAG", "onUnavailable: ");
            applicationDataHolder.netWorkAvailable().postValue(false);
        }

        @Override
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
                if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    applicationDataHolder.netWorkState().setValue(NetWorkType.WIFI);
                    LogUtils.d("onCapabilitiesChanged: 网络类型为wifi");
                } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    applicationDataHolder.netWorkState().setValue(NetWorkType.CELLULAR);
                    LogUtils.d("onCapabilitiesChanged: 蜂窝网络");
                } else {
                    applicationDataHolder.netWorkState().setValue(NetWorkType.OTHER);
                    LogUtils.d("onCapabilitiesChanged: 其他网络");
                }
            }

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

}
