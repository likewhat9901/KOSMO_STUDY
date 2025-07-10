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

  // 페이지 컨트롤러 생성
  final _pageController = PageController(
    initialPage: 0,
  );

  // 각 페이지의 페이지명으로 사용할 리스트
  List<String> pages = ['Page 1', 'Page 2', 'Page 3'];
  
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
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              // 페이지 상단에 바로가기 버튼 생성(고정)
              children: [
                ElevatedButton(
                  child: const Text(
                    'Page 1',
                    style: TextStyle(fontSize: 20),
                  ),
                  // 각 버튼을 누르면 람다형식으로 메서드 호출
                  onPressed: () => onClick(0),
                ),
                SizedBox(width: 10,),
                ElevatedButton(
                  child: const Text(
                    'Page 2',
                    style: TextStyle(fontSize: 20),
                  ),
                  onPressed: () => onClick(1),
                ),
                SizedBox(width: 10,),
                ElevatedButton(
                  child: const Text(
                    'Page 3',
                    style: TextStyle(fontSize: 20),
                  ),
                  onPressed: () => onClick(2),
                ),
                SizedBox(width: 10,),
              ],
            ),
            // 상단에 고정된 텍스트
            Text(
              '터치한 후 좌우로 Swipe 하세요.',
              style: TextStyle(fontSize: 24.0),
            ),
            // 페이지를 전체 영역에 삽입
            Expanded(
              flex: 1,
              // 페이지 뷰 추구
              child: PageView.builder(
                // 컨트롤러
                controller: _pageController,
                // 페이지 수
                itemCount: pages.length,
                // 각 함수를 호출하여 컨테이너 위젯을 반환받아 페이지 구성
                itemBuilder: (context, index) {
                  print('PageView.builder호출:$index');
                  // 인수로 전달받은 인덱스를 통해 페이지 반환
                  return getPage(index);
                },
              ),
            )
          ],
        ),
      ),
    );
  }

  void onClick(int index) {
    /* if (_pageController.hasClients)
    : _pageController가 실제로 연결된 PageView가 있을 경우만 실행해라는 뜻
      - 실무에선 거의 필수로 넣는 안전장치
    */
    if (_pageController.hasClients) {
      /* animateToPage(index, ...)
      - 페이지를 애니메이션과 함께 해당 페이지로 부드럽게 이동 */
      _pageController.animateToPage(
        index,
        // 설정된 시간만큼 애니메이션 효과 적용 (0.5초 이하 권장)
        // duration: const Duration(milliseconds: 1),
        duration: const Duration(milliseconds: 400),
        curve: Curves.easeInOut,
      );

      // 애니메이션 효과 없이 화면 전환
      // _pageController.jumpToPage(index);
    }
  }

  // 각 페이지를 위젯으로 반환
  Widget getPage(int index) {
    // 컨테이너를 생성한 후 반환한다.
    return Container(
      height: 200,
      child: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            /* 인수로 전달받은 인덱스를 통해 페이지에 출력할 텍스트와 아이콘을
            지정한 후 컨테이너 위젯을 반환한다. */
            getIcon(index),
            Text(
              pages[index],
              style: TextStyle(fontSize: 20),
            ),
          ],
        ),
      ),
    );
  }
  
  Widget getIcon(int index) {
    if (index == 0) {
      return Icon(
        Icons.camera_alt,
        color: Colors.red,
        size: 35.0,
      );
    } else if (index == 1) {
      return Icon(
        Icons.add_circle,
        color: Colors.orange,
        size: 35.0
      );
    } else {
      return Icon(
        Icons.star,
        color: Colors.indigo,
        size: 35.0,
      );
    }
  }
}
