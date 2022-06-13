import requests

url = "https://api.github.com/events"

res = requests.get(url, timeout=0.001)
# timeout= :: 웹 페이지를 접근하는데, timeout Exception 발생 시점 지정 ( 시간 제한 )

# requests.exceptions.ConnectTimeout: HTTPSConnectionPool(host='api.github.com', port=443):
# Max retries exceeded with url: /events (Caused by ConnectTimeoutError(<urllib3.connection.HTTPSConnection object at 0x0000020A2295DAE0>,
#  'Connection to api.github.com timed out. (connect timeout=0.001)'))
print(res.text)
