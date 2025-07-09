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

  // 체크박스와 스위치에서 체크여부 확인을 위한 변수
  bool _chk1 = false;   // Non-nullable
  bool? _chk2 = false;  // Nullable
  bool _chk3 = false;   // Non-nullable

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            // 체크박스1 : 필수사항만 설정한 기본상태로 표현
            Checkbox(
              activeColor: Colors.lightBlue,
              // 체크박스에서 사용할 값 설정
              value: _chk1,
              // 체크박스에서 check/uncheck했을때 이벤트 처리
              onChanged: (bool? value) {
                /** 매개변수를 통해 null값이 들어올 수 있으므로 Nullable로 선언하고,
                 * 변수할당 시 null check operator를 추가하여 null인 경우 런타임 에러 발생시킨다. */
                setState(() {
                  _chk1 = value!;
                });
                print('Checkbox1 : $_chk1');
              }
            ),
            // 체크박스2 : 컬러지정
            Checkbox(
              value: _chk2,
              // 체크 시 색깔
              checkColor: Colors.pink,
              // 체크 시 배경색
              activeColor: Colors.green,
              /** _chk2는 Nullable로 선언, null값이 허용되므로 별도처리 불필요 */
              onChanged: (value) {
                setState(() {
                  _chk2 = value;
                });
                print('Checkbox2 : $_chk2');
              }
            ),
            Switch(
              value: _chk3,
              activeColor: Colors.red,
              activeTrackColor: Colors.cyan,
              inactiveThumbColor: Colors.lightGreen,
              inactiveTrackColor: Colors.lightGreen,
              onChanged: (value) {
                setState(() {
                  _chk3 = value;
                });
                print('Switch : $_chk3');
              }
            )
          ],
        ),
      ),
    );
  }
}
