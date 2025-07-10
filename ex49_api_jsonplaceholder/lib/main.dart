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
                'jsonplaceholder 파싱1',
                style: TextStyle(fontSize: 24),  
              ),
              onPressed: () {
                getRequest();
              },
            ),
            SizedBox(height: 20,),
            ElevatedButton(
              child: const Text(
                'jsonplaceholder 파싱2',
                style: TextStyle(fontSize: 24),  
              ),
              onPressed: () {
                getRequest2();
              },
            ),
          ],
        ),
      ),
    );
  }

  void getRequest() async {
    /* Uri
    : Dart에서 URL을 안전하게 다루기 위한 내장 클래스야.
    - "문자열로 된 URL을 분석하고, 구성하고, 쪼개기 좋게 만든 객체형 URL"
    - http.get() 같은 함수는 Uri 타입을 요구함. */
    /* 예시
    Uri url = Uri.https('[example.com](http://example.com/)', '/api/data', {
    'page': '1',
    'sort': 'asc'
    });
    print(url.toString()); 👉 https://example.com/api/data?page=1&sort=asc */
    // API 사이트에서 하나의 게시물을 얻어온 후 파싱
    var url = Uri.parse("https://jsonplaceholder.typicode.com/posts/1");

    // get방식의 요청을 통해 응답이 올때까지 기다린 후 응답데이터 저장
    http.Response response = await http.get(
      url,
      headers: {"Accept": "application/json"}
    );

    // 응답데이터
    var statusCode = response.statusCode;
    var responseBody = utf8.decode(response.bodyBytes);
    // print("statusCode: $statusCode");
    // print("responseBody: $responseBody");

    // 1차 파싱
    var jsonData = jsonDecode(responseBody);
    // print(jsonData);

    // 각 Key를 이용해서 데이터 인출
    String userId = jsonData['userId'].toString();
    String id = jsonData['id'].toString();
    String title = jsonData['title'];
    String body = jsonData['body'];

    // 콘솔 출력
    print("userId : $userId");
    print("id : $id");
    print("title : $title");
    print("body : $body");
  }

  void getRequest2() async {
    var url = Uri.parse("https://jsonplaceholder.typicode.com/posts");

    http.Response response = await http.get(
      url,
      headers: {"Accept": "application/json"}
    );

    var statusCode = response.statusCode;
    var responseBody = utf8.decode(response.bodyBytes);
    // print("statusCode: $statusCode");
    // print("responseBody: $responseBody");

    // 1차 파싱
    var jsonData = jsonDecode(responseBody);
    // print(jsonData);

    for(var item in jsonData) {
      print('===============================');
      String userId = item['userId'].toString();
      String id = item['id'].toString();
      String title = item['title'];
      String body = item['body'];

      print("userId : $userId");
      print("id : $id");
      print("title : $title");
      print("body : $body");
    }

    // for(int i=0; i<jsonData.length; i++){
    //   print('===============================');
    //   String userId = jsonData[i]['userId'].toString();
    //   String id = jsonData[i]['id'].toString();
    //   String title = jsonData[i]['title'];
    //   String body = jsonData[i]['body'];

    //   // 콘솔 출력
    //   print("userId : $userId");
    //   print("id : $id");
    //   print("title : $title");
    //   print("body : $body");
    // }
  }
}
