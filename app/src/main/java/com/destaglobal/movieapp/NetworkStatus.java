package com.destaglobal.movieapp;

/**
 * Created by Harshada Chavan on 12/24/2017.
 */
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkStatus
{
    //Creating instance of this class and context.
    private static NetworkStatus instance=new NetworkStatus();
    static Context context;
    ConnectivityManager connectivityManager;
    boolean connected = false;

    //Method to get instance of this class.
    public static NetworkStatus getInstance(Context ctx)
    {
        context=ctx;
        return instance;
    }

    //Method to get whether system is Online or not.
    public boolean isOnline(Context con)
    {
        try
        {
            connectivityManager=(ConnectivityManager)con.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            connected = networkInfo!=null && networkInfo.isAvailable() && networkInfo.isConnected();
            return connected;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(con,"Check Network Connection its unavailable"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return connected;
    }

    //Method to get whether system is connected to internet or not.
    public boolean isConnectedToInternet()
    {
        connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null)
            return true;
        else
            return false;
    }
}

