package com.example.webcamprojecttest.test;/*
package com.hexinban.test;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends Activity {

	
	private String data[] = {    
			"0.设置红外灯亮度值",
			"1.获取红外灯亮度值", 
			"2.打开或关闭IR-CUT", 
			"3.获取IR-CUT状态", 
			"4.设置camera模式", 
			"5.获取camera模式", 
			"6.打开/关闭主硅麦", 
			"7.获取主硅麦状态",
			"8.打开/关闭副硅麦", 
			"9.获取副麦状态", 
			"10.打开/关闭柱状麦", 
			"11.获取柱状麦状态",
			"12.设置通知栏是否可下拉操作", 
			"13.锁定屏幕", 
			"14.设备不锁定屏幕", 
			"15.关机或重启",
			"16.设备休眠",
			"17.休眠唤醒",
			"18.重置设备", 
			"19.自毁设备", 
			"20.开/关蓝牙", 
			"21.获取蓝牙状态",
			"22.开/关wifi", 
			"23.判断是否已打开wifi", 
			"24.开/关GPS", 
			"25.判断是否已打开GPS",
			"26.开/关NFC",
			"27.判断是否已打开NFC",
			"28.打开/关闭飞行模式", 
			"29.判断是否已打开飞行模式", 
			"30.启用或禁用Camera", 
			"31.获取canera的禁用状态", 
			"32.打开/关闭激光灯",
			"33.获取激光灯状态",
			"34.打开/关闭红蓝警示灯",
			"35.获取警示灯状态", 
			"36.设置是否由系统控制led灯", 
			"37.LED灯（指示灯）控制", 
			"38.设置指示灯闪烁",
			"39.判断adb调试是否启用/停用", 
			"40.启用/停用adb调试", 
			"41.判断是否打开adb", 
			"42.打开/关闭adb",
			"43.判断（在设备连接电脑时）是否跳过“允许USB调试吗？”的提示框",
			"44.用于配置是否跳过 允许USB调试吗? 的提示框",
			"45.判断是否打开U盘传输模式",
			"46.打开/关闭U盘传输模式",
			"47.判断是否打开MTP传输模式",
			"48.打开/关闭MTP传输模式",
			"49.判断是否打开光盘模式",
			"50.打开/关闭光盘模式",
			"51.获取开机时间",
			"52.修改（同步）设备时间",
			"53.判断是否接入外置摄像头",
			"54.判断在接入外置摄像头时是否跳过“允许外置摄像头接入”的提示框",
			"55.设置是否USB限制充电电流",
			"56.G-sensor X,Y,Z值",
			"57.G-sensor灵敏度设置",
			"58.G-sensor获取当前灵敏度值",
			"59.G-sensor中断上报键值",
			"60.L-sensor获取光感值",
			"61.L-sensor中断上报键值",
			"62.打开/关闭震动"};

	ListView listView;
	TextView tvShow ;
	EditText ed_value;
	CheckBox cb_switch;
	private int[] colors = {
			0xffff0000,
			0xff00ff00,
			0xff0000ff,
			0x00000000
		};
	
	final int RED_LIGHT=0x11;
	final int BLUE_LIGHT=0x12;
	final int GREEN_LIGHT=0x13;
	final int CLOSE_LIGHT=0x14;
	
	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {

			switch (msg.what) {
			case RED_LIGHT:
				DeviceManager.getInstance().setLedColor(colors[0],false);
				sendEmptyMessageDelayed(BLUE_LIGHT,1500);
				break;
			case BLUE_LIGHT:
				DeviceManager.getInstance().setLedColor(colors[1],false);
				mHandler.sendEmptyMessageDelayed(GREEN_LIGHT,1500);
				break;
			case GREEN_LIGHT:
				DeviceManager.getInstance().setLedColor(colors[2],false);
				mHandler.sendEmptyMessageDelayed(CLOSE_LIGHT,1500);
				break;
			case CLOSE_LIGHT:
				DeviceManager.getInstance().setLedColor(colors[3],false);
				break;

			default:
				break;
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		listView = (ListView) findViewById(R.id.list);
		tvShow = (TextView) findViewById(R.id.tv_show);
		ed_value = (EditText) findViewById(R.id.ed_value);
		cb_switch = (CheckBox) findViewById(R.id.cb_switch);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data);
		listView.setAdapter(adapter);
		clickEvent();
	}
	
	private int getValue(){
		try {
			return Integer.valueOf(ed_value.getText().toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	private boolean getSwitchState(){
		return cb_switch.isChecked();
	}

	
	private void showMessage(String msg){
		if(tvShow!=null)
			tvShow.setText(msg);
	}
	
	private void showMessage(boolean isSuccess,String msg){
		String msg2 = "尝试"+ ((getSwitchState()?"打开":"关闭")+msg+(isSuccess?"成功!":"失败!"));
		if(tvShow!=null)
			tvShow.setText(msg2);
	}
	
	private void clickEvent(){
	    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                    	DeviceManager.getInstance().setInfraredBrightness(getValue());
                        break;
                    case 1:
                        int value = DeviceManager.getInstance().getInfraredBrightness();
                        showMessage("当前红外灯的亮度为 : " + value);
                        break;
                    case 2:
                    	boolean isSuccess = DeviceManager.getInstance().setIRCutEnabled(getSwitchState());
                    	showMessage(isSuccess,"IR-CUT");
                        break;
                    case 3:
                    	int state = DeviceManager.getInstance().getIRCutEnabled();
                    	 showMessage("当前IR-CUT的状态是 : " + state);
                        break;
                    case 4:
                    	isSuccess = DeviceManager.getInstance().setCameraMode(getSwitchState()?1:0);
                    	showMessage("尝试设置camera模式为"+(getSwitchState()?"彩色":"黑白")+(isSuccess?"成功":"失败"));
                        break;
                    case 5:
                    	 state = DeviceManager.getInstance().getCameraMode();
                    	 showMessage("camera当前模式为 : "+(state==1?"彩色":"黑白"));
                        break;
 
                    case 6:
                    	isSuccess = DeviceManager.getInstance().switchMic(getSwitchState());
                    	showMessage(isSuccess,"主硅MIC");
                        break;
 
                    case 7:
                    	// state = DeviceManager.getInstance().getMicState();
                    	 //showMessage("主硅MIC的状态为 : "+(state==1?"打开":"关闭"));
                        break;
 
                    case 8:
                    	isSuccess = DeviceManager.getInstance().setMic2Enable(getSwitchState());
                    	showMessage(isSuccess,"主硅MIC");
                        break;
 
                    case 9:
                    	state = DeviceManager.getInstance().getMic2Enable();
                   	   showMessage("副硅MIC的状态为 : "+(state==1?"打开":"关闭"));
                        break;
                    case 10:
                    	isSuccess = DeviceManager.getInstance().setMic3Enable(getSwitchState());
                    	showMessage(isSuccess,"柱状MIC");
                        break;
 
                    case 11:
                    	state = DeviceManager.getInstance().getMic3Enable();
                    	 showMessage("柱状MIC的状态为 : "+(state==1?"打开":"关闭"));
                        break;
 
                    case 12:
                    	 DeviceManager.getInstance().setSystemUIPanelDragDownEnable(getSwitchState());
                    	 showMessage((getSwitchState()?"已经可以下拉  ":"已经禁止下拉  ")+"请检查状态");
                        break;
 
                    case 13:
                    	isSuccess = DeviceManager.getInstance().lockDevice();
                    	showMessage(isSuccess,"设备锁定屏幕");
                        break;
 
                    case 14:
                    	isSuccess = DeviceManager.getInstance().unlockDevice();
                    	showMessage(isSuccess,"设备不锁定屏幕");
                        break;
                    case 15:
                    	DeviceManager.getInstance().shutdown(getSwitchState());
                        break;
 
                    case 16:
                    	DeviceManager.getInstance().goToSleep();
                        break;
                    case 17:
                    	DeviceManager.getInstance().wakeUp();
                        break;
                        
                    case 18:
                    	DeviceManager.getInstance().resetDevice();
                        break;
 
                    case 19:
                    	DeviceManager.getInstance().destroyDevice();
                    	showMessage("暂不支持此功能!");
                        break;
                        
                    case 20:
                    	isSuccess = DeviceManager.getInstance().setBluetoothEnabled(getSwitchState());
                    	showMessage(isSuccess,"蓝牙");
                        break;
 
                    case 21:
                    	isSuccess = DeviceManager.getInstance().getBluetoothEnabled();
                    	showMessage("蓝牙当前的状态为: "+(isSuccess?"打开":"关闭"));
                        break;
 
                    case 22:
                    	isSuccess =DeviceManager.getInstance().setWifiEnabled(getSwitchState());
                    	showMessage(isSuccess,"wifi");
                        break;
 
                    case 23:
                    	isSuccess = DeviceManager.getInstance().getWifiEnabled();
                    	showMessage("wifi当前的状态为: "+(isSuccess?"打开":"关闭"));
                        break;
 
                    case 24:
                    	isSuccess =DeviceManager.getInstance().setGPSEnabled(getSwitchState());
                    	showMessage(isSuccess,"gps");
                        break;
                    case 25:
                    	isSuccess =DeviceManager.getInstance().getGPSEnabled();
                    	showMessage("gps当前的状态为: "+(isSuccess?"打开":"关闭"));
                        break;
 
                    case 26:
                    	isSuccess =DeviceManager.getInstance().setNFCEnabled(getSwitchState());
                    	showMessage(isSuccess,"nfc");
                        break;
 
                    case 27:
                    	state =DeviceManager.getInstance().getNFCEnabled();
                    	showMessage("nfc当前的状态为: "+((state==1)?"打开":"关闭"));
                        break;
 
                    case 28:
                    	isSuccess = DeviceManager.getInstance().setAirplaneModeOn(getSwitchState());
                    	showMessage(isSuccess,"飞行模式");
                        break;
 
                    case 29:
                    	isSuccess = DeviceManager.getInstance().getAirplaneModeOn();
                    	showMessage("飞行模式当前的状态为: "+(isSuccess?"打开":"关闭"));
                        break;
                    case 30:
                    	DeviceManager.getInstance().setCameraEnabled(getSwitchState());
                        break;
 
                    case 31:
                    	DeviceManager.getInstance().getCameraEnabled();
                        break;
 
                    case 32:
                    	isSuccess =DeviceManager.getInstance().setLaserLightEnabled(getSwitchState());
                    	showMessage(isSuccess,"激光灯");
                        break;
 
                    case 33:
                    	isSuccess =DeviceManager.getInstance().getLaserLightEnabled();
                    	showMessage("激光灯当前的状态为: "+(isSuccess?"打开":"关闭"));
                        break;
 
                    case 34:
                    	isSuccess =DeviceManager.getInstance().setWarningLightEnabled(getSwitchState());
                    	showMessage(isSuccess,"警灯");
                        break;
                    case 35:
                    	state =DeviceManager.getInstance().getWarningLightEnabled();
                    	showMessage("警灯当前的状态为: "+((state==1)?"打开":"关闭"));
                        break;
 
                    case 36:
                    	DeviceManager.getInstance().setSystemLedEnabled(getSwitchState());
                    	showMessage("请检测系统"+(getSwitchState()?"是否可以控制led灯":"是否已经无法控制led灯"));
                        break;
 
                    case 37:
                    	Toast.makeText(Test.this, "请等三种灯都亮完!", Toast.LENGTH_SHORT).show();
                    	mHandler.sendEmptyMessageDelayed(RED_LIGHT,1000);
                        break;
 
                    case 38:
                    	//DeviceManager.getInstance().setFlash(color,onMs,offMs);
                        break;
 
                    case 39:
                    	isSuccess =DeviceManager.getInstance().getAdbEnable();
                    	showMessage("当前adb的状态为 : "+(isSuccess?"启用!":"停用!"));
                        break;
                    case 40:
                    	isSuccess =DeviceManager.getInstance().enableAdb(getSwitchState());
                    	showMessage("尝试"+(getSwitchState()?"启用":"停用")+"adb"+(isSuccess?"成功":"失败"));
                        break;

                    case 41:
                    	isSuccess =DeviceManager.getInstance().getAdbOpened();
                    	showMessage("当前adb的状态是--->"+(isSuccess?"打开":"关闭"));
                        break;
 
                    case 42:
                    	isSuccess =DeviceManager.getInstance().openOrCloseAdb(getSwitchState());
                    	showMessage(isSuccess,"adb");
                        break;
 
                    case 43:
                    	isSuccess =DeviceManager.getInstance().getAdbConfirmSkiped();
                        break;
 
                    case 44:
                    	DeviceManager.getInstance().skipAdbConfirm(getSwitchState());
                        break;
                    case 45:
                    	isSuccess =DeviceManager.getInstance().getUMOpened();
                        break;
 
                    case 46:
                    	isSuccess =DeviceManager.getInstance().openOrCloseUMS(getSwitchState());
                        break;
 
                    case 47:
                    	isSuccess =DeviceManager.getInstance().getMTPOpened();
                    	showMessage("当前mtp的状态是--->"+(isSuccess?"打开":"关闭"));
                        break;
 
                    case 48:
                    	isSuccess =DeviceManager.getInstance().openOrCloseMtp(getSwitchState());
                    	showMessage(isSuccess,"mtp");
                        break;
 
                    case 49:
                    	isSuccess =DeviceManager.getInstance().getCDROMOpened();
                    	showMessage("暂不支持此功能!");
                        break;
                    case 50:
                    	isSuccess =DeviceManager.getInstance().openOrCloseCDROM(getSwitchState());
                    	showMessage("暂不支持此功能!");
                        break;
 
                    case 51:
                    	long time = DeviceManager.getInstance().getBootTime();
                    	showMessage("当前的时间是 : " + time);
                        break;
 
                    case 52:
                    	long time2 = DeviceManager.getInstance().getBootTime();
                    	DeviceManager.getInstance().setTime(time2+100000);
                    	showMessage("请查看系统时间是否变化 : ");
                        break;
 
                    case 53:
                    	isSuccess =DeviceManager.getInstance().getExternalCameraIn();
                        break;
 
                    case 54:
                    	isSuccess =DeviceManager.getInstance().skipExteranlCameraConfirm(getSwitchState());
                        break;
                    case 55:
                    	isSuccess =DeviceManager.getInstance().setChargeNotLimit(getSwitchState());
                        break;
 
                    case 56:
                    	//?????
                        break;
 
                    case 57:
                    	isSuccess =DeviceManager.getInstance().setGsensorSensitivity(0);
                        break;
 
                    case 58:
                    	DeviceManager.getInstance().getGsensorSensitivity();
                        break;
 
                    case 59:
                    	//????
                        break;
                    case 60:
                    	DeviceManager.getInstance().getLightValue();
                        break;

 
                    case 61:
                    	//????
                        break;
 
                    case 62:
                    	isSuccess =DeviceManager.getInstance().setShakeEnable(getSwitchState());
                        break;
 
                    case 63:
    
                        break;
 
 
                  
                }
            }
        });
	}

}
*/
