# 리스트 안에 특정한 요소가 있는지 검색

# 순차탐색의 장점 : 리스트를 정렬할 필요 없이 탐색이 가능하다

# 순차탐색 ( 복잡도 : O(n) )
def seq_search(list, key):
    for i in range(len(list)):
        if list[i] == key:
            return i
    return -1


def seq_searchList(list, key):
    result = []
    for i in range(len(list)):
        if list[i] == key:
            result.append(i)
    return result


if __name__ == "__main__":
    list = [17, 92, 18, 33, 58, 7, 33, 42]
    print("18 :: ", seq_search(list, 18))
    print("33 :: ", seq_searchList(list, 33))
    print("800 :: ", seq_search(list, 800))
