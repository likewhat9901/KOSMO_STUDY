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

// Fruit이라는 열거형 타입을 정의 => 가능한 값은 Fruit.apple 또는 Fruit.banana
// enum은 열거형 상수로 클래스 외부에 선언할 수 있다.
enum Fruit {apple, banana}

class _MyHomePageState extends State<MyHomePage> {

  // 상태 클래스 선언과 변수
  /**
  라디오는 여러 항목 중 하나만 선택할 수 있으므로 그룹으로 묶어주기 위해 이와 같은 변수가 필요하다.
  즉, 그룹 구분에 사용할 변수 생성
   */
  Fruit _myGroup1 = Fruit.apple;
  Fruit _myGroup2 = Fruit.banana;

  bool _btn = true;   // 버튼 비활성화/활성화 flag

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
            // 라디오를 정확히 터치해야 선택되는 위젯
            // ListTile : 리스트 항목 UI 컴포넌트
            ListTile(
              title: const Text ('사과'), 
              // groupValue와 value를 비교해서, 버튼 선택여부를 Flutter가 판단
              leading: Radio <Fruit>( 
                // groupValue: 현재 선택된 값이 뭔지 알려주는 변수
                // 라디오를 하나의 그룹으로 묶을 때 사용하는 속성
                groupValue: _myGroup1, 
                // 설정된 값
                value: Fruit.apple,
                // 항목을 선택했을때 이벤트 핸들러
                onChanged: (Fruit? value) { 
                  /** 매개변수의 null값을 체크하여 상태를 변경한 후 리렌더링 한다. */
                  setState(() {
                    _myGroup1 = value!;
                    print(_myGroup1);
                  });
                },
              ),
            ),
            ListTile(
              title: const Text('바나나'),
              leading: Radio <Fruit>( 
                groupValue: _myGroup1, 
                value: Fruit.banana,
                onChanged: (value) { 
                  setState(() {
                    _myGroup1 = value!; 
                    print(_myGroup1);
                  });
                },
              ),
            ),
            const SizedBox (height: 50), // 2
            /**
            라디오의 선택 영역을 넓게 설정할 수 있는 위젯으로, 해당 라인 전체를 클릭해도 체크할 수 있다.
             */
            RadioListTile <Fruit>(
              title: const Text('사과'),
              groupValue: _myGroup2, 
              value: Fruit.apple,
              onChanged: (value) { 
                setState(() {
                  _myGroup2 = value!; 
                  print(_myGroup2); 
                  /** 
                  선택한 라디오의 값을 출력하고, 아래 엘리베이트 버튼을 활성화하는 기능이 추가되어 있다.
                   */
                  _btn = true;
                });
              },
            ),
            RadioListTile <Fruit>(
              title: const Text('바나나'),
              groupValue: _myGroup2, 
              value: Fruit.banana,
              activeColor: Colors.pink,
              onChanged: (value) { 
                setState(() {
                  _myGroup2 = value!; 
                  print(_myGroup2); 
                  _btn = false;
                });
              },
            ),
            const SizedBox (height: 50), // 2
            // 눌렀을 때 동작을 수행하는 입체감 있는 버튼
            ElevatedButton(
              child: const Text(
                'ElevateButton',
                style: TextStyle(fontSize: 24,
                color: Colors.white)
              ),
              /** 이 버튼이 활성화 상태라면 함수를 호출할 수 있다.
              비활성화 상태라면 null이 선택되어 누를 수 없는 상태가 된다.
               */
              onPressed: _btn ? _onClick1 : null,
            ),
          ],
        ),
      ),
    );
  }

  void _onClick1() {
    print('Radio 2 : $_myGroup2');
  }
}
