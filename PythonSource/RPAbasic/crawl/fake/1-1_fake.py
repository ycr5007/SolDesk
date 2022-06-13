from urllib.request import Request, urlopen
from fake_useragent import UserAgent

url = "https://n.news.naver.com/mnews/article/001/0013237407?sid=000000"
try:

    user_agent = UserAgent()
    headers = {"user-agent": user_agent.chrome}

    request_url = Request(url, headers=headers)
    res = urlopen(request_url).read().decode("UTF-8")
    print(res)
    print(request_url.header_items())
    # [('Host', 'n.news.naver.com'), ('User-agent', 'Python-urllib/3.10')]
    # User-agent : Python-rullib/3.10 >> 서버쪽에서는 어떤 경로로 요청이 들어왔는지 확인 가능
    # 크롤링 과정에서 일부 페이지는 보안 차원에서 비정상적인 경로로 요청이 들어온 경우 block 하는 경우가 있음
except Exception as e:
    print(e)

# 서버측으로 전송되는 User-agent 정보를 직접 제작해서 보낼 수 있는 라이브러리 ( fake-useragent )
# pip install fake-useragent

# fake_useragent 적용
# [('Host', 'n.news.naver.com'), ('User-agent', 'Mozilla/5.0 (Windows NT 4.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2049.0 Safari/537.36')]

# 페이지 Network 탭 확인 ( Chrome )
# [('Host', 'n.news.naver.com'), ('User-agent', 'Mozilla/5.0 (Windows NT 4.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2049.0 Safari/537.36')]
