package com.example.kotlinapplication.util

import android.content.Context
import android.net.ConnectivityManager
import java.security.AccessControlContext

class NetWorkConection {

    companion object{
       fun isNEtworkConnected(context: Context) : Boolean{
           var connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
           val activeNetworkInfo = connectionManager.activeNetworkInfo

           return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
       }
    }
}