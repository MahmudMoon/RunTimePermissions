package com.example.moon.runtimepermissions;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void allPermissions(View view) {

    }

    public void cameraPermissions(View view) {
           if(ContextCompat.checkSelfPermission(getApplicationContext(),
                   Manifest.permission.CAMERA )!= PackageManager.PERMISSION_GRANTED){

               if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.CAMERA)){
                   final AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                   builder.setTitle("Request for Camera")
                           .setMessage("This app need camera permission to work properly")
                           .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {
                                   ActivityCompat.requestPermissions(getParent(),new String[]{
                                           Manifest.permission.CAMERA
                                   },100);
                               }
                           })
                   .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           dialog.dismiss();
                       }
                   });
                   
                   AlertDialog alertDialog = builder.create();
                   alertDialog.show();
               }

//               ActivityCompat.requestPermissions(getParent(),new String[]{
//                       Manifest.permission.CAMERA
//               },100);
           }else{
               Toast.makeText(getApplicationContext(),"Permission granted",Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(MainActivity.this,PermissionResults.class);
               startActivity(intent);
           }
    }

    public void storagePermission(View view) {

    }

    public void contactPermission(View view) {

    }
}
