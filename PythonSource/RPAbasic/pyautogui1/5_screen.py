import pyautogui as p

# 전체화면 캡쳐
# p.screenshot("./RPAbasic/pyautogui1/screen.png")

# img = p.screenshot()
# img.save("./RPAbasic/pyautogui1/screen.png")

p.screenshot("./RPAbasic/pyautogui1/screen.png", region=(0, 0, 300, 400))
# region(st_x, st_y, ed_x, ed_y) : 시작 x , y 에서 끝 x , y 지점까지 캡쳐
