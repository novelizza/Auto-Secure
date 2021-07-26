package com.example.user.auto_secure;

import android.util.Log;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTTClient {
    private static final String TAG = "MQTTClient";
    private String mqttBroker = "tcp://mqtt.eclipse.org:1883";//iot.eclipse.org
    private String mqttTopic = "esp8266/button";
    private String deviceId = "androidClient";
    private int msgCounter = 0;

    MqttClient client;

    private MainActivity activity = null;

    public MQTTClient(MainActivity activity) {
        this.activity = activity;
    }

    public void connectToMQTT() throws MqttException {
        Log.i(TAG, "Setting Connection Options");
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        Log.i(TAG, "Creating New Client");
        client = new MqttClient(mqttBroker, deviceId, new MemoryPersistence());
        client.connect(options);
    }

    public void subscribeToMQTT() throws MqttException {
        Log.i(TAG, "Subscribing to Topic");
        client.setCallback(new MqttEventCallback());
        client.subscribe(mqttTopic, 0);
    }


    private class MqttEventCallback implements MqttCallback {

        @Override
        public void connectionLost(Throwable arg0) {
            // Do nothing
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken arg0) {
            // Do nothing
        }

        @Override
        public void messageArrived(String topic, final MqttMessage msg) throws Exception {
            Log.i(TAG, "New Message Arrived from Topic - " + topic);
            try {
                String buttonMessage = new String(msg.getPayload());
                if (buttonMessage.equalsIgnoreCase("button pressed")) {
                    // Update the screen with newly received message.
                    msgCounter++;
                    buttonMessage = "You pressed the button "+msgCounter+" times";
                    activity.updateView(buttonMessage);
                }
            } catch (Exception ex) {
                Log.e(TAG, ex.getMessage());
            }
        }
    }
}