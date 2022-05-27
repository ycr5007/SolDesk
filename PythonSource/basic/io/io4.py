# json 파일 입출력

import json

# data = (
#     '{"id": "hong","language": "python","edition": "3.9","author": "Guido van Rossum"}'
# )


# 문자열을 json 으로 로드
# json_data = json.loads(data)
# print(type(json_data))  # <class 'dict'>
# print(type(data))  # <class 'str'>

# print(json_data["id"], json_data["language"], json_data["edition"], json_data["author"])

# data = {
#     "id": "hong",
#     "language": "python",
#     "edition": "3.9",
#     "author": "Guido van Rossum",
# }

# # json을 문자열로 로드
# json_data = json.dumps(data)
# print(json_data)
# # "{\"id\": \"hong\",\"language\": \"python\",\"edition\": \"3.9\",\"author\": \"Guido van Rossum\"}"
# print(type(json_data))  # <class 'str'>

# data = {
#     "id": "hong",
#     "language": "python",
#     "edition": "3.9",
#     "author": "Guido van Rossum",
# }

# key, value 추가
# data["language"] = ["Java", "Script"]
# with open("data/test1.json", "w") as f:
#     # indent >> Json 파일 생성 시, 보기 편하도록 들여쓰기 처리
#     json.dump(data, f, indent=2)

# with open("data/test1.json", "r") as f:
#     json_data = json.load(f)
#     print(json_data)


# 실습
with open("data/users.json", "r") as f:
    json_data = json.load(f)
    # print(json_data)
    for person in json_data:
        # print(person)
        # print()
        for k, v in person.items():
            print(k, v, sep="\t")
            
