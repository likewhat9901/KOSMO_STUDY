import requests
from bs4 import BeautifulSoup

# KBO 타자기록실
response = requests.get("https://www.koreabaseball.com/Record/Player/HitterBasic/BasicOld.aspx?sort=HRA_RT")
# HTML 소스 저장
html = response.text
# Soup 객체로 저장
soup = BeautifulSoup(html, 'html.parser')
# print(soup)

# 타이틀 크롤링 : HTML태그 포함
title = soup.select_one("#contents > h4")
# print("title 요소 :", title)

# 태그를 제거하여 순수한 텍스트만 추출
title_txt = title.get_text()
print("title 텍스트 :", title_txt)

# 타자기록이 있는 <table> 태그 전체를 얻어오기
record_table = soup.select_one('#cphContents_cphContents_cphContents_udpContent > div.record_result > table')
# print("타자기록 요소 :", record_table)

record_th = soup.select_one('#cphContents_cphContents_cphContents_udpContent > div.record_result > table > thead')
repeat_th = record_th.select('tr')
for rec in repeat_th:
  d1 = rec.select_one('th:nth-child(1)').get_text() # 순위
  d2 = rec.select_one('th:nth-child(2)').get_text() # 선수명
  d3 = rec.select_one('th:nth-child(3)').get_text() # 팀명
  d4 = rec.select_one('th:nth-child(4)').get_text() # AVG(타율)
  d5 = rec.select_one('th:nth-child(5)').get_text() # G(경기)
  d6 = rec.select_one('th:nth-child(6)').get_text() # PA(타석)
  d7 = rec.select_one('th:nth-child(7)').get_text() # AB(타수)
  d8 = rec.select_one('th:nth-child(8)').get_text() # H(안타)
  d9 = rec.select_one('th:nth-child(9)').get_text() # 2B(2루타)
  d10 = rec.select_one('th:nth-child(10)').get_text() # 3B(3루타)
  
  d11 = rec.select_one('th:nth-child(11)').get_text() # HR(홈런)
  d12 = rec.select_one('th:nth-child(12)').get_text() # RBI(타점)
  d13 = rec.select_one('th:nth-child(13)').get_text() # SB(도루)
  d14 = rec.select_one('th:nth-child(14)').get_text() # CS(도루실패)
  d15 = rec.select_one('th:nth-child(15)').get_text() # BB(볼넷)
  d16 = rec.select_one('th:nth-child(16)').get_text() # HBP(사구)
  d17 = rec.select_one('th:nth-child(17)').get_text() # SO(삼진)
  d18 = rec.select_one('th:nth-child(18)').get_text() # GDP(병살타)
  d19 = rec.select_one('th:nth-child(19)').get_text() # E(실책)
  
  print(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d15, d16, d17, d18, d19)

# 타자 기록이 반복되어 출력되는 <tbody>를 얻어온 후 <tr>의 개수만큼 반복출력
record_tr = soup.select_one('#cphContents_cphContents_cphContents_udpContent > div.record_result > table > tbody')
repeat_tr = record_tr.select('tr')
# print('순위, 선수명, 팀명, AVG(타율), G(경기), PA(타석), AB(타수), H(안타), 2B(2루타), 3B(3루타), HR(홈런), RBI(타점), SB(도루), CS(도루실패), BB(볼넷), HBP(사구), SO(삼진), GDP(병살타), E(실책)')

for rec in repeat_tr:
  # print("dddd", rec)
  
  d1 = rec.select_one('td:nth-child(1)').get_text() # 순위
  d2 = rec.select_one('td:nth-child(2)').get_text() # 선수명
  d3 = rec.select_one('td:nth-child(3)').get_text() # 팀명
  d4 = rec.select_one('td:nth-child(4)').get_text() # AVG(타율)
  d5 = rec.select_one('td:nth-child(5)').get_text() # G(경기)
  d6 = rec.select_one('td:nth-child(6)').get_text() # PA(타석)
  d7 = rec.select_one('td:nth-child(7)').get_text() # AB(타수)
  d8 = rec.select_one('td:nth-child(8)').get_text() # H(안타)
  d9 = rec.select_one('td:nth-child(9)').get_text() # 2B(2루타)
  d10 = rec.select_one('td:nth-child(10)').get_text() # 3B(3루타)
  
  d11 = rec.select_one('td:nth-child(11)').get_text() # HR(홈런)
  d12 = rec.select_one('td:nth-child(12)').get_text() # RBI(타점)
  d13 = rec.select_one('td:nth-child(13)').get_text() # SB(도루)
  d14 = rec.select_one('td:nth-child(14)').get_text() # CS(도루실패)
  d15 = rec.select_one('td:nth-child(15)').get_text() # BB(볼넷)
  d16 = rec.select_one('td:nth-child(16)').get_text() # HBP(사구)
  d17 = rec.select_one('td:nth-child(17)').get_text() # SO(삼진)
  d18 = rec.select_one('td:nth-child(18)').get_text() # GDP(병살타)
  d19 = rec.select_one('td:nth-child(19)').get_text() # E(실책)

  # 출력
  print(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d15, d16, d17, d18, d19)
  # DB입력