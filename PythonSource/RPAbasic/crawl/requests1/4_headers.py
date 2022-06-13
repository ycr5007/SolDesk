import requests as req
from fake_useragent import UserAgent

headers = {"user-agent": UserAgent().chrome}

url = "https://httpbin.org/get"
res = req.get(url, headers=headers)
print(res.text)
