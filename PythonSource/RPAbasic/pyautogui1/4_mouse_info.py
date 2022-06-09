import pyautogui

# 마우스 위치, 색 ... 등의 위치를 확인할 수 있는 Tool
# pyautogui.mouseInfo()

for i in range(10):
    pyautogui.moveTo(100, 100)
    pyautogui.sleep(1)

# 마우스 커서를 모서리로 위치시킬 경우, 에러 발생 후, 프로그램 강제종료
# pyautogui.FailSafeException: PyAutoGUI fail-safe triggered from mouse moving to a corner of the screen. To disable
# this fail-safe, set pyautogui.FAILSAFE to False. DISABLING FAIL-SAFE IS NOT RECOMMENDED.
