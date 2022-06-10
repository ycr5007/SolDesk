# 이미지 인식

from socket import timeout
import pyautogui as p

# confidence : 신뢰도 ( default : 1, 0.8 ~ 0.9 로 설정 ) - opencv-python 라이브러리 설치 필요

# locateOnScreen(path, confidence) : 캡쳐한 이미지(png)의 화면상 좌표 구하기 ( 이미지 구분하여, 좌표값 반환 )
# 이미지 기반이어서 해상도가 바뀐다거나 이런 경우는 잘 안될 수 있음
# 이미지 파일명은 반드시 영문명으로 작성해야한다.

# screen_locate = p.locateOnScreen("./RPAbasic/pyautogui1/screen.png")
# print(screen_locate)

# screen_locate = p.locateOnScreen("./RPAbasic/pyautogui1/file_menu.png", confidence=0.9)
# print(screen_locate)  # Box(left=44, top=0, width=67, height=33)

# p.click(screen_locate)


# locateAllOnScreen(path, confidence) : 찾는 이미지가 여러개 있는 경우
# screen_locate = p.locateAllOnScreen(
#     "./RPAbasic/pyautogui1/checkbox.png", confidence=0.9
# )

# p.sleep(3)
# <generator object _locateAll_opencv at 0x0000025485F01EE0>
# print(screen_locate)

# for pos in screen_locate:
#     # print(pos)
#     p.click(pos, duration=0.5)

# https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_checkbox ( 테스트 페이지 )

# Box(left=977, top=418, width=21, height=23)
# Box(left=977, top=445, width=21, height=23)
# Box(left=977, top=472, width=21, height=23)


# 찾아야 하는 대상이 화면에 늦게 나타나는 경우

# 시간에 제한 두기 ( 일정한 시간 기다려도 발견이 안될 경우 처리 )
import time, sys

start = time.time()

timeout = 10

file_menu = p.locateOnScreen("./RPAbasic/pyautogui1/file_menu.png", confidence=0.9)
# 검색한 이미지 결과가 나올 때까지 반복 ( 화면 변화 감지 )
while file_menu is None:
    file_menu = p.locateOnScreen("./RPAbasic/pyautogui1/file_menu.png", confidence=0.9)
    print("발견할 수 없음")
    end = time.time()

    if end - start > timeout:
        print("시간이 초과되었습니다.")
        sys.exit()

p.click(file_menu)
