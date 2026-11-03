# 가나 연습

히라가나·가타카나를 소리 듣고 고르는 문제로 익히는 안드로이드 앱.
AI·네트워크 호출 없이 폰 안에서만 동작하고, 일본어 소리는 폰의 TTS(일본어)를 쓴다.

- 화면: `app/src/main/assets/index.html` (HTML/JS 한 파일)
- 메뉴: 글자 단원 연습 + 문장 만들기(히라가나 문장을 단어 조각으로 맞추기)
- 앱 껍데기: `MainActivity.java` (WebView + TextToSpeech 다리)
- 빌드: push 하면 GitHub Actions가 APK를 만들어 Releases(`latest`)에 올린다.
- 웹 버전(아이폰 등): push 하면 GitHub Pages로도 배포된다. 주소는 `https://groundivy82.github.io/kana-practice/`
  (처음 한 번, 저장소 Settings → Pages → Source 를 `GitHub Actions` 로 바꿔야 한다.)
  아이폰은 Safari에서 열고 공유 버튼 → "홈 화면에 추가"로 앱처럼 쓴다.
- 문장 만들기: 히라가나 문장 87개 중 10문제씩 단어 조각 맞추기 / 대화하기: 10개 대화에서 상황만 보고 내 대답 만들기 (여러 답 허용)
