package ru.litvinov.javapool.utils;

import java.io.IOException;
import java.net.InetAddress;

public class Ping {
    public static boolean ping(String ip){
        try{
            InetAddress address = InetAddress.getByName(ip);
            boolean reachable = address.isReachable(10000);
            System.out.println("ip " + ip + " is reachable");
            return true;
        } catch (Exception e){
            System.out.println("ip " + ip + " is not reachable");
            return false;
        }
    }

    private boolean executeCommand(){
        System.out.println("executeCommand");
        Runtime runtime = Runtime.getRuntime();
        try
        {
            Process  mIpAddrProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int mExitValue = mIpAddrProcess.waitFor();
            System.out.println(" mExitValue "+mExitValue);
            if(mExitValue==0){
                return true;
            }else{
                return false;
            }
        }
        catch (InterruptedException ignore)
        {
            ignore.printStackTrace();
            System.out.println(" Exception:"+ignore);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println(" Exception:"+e);
        }
        return false;
    }
}
