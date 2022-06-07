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
    # 앞으로 처리해야 할 사람들을 Queue(리스트)에 저장
    queue = []
    # 큐에 추가한 사람들 기록
    end = set()

    # name 을 queue, end 추가
    queue.append(name)
    end.add(name)
    # 반복문 : Queue 에 사람이 있을 때 까지
    while queue:
        # Queue 에서 한 사람씩 꺼낸 후, 꺼낸 이름을 출력
        person = queue.pop(0)
        print(person)
        # 꺼낸 이름을 Key 값으로 하여, 아직 Queue 추가되지 않은 사람을 Queue에 추가하고 집합에도 추가
        for p in info[person]:
            if p not in end:
                queue.append(p)
                end.add(p)


if __name__ == "__main__":
    all_friends(friend_info, "Summer")
