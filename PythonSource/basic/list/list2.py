# Q1 주차장 프로그램 작성
# [조건] : 다음과 같은 메뉴를 제공한다.
#   [1] 자동차 넣기 | [2] 자동차 뺴기 [3] 종료 :
# 사용자 메뉴에서 1 ~ 3 번 사이의 메뉴만 선택할 수 있도록 한다
parking_lot = []
car_name = "A"
# print(ord(car_name))  # 문자열의 ASCII 코드값 반환
# print(chr(65))  # ASCII 코드값을 문자열로 반환
while True:
    user = int(input("[1] 자동차 넣기 | [2] 자동차 뺴기 [3] 종료 : "))

    if user <= 3:
        pass  # 에러 없이 기본 구조를 생성하는데 쓰는 Keyword
        if user == 1:
            if len(parking_lot) < 5:
                parking_lot.append(car_name)
                print("{} 자동차 들어감, 주차장 상태 ==> {}".format(car_name, parking_lot))
                car_name = chr(ord(car_name) + 1)
            else:
                print("주차장 꽉 찼음")
        elif user == 2:
            if len(parking_lot) > 0:
                pop_car = parking_lot.pop()
                print("{} 자동차 나감 주차장 상태 ==> {}".format(pop_car, parking_lot))
                car_name = chr(ord(car_name) - 1)
            else:
                print("빠져나갈 자동차가 없음")
        elif user == 3:
            print("프로그램 종료")
            break
    else:
        print("올바르지 않은 메뉴입니다.")
