// Flutter에서 Material 디자인 컴포넌트들을 사용하려면 반드시 import해야 함.
import 'package:flutter/material.dart';
import 'dart:convert';    // for jsonDecode
import 'package:xml2json/xml2json.dart';

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
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              child: const Text(
                'JSON Parsing',
                style: TextStyle(fontSize: 24),
              ),
              onPressed: () {
                getJsonData();
              },
            ),
            SizedBox(height: 30,),
            ElevatedButton(
              child: const Text(
                'XML Parsing',
                style: TextStyle(fontSize: 24),
              ),
              onPressed: () {
                getXMLData();
              },
            ),
            SizedBox(height: 30,),
            ElevatedButton(
              child: const Text(
                'Covid19 공공데이터 파싱',
                style: TextStyle(fontSize: 24),
              ),
              onPressed: () {
                covid19XMLData();
              },
            ),
          ],
        ),
      ),
    );
  }

  // Json 데이터 파싱
  void getJsonData() {
    String json = '''
{"items": {"item":
            [{"id": "1", "name": "홍길동"},
             {"id": "2", "name": "전우치"},
             {"id": "3", "name": "손오공"}]
          }           
}                  
''';
    // Json 최초 파싱
    var data1 = jsonDecode(json);
    print(data1);


    // 객체이므로 key값으로 접근
    List data2 = data1['items']['item'];
    print(data2);

    print('===============================');
    // 일반 for문으로 배열의 크기만큼 반복
    for(int i=0; i<data2.length; i++){
      print(data2[i]['id']);
    }
    print('===============================');
    // 개선된 for문으로 접근
    for(var item in data2){
      print(item['name']);
    }
  }

  // xml2json: 의존성 추가
  void getXMLData() {
    String xmlData = '''
<items>
  <item>
    <id>1</id>
    <name>홍길동</name>
  </item>
  <item>
    <id>2</id>
    <name>전우치</name>
  </item>
  <item>
    <id>3</id>
    <name>손오공</name>
  </item>
</items>
''';
    // XML을 Json으로 변환 후 파싱을 진행한다.
    Xml2Json xml2json = Xml2Json();   // 객체생성
    xml2json.parse(xmlData);          // 1차 파싱 
    var json = xml2json.toParker();   // JSON으로 변환
    print(json);

    var data1 = jsonDecode(json);
    print(data1);

    List data2 = data1['items']['item'];
    print(data2);

    print('===============================');
    for(int i=0; i<data2.length; i++){
      print(data2[i]['id']);
    }
    print('===============================');
    for(var item in data2){
      print(item['name']);
    }
  }

  void covid19XMLData() {
    String xmlData = '''
<response>
  <header>
    <resultCode>00</resultCode>
    <resultMsg>NORMAL SERVICE.</resultMsg>
  </header>
  <body>
    <items>
      <item>
        <createDt>2022-04-08 09:06:47.712</createDt>
        <deathCnt>18754</deathCnt>
        <decideCnt>14983694</decideCnt>
        <seq>843</seq>
        <stateDt>20220408</stateDt>
        <stateTime>00:00</stateTime>
        <updateDt>null</updateDt>
      </item>
      <item>
        <createDt>2022-04-07 09:05:52.46</createDt>
        <deathCnt>18381</deathCnt>
        <decideCnt>14778361</decideCnt>
        <seq>842</seq>
        <stateDt>20220407</stateDt>
        <stateTime>00:00</stateTime>
        <updateDt>2022-04-08 09:07:09.65</updateDt>
      </item>
      <item>
        <createDt>2022-04-06 09:07:21.018</createDt>
        <deathCnt>18033</deathCnt>
        <decideCnt>14553541</decideCnt>
        <seq>841</seq>
        <stateDt>20220406</stateDt>
        <stateTime>00:00</stateTime>
        <updateDt>2022-04-08 09:07:22.821</updateDt>
      </item>
      <item>
        <createDt>2022-04-05 09:05:37.473</createDt>
        <deathCnt>17662</deathCnt>
        <decideCnt>14267254</decideCnt>
        <seq>840</seq>
        <stateDt>20220405</stateDt>
        <stateTime>00:00</stateTime>
        <updateDt>2022-04-08 09:07:48.8</updateDt>
      </item>
      <item>
        <createDt>2022-04-04 09:03:19.219</createDt>
        <deathCnt>17453</deathCnt>
        <decideCnt>14001148</decideCnt>
        <seq>839</seq>
        <stateDt>20220404</stateDt>
        <stateTime>00:00</stateTime>
        <updateDt>2022-04-08 09:08:13.24</updateDt>
      </item>
      <item>
        <createDt>2022-04-03 09:11:21.229</createDt>
        <deathCnt>17235</deathCnt>
        <decideCnt>13873981</decideCnt>
        <seq>837</seq>
        <stateDt>20220403</stateDt>
        <stateTime>00:00</stateTime>
        <updateDt>2022-04-08 09:08:29.365</updateDt>
      </item>
      <item>
        <createDt>2022-04-02 09:27:09.919</createDt>
        <deathCnt>16929</deathCnt>
        <decideCnt>13639715</decideCnt>
        <seq>836</seq>
        <stateDt>20220402</stateDt>
        <stateTime>00:00</stateTime>
        <updateDt>2022-04-08 09:08:47.784</updateDt>
      </item>
      <item>
        <createDt>2022-04-01 09:04:54.638</createDt>
        <deathCnt>16590</deathCnt>
        <decideCnt>13375568</decideCnt>
        <seq>835</seq>
        <stateDt>20220401</stateDt>
        <stateTime>00:00</stateTime>
        <updateDt>2022-04-08 09:09:14.895</updateDt>
      </item>
    </items>
    <numOfRows>10</numOfRows>
    <pageNo>1</pageNo>
    <totalCount>8</totalCount>
  </body>
</response>
''';

    Xml2Json xml2json = Xml2Json();   // 객체생성
    xml2json.parse(xmlData);          // 1차 파싱 
    var json = xml2json.toParker();   // JSON으로 변환

    var data1 = jsonDecode(json);

    List data2 = data1['response']['body']['items']['item'];
  
    // print('===============================');
    // print('날짜 - 누적확진자 - 누적사망자');
    // for(int i=0; i<data2.length; i++){
    //   // print(data2[i]['createDt']);
    //   print('${data2[i]['createDt']}  ${data2[i]['decideCnt']}  ${data2[i]['deathCnt']}');
    // }

    print('===============================');
    print('날짜 - 누적확진자 - 누적사망자');
    for(var item in data2){
      String createDt = item['createDt'].substring(0,10);
      print('${createDt} - ${item['decideCnt']}명 - ${item['deathCnt']}명');
    }
  }
}
