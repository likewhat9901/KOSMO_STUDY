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
  // 나중에 초기화될 것임을 명시하여 데이터로 사용할 List선언
  late List<Person> persons;

  /**
  위젯 초기화시 딱 한번만 호출되는 함수. State(상태)를 초기화한다.
  단, 코드 변경시 Hot reload가 지원되지 않으므로 반드시 재시작해야 한다.
  */
  @override
  void initState() {
    super.initState();    // must call in 2.0 ~

    persons = [];
    for (int i=0; i<15; i++) {
      persons.add(Person(i+21, '홍길동$i', true));
    }
  }
  
  @override
  Widget build(BuildContext context) {
    print('🔄 build() 호출됨!');
    
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: 
      /* 2. ListView.builder를 사용해서 Lazy하게 생성.
      index 를 이용하여 플러터가 알아서 필요한만큼 리스트를 생성한다.
      타일 전체를 한꺼번에 생성하지 않아 메모리 절약, 속도도 빠름.
      */
      ListView.builder(
        // 패딩 지정
        padding: const EdgeInsets.all(8),
        // 리스트에 저장된 아이템의 개수만큼 알아서 반복
        itemCount: persons.length,    // itemCount가 3이면 index = 0, 1, 2까지 자동으로 전달하며 itemBuilder 호출
        // 아이템 개수만큼 Tile을 생성하여 반환.
        itemBuilder: (BuildContext context, int index) {
          return PersonTile(persons[index]);
        }
      ),
    );
  }
}

// 데이터로 사용할 DTO 클래스
class Person {
  int age;
  String name;
  bool isLeftHand;

  Person(this.age, this.name, this.isLeftHand);
}

// StatelessWidget : 상태가 없는 위젯(정적인 위젯)
class PersonTile extends StatelessWidget {
  // 멤버변수와 생성자 정의
  final Person _person;
  PersonTile(this._person);

  // 출력할 타일 생성
  @override
  Widget build(BuildContext context) {
    return ListTile(
      leading: Icon(Icons.person),
      title: Text(_person.name),
      subtitle: Text("${_person.age}세"),
      trailing: Icon(Icons.arrow_forward_ios),
      onTap: () {
        print(_person.name);
      },
    );
  }
}