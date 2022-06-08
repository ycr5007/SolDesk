# 가짜 동전 찾기
# 겉보기에는 똑같은 동전이 n 개 있다. 이 중에서 한 개는 싸고 가벼운 재료로 만들어진 '가짜 동전'일 때,
# 좌우 무게를 비교할 수 있는 양팔 저울을 이용해서 다른 동전보다 가벼운 가짜 동전 찾아내기
# in : 전체 동전위치의 시작과 끝 / out : 가짜 동전의 위치 번호

# 2 그룹 중 a ~ b 에 가짜 동전이 있다면 -1 Return / c ~ d 에 가짜 동전이 있다면 1 Return / 가짜 동전이 없다면 0 Return


def weight(a, b, c, d):
    # 임의의 fake 동전 위치
    fake = 29
    if a <= fake and fake <= b:
        return -1
    if c <= fake and fake <= d:
        return 1
    return 0


def fakeCoin(left, right):

    if left == right:
        return left

    half = (right - left + 1) // 2

    # 100 개의 동전이 있다고 할 때 0 ~ 49 g1 / 50 ~ 99 g2
    g1_left = left
    g1_right = left + half - 1
    g2_left = left + half
    g2_right = g2_left + half - 1
    result = weight(g1_left, g1_right, g2_left, g2_right)

    if result == -1:
        return fakeCoin(g1_left, g1_right)
    elif result == 1:
        return fakeCoin(g2_left, g2_right)
    else:  # 그룹 안에 가짜동전 없음
        return right


if __name__ == "__main__":
    n = 100
    print(fakeCoin(0, n - 1))
