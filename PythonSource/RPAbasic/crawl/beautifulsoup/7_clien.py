# clien 팁과강좌 크롤링

import requests
from bs4 import BeautifulSoup

# res = requests.get("https://www.clien.net/service/board/lecture?&od=T31&category=0&po=1")
# soup = BeautifulSoup(res.text, "lxml")

# 게시판 제목 가져오기
# #div_content > div.list_content > div:nth-child(2) > div.list_title > a.list_subject > span.subject_fixed

# title_list = soup.select("a.list_subject > span.subject_fixed")
# for title in title_list:
#     print(title.get_text().strip())

# 1 ~ 5 Page

for i in range(5):
    res = requests.get(
        "https://www.clien.net/service/board/lecture?&od=T31&category=0&po=" + str(i)
    )
    soup = BeautifulSoup(res.text, "lxml")

    print(
        "\n\n=====================================================",
        i + 1,
        "=====================================================\n\n",
    )

    title_list = soup.select("a.list_subject > span.subject_fixed")
    for title in title_list:
        print(title.get_text().strip())
