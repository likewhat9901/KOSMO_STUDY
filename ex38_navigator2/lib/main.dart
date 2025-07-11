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

class Page1 extends StatefulWidget {
  const Page1({ Key? key}) : super(key: key);

  @override
  _Page1State createState() => _Page1State();
}

class _Page1State extends State<Page1> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Page1'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              child: const Text(
                '2페이지로 교체',
                style: TextStyle(fontSize: 24),
              ),
              onPressed: () {
                /* 2페이지로 전환됨. 즉 stack에 쌓이지 않고 교체. HTML a태그와 비슷하다. */
                Navigator.pushReplacement(
                  context, 
                  PageRouteBuilder(
                    pageBuilder: (context, anim1, anim2) => const Page2(),
                    transitionDuration: const Duration(seconds: 0),
                  ),
                );
              },
            ),
            ElevatedButton(
              child: const Text(
                '3페이지로 교체',
                style: TextStyle(fontSize: 24),
              ),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.orange,
              ),
              onPressed: () {
                Navigator.pushReplacement(
                  context, 
                  PageRouteBuilder(                    
                    pageBuilder: (context, anim1, anim2) => const Page2(),
                    // 화면이 전환되는 시간 설정(초단위)
                    //transitionDuration: const Duration(seconds: 0),
                    // 전환 시간을 밀리세컨즈 단위로 설정(0.5초 이하가 적당)
                    transitionDuration: const Duration(milliseconds: 1000),
                    // 화면 전환 에니메이션 설정
                    transitionsBuilder: (context, animation, secondaryAnimation, child) {
                      /*
                      Offset(0.0, 1.0) : 하단에서 올라옴
                      Offset(0.0, -1.0) : 상단에서 내려옴
                      Offset(1.0, 0.0) : 오른쪽에서 나옴
                      Offset(-1.0, 0.0) : 왼쪽에서 나옴
                       */
                      // 새로운 페이지의 움직임
                      var begin = Offset(1.0, 0.0);
                      // 기존 페이지의 움직임
                      var end = Offset.zero;  // Offset(0.0, 0.0)과 동일
                      // 애니메이션 커브
                      var curve = Curves.easeInOut;
                      // 시작, 종료, 커브까지 지정하여 트윈변수 생성
                      var tween = Tween(begin: begin, end: end).chain(CurveTween(curve: curve));
                      // 화면이 전환될때 적용
                      var offsetAnimation = animation.drive(tween);
                      return SlideTransition(position: offsetAnimation, child: child,);
                    },
                  ),
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
            ElevatedButton(
              child: const Text(
                '3페이지로 교체',
                style: TextStyle(fontSize: 24),
              ),
              onPressed: () {
                Navigator.pushReplacement(
                  context,
                  PageRouteBuilder(
                    pageBuilder: (context, anim1, animation2) => const Page3(),
                    transitionDuration: const Duration(seconds: 0),
                  ),
                );
              },
            ),
            ElevatedButton(
              child: const Text(
                '1페이지로 교체',
                style: TextStyle(fontSize: 24),
              ),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.orange,
              ),
              onPressed: () {
                Navigator.pushReplacement(
                  context,
                  PageRouteBuilder(
                    pageBuilder: (context, anim1, animation2) => const Page1(),
                    transitionDuration: const Duration(seconds: 0),
                  ),
                );
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
                '1페이지로 교체',
                style: TextStyle(fontSize: 24),
              ),
              onPressed: () {
                Navigator.pushReplacement(
                  context,
                  PageRouteBuilder(
                    pageBuilder: (context, anim1, animation2) => const Page1(),
                    transitionDuration: const Duration(seconds: 0),
                  ),
                );
              },
            ),
            ElevatedButton(
              child: const Text(
                '2페이지로 교체',
                style: TextStyle(fontSize: 24),
              ),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.orange,
              ),
              onPressed: () {
                Navigator.pushReplacement(
                  context,
                  PageRouteBuilder(
                    pageBuilder: (context, anim1, animation2) => const Page2(),
                    transitionDuration: const Duration(seconds: 0),
                  ),
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}
