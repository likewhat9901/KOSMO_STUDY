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
  late List<Person> persons;

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
      // 3. ListView.separated를 사용해서 Lazy하게 생성.
      //    아이템 사이에 구분자도 Lazy 하게 생성.
      ListView.separated(
        // 아이템
        itemCount: persons.length,
        // 아이템 빌더 내에서 출력할 Tile을 생성
        itemBuilder: (BuildContext context, int index) {
          // Person 인스턴스 외 추가데이터인 index 사용
          return PersonTile(persons[index], index);
        },
        // 구분선 표시
        separatorBuilder: (BuildContext context, int index) {
          return const Divider(
            color: Colors.black,
            /* 구분선은 아래 속성에 따라 다른 경과를 출력하므로 선택해서 사용한다. */
            height: 1,
            // thickness: 1.0,
          );
        },
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
// ListTile 생성용 클래스
class PersonTile extends StatelessWidget {
  // 멤버변수
  final Person _person;
  final int index;

  // 추가데이터는 생성자를 통해 추가할 수 있다.
  PersonTile(this._person, this.index);

  @override
  Widget build(BuildContext context) {
    /*
    코드추가 : ListTile에 배경색을 부여하고 싶다면 Ctrl+. 으로
    Container를 랩핑한 후 color 속성을 부여하면 된다. */
    // 리스트 타일 생성
    return Container(
      color: Colors.amber[50],
      child: ListTile(
        leading: Icon(Icons.person),
        title: Text(_person.name),
        subtitle: Text("${_person.age}세"),
        trailing: Icon(Icons.arrow_forward_ios),
        onTap: () {
          print('추가 데이터 : $index');
        },
      ),
    );
  }
}