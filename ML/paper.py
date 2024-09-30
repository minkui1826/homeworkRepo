# selenium의 webdriver를 사용하기 위한 import
from selenium import webdriver

# selenium으로 키를 조작하기 위한 import
from selenium.webdriver.common.keys import Keys

# 페이지 로딩을 기다리는데에 사용할 time 모듈 import
import time
from selenium.webdriver.common.by import By

# 크롬드라이버 실행
driver = webdriver.Chrome() 

#크롬 드라이버에 url 주소 넣고 실행
driver.get('https://scholar.google.co.kr/citations?view_op=top_venues&hl=ko&vq=eng_artificialintelligence')
name_list = []
# 페이지가 완전히 로딩되도록 3초동안 기다림
time.sleep(3)
for num in range(2,21):
    driver.find_element(By.CSS_SELECTOR,"#gsc_mvt_table > tbody > tr:nth-child("+str(num)+") > td:nth-child(3) > a").click()
    time.sleep(1)
    for i in range(2,22):
        name = driver.find_element(By.CSS_SELECTOR,"#gsc_mpat_table > tbody > tr:nth-child("+str(i)+") > td.gsc_mpat_t > div.gsc_mpat_ttl").text
        name_list.append(name)
    driver.back()
print(name_list)