package com.jl.platform.common.utils;

import org.apache.commons.codec.binary.Hex;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lishoubo on 16/6/24.
 */
public class IDUtils {
    private static final byte[] IP_BYTES = IpUtils.getLocalIpAsBytes();
    private static AtomicInteger SEQ = new AtomicInteger(0);

    private static ThreadLocal<ByteBuffer> BUFFER = new ThreadLocal<ByteBuffer>();

    public static String nextId() {
        ByteBuffer byteBuffer = BUFFER.get();
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(14);
            BUFFER.set(byteBuffer);
        }
        int current, next;
        do {
            current = SEQ.get();
            next = (current >= 8000 ? 1 : current + 1);
        } while (!SEQ.compareAndSet(current, next));

        byteBuffer.putShort((short) next); //2
        byteBuffer.putLong(System.currentTimeMillis());//8
        byteBuffer.put(IP_BYTES);//4
        byteBuffer.flip();
        return Hex.encodeHexString(byteBuffer.array());

    }
}
