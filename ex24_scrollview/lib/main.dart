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
    print('🔄 build() 호출됨!');
    
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        /** Container 기본값
        margin	        EdgeInsets.zero	  바깥 여백 없음
        padding	        EdgeInsets.zero	  안쪽 여백 없음
        width, height	  null	            크기 제한 없음 (내용이나 부모에 따라 결정됨)
         */
        child: Container(
          // 패딩과 마진을 4방향 모두 0으로 설정
          margin: EdgeInsets.all(0.0),
          // 패딩을 지정하면 cyan 색깔로 테두리(배경색)이 보임
          padding: EdgeInsets.all(10.0),
          /** 화면 크기보다 자식이 크면 화면의 크기로 맞춰짐. */
          // width: 300,  // 크기를 지정하지 않으면 부모의 크기
          // height: 500,  // 크기를 지정하지 않으면 자식의 크기 (if 화면 크기보다 자식이 크면 화면의 크기)
          color: Colors.cyan,
          alignment: Alignment.topLeft,
          height: MediaQuery.of(context).size.height,
          child: Scrollbar(
            thumbVisibility: true,  // 항상 스크롤바 보이게
            interactive: true,      // 터치 드래그 가능하게
            thickness: 10.0,             // 👉 스크롤바 두께
            radius: Radius.circular(10), // 👉 둥근 모서리
            // trackVisibility: true,       // 👉 스크롤 경로도 보이게
            // 스크롤 뷰 위젯 : 화면이 길어지면 자동으로 스크롤이 생성됨.
            child: SingleChildScrollView(     // #2
              // 스크롤 방향 설정(수직이 Default)
              scrollDirection: Axis.vertical, // #2-1
              child: Column(
                // mainAxisAlignment: MainAxisAlignment.center, // 의미 없다.

                // 세로 화면을 벗어날 정도의 컨테이너를 추가한 후 테스트
                children: [   // #1
                  Container(
                    width: double.infinity,   // like Match_parent in Android
                    height: 200,
                    alignment: Alignment.center,
                    color: Colors.amber[700],
                    child: Text('Entry A', style: TextStyle(fontSize: 30),),
                  ),
                  Container(
                    width: double.infinity,
                    height: 200,
                    alignment: Alignment.center,
                    color: Colors.amber[500],
                    child: Text('Entry b', style: TextStyle(fontSize: 30),),
                  ),
                  Container(
                    width: double.infinity,
                    height: 200,
                    alignment: Alignment.center,
                    color: Colors.amber[300],
                    child: Text('Entry c', style: TextStyle(fontSize: 30),),
                  ),
                  Container(
                    width: double.infinity,
                    height: 200,
                    alignment: Alignment.center,
                    color: Colors.amber[100],
                    child: Text('Entry d', style: TextStyle(fontSize: 30),),
                  ),
                ],
              ),
            ),
          ),

        )
      ),
    );
  }
}
