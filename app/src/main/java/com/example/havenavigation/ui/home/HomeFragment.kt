package com.example.havenavigation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.havenavigation.R
import com.example.havenavigation.ScanActivity
import com.example.havenavigation.databinding.FragmentHomeBinding
import com.google.zxing.integration.android.IntentIntegrator


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val root: View = binding.root



//        inflater.inflate(R.layout.express_information,container,false)



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = activity?.findViewById<View>(R.id.express_1)

        view?.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                activity,
                "点击了返回按钮",
                Toast.LENGTH_SHORT
            ).show()
        })



//        view?.setOnClickListener {
//            val integrator = IntentIntegrator.forSupportFragment(this@HomeFragment)
//            // 设置要扫描的条码类型，ONE_D_CODE_TYPES：一维码，QR_CODE_TYPES-二维码
//            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
//            integrator.captureActivity = ScanActivity::class.java
//            integrator.setPrompt("将二维码放到框内即可") //底部的提示文字，设为""可以置空
//
//            integrator.setCameraId(0) //前置或者后置摄像头
//
//            integrator.setBeepEnabled(true) //扫描成功的「哔哔」声，默认开启
//
//            integrator.setBarcodeImageEnabled(true)
//            integrator.initiateScan()
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(activity, "扫码取消！", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "扫描成功，条码值: " + result.contents, Toast.LENGTH_LONG).show()
//                val results: TextView = view?.findViewById<View>(R.id.textView) as TextView
//                results.text = result.contents
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}