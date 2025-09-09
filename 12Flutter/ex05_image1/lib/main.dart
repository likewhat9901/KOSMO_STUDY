// Flutter에서 Material 디자인 컴포넌트들을 사용하려면 반드시 import해야 함.
import 'package:flutter/material.dart';
import 'dart:ui';   // 화면 사이즈용 추가

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

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  void getWindowSize() {
    print(MediaQuery.of(context).size);             // 앱 화면 논리적 크기
    print(MediaQuery.of(context).devicePixelRatio); // 화면 배율(디바이스) -> 2.625(Pixel2 애뮬레이터 사용시)
    // print(MediaQuery.of(context).padding.top);   // 상단 상태 표시줄의 높이
    print(window.physicalSize);                     // 앱 화면 실제 크기
  }

  @override
  Widget build(BuildContext context) {

    // 화면의 사이즈 출력을 위한 메서드 호출
    getWindowSize();

    // 실제 화면에 표시되는 UI를 표현하기 위한 객체
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      // 위젯을 수직방향으로 정렬
      body: Column(
        // 수직방향 중앙정렬
        mainAxisAlignment: MainAxisAlignment.center,
        // 수평방향 좌측정렬
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          // 해당 배율에 맞는 이미지가 없으므로 기본 이미지를 출력한다. 즉 녹색이미지가 출력.
          // 300a는 하나밖에 없는 상태임.
          Image.asset(
            'assets/images/300x300a.png'
          ),
          // 해당 배율(3.0x)에 이미지가 있으므로 해당 배율의 분홍 이미지가 출력.
          // 만약 이미지가 하나밖에 없다면 노란색 이미지가 출력될 것.
          // 이처럼 현재 디바이스(단말기)의 화면 배율에 맞는 동일한 이름의 이미지가 있다면, 자동으로 선택해서 출력하게 된다.

          // 기본 폴더의 같은 이름의 이미지는 노랑색 이미지
          // 크기를 지정하지 않으면 배율만큼 자동으로 줄어듬
          Image.asset(
            'assets/images/300x300b.png'
          ),
          // 해당 배율의 이미지라도 크기를 지정하면 지정한 크기가 적용됨
          // width 속성으로 이미지가 표현되는 상자의 크기를 지정하고, fit 속성으로 가로/세로의 채움 여부를 결정할 수 있다.
          // Image.asset 의 크기가 지정된 것이지, 내부의 이미지 크기가 지정된 것은 아니다.
          Image.asset(
            'assets/images/300x300b.png',
            fit: BoxFit.fill,
            width: 150,
          ),
          // 기본 폴더의 이미지에 크기 지정하기
          Image.asset(
            'assets/images/300x300a.png',
            width: 100,
          ),
        ],
      ),
    );
  }
}
