package com.example.havenavigation.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.havenavigation.R
import com.example.havenavigation.ui.dashboard.DashboardFragment
import com.google.android.material.internal.ContextUtils.getActivity


@SuppressLint("RestrictedApi", "CutPasteId")
class ExpressInFormationView(context: Context, attrs: AttributeSet) : Fragment() {
    init {
        LayoutInflater.from(context).inflate(R.layout.express_information, this)
        val btn2: Button = findViewById<View>(R.id.button2) as Button
        btn2.setOnClickListener {
            getActivity(context).getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.navigation_home, DashboardFragment(), null)
                .addToBackStack(null)
                .commit()
        }

    }
//    fun onResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
//        if (result != null) {
//            if (result.contents == null) {
//                Toast.makeText(context, "扫码取消！", Toast.LENGTH_LONG).show()
//            } else {
//                Toast.makeText(context, "扫描成功，条码值: " + result.contents, Toast.LENGTH_LONG)
//                    .show()
//                val results: TextView = findViewById<View>(R.id.textView) as TextView
//                results.text = result.contents
//            }
//        } else {
////                    super.onResult(requestCode, resultCode, data)
//        }
//    }
}