import urllib.request as req

target_url = [
    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA1MjZfOTgg%2FMDAxNjUzNTU1MTgyNjQ0.AsNU_3zUeZnTfhbfbmuvJSML-QC_xfByPAke-JJcdEYg.5AaJyDonSP5gYXZ6XDtoNv8Wkh2NjHTNDXRN8GwchnAg.PNG.aloefujm44%2F20220526-175256-004.png&type=a340",
    "https://www.naver.com",
]

# 다운로드 받을 경로
path_list = [
    "./RPAbasic/crawl/download/cat.png",
    "./RPAbasic/crawl/download/naver.html",
]

for i, url in enumerate(target_url):

    try:
        res = req.urlopen(url)
        contents = res.read()
        print("==============================================")
        print("Header info-{} : {}".format(i, res.info()))
        print("http status : {}".format(res.getcode()))
        print("==============================================")

        with open(path_list[i], "wb") as c:
            c.write(contents)
    except Exception as e:
        print(e)
    else:
        print("SUCCESS")
