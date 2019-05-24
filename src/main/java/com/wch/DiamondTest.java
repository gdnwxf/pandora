package com.wch;

import com.taobao.diamond.client.Diamond;

import java.io.IOException;

public class DiamondTest {


    public static void main(String[] args) throws IOException {
        String config = Diamond.getConfig("diamond", "diamond", 100l);

        System.out.println(config);
    }
}
