// Flutter에서 Material 디자인 컴포넌트들을 사용하려면 반드시 import해야 함.
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

/* 앱 실행의 시작점 (main() 함수)
- runApp()은 Flutter에게 어떤 Widget을 화면에 그릴지 알려줌.
- MyApp 위젯을 최상위로 실행. */
void main() {
  runApp(const MyApp());
}

/* 앱 전체를 감싸는 StatelessWidget (불변) 클래스
- build() 안에서 MaterialApp 반환 → 테마, 타이틀, 홈 위젯 정의 */
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  /* 화면을 그리는 함수 - 매번 상태 변경될 때마다 호출됨 */
  Widget build(BuildContext context) {
    // MaterialApp: 앱의 뼈대를 설정 (테마, 라우팅, 기본 스타일 등)
    return MaterialApp(
      // title: 앱 타이틀 (안드로이드에서는 task switcher에 뜸)
      title: 'Flutter Demo',
      // theme: 앱 전체의 색상/폰트 스타일을 지정
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      // home: 앱이 실행되었을 때 가장 먼저 보여줄 화면
      home: const MyHomePage(title: 'Flutter 기본형'),
    );
  }
}

/* StatefulWidget (상태 변경 가능)
- 화면에 동적인 동작(예: 버튼 클릭, 값 변경 등)이 필요한 경우 사용
- title이라는 문자열을 외부에서 받음 (final String title) */
class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  
  @override
  Widget build(BuildContext context) {
    print('🔄 build() 호출됨!');
    
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              child: const Text(
                'Http (Get)',
                style: TextStyle(fontSize: 24),
              ),
              onPressed: () {
                _getRequest();
              },
            ),
            ElevatedButton(
              child: const Text(
                'Http (Post)',
                style: TextStyle(fontSize: 24),
              ),
              onPressed: () {
                _postRequest();
              },
            ),
          ],
        ),
      ),
    );
  }

  void _getRequest() async {
    var url = Uri.parse("https://sample.bmaster.kro.kr/contacts/672736bf012fed1c332e5f51");
    // http get 방식 요청
    http.Response response = await http.get(
      url,
      headers: {
        'Accept': 'application/json',
      },
    );

    // 응답코드 및 데이터
    var statusCode = response.statusCode;
    // var responseHeaders = response.headers;
    var responseBody = utf8.decode(response.bodyBytes);   // for 한글

    print("statusCode: $statusCode");
    // print("responseHeaders: $responseHeaders");
    print("responseBody: $responseBody");
  }

  // Post 방식 요청
  void _postRequest() async {
    // 새로운 연락처 추가하기
    var url = Uri.parse('https://sample.bmaster.kro.kr/contacts');

    // 헤더 및 요청 시 전송할 데이터를 JSON형식으로 기술
    http.Response response = await http.post(
      url,
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: {
        "name" : "김혜림 3행시",
        "tel" : "010-1111-2222",
        "address" : "김: 김말이 먹고싶다. 혜: 혜림이가 말합니다. 림: 임진석 사와."
      },
    );

    var statusCode = response.statusCode;
    // var responseHeaders = response.headers;
    var responseBody = utf8.decode(response.bodyBytes);   // for 한글

    print("statusCode: $statusCode");
    // print("responseHeaders: $responseHeaders");
    print("responseBody: $responseBody");
  }
}
