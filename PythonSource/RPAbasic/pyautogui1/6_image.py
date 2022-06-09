# 이미지 인식

import pyautogui as p

# locateOnScreen(path, confidence) : 캡쳐한 이미지(png)의 화면상 좌표 구하기 ( 이미지 구분하여, 좌표값 반환 )
# 이미지 기반이어서 해상도가 바뀐다거나 이런 경우는 잘 안될 수 있음
# 이미지 파일명은 반드시 영문명으로 작성해야한다.

# screen_locate = p.locateOnScreen("./RPAbasic/pyautogui1/screen.png")
# print(screen_locate)

screen_locate = p.locateOnScreen("./RPAbasic/pyautogui1/file_menu.png")
# print(screen_locate)  # Box(left=44, top=0, width=67, height=33)

p.click(screen_locate)
