// CreService.aidl
package com.example.webcamprojecttest;

// Declare any non-default types here with import statements

interface CreService {
   //c354-----------------------------------------------
   	boolean setInfraredBrightness(int brightness);
   	int getInfraredBrightness();

   	boolean setIRCutEnabled(boolean isEnabled);
   	int getIRCutEnabled();

   	boolean setCameraMode(int mode);
       int getCameraMode();

       boolean switchMic(boolean isEnabled);
       int getMicState();


       boolean setSystemUIPanelDragDownEnable(boolean enable);
   	boolean isSystemUIPanelDragDownEnable();
   	boolean lockDevice();
   	boolean unlockDevice();
   	void shutdown(boolean reboot);
   	void goToSleep();
   	void wakeUp();
   	void resetDevice();
   	void destroyDevice();

   	boolean setBluetoothEnabled(boolean isEnabled);
   	boolean getBluetoothEnabled();

   	boolean setWifiEnabled(boolean isEnabled);
   	boolean getWifiEnabled();

   	boolean setGPSEnabled(boolean isEnabled);
   	boolean getGPSEnabled();

   	boolean setNFCEnabled(boolean getEnabled);
   	int getNFCEnabled();

   	boolean setAirplaneModeOn(boolean enabling);
   	boolean getAirplaneModeOn();

   	boolean setCameraEnabled(boolean isEnabled);
   	boolean getCameraEnabled();


   	boolean setLaserLightEnabled(boolean isEnabled);
   	boolean getLaserLightEnabled();

   	boolean setWarningLightEnabled(boolean getEnabled);
   	int getWarningLightEnabled ();

   	void setSystemLedEnabled(boolean isEnabled);

   	boolean setLedColor(int color,boolean blink);
   	void setFlash(int color,int onMs,int offMs);

   	boolean enableAdb(boolean enable);
       boolean getAdbEnable();
       boolean getAdbOpened();
       boolean openOrCloseAdb(boolean enable);
       boolean getAdbConfirmSkiped();
   	void skipAdbConfirm(boolean skip);

   	boolean getUMOpened();
   	boolean openOrCloseUMS(boolean enable);


   	boolean getCDROMOpened();
   	boolean openOrCloseCDROM(boolean enable);

   	boolean openOrCloseMtp(boolean enable);
   	boolean getMTPOpened();

   	long getBootTime();
   	void setTime(long millis);

       boolean getExternalCameraIn();//new
   	boolean skipExteranlCameraConfirm(boolean skip);
   	boolean setChargeNotLimit(boolean notlimit);

   	boolean setGsensorSensitivity(int sensitivity);//new

   	int getGsensorSensitivity();//new

   	int getLightValue(); //new
   	boolean setShakeEnable(boolean enable);//new


   	boolean justCloseBacklightWhenSleep(boolean close);
   	boolean isJustCloseBacklightWhenSleep();

   	boolean startScreenOffVideoMode(boolean start);
   	boolean isScreenOffVideoMode();




   //c354-----------------------------------------------
}