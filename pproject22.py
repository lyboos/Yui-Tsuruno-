from selenium import webdriver
import time
import os
# “http://wenshu.court.gov.cn/down/one?docId=” + docID地址
# bro = webdriver.Chrome()
path=os.getcwd()
bro=webdriver.Firefox(executable_path=os.path.join(path,'geckodriver'))
# 打开网页
bro.get('https://wenshu.court.gov.cn/')

# 最大化窗口
bro.maximize_window()
time.sleep(6)
bro.refresh()

# 点击登录按钮
login_tag = bro.find_element_by_xpath('//*[@id="loginLi"]/a')

# 执行点击命令
time.sleep(5)
login_tag.click()
time.sleep(5)
bro.refresh()

# 切换到iframe登录窗
time.sleep(10)
bro.switch_to.frame("contentIframe")
options = webdriver.FirefoxOptions()
prefs = {"profile.managed_default_content_settings.images": 2}
options.add_experimental_option("prefs", prefs)
# 定位 手机号，密码，登录按钮位置
username_path = bro.find_element_by_xpath('//*[@class="phone-number-input"]')
password_path = bro.find_element_by_xpath('//*[@class="password"]')
login_in = bro.find_element_by_xpath('//*[@id="root"]/div/form/div/div[3]/span')
time.sleep(3)
username_path.send_keys()
time.sleep(3)
password_path.send_keys()
login_in.click()
