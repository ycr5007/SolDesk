import urllib.request as req

try:
    url = "https://www.11st.co.kr/browsing/BestSeller.tmall?method=getBestSellerMain&xfrom=main^gnb"
    res = req.urlopen(url)
    # 국내 페이지 ( UTF-8 적용 안된 페이지 多 -> EUC-KR )
    content = res.read().decode("euc-kr")
except Exception as e:
    print(e)
else:
    print(res)
    print(content[:3000])
