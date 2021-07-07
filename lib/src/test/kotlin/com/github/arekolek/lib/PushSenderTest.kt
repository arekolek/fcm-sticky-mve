package com.github.arekolek.lib

import com.google.auth.oauth2.GoogleCredentials
import org.junit.Test

class PushSenderTest {
    @Test
    fun sendPush() {
        val credentials = PushSenderTest::class.java.classLoader
            // file name only if placed under lib/src/test/resources
            .getResourceAsStream("service-accounts.json")

        PushSender().sendPush(
            // Paste token from Logcat here:
            registrationToken = "",
            googleCredentials = GoogleCredentials.fromStream(credentials)
        )
    }
}
