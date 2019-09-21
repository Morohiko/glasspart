package com.example.glassespart.config;

public class NetworkConfig {
// DEFAULT CONFIG
    //private static String DEFAULT_IP_LOCAL_ADDRESS = "192.168.43.183";
    private static String DEFAULT_IP_LOCAL_ADDRESS = "0.0.0.0";
    private static String DEFAULT_IP_TARGET_ADDRESS = "192.168.43.164";

    private static int DEFAULT_GYROSCOPE_LOCAL_PORT = 3334;
    private static int DEFAULT_GYROSCOPE_TARGET_PORT = 3333;

    private static int DEFAULT_CAMERA_LOCAL_PORT = 3336;
    private static int DEFAULT_CAMERA_TARGET_PORT = 3335;

    private static int DEFAULT_TEST_LOCAL_PORT = 3338;
    private static int DEFAULT_TEST_TARGET_PORT = 3337;

// CURRENT CONFIG
    public static String IP_LOCAL_ADDRESS = DEFAULT_IP_LOCAL_ADDRESS;
    public static String IP_TARGET_ADDRESS = DEFAULT_IP_TARGET_ADDRESS;

    public static int GYROSCOPE_LOCAL_PORT = DEFAULT_GYROSCOPE_LOCAL_PORT;
    public static int GYROSCOPE_TARGET_PORT = DEFAULT_GYROSCOPE_TARGET_PORT;

    public static int CAMERA_LOCAL_PORT = DEFAULT_CAMERA_LOCAL_PORT;
    public static int CAMERA_TARGET_PORT = DEFAULT_CAMERA_TARGET_PORT;

    public static int TEST_LOCAL_PORT = DEFAULT_TEST_LOCAL_PORT;
    public static int TEST_TARGET_PORT = DEFAULT_TEST_TARGET_PORT;

//MOVE CURRENT TO DEFAULT
    public static void toDefaultConfig(){
        IP_LOCAL_ADDRESS = DEFAULT_IP_LOCAL_ADDRESS;
        IP_TARGET_ADDRESS = DEFAULT_IP_TARGET_ADDRESS;

        GYROSCOPE_LOCAL_PORT = DEFAULT_GYROSCOPE_LOCAL_PORT;
        GYROSCOPE_TARGET_PORT = DEFAULT_GYROSCOPE_TARGET_PORT;

        CAMERA_LOCAL_PORT = DEFAULT_CAMERA_LOCAL_PORT;
        CAMERA_TARGET_PORT = DEFAULT_CAMERA_TARGET_PORT;

        TEST_LOCAL_PORT = DEFAULT_TEST_LOCAL_PORT;
        TEST_TARGET_PORT = DEFAULT_TEST_TARGET_PORT;
    }
}
