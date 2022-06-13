from fake_useragent import UserAgent
from urllib.request import urlopen

userAgent = UserAgent()
print("ie :: ", userAgent.ie)
print("msie :: ", userAgent.msie)
print("chrome :: ", userAgent.chrome)
print("safari :: ", userAgent.safari)
print("opera :: ", userAgent.opera)
print("firefox :: ", userAgent.firefox)
print("random :: ", userAgent.random)

"""
    ie ::  Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; Media Center PC 6.0; InfoPath.3; MS-RTC LM 8; Zune 4.7)
    msie ::  Mozilla/5.0 (compatible; MSIE 10.0; Macintosh; Intel Mac OS X 10_7_3; Trident/6.0)
    chrome ::  Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36
    safari ::  Mozilla/5.0 (Windows; U; Windows NT 6.1; fr-FR) AppleWebKit/533.20.25 (KHTML, like Gecko) Version/5.0.4 Safari/533.20.27
    opera ::  Opera/9.80 (X11; Linux x86_64; U; fr) Presto/2.9.168 Version/11.50
    firefox ::  Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20130331 Firefox/21.0
    random ::  Mozilla/5.0 (Windows NT 6.4; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2225.0 Safari/537.36
"""
