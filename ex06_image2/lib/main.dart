// Flutter에서 Material 디자인 컴포넌트들을 사용하려면 반드시 import해야 함.
import 'package:flutter/material.dart';

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
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // 1번) fit속성: 이미지를 어떤식으로 채울지 여부를 결정하는 옵션
          Image.asset(
            'assets/images/900.png',
            fit: BoxFit.fill,             // 사이즈만 지정하면 자동 설정.
            alignment: Alignment.topLeft,
            width: 150.0,                 // 원래 사이즈가 비율대로 줄어듬.
          ),
          // 사이즈박스를 통해 위젯 사이에 약간의 여백을 지정
          const SizedBox(height: 5,),
          // 2번
          Image.asset(
            'assets/images/900.png',
            fit: BoxFit.cover,             // 큰 쪽에 맞춤. 작은쪽 잘림
            alignment: Alignment.centerLeft,
            width: 150.0,
            height: 100.0,
          ),
          const SizedBox(height: 5,),
          // 3번
          Image.asset(
            'assets/images/900.png',
            fit: BoxFit.fill,               // 사이즈에 맞춤. 이미지 형태에 변형 옴.
            alignment: Alignment.centerLeft,
            width: 150.0,
            height: 100.0,
          ),
          const SizedBox(height: 5,),
          // 4번
          Image.asset(
            'assets/images/900.png',
            fit: BoxFit.contain,            // 작은 쪽에 맞춤. 큰 쪽에 여백 남음
            alignment: Alignment.topLeft,
            width: 150.0,
            height: 100.0,
          ),
          const SizedBox(height: 5,),
          // 5번
          Image.asset(
            'assets/images/900.png',
            // fit: BoxFit.contain,
            alignment: Alignment.topLeft,   // 큰 쪽인 오른쪽에 여백 남음
            width: 150.0,                   // 사이즈를 둘 다 주면 fill이 아니고 contain이 된다.
            height: 100.0,
          ),
          const SizedBox(height: 5,),
          // 6번
          Image.asset(
            'assets/images/900.png',  
            fit: BoxFit.none,               // 원래 크기. 화면 배율에 영향 안받음.
            alignment: Alignment.topLeft,   // 오른쪽, 아래쪽 잘림.
            // 이미지 크기가 900이므로 우측, 하단이 모두 잘린다.
            width: 320.0,
            height: 80.0,
          ),
          const SizedBox(height: 5,),
        ],
      ),
    );
  }
}
