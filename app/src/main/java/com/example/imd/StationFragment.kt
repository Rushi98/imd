package com.example.imd


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class StationFragment : Fragment() {
    val TAG = TAG_PREFIX + StationFragment::class.java.simpleName
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.i(TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment_station, container, false)
    }
}
