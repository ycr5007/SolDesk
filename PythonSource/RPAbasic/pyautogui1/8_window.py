import pyautogui as p

# getActiveWindow()
# w = p.getActiveWindow()
# <Win32Window left="-9", top="-9", width="1938", height="1048", title="8_window.py - PythonSource - Visual Studio Code [관리자]">
# print(w)
# print(w.title)
# print(w.size)
# p.click(1913, w.top + 20)

# getAllWindows() : 현재 윈도우에 떠 있는 모든 창 가져오기
# for w in p.getAllWindows():
#     print(w)

# getWindowsWithTitle() : 특정 타이틀을 가진 창 모두 가져오기
w = p.getWindowsWithTitle("제목 없음")[0]
# 창 활성화 여부
if not w.isActive:
    w.activate()

# 창 최대화 여부
if not w.isMaximized:
    w.maximize()

p.sleep(1)

# 창 내리기 여부
if not w.isMinimized:
    w.minimize()

# 창 닫기
p.sleep(1)
w.close()
