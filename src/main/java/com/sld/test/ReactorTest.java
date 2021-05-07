package com.sld.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ReactorTest {

    class Reactor implements Runnable {
        final Selector selector;
        final ServerSocketChannel serverSocketChannel;

        Reactor(int port) throws IOException {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            SelectionKey key = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            key.attach(new Acceptor());
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        dispatch(iterator.next());
                    }
                    selectionKeys.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void dispatch(SelectionKey next) {
            Runnable r = (Runnable) next.attachment();
            if (r != null)
                r.run();
        }

        class Acceptor implements Runnable {

            @Override
            public void run() {
                try {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    if (socketChannel != null)
                        new Handler(selector, socketChannel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    final class Handler implements Runnable {

        final SocketChannel socketChannel;
        final SelectionKey key;
        ByteBuffer input = ByteBuffer.allocate(1024);
        ByteBuffer output = ByteBuffer.allocate(1024);
        static final int READING = 0, SENDING = 1;
        int state = READING;

        Handler(Selector selector, SocketChannel c) throws IOException {
            socketChannel = c;
            c.configureBlocking(false);
            key = socketChannel.register(selector, 0);
            key.attach(this);
            key.interestOps(SelectionKey.OP_READ);
            selector.wakeup();
        }

        @Override
        public void run() {
            if (state == READING) {
                //read
            } else if (state == SENDING) {
                //send
            }
        }
    }



}
