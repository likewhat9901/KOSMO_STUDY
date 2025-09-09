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
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Container(
              // margin: const EdgeInsets.all(10.0),
              // 마진을 지정한 방향에만 적용(좌,상)
              margin: const EdgeInsets.only(left: 10, top: 10),
              // 패딩은 4방향 모두 적용
              padding: const EdgeInsets.all(0.0),
              color: Colors.yellow,
              // 가로크기는 미지정시 부모의 크기만큼 적용
              // width: 300,    // 크기를 지정하지 않으면 부모의 크기
              // 세로크기는 미지정시 자식 크기만큼 적용
              height: 100,      // 크기를 지정하지 않으면 자식의 크기
              alignment: Alignment.topLeft,    // 정렬은 자식 위젯에 적용됨.
              child: const Text(
                '홍길동',
                style: TextStyle(fontSize: 30, color: Colors.blue),
              ),
            ),
            Container(
              margin: const EdgeInsets.all(0.0),
              padding: const EdgeInsets.all(80.0),    // 자식과의 패딩으로 크기가
              alignment: Alignment.center,
              // 컨테이너의 모양을 결정하는 속성
              decoration: const BoxDecoration(
                shape: BoxShape.circle,
                color: Colors.blue,
              ),
              child: const Text(
                '전우치',
                style: TextStyle(fontSize: 30, color: Colors.white),
              ),
            ),
            Container(
              margin: const EdgeInsets.all(0.0),
              padding: const EdgeInsets.all(0.0),
              width: 400,       // 크기를 지정하지 않으면 부모의 크기
              height: 100,      // 크기를 지정하지 않으면 자식의 크기
              alignment: Alignment.bottomRight,
              decoration: const BoxDecoration(
                // 박스 모양을 사각형으로 설정
                shape: BoxShape.rectangle,
                color: Colors.brown,
              ),
              child: const Text(
                '손오공',
                style: TextStyle(fontSize: 30, color: Colors.white),
              ),
            ),
            const SizedBox(height: 5,),

            Container(
              width: 100.0,       // 크기를 지정하지 않으면 부모의 크기
              height: 40.0,      // 크기를 지정하지 않으면 자식의 크기
              // 컨테이너에 이미지를 데코레이션으로 삽입
              decoration: const BoxDecoration(
                image: DecorationImage(
                  image: AssetImage('assets/images/300x100.png')
                ),
              ),
              // 텍스트버튼으로 마치 이미지 버튼과 같은 효과를 적용
              child: TextButton(
                // 텍스트를 삽입하면 이미지 위에 보이게 되므로 빈문자열 처리
                child: const Text('',),
                onPressed: () => _onClick(1),
              ),
            ),

            /* InkWell 위젯
            : Text와 같이 제스쳐 기능을 제공하지 않는 위젯을 랩핑하여 onTap 기능을 제공한다.
            터치했을때 물결모양의 애니메이션 효과가 발생된다. */
            Ink.image(
              image: const AssetImage('assets/images/300x100.png'),
              width: 100.0,
              height: 40.0,
              // fit: BoxFit.fill,
              child: InkWell(
                // child: Text(''),
                onTap: () => _onClick(2),
              ),
            ),
            
          ],
        ),
      ),
    );
  }

  void _onClick(int num) {
    print('Hello~ $num');
  }
}
