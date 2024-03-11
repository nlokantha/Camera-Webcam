package com.example.webcamprojecttest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.webcamprojecttest.databinding.ActivityMainBinding;
import com.example.webcamprojecttest.test.DeviceManager;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    public DeviceManager mDeviceManager;
    private ActivityMainBinding binding;
    private ProcessCameraProvider cameraProvider;
    private CameraSelector currentCameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;

    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    private int currentCameraIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Permissions Camera.....................................
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        cameraProviderFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    cameraProvider = cameraProviderFuture.get();
                    startCameraX(cameraProvider, currentCameraSelector);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, ContextCompat.getMainExecutor(this));

        binding.btnSwitchCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchCamera2();
                Toast.makeText(MainActivity.this, "SwitchCamera", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDeviceManager.setWarningLightEnabled(true);
            }
        });

        mDeviceManager = DeviceManager.getInstance();
    }

    private void switchCamera() {
        if (currentCameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
            currentCameraSelector = cameraProvider.getAvailableCameraInfos().get(1).getCameraSelector();
        } else {
            currentCameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
        }

        startCameraX(cameraProvider, currentCameraSelector);
    }

    private void switchCamera2() {
        List<CameraInfo> cameraInfos = cameraProvider.getAvailableCameraInfos();

        if (cameraInfos.size() > 0) {
            currentCameraIndex = (currentCameraIndex + 1) % cameraInfos.size();
            CameraSelector newCameraSelector = cameraInfos.get(currentCameraIndex).getCameraSelector();
            if (currentCameraIndex==2){
                Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
            }
            startCameraX(cameraProvider, newCameraSelector);
        }
    }


    private void startCameraX(ProcessCameraProvider cameraProvider, CameraSelector cameraSelector) {
        Preview preview = null;
        if (currentCameraIndex == 2){
            preview=new Preview.Builder().build();
            preview.setSurfaceProvider(binding.previewView2.getSurfaceProvider());
        }else {
            preview  = new Preview.Builder().build();
            preview.setSurfaceProvider(binding.previewView.getSurfaceProvider());
        }

        try {
            cameraProvider.unbindAll();
            cameraProvider.bindToLifecycle(this, cameraSelector, preview);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
