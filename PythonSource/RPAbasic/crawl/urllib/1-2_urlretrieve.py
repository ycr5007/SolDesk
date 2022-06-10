import urllib.request as req

# 이미지, html 파일 다운로드

img_url = "https://search.pstatic.net/sunny/?src=http%3A%2F%2Ffile3.instiz.net%2Fdata%2Fcached_img%2Fupload%2F2022%2F02%2F07%2F2%2F1c86a8725c637c11daa53f24494eb936.jpg&type=a340"
file_url = "https://www.naver.com"

# 다운받을 경로
path = "./RPAbasic/crawl/download/"

try:
    file1, header1 = req.urlretrieve(img_url, path + "MAGUNI.png")
    file2, header2 = req.urlretrieve(file_url, path + "naver.html")
except Exception as e:
    print(e)
else:
    print(header1)
    print()
    print(header2)
