package com.dubbo.provider;

import org.apache.log4j.BasicConfigurator;

public class Main {
    public static void main(String[] args) {
        com.alibaba.dubbo.container.Main.main(args);
        BasicConfigurator.configure();
    }
}
