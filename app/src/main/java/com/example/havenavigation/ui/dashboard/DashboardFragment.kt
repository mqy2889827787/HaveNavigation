package com.example.havenavigation.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.havenavigation.R
import com.example.havenavigation.ScanActivity
import com.example.havenavigation.databinding.FragmentDashboardBinding
import com.google.zxing.integration.android.IntentIntegrator


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val btnScan: ImageButton = activity?.findViewById<View>(R.id.imageButton) as ImageButton
        btnScan.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val integrator = IntentIntegrator.forSupportFragment(this@DashboardFragment)
                // 设置要扫描的条码类型，ONE_D_CODE_TYPES：一维码，QR_CODE_TYPES-二维码
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
                integrator.captureActivity = ScanActivity::class.java
                integrator.setPrompt("将二维码放到框内即可") //底部的提示文字，设为""可以置空

                integrator.setCameraId(0) //前置或者后置摄像头

                integrator.setBeepEnabled(true) //扫描成功的「哔哔」声，默认开启

                integrator.setBarcodeImageEnabled(true)
                integrator.initiateScan()

            }
        })
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