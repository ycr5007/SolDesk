import pyautogui

# 마우스 액션 : click, doubleclick, drag and drop, scroll

# Click
# click() : 현재 포인터에서 왼쪽 클릭
# click(pos_x, pos_y) : x, y 좌표에서 왼쪽 클릭

# pyautogui.sleep(3)
# print(pyautogui.position())
# pyautogui.click(84,17, duration=0.5)

# pyautogui.sleep(3)
# pyautogui.click(clicks=5) # n 회 클릭

# 2초 간격으로 오른쪽 버튼 2번 클릭
# pyautogui.click(clicks=2, interval=2, button="right")

# pyautogui.doubleClick(x=487, y=142)

# pyautogui.rightClick()

# mouseDown() / mouseUp()

# pyautogui.moveTo(300, 300)
# pyautogui.mouseDown()
# pyautogui.moveTo(400, 400)
# pyautogui.mouseUp()

# drag() : 상대 좌표 / dragTo() : 절대 좌표
# drag : x 만큼 이동, y 만큼 드래그
# dragTo : 현재 좌표에서 x, y 좌표로 드래그

# pyautogui.drag(776, 569, duration=1)


# scroll(val) : val 이 음수이면 현재 커서에서 아래로 , 양수이면 현재 커서에서 위로 스크롤
pyautogui.scroll(1000)
