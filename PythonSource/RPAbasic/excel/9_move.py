from openpyxl import load_workbook

wb = load_workbook("./RPAbasic/excel/range.xlsx")
ws = wb.active

# 셀 이동
# 행 : 변화 X, 열 : 1칸 오른쪽으로 이동 ( - 는 왼쪽/위쪽으로 이동 )
ws.move_range("B1:C11", rows=0, cols=1)


wb.save("./RPAbasic/excel/range_move.xlsx")
