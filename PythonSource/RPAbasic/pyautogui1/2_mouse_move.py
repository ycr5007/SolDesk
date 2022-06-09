import pyautogui

# 좌표인식 :: position()

# pos = pyautogui.position()
# print(pos)
# print(pos.x, ", ", pos.y)


# 마우스 이동 :: moveTo(pos_x, pos_y, 시간) > 절대좌표 / moveRel(pos_x, pos_y, 시간) > 상대좌표 ( move 같음 )

# pyautogui.moveTo(100, 100, duration=1)
# pyautogui.moveTo(300, 300, duration=1)
# pyautogui.moveTo(100, 100, duration=1)

pyautogui.moveTo(300, 300, duration=1)
pyautogui.moveRel(100, 100, duration=0.5)
