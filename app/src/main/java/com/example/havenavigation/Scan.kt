//package com.example.havenavigation
//
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.google.zxing.integration.android.IntentIntegrator
//
//
//class Scan : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_dashboard)
//
////        new IntentIntegrator(this).initiateScan();
//        val btnScan: Button = findViewById<View>(R.id.button) as Button
//        btnScan.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                val integrator = IntentIntegrator(this@Scan)
//                // 设置要扫描的条码类型，ONE_D_CODE_TYPES：一维码，QR_CODE_TYPES-二维码
//                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
//                integrator.captureActivity = ScanActivity::class.java
//                integrator.setPrompt("请扫描") //底部的提示文字，设为""可以置空
//
//                integrator.setCameraId(0) //前置或者后置摄像头
//
//                integrator.setBeepEnabled(false) //扫描成功的「哔哔」声，默认开启
//
//                integrator.setBarcodeImageEnabled(true)
//                integrator.initiateScan()
//            }
//        })
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
//        if (result != null) {
//            if (result.contents == null) {
//                Toast.makeText(this, "扫码取消！", Toast.LENGTH_LONG).show()
//            } else {
//                Toast.makeText(this, "扫描成功，条码值: " + result.contents, Toast.LENGTH_LONG).show()
//                val results: TextView = findViewById<View>(R.id.textView) as TextView
//                results.text = result.contents
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }
//}