from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

# pip install webdriver-manager


def set_chrome_driver():
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
    return driver


if __name__ == "__main__":
    driver = set_chrome_driver()
    driver.get("https://www.naver.com")
