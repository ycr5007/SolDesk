# 짝짓기
# ['Tom', 'Jerry', 'Mike']

def make_pair(list):
    size = len(list)
    for i in range(0, size - 1):
        for j in range(i + 1, size):
            print(list[i], "-", list[j])

if __name__ == "__main__":
    make_pair(['Tom', 'Jerry', 'Mike'])