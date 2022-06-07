# Stack ( 후입선출 LIFO ) 삽입 1 - 2 - 3 - 4 반출 4 - 3 - 2 - 1
# Queue ( 선입선출 FIFO ) 삽입 1 - 2 - 3 - 4 반출 1 - 2 - 3 - 4

# list
# 회문 : 순서대로 읽어도, 거꾸로 읽어도 내용이 같은 낱말이나 문장
# 역삼역, 기러기, 일요일, mom, wow, level ...

# 주어진 문장이 회문인지 아닌지 찾기
# 회문인 경우 True, 아니면 False


def palindrome(str):
    qu = []  # Queue
    st = []  # Stack

    # 받은 문자를 큐와 스택에 담기 ( 알파벳인 경우만 리스트에 담기 )
    for c in str:
        if c.isalpha():
            qu.append(c.lower())
            st.append(c.lower())

    # Queue 와 Stack 에 들어있는 문자를 꺼내면서 비교
    # 큐에 문자가 남아있는 동안 반복
    while qu:
        # pop() : 뒤에서부터 인출
        # pop(n) : n 번째 인출
        if qu.pop(0) != st.pop():
            return False
    return True


# Queue Stack 사용 X, 반복문으로 회문
def palindrome_roof(str):
    # 시작위치 지정
    start = 0
    # 종료위치 지정
    end = len(str) - 1

    while start < end:
        # start 위치에 있는 문자가 알파벳이 아니면 start + 1
        # end 위치에 있는 문자가 알파벳이 아니면 end - 1
        if not str[start].isalpha():
            start += 1
        elif not str[end].isalpha():
            end -= 1
        # start 와 end 위치에 있는 문자 비교 후 반환
        elif str[start].lower() != str[end].lower():
            return False
        else:
            start += 1
            end -= 1

    return True


if __name__ == "__main__":
    print(palindrome("Wow"))
    print(palindrome("Madam, I'm Adam."))
    print(palindrome("Madam, I am Adam."))
    print(palindrome_roof("Wow"))
    print(palindrome_roof("Madam, I'm Adam."))
    print(palindrome_roof("Madam, I am Adam."))
