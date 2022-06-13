import requests as req

url = "https://shoppinghow.kakao.com/siso/p/api/bestRank/dispprodbest?vCateId=GMP&durationDays=30&count=100&_=1654833643780"

res = req.get(url)
# print(res.text)


for idx, item in enumerate(res.json(), 1):
    print("{} 순위 >> 제품명 : {}\n".format(idx, item["product_name"]))
