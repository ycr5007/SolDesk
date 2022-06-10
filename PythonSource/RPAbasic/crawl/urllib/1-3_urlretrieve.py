import urllib.request as req

img_url = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAyMTRfMjk2%2FMDAxNjEzMjY0MjA3MjQ5.FSzpbqwKEzqyW2vyT4MspJZ0tZzpVp9X7q0x26HWYV0g.k8p1_DkZ8MCCniq6_vYpvuDqeqA5BmJ5EU1xL5tYki4g.JPEG.agent05%2F%253F%258B%25A4%253F%259A%25B4%25EB%25A1%259C%25EB%2593%259C.jpeg.jpg&type=a340"

path = "./RPAbasic/crawl/download/"

try:
    img, header = req.urlretrieve(img_url, path + "OGU.png")
except Exception as e:
    print(e)
else:
    print(header)
