# 이미지 삽입
from openpyxl import Workbook
from openpyxl.drawing.image import Image

wb = Workbook()
ws = wb.active

img = Image("./RPAbasic/excel/Image.jpg")

ws.add_image(img, "C3")
# Image 관련 작업 위해 Install 필요 ( ImportError: You must install Pillow to fetch image objects )
# pip install Pillow
wb.save("./RPAbasic/excel/image.xlsx")
