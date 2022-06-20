# 다나와 로그인 ( 로그인 페이지 => 로그인 => 메인페이지 => 주문배송 조회)

import requests
from bs4 import BeautifulSoup

# payload ( 서버에 전송하는 데이터 셋 )
login_info = {
    "redirectUrl": "http://www.danawa.com/",
    "loginMemberType": "general",
    "id": "ycr5007",
    "isSaveId": "true",
    "password": "qpxmffpt1!",
}

# request Headers 정보 ( 유입된 페이지 경로, 유입 브라우저 정보 )
headers = {
    "Referer": "https://auth.danawa.com/login?url=http%3A%2F%2Fwww.danawa.com%2F",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36",
}

# 하나의 세션 처리 ( 로그인 정보 및 유지가 필요한 경우 사용 )
with requests.Session() as s:
    # 로그인 시도 ( POST 방식 ) >> post("URL", Form 데이터, Header 정보)
    res = s.post("https://auth.danawa.com/login", login_info, headers=headers)
    #  print(res.text)

    # 주문배송 조회 ( 로그인 후 들어갈 수 있는 페이지 )
    res = s.get("https://buyer.danawa.com/order/Order/orderList", headers=headers)

    soup = BeautifulSoup(res.text, "lxml")

    # 아이디 찾기 ( 쇼핑내역 ID 호출 정보 찾기 )
    user_id = soup.find("p", class_="user")

    if user_id is None:
        # rainse :: 강제 예외처리
        raise Exception("Login 실패, 아이디 또는 비밀번호 확인")

    print(user_id.text)

    # 주문 배송조회 정보
    order_info = soup.find("div", "my_info")
    order_title = order_info.find("h3")
    info_list = order_info.select("li")

    print(order_title.text)

    duration_set = soup.find("div", class_="cal_set")

    date_list = duration_set.select(".input_date", limit=2)
    for info in date_list:
        print(info.get("title"), " : ", info.get("value"))

    # print(info_list)
    for info in info_list:
        print(info.find("span").text.strip(), end="\t")
        print(info.find("strong").text.strip())
