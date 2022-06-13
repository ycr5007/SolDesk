# requests 라이브러리 :: pip install requests

# urllib 라이브러리보다 간단한 방법으로 request 처리
# Decoding 기본 처리
# json 처리 간편

import requests

# get 방식
res = requests.get("http://www.naver.com")

# 응답 확인
print(res.text)  # HTML 소스

# 응답 상태
print(res.status_code)  # 200

print(res.ok)  # True ( 정상접근 )
