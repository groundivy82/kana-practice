# 가나 연습

히라가나·가타카나를 소리 듣고 고르는 문제로 익히는 안드로이드 앱.
AI·네트워크 호출 없이 폰 안에서만 동작하고, 일본어 소리는 폰의 TTS(일본어)를 쓴다.

- 화면: `app/src/main/assets/index.html` (HTML/JS 한 파일)
- 앱 껍데기: `MainActivity.java` (WebView + TextToSpeech 다리)
- 빌드: push 하면 GitHub Actions가 APK를 만들어 Releases(`latest`)에 올린다.
