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

  // 별도의 설정 없이도 로컬 시간이 표시된다.
  String _selectedDate = DateTime.now().toString();
  
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
            // 현재 날짜 출력 혹은 선택한 날짜 출력
            Text('$_selectedDate', style: TextStyle(fontSize: 30)),
            ElevatedButton(
              child: const Text(
                'Show DatePicker',
                style: TextStyle(fontSize: 24),
              ),
              onPressed: () => selectDate(),
            )
          ],
        ),
      ),
    );
  }

  // 현재날짜를 표시하기 위해 날짜를 구해서 반환
  DateTime selectNowDate() {
    // 현재 시각을 얻어옴
    DateTime _now = DateTime.now();
    if (_now.weekday == 6) {
      // 오늘이 토요일이면 2일을 더함
      _now = _now.add(Duration(days: 2));
    } else if (_now.weekday == 7) {
      // 오늘이 일요일이면 1일을 더함
      _now = _now.add(Duration(days: 1));
    }
    /** 즉 오늘이 평일인 경우에는 그대로 반환하고, 주말인 경우에는
     * 돌아오는 월요일의 날짜를 계산해서 반환해준다. */
    return _now;
  }

  // 특정날짜, 요일 등을 활성화/비활성화 시키는 메서드
  bool _predicate(DateTime day) {
    
    /** isAfter() 와 isBefore()를 통해 활성화 할 날짜의 범위를 설정할 수 있다.
     * 단, 오늘 날짜가 포함된 범위로 지정해야 문제없이 앱을 실행할 수 있다. */
    // if ((day.isAfter(DateTime(2025, 7, 1)) &&
    //   day.isBefore(DateTime(2025, 7, 9)))) {
    //  return true; // 활성화시킴
    // }

    // 토, 일요일은 비활성화시키는 코드
    // if (day.weekday != 6 && day.weekday != 7) {
    //   // 매달 25일 비활성화
    //   if (day != DateTime(day.year, day.month, 25)) {
    //     return true;
    //   }
    //   return true;
    // }

    // 매달 1일부터 리스트에 설정된 날짜까지를 비활성화.
    List days = [1,2,3,4,5,6,7];
    if (!days.contains(day.day.toInt())) {
      return true;
    }

    return false;
  }

  Future selectDate() async {
    DateTime _now = DateTime.now();

    DateTime? picked = await showDatePicker(
      context: context, 
      // initialDatePickerMode: DatePickerMode.year,
      // 초기날짜. 메서드를 토해 표시
      initialDate: selectNowDate(),
      // 선택가능한 년도의 시작(2년전)
      firstDate: DateTime(_now.year - 2), 
      // 종료 년도(2년후)
      lastDate: DateTime(_now.year + 2),
      // 달력의 날짜 비활성화 설정(메서드 호출을 통해)
      selectableDayPredicate: _predicate,
      builder: (BuildContext context, Widget? child) {
        return Theme(
          data: ThemeData.light(),
          // data: ThemeData.dark(),
          // data: ThemeData(primarySwatch: Colors.pink), 
          child: child!
        );
      },
    );
    // 날짜를 선택 후 OK를 누를때 표시된 날짜를 변경한다.
    if(picked != null) {
      setState(() {
        _selectedDate = picked.toString().substring(0, 10);
      });
    }
  }
}
