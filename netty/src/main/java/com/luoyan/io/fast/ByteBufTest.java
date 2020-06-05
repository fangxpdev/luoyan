package com.luoyan.io.fast;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBufTest {

    public static void main(String[] args) {

        ByteBuf byteBuf = Unpooled.buffer(2,2);

        byteBuf.writeByte(1);
        byteBuf.writeByte(2);

        System.out.println("readIndex:" + byteBuf.readerIndex() + " writeIndex: " + byteBuf.writerIndex());

        byteBuf.readByte();
        byteBuf.writeByte(3);
        System.out.println("readIndex:" + byteBuf.readerIndex() + " writeIndex: " + byteBuf.writerIndex());



    }

}
