package com.luoyan.io.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "," + msg);
        ctx.channel().writeAndFlush("from server:" + UUID.randomUUID());
    }

//    @Override
//    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
//        System.out.println(ctx.channel().remoteAddress());
//        EventLoop eventLoop = ctx.channel().eventLoop();
//        //作为客户端
//
////        Bootstrap b = new Bootstrap();
////        b.group(ctx.channel().eventLoop())
////                .channel(NioSocketChannel.class);
//
//
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();

        ctx.close();
    }


}
