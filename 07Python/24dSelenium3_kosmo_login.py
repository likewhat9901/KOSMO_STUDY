#셀레니움 모듈과 드라이버 로드
from selenium import webdriver
from selenium.webdriver.common.by import By
import time


#셀레니움의 크롬 드라이버 로드
driver = webdriver.Chrome()

#다음 접속
url = 'https://www.ikosmo.co.kr/main'
driver.get(url)


driver.find_element(By.XPATH, '//*[@id="header"]/div[1]/div/ul/li[1]/a').click()
time.sleep(2)
driver.find_element(By.XPATH, '//*[@id="subConts"]/div/div/div/div/section/section/form/fieldset/div[3]/ul/li[2]/a').click()
time.sleep(2)


driver.find_element(By.NAME, 'id').send_keys('likewhat9901')
time.sleep(2)
driver.find_element(By.NAME, 'pw').send_keys('')
time.sleep(2)
#입력을 마친 후 로그인 버튼을 클릭한다.
driver.find_element(By.XPATH, '//*[@id="log.login"]').click()
time.sleep(2)
driver.find_element(By.NAME, 'pw').send_keys('')
time.sleep(30)

time.sleep(10)