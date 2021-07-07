
# Prerequisites

* Add your own google-services.json to app directory
* Set proper applicationId in app/build.gradle
* Set database url in PushSender
* Set a path to a json file with Service Account credentials in PushSenderTest

# Steps to reproduce

1. Launch app
2. Filter Logcat by "FCM-test"
3. Paste the token in PushSenderTest
4. Run PushSenderTest
5. Move app to background
6. Run PushSenderTest

Result:

Clicking multiple times on the foreground notification works as expected

Clicking multiple times on the background notification works only the first time
