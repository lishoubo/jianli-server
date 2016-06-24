package com.jl.platform.common.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Created by lishoubo on 16/6/24.
 */
public class IpUtils {
    private static String LOCAL_IP = null;

    public static String getLocalIp() {
        if (LOCAL_IP != null) {
            return LOCAL_IP;

        }
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) e.nextElement();
                Enumeration ipAddresses = ni.getInetAddresses();
                while (ipAddresses.hasMoreElements()) {
                    InetAddress address = (InetAddress) ipAddresses.nextElement();
                    if (address.isSiteLocalAddress() && !address.isLoopbackAddress() && !address.getHostAddress().contains(":")) {
                        LOCAL_IP = address.getHostAddress();
                        return LOCAL_IP;
                    }
                }
            }
            LOCAL_IP = "127.0.0.1";
            return LOCAL_IP;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] getLocalIpAsBytes() {
        String localIp = getLocalIp();
        byte[] bytes = new byte[4];
        try {
            String[] split = localIp.split(".");
            for (int i = 0; i < split.length; i++) {
                bytes[i] = Byte.parseByte(split[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid ip." + localIp);
        }
        return bytes;
    }
}
