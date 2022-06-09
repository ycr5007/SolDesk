# 함수 삽입
from openpyxl import load_workbook
from datetime import datetime

wb = load_workbook("./RPAbasic/excel/formula.xlsx", data_only=True)
# data_only : 함수를 제외하고 데이터만 출력 여부
ws = wb.active

for row in ws.values:
    for cell in row:
        print(cell)
