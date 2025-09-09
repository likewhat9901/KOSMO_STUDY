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
  
  // 스낵바에서 사용할 메세지
  String msg = "Hello world";

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
                'SnackBar 기본',
                style: TextStyle(fontSize: 24)
              ), 
              // 버튼 클릭시 실행할 함수를 직접 정의
              onPressed: () {
                // 이 클래스를 통해 직접 스낵바를 띄운다.
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                    // 스낵바에 표시할 메세지
                    content: Text(msg),
                    // 유지시간을 밀리세컨즈 단위로 설정(1000m/s => 1초 설정)
                    duration: const Duration(milliseconds: 1000),
                  ),
                );
              },
            ),
            const SizedBox(height: 10,),
            ElevatedButton(
              child: const Text(
                'SnackBar 옵션',
                style: TextStyle(fontSize: 24)
              ),
              // 버튼 클릭시 람다 형식으로 외부함수 호출
              onPressed: () => callSnackBar ("안녕하세요~홍길동님!"),
            ),
          ],
        ),
      ),
    );
  }

  callSnackBar(msg) {
    ScaffoldMessenger.of (context).showSnackBar(
      SnackBar(
        // 메세지 내용. 텍스트의 스타일 지정.
        content: Text (msg, style: const TextStyle(color: Colors.black,)),
        // 배경색
        backgroundColor: Colors.yellow[800],
        // 유지시간
        duration: const Duration(milliseconds: 2000),
        // 스낵바에 별도의 텍스트 버튼 추가
        action: SnackBarAction(
          label: '닫기',
          textColor: Colors.black, 
          onPressed: () {
            print('스낵바 닫힘');
          },
        ),
        // 플로팅 여부 설정 : 아래부분에서 살짝 띄워준다. 이 부분이 없으면 기본 설정처럼
        // 아래쪽에서 스낵바를 밀어 올린다.
        // behavior: SnackBarBehavior.floating, 
        // 스낵바의 모서리 부분을 둥글게 커스텀한다.
        shape: RoundedRectangleBorder (
          borderRadius: BorderRadius.circular(20),
          side: BorderSide(
            color: Colors.red,
            width: 2,
          ),
        ),
      ),
    );
  }
}
