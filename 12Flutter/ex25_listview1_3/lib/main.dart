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
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      /** 
      방법 1: 명시적으로 ListView의 Children으로 List를 넘겨서 생성한다.
        리스트뷰가 로드될 때 데이터까지 한꺼번에 로드되므로 개수가 적을때 적합한 방식.
       */
      body: ListView(
        // 1단계
        // children을 쓰는 이유: ListView는 기본적으로 여러 위젯을 담는 "스크롤 가능한 Column" 구조이기 때문
        // children: [
        //   ListTile(
        //     // 좌측 아이콘 혹은 이미지
        //     leading: FlutterLogo(size: 50.0,),
        //     // 타일에 출력할 제목
        //     title: Text('Basic #1'),
        //     // 출력할 내용
        //     subtitle: Text('타이틀과 서브 타이틀로만 구성'),
        //     // 우측 아이콘
        //     // Icons.more_vert: ⋮ ← 세로 점 3개짜리 메뉴 아이콘
        //     trailing: Icon(Icons.more_vert),    
        //     // 타일을 눌렀을때 동작 지정
        //     onTap: () {
        //       print('Basic #1');
        //     },
        //   ),
        // ],

        // 2단계
        // children: getMyList1(),

        // 3단계
        children: getMyList2(),
      ),
    );
  }

  // 메서드의 리턴값으로 Scaffold의 body 구성
  List<Widget> getMyList1() {
    List<Widget> myList = [
      ListTile(
        // 좌측 아이콘 혹은 이미지
        leading: FlutterLogo(size: 50.0,),
        // 타일에 출력할 제목
        title: Text('Basic #1'),
        // 출력할 내용
        subtitle: Text('타이틀과 서브 타이틀로만 구성'),
        // 우측 아이콘
        // Icons.more_vert: ⋮ ← 세로 점 3개짜리 메뉴 아이콘
        trailing: Icon(Icons.more_vert),    
        // 타일을 눌렀을때 동작 지정
        onTap: () {
          print('Basic #1');
        },
      ),
      // 리스트뷰 타일을 구분하는 선
      Divider(
        color: Colors.black,
        height: 5,
        // 좌우측 여백 지정
        indent: 10,
        endIndent: 10,
      )
    ];
    return myList;
  }

  // 3단계: 데이터를 이용해서 개수만큼 반복하는 List를 생성
  List<Widget> getMyList2() {
    
    // Person 인스턴스를 저장할 수 있는 리스트 생성
    List<Person> persons = [];
    for (int i=0; i<15; i++) {
      // Person 인스턴스를 순서대로 생성한 후 리스트에 추가
      persons.add(Person(i+21, '홍길동$i', true));
    }

    // 앞에서 준비한 데이터를 이용해서 리스트 타일 생성
    List<Widget> myList = [];
    // 데이터의 개수만큼 반복
    for (int i=0; i<persons.length; i++) {
      // 리스트타일을 생성한 후 리스트에 추가한다.
      /**
      Widget wid = ...	✅	명확한 타입 표현 원할 때
      var wid = ...	    ✅	간단하게 쓰고 싶을 때
      final wid = ... 	✅	변경 안 할 거면 이게 제일 안전 */
      Widget wid = ListTile(
        leading: FlutterLogo(size: 50.0,),
        title: Text('Basic #$i'),
        subtitle: Text('${persons[i].name} - ${persons[i].age}'),
        trailing: Icon(Icons.more_vert),    
        onTap: () {
          print('Basic #$i');
        },
      );
      // ListTile 인스턴스 생성 후 List에 추가.
      myList.add(wid);
    }
    // 리스트타일 전체 반환
    return myList;
  }

}

// 데이터로 사용할 DTO클래스
// Person이라는 클래스로 한 사람의 정보를 묶어서 관리
class Person {
  // 멤버변수
  int age;
  String name;
  bool isLeftHand;

  // 생성자 : 각 멤버변수를 초기화하는 축약형 표현방식
  Person(this.age, this.name, this.isLeftHand);
}
