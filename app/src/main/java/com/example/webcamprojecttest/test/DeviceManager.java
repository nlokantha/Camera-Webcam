
package com.example.webcamprojecttest.test;

public class DeviceManager{

	private static DeviceManager mInstance;
	private DeviceManager(){
	}

	public static DeviceManager getInstance(){
		if(mInstance == null){
			mInstance = new DeviceManager();
		}
		return mInstance;
	}
	// --------------c352----------------------------------
	
	public boolean setInfraredBrightness(int brightness) {
		try{
			 return LovUtility.getService().setInfraredBrightness(brightness);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
/*	
	public boolean switchMic1(boolean isEnable) {
		try{
			 return LovUtility.getService().switchMic(isEnable);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
*/
	
	public int getInfraredBrightness() {
		try{
			 return LovUtility.getService().getInfraredBrightness();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	
	public boolean setIRCutEnabled(boolean isEnabled) {
		try{
			return  LovUtility.getService().setIRCutEnabled(isEnabled);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public int getIRCutEnabled() {
		try{
			 return LovUtility.getService().getIRCutEnabled();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	
	public boolean setCameraMode(int mode) {
		try{
			return  LovUtility.getService().setCameraMode(mode);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public int getCameraMode() {
		try{
			 return LovUtility.getService().getCameraMode();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	
	public boolean switchMic(boolean mode) {
		try{
			return  LovUtility.getService().switchMic(mode);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
/*	public int getMicState() {
		try{
			 return LovUtility.getService().getMicState();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}*/

	
	public boolean setMic2Enable(boolean mode) {
		/*try{
			return  LovUtility.getService().setMic2Enable(mode);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}*/
		return false;
	}

	
	public int getMic2Enable() {
		/*try{
			 return LovUtility.getService().getMic2Enable();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}*/
		return 0;
	}

	
	public boolean setMic3Enable(boolean mode) {
		/*try{
			return  LovUtility.getService().setMic3Enable(mode);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}*/
		return false;
	}

	
	public int getMic3Enable() {
		/*try{
			 return LovUtility.getService().getMic3Enable();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}*/
		return 0;
	}

	
	public boolean setSystemUIPanelDragDownEnable(boolean isEnabled) {
		try{
			return  LovUtility.getService().setSystemUIPanelDragDownEnable(isEnabled);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean isSystemUIPanelDragDownEnable() {
		try{
			 return LovUtility.getService().isSystemUIPanelDragDownEnable();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean lockDevice() {
		try{
			 return LovUtility.getService().lockDevice();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean unlockDevice() {
		try{
			return LovUtility.getService().unlockDevice();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public void shutdown(boolean reboot) {
		try{
			 LovUtility.getService().shutdown(reboot);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public void goToSleep() {
		try{
			 LovUtility.getService().goToSleep();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public void wakeUp() {
		try{
			 LovUtility.getService().wakeUp();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
	public void resetDevice() {
		try{
			 LovUtility.getService().resetDevice();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public void destroyDevice() {
		try{
			 LovUtility.getService().destroyDevice();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public boolean setBluetoothEnabled(boolean isEnabled) {
		try{
			return  LovUtility.getService().setBluetoothEnabled(isEnabled);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean getBluetoothEnabled() {
		try{
			 return LovUtility.getService().getBluetoothEnabled();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean setWifiEnabled(boolean isEnabled) {
		try{
			return  LovUtility.getService().setWifiEnabled(isEnabled);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean getWifiEnabled() {
		try{
			 return LovUtility.getService().getWifiEnabled();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean setGPSEnabled(boolean isEnabled) {
		try{
			return  LovUtility.getService().setGPSEnabled(isEnabled);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean getGPSEnabled() {
		try{
			 return LovUtility.getService().getGPSEnabled();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean setNFCEnabled(boolean isEnabled) {
		try{
			return  LovUtility.getService().setNFCEnabled(isEnabled);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public int getNFCEnabled() {
		try{
			 return LovUtility.getService().getNFCEnabled();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	
	public boolean setAirplaneModeOn(boolean enabling) {
		try{
			return  LovUtility.getService().setAirplaneModeOn(enabling);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean getAirplaneModeOn() {
		try{
			 return LovUtility.getService().getAirplaneModeOn();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean setCameraEnabled(boolean isEnabled) {
		try{
			return  LovUtility.getService().setCameraEnabled(isEnabled);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean getCameraEnabled() {
		try{
			 return LovUtility.getService().getCameraEnabled();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean setLaserLightEnabled(boolean isEnabled) {
		try{
			return  LovUtility.getService().setLaserLightEnabled(isEnabled);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean getLaserLightEnabled() {
		try{
			 return LovUtility.getService().getLaserLightEnabled();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean setWarningLightEnabled(boolean isEnabled) {
		try{
			return LovUtility.getService().setWarningLightEnabled(isEnabled);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public int getWarningLightEnabled() {
		try{
			 return LovUtility.getService().getWarningLightEnabled();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	
	public void setSystemLedEnabled(boolean isEnabled) {
		try{
			 LovUtility.getService().setSystemLedEnabled(isEnabled);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public boolean setLedColor(int color, boolean blink) {
		try{
			 LovUtility.getService().setLedColor(color,blink);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public void setFlash(int color, int onMs, int offMs) {
		try{
			  LovUtility.getService().setFlash(color,onMs,offMs);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public boolean enableAdb(boolean enable) {
		try{
			return LovUtility.getService().enableAdb(enable);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean getAdbEnable() {
		try{
			return LovUtility.getService().getAdbEnable();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean openOrCloseUMS(boolean enable) {
		try{
			return  LovUtility.getService().openOrCloseUMS(enable);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean getAdbOpened() {
		try{
			return LovUtility.getService().getAdbOpened();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean openOrCloseAdb(boolean enable) {
		try{
			return  LovUtility.getService().openOrCloseAdb(enable);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean getAdbConfirmSkiped() {
		try{
			 return LovUtility.getService().getAdbConfirmSkiped();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public void skipAdbConfirm(boolean skip) {
		try{
			 LovUtility.getService().skipAdbConfirm(skip);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public boolean getUMOpened() {
		try{
			return  LovUtility.getService().getUMOpened();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean openOrCloseMtp(boolean enable) {
		try{
			return LovUtility.getService().openOrCloseMtp(enable);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean getMTPOpened() {
		try{
			return LovUtility.getService().getMTPOpened();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	public long getBootTime() {
		try{
			 return LovUtility.getService().getBootTime();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0L;
	}

	
	public void setTime(long millis) {
		try{
			 LovUtility.getService().setTime(millis);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	public boolean getExternalCameraIn(){
		try{
			return LovUtility.getService().getExternalCameraIn();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean skipExteranlCameraConfirm(boolean skip) {
		try{
			return LovUtility.getService().skipExteranlCameraConfirm(skip);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean setChargeNotLimit(boolean notlimit) {
		try{
			return LovUtility.getService().setChargeNotLimit(notlimit);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	//G-sensor X,Y,Z ??? 
	
	
	public boolean setGsensorSensitivity(int sensitivity){
		try{
			return LovUtility.getService().setGsensorSensitivity(sensitivity);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	//G-sensor中断上报键值 ???
	
	
	
	public int getGsensorSensitivity(){
		try{
			return LovUtility.getService().getGsensorSensitivity();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	
	//L-sensor中断上报键值???
	
	
	public int getLightValue(){
		try{
			return LovUtility.getService().getLightValue();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean setShakeEnable(boolean enable){
		try{
			return LovUtility.getService().setShakeEnable(enable);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	

	public boolean getCDROMOpened(){
		try{
			return LovUtility.getService().getCDROMOpened();
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean openOrCloseCDROM(boolean enable){
		try{
			return LovUtility.getService().openOrCloseCDROM(enable);
		}catch(SecurityException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}


}
