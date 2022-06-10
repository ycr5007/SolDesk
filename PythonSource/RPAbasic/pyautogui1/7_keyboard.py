# 키보드 핸들링
import pyautogui as p

# 입력 : write()

# p.write("write")

# 메모장에 문자열 타이핑
# 현재 화면에 메모장 활성화 ( .getWindowsWithTitle(프로그램 Title)[index] :: 중복된 이름이 있을경우를 대비해 index 값 지정 )

notepad = p.getWindowsWithTitle("제목 없음")[0]
notepad.activate()  # 메모장에 커서가 지정 된 상태 ( 데이터의 가장 끝 )

# p.write("write\n")
# p.write("pyautogui\n")
# p.write("안녕하시구려\n") # 한글 지원 X ( pip install pyperclip )

# import pyperclip  # 클립보드 개념으로 복사 붙여넣기 실행

# pyperclip.copy("\n")
# p.hotkey("ctrl", "v")

# p.write(
#     ["h", "e", "l", "l", "o", "left", "left", "left", "right", "l", "o", "enter"],
#     interval=0.25,
# )

# keyDown(), keyUp()
# p.keyDown("shift")
# p.press("4")
# p.keyUp("shift")

# p.press(["#", "$", "%"], 2, 1)


# hotkey ( 조합키 )
p.hotkey("ctrl","shift","backspace")