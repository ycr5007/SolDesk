from openpyxl import load_workbook

wb = load_workbook("./RPAbasic/excel/range.xlsx")
ws = wb.active

# 행 삽입
# ws.insert_rows(8)

# 행의 개수 지정 가능
# .insert_rows(삽입위치, 행 개수)
# ws.insert_rows(8, 5)

# 열 삽입
# ws.insert_cols(2)

# 열의 개수 지정 가능
# .insert_cols(삽입위치, 열 개수)
# ws.insert_cols(2,3)


wb.save("./RPAbasic/excel/range.xlsx")
