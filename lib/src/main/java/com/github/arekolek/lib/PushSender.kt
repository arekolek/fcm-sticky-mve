package com.github.arekolek.lib

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.AndroidConfig
import com.google.firebase.messaging.AndroidNotification
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message

class PushSender {

    fun sendPush(googleCredentials: GoogleCredentials, registrationToken: String) {
        val options = FirebaseOptions.Builder()
            .setCredentials(googleCredentials)
            .setDatabaseUrl("https://example.firebaseio.com")
            .build()

        val app = FirebaseApp.initializeApp(options)

        val message = Message.builder()
            .setToken(registrationToken)
//            .putData("body", "Example data body")
            .setAndroidConfig(
                AndroidConfig.builder()
                    .setNotification(
                        AndroidNotification.builder()
                            .setBody("Example notification body")
                            .setSticky(true)
                            .build()
                    )
                    .build()
            )
            .build()

        val response = FirebaseMessaging.getInstance(app).send(message)

        println("Successfully sent message: $response")
    }

}
