# 동명이인 찾기
# ['Tom', 'Jerry', 'Mike', 'Tom']

# 계산 복잡도 : O(n^2)

# 중복된 이름을 set 구조에 담아 return
def dup_name(list):
    result = set()
    size = len(list)
    for i in range(0, size - 1):
        for j in range(i + 1, size):
            if list[i] == list[j]:
                result.add(list[i])
    return result


def dup_name2(list):
    result = {}
    for name in list:
        if result.get(name) == None:
            result[name] = 0
        else:
            result[name] += 1
    return result


if __name__ == "__main__":
    print(dup_name2(["Tom", "Jerry", "Mike", "Tom"]))
