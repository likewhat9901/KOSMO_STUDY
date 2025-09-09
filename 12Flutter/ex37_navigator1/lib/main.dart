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
        primarySwatch: Colors.blue,
      ),
      // home: 앱이 실행되었을 때 가장 먼저 보여줄 화면
      home: const Page1(),
    );
  }
}

/*
stful 스니펫을 통해 자동생성한 클래스를 통해 새로운 페이지를 구성한다.
Page1과 _Page1State가 쌍으로 생성된다. */
class Page1 extends StatefulWidget {
  const Page1({ Key? key}) : super(key: key);

  @override
  _Page1State createState() => _Page1State();
}

class _Page1State extends State<Page1> {
  
  @override
  Widget build(BuildContext context) {
    // 콘솔에 페이지 정보 출력
    print('Page1');
    return Scaffold(
      appBar: AppBar(
        title: const Text('Page 1'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              child: const Text(
                '2페이지 추가',
                style: TextStyle(fontSize: 24),
              ),
              /* 1페이지에는 아무것도 없는 상태이므로 2페이지를 Stack에 추가하는 기능만 있다.
              버튼을 누르면 두번째 페이지를 팝업과 같이 스택에 추가하게 된다. */
              onPressed: () {
                Navigator.push(
                  context, 
                  MaterialPageRoute(builder: (context) => const Page2())
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}

class Page2 extends StatefulWidget {
  const Page2({ Key? key}) : super(key: key);

  @override
  _Page2State createState() => _Page2State();
}

class _Page2State extends State<Page2> {
  @override
  Widget build(BuildContext context) {
    print('Page2');
    return Scaffold(
      appBar: AppBar(
        title: const Text('Page 2'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            /* 새로운 페이지를 Stack에 추가한다. push()를 통해 추가된 페이지는
            좌상단에 Back(제거) 버튼이 자동으로 생성된다. */
            ElevatedButton(
              child: const Text(
                '3페이지 추가',
                style: TextStyle(fontSize: 24),
              ),
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const Page3())
                );
              },
            ),
            /* 페이지를 Stack에서 제거한다. */
            ElevatedButton(
              child: const Text(
                '2페이지 제거',
                style: TextStyle(fontSize: 24),
              ),
              onPressed: () {
                print('Page2-pop');
                Navigator.pop(context);
              },
            ),
          ],
        ),
      ),
    );
  }
}

class Page3 extends StatefulWidget {
  const Page3({ Key? key}) : super(key: key);

  @override
  _Page3State createState() => _Page3State();
}

class _Page3State extends State<Page3> {
  @override
  Widget build(BuildContext context) {
    print('Page3');
    return Scaffold(
      appBar: AppBar(
        title: const Text('Page 3'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              child: const Text(
                '3페이지 제거',
                style: TextStyle(fontSize: 24),
              ),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.orange,
              ),
              onPressed: () {
                print('Page3-pop');
                Navigator.pop(context);
              },
            ),
          ],
        ),
      ),
    );
  }
}
