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


# 실습 :: 핵생번호와 이름이 리스트로 주어졌을 때 학생 번호를 입력하면 해당하는 이름을 순차탐색으로 찾아 돌려주는 함수 작성
# 없는 경우, ? 반환
def seq_searchStudent(stu_no, stu_name, key):
    idx = -1
    for i in range(len(stu_no)):
        if stu_no[i] == key:
            idx = i
    if idx >= 0:
        return stu_name[idx]
    else:
        return "?"
        
def seq_searchStudent_answert(stu_no, stu_name, num):
    for idx, no in enumerate(stu_no):
        if no == num:
            return stu_name[idx]
    return "?"

if __name__ == "__main__":
    list = [17, 92, 18, 33, 58, 7, 33, 42]
    print("18 :: ", seq_search(list, 18))
    print("33 :: ", seq_searchList(list, 33))
    print("800 :: ", seq_search(list, 800))

    # 실습
    stu_no = [39, 14, 67, 105]
    stu_name = ["Justin", "John", "Mike", "Summer"]
    print(seq_searchStudent(stu_no, stu_name, 39))
    print(seq_searchStudent(stu_no, stu_name, 67))
    print(seq_searchStudent(stu_no, stu_name, 190))
