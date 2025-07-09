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

  String _sPersonName = '';
  
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
                'Show AlertDialog',
                style: TextStyle(
                  fontSize: 24,
                  color: Colors.white),
              ),
              // 람다식으로 호출
              onPressed: () => _showAlertDialog(context, 'hello~'),
            ),
          ],
        ),
      ),
    );
  }

  // void showAlertDialog() async {
  Future _showAlertDialog(BuildContext context, String message) async {
    await showDialog(
      context: context,
      // false: 화면의 빈곳을 눌러도 창이 닫히지 않음. true: 빈곳을 누르면 창이 닫힘.
      barrierDismissible: false,
      builder: (BuildContext context) {
        // 대화창의 테마 설정
        return Theme(
          data: ThemeData(dialogTheme: DialogThemeData(backgroundColor: Colors.orange)),
          child: AlertDialog(
            // 대화창의 모서리 부분을 라운딩 처리
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(8.0)
            ),
            // 타이틀
            title: Text('AlertDialog Example'),
            // 내용
            content: Container(
              height: 90,
              child: Column(
                children: [
                  Text(message),
                  TextField(
                    /** 대화창이 열릴때 자동으로 포커싱, 이 경우 키보드가 자동으로 올라옴. */
                    autofocus: true,
                    // 입력상자의 힌트. HTML의 placeholder와 동일.
                    decoration: InputDecoration(
                      labelText: 'Name', hintText: '홍길동',
                    ),
                    // 내용의 변경이 있을때 실행할 핸들러
                    onChanged: (value) {
                      _sPersonName = value;
                    },
                  )
                ],
              ),
            ),
            actions: [
              ElevatedButton(
                onPressed: () {
                  // 버튼을 누르면 대화창 닫음
                  Navigator.pop(context, 'OK');
                  // 입력된 내용을 콘솔에 출력
                  print('OK');
                },
                child: const Text('OK')
              ),
              ElevatedButton(
                onPressed: () {
                  // Navigator.pop() : 뒤로 가기(back) 또는 현재 라우트를 종료
                  Navigator.pop(context, 'Cancel');
                  print('Cancel');
                },
                child: const Text('Cancel')
              ),
            ],
          )
        );
      },
    );
  }
}
