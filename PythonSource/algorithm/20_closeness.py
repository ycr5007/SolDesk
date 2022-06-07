# 친밀도

friend_info = {
    "Summer": ["John", "Justin", "Mike"],
    "John": ["Summer", "Justin"],
    "Justin": ["John", "May", "Mike", "Summer"],
    "Mike": ["Summer", "Justin"],
    "May": ["Justin", "Kim"],
    "Kim": ["May"],
    "Tom": ["Jerry"],
    "Jerry": ["Tom"],
}


def all_friends(info, name):
    queue = []
    end = set()

    # Tuple 구조로 삽입 ( queue = [("Summer", 0), ("Justin", 1)] )
    queue.append((name, 0))
    end.add(name)
    while queue:
        # Tuple 구조로 넘어오는 값을 변수에 대입
        person, d = queue.pop(0)
        print(person, d)
        for p in info[person]:
            if p not in end:
                queue.append((p, d + 1))
                end.add(p)


if __name__ == "__main__":
    all_friends(friend_info, "Summer")
    print()
    all_friends(friend_info, "Jerry")
