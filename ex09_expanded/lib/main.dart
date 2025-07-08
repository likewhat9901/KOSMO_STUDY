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
      home: const MyHomePage(title: 'Expanded 사용'),
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

  // 이미지 위젯에 설정할 변수
  String _image1 = 'assets/images/900.png';
  String _image2 = 'assets/images/placeholder.png';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            Expanded(
              // HTML의 %와 같이 위젯의 비율(가중치)을 설정
              flex: 5,
              child: Container(
                // 마진, 패딩, 컬러, 정렬 지정
                margin: const EdgeInsets.all(0.0),
                padding: const EdgeInsets.all(0.0),
                color: Colors.cyan,
                alignment: Alignment.topLeft,
                // 컨테이너의 자식으로 이미지 추가
                child: Image.asset(
                  _image1,
                  alignment: Alignment.topLeft,
                  // alignment: Alignment.topCenter,
                  // alignment: Alignment.bottomRight,
                  // 이미지의 원본 크기로 설정
                  fit: BoxFit.none,
                  width: 390.0,
                  height: 250.0,
                ),
              ),
            ),
            Container(
              // 마진을 4방향 각각 설정
              margin: const EdgeInsets.only(left: 0, top: 10, right: 0, bottom: 10),
              // 패딩은 한꺼번에 설정
              padding: const EdgeInsets.all(0.0),
              color: Colors.white,
              // width: 300,          // 지정하지 않으면 부모 크기
              // height: 100,         // 지정하지 않으면 자식 크기
              // alignment: Alignment.center,
              // 아이콘 버튼이 가로형으로 배치된다.
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  IconButton(
                    icon: const Icon(Icons.upload_sharp),
                    tooltip: "이미지 위로 이동",
                    iconSize: 50.0,
                    // 버튼 클릭시 람다형식으로 함수 호출
                    onPressed: () => _onClick1(),
                  ),
                  // 사이즈박스로 중간에 간격을 20 띄움
                  const SizedBox(width: 20),
                  IconButton(
                    icon: const Icon(Icons.download_sharp),
                    tooltip: "이미지 아래로 이동",
                    iconSize: 50.0,
                    onPressed: () => _onClick2(),
                  ),
                ],
              )
            ),
            Expanded(
              flex: 5,
              child: Container(
                margin: const EdgeInsets.all(0.0),
                padding: const EdgeInsets.all(0.0),
                color: Colors.cyan,
                alignment: Alignment.topLeft,
                child: Image.asset(
                  _image2,
                  alignment: Alignment.topLeft,
                  fit: BoxFit.none,     // 원래 크기대로...
                  width: 390.0,
                  height: 250.0,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  /* 상태변경을 위해 사용하는 메서드로 특정 변수를 변경시키면 화면이
  리렌더링되면서 변경된 화면을 볼 수 있다.
   */
  void _onClick1() {
    setState(() {
      _image1 = 'assets/images/900.png';
      _image2 = 'assets/images/placeholder.png';
    });
  }

    void _onClick2() {
    setState(() {
      _image1 = 'assets/images/placeholder.png';
      _image2 = 'assets/images/900.png';
    });
  }
}
