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

  // 토글버튼 선택항목 구분용 리스트
  var isSelected1 = [false, false, true];
  var isSelected2 = [false, false, true];

  @override
  Widget build(BuildContext context) {
    print('🔄 build() 호출됨!');
    
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            // multi-select
            const Text('multi-select', textScaleFactor: 2),
            // 토글버튼 위젯 
            ToggleButtons(
              // 토글버튼은 주로 아이콘으로 표현
              // children : 화면에 (가로로) 나열될 개별 버튼들의 UI 구성 요소 => List<Widget> 타입
              children: const [ 
                Icon (Icons.ac_unit), 
                Icon (Icons.call),
                Icon (Icons.cake),
              ],
              // 각 버튼의 값으로 사용할 List를 설정.
              isSelected: isSelected1, // 각 버튼의 선택 여부
              // 이벤트 핸들러 : 누른 버튼의 인덱스 값이 인수로 전달
              onPressed: (int index) {
                setState(() {
                  /** !가 변수 앞에 있으므로 Not(부정)연산자로 사용된다.
                  즉, 버튼을 클릭할때마다 상태가 반전된다.
                   */
                  isSelected1[index] = !isSelected1 [index]; 
                  // 셀렉트 된 항목 전체를 리스트로 출력
                  print('isSelected1 : $isSelected1');
                  // 선택한 항목의 인덱스 출력
                  print('index : $index');
                });
              },
            ),
            const SizedBox (height: 20),
            // single select
            const Text('single select', textScaleFactor: 2), 
            ToggleButtons(
              children: const [
                Icon(Icons.ac_unit), // index 0
                Icon(Icons.call),    // index 1
                Icon(Icons.cake),    // index 2
              ],
              // index => 사용자가 클릭한 버튼의 인덱스 번호가 자동으로 전달
              onPressed: (int index) {
                setState(() {
                  print('눌린 인덱스: $index');
                  // 전체 항목 중 선택한 하나만 토글함
                  for (var i = 0; i < isSelected2.length; i++) {
                    if (i == index) {
                      // 사용자가 선택한 항목 하나만 활성화
                      isSelected2[i] = true;
                    } else {
                      // 나머지는 모두 비활성화 처리
                      isSelected2[i] = false;
                    }
                  }
                  print('isSelected2: $isSelected2');
                });
              },
              isSelected: isSelected2,
            ), // ToggleButtons
          ],
        ),
      ),
    );
  }
}
