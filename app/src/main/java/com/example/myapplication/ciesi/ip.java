package com.example.myapplication.ciesi;


import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
public class ip {


    public static void main(String args) {

     System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n"+args);
    }

    private int getPhoneBattery(Context context) {
        int level = 0;
        Intent batteryInfoIntent = context.getApplicationContext().registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        level = batteryInfoIntent.getIntExtra("level", 0);
        int batterySum = batteryInfoIntent.getIntExtra("scale", 100);
        return 100 * level / batterySum;
    }


    //——————————————————————
    public String get(String url)
    {
        StringBuffer buffer = new StringBuffer();
        InputStreamReader isr = null;
        try
        {
            URL urlObj = new URL(url);
            URLConnection uc = urlObj.openConnection();
            uc.setConnectTimeout(10000);
            uc.setReadTimeout(10000);
            isr = new InputStreamReader(uc.getInputStream(), "utf-8");
            BufferedReader reader = new BufferedReader(isr); //缓冲
            String line;
            while ((line = reader.readLine()) != null)
            {
                buffer.append(line + "\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (null != isr)
                {
                    isr.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        if (buffer.length() == 0) return buffer.toString();
        buffer.delete(buffer.length() - 1, buffer.length());
        return buffer.toString();
    }
    public static String formatSize(float size)
    {
        String suffix = null;
        if (size >= 1024)
        {
            suffix = "KB";
            size /= 1024;
            if (size >= 1024)
            {
                suffix = "MB";
                size /= 1024;
            }
            if (size >= 1024)
            {
                suffix = "GB";
                size /= 1024;
            }
        }
        DecimalFormat format=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p=format.format(size);
        StringBuilder resultBuffer = new StringBuilder(p);
        if(suffix != null)
            resultBuffer.append(suffix);
        return resultBuffer.toString();
    }
    long time=System.currentTimeMillis();
    /**
     * @LXH 获取设备的SN序列号
     * @return SN序列号
     */
    /**
     * @LXH 判断ping一个xx地址是否能ping通
     * @param ip
     * @return boolean
     */
    public boolean is_PingIP(String ip) {
        boolean pingIP = false;
        try {//-c 1是指ping的次数为1次，-w 3是指超时时间为3s
            Process process = Runtime.getRuntime().exec("ping -c 1 -w 3 " + "101.43.22.111");
            int status = process.waitFor();
            if (status == 0) {//status为0表示ping成功
                pingIP=true;
                Log.i("LXH","ping "+"101.43.22.111 " +" 是否成功:"+pingIP);
                return pingIP;
            }
        }catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        Log.i("LXH","ping "+"101.43.22.111 " +" 是否成功:"+pingIP);
        return pingIP;
    }

    /**
     * @LXH 获取wlan的MAC地址
     * @return wlan0的mac地址
     */
    public String get_wlan_MAC() {
        String wlan_MAC="";
        List<NetworkInterface> interfaces = null;
        try {
            interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface networkInterface : interfaces) {
                if (networkInterface != null && TextUtils.isEmpty(networkInterface.getName()) == false) {
                    if ("wlan0".equalsIgnoreCase(networkInterface.getName())) {
                        byte[] macBytes = networkInterface.getHardwareAddress();
                        if (macBytes != null && macBytes.length > 0) {
                            StringBuilder str = new StringBuilder();
                            for (byte b : macBytes) {
                                str.append(String.format("%02X:", b));
                            }
                            if (str.length() > 0) {
                                str.deleteCharAt(str.length() - 1);
                            }
                            wlan_MAC=str.toString();
                            Log.i("LXH","设备wlan的MAC地址:"+wlan_MAC);
                            return wlan_MAC;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return wlan_MAC;
    }

    /**
     * @LXH 获取设备wlan的IP地址
     * @return wlan的IP地址
     */
    public String get_wlan_IP() {
        String wlan_IP="";
        List<NetworkInterface> interfaces = null;
        try {
            interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface networkInterface : interfaces) {
                if (networkInterface != null && TextUtils.isEmpty(networkInterface.getName()) == false) {
                    if ("wlan0".equalsIgnoreCase(networkInterface.getName())) {
                        Enumeration<InetAddress> enumIpAddr = networkInterface.getInetAddresses();
                        while (enumIpAddr.hasMoreElements()) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                wlan_IP=inetAddress.getHostAddress();
                                Log.i("LXH","设备wlan的IP地址:"+wlan_IP);
                                return wlan_IP;
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return wlan_IP;
    }

    /**
     * @LXH 获取设备以太网的IP地址
     * @return 以太网的IP地址
     */
    public String get_ethernet_IP() {
        String ethernet_IP = null;
        try {
            Enumeration nis = NetworkInterface.getNetworkInterfaces();
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    InetAddress ia = ias.nextElement();
                    if (ia instanceof Inet6Address) {
                        continue;
                    }
                    String hostAddress = ia.getHostAddress();
                    if (!"127.0.0.1".equals(hostAddress)) {
                        ethernet_IP = hostAddress;
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        Log.i("LXH","设备以太网的IP地址:"+ethernet_IP);
        return ethernet_IP;
    }

    /**
     * @LXH 获取设备的MAC地址
     * MAC地址=局域网地址=MAC位址=以太网地址=或物理地址
     * @return MAC地址
     */
    public String get_MAC() {
        String ethernet_mac = null;
        BufferedReader bufferedReader_mac = null;
        FileReader fileReader_mac = null;
        try {
            fileReader_mac = new FileReader("sys/class/net/eth0/address");
            bufferedReader_mac = new BufferedReader(fileReader_mac);
            ethernet_mac = bufferedReader_mac.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader_mac != null)
                    bufferedReader_mac.close();
                if (fileReader_mac != null)
                    fileReader_mac.close();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("LXH", "读取设备MAC地址异常：" + e.toString());
            }
        }
        Log.i("LXH","设备的MAC地址:"+ethernet_mac);
        return ethernet_mac;
    }

    public static String getIpAddressString() {
        try {
            for (Enumeration<NetworkInterface> enNetI = NetworkInterface
                    .getNetworkInterfaces(); enNetI.hasMoreElements(); ) {
                NetworkInterface netI = enNetI.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = netI
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "0.0.0.0";
    }


    /*
     *获取Mac地址
     *
     * android 7.0 以上使用*/

    public static String getMacAddress() {
        String strMacAddr = null;
        try {
            // 获得IpD地址
            InetAddress ip = getLocalInetAddress();
            byte[] b = NetworkInterface.getByInetAddress(ip)
                    .getHardwareAddress();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                if (i != 0) {
                    buffer.append(':');
                }
                String str = Integer.toHexString(b[i] & 0xFF);
                buffer.append(str.length() == 1 ? 0 + str : str);
            }
            strMacAddr = buffer.toString().toUpperCase();
        } catch (Exception e) {
        }
        return strMacAddr;
    }

    /**
     * 获取移动设备本地IP
     *
     * @return
     */




    private static InetAddress getLocalInetAddress() {
        InetAddress ip = null;
        try {
            // 列举
            Enumeration<NetworkInterface> en_netInterface = NetworkInterface
                    .getNetworkInterfaces();
            while (en_netInterface.hasMoreElements()) {// 是否还有元素
                NetworkInterface ni = (NetworkInterface) en_netInterface
                        .nextElement();// 得到下一个元素
                Enumeration<InetAddress> en_ip = ni.getInetAddresses();// 得到一个ip地址的列举
                while (en_ip.hasMoreElements()) {
                    ip = en_ip.nextElement();
                    if (!ip.isLoopbackAddress()
                            && ip.getHostAddress().indexOf(":") == -1)
                        break;
                    else
                        ip = null;
                }

                if (ip != null) {
                    break;
                }
            }
        } catch (SocketException e) {

            e.printStackTrace();
        }
        return ip;
    }
}




