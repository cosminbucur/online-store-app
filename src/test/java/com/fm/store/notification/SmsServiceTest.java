package com.fm.store.notification;

import com.fm.store.config.PropertiesLoader;
import com.fm.store.notification.sms.SmsService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmsServiceTest {

    @Test
    void sendMockSMSConfirmation() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        SmsService smsService = new SmsService(propertiesLoader.getSecretsConfig());

        smsService.sendSMSConfirmation("40723187106", "hi");
    }
}