# 미로찾기 알고리즘

# 미로의 각 위치에 알파벳으로 이름 지정
maze = {
    "a": ["e"],
    "b": ["c", "f"],
    "c": ["b", "d"],
    "d": ["c"],
    "e": ["a", "i"],
    "f": ["b", "g", "j"],
    "g": ["f", "h"],
    "h": ["g", "l"],
    "i": ["e", "m"],
    "j": ["n", "k", "f"],
    "k": ["j", "o"],
    "l": ["p", "h"],
    "m": ["i", "n"],
    "n": ["m", "j"],
    "o": ["k"],
    "p": ["l"],
}


def solve_maze(g, start, end):
    # 앞으로 이동해야 할 이동 경로를 Queue에 저장
    queue = []
    # Queue에 추가한 꼭지점을 집합에 저장(중복 제거)
    done = set()
    # 출발점 Queue와 집합에 추가
    queue.append(start)
    done.add(start)

    # Queue에 경로가 남아있는 동안 반복
    while queue:
        p = queue.pop(0)
        # Queue 에 저장된 이동 경로의 마지막 문자가 현재 처리해야할 꼭지점
        v = p[-1]

        if v == end:
            return p
        for x in g[v]:
            if x not in done:
                queue.append(p + x)
                done.add(x)

    return "미로 탈출 불가"


if __name__ == "__main__":
    print(solve_maze(maze, "a", "p"))
