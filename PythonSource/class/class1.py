# 학생 3명의 정보 저장

# 변수
# studend1_name = "KIM"
# studend1_number = 1
# studend1_grade = 1
# studend1_detail = [{"gender": "male"}, {"score1": 97}, {"score2": 88}]

# studend2_name = "PARK"
# studend2_number = 2
# studend2_grade = 2
# studend2_detail = [{"gender": "female"}, {"score1": 87}, {"score2": 96}]

# studend3_name = "CHOI"
# studend3_number = 3
# studend3_grade = 3
# studend3_detail = [{"gender": "male"}, {"score1": 66}, {"score2": 78}]

# print(
#     "이름 : %s, 학번 : %d, 학년 : %d, 학생정보 : %s"
#     % (studend1_name, studend1_number, studend1_grade, studend1_detail)
# )

# print(
#     "이름 : %s, 학번 : %d, 학년 : %d, 학생정보 : %s"
#     % (studend2_name, studend2_number, studend2_grade, studend2_detail)
# )

# print(
#     "이름 : %s, 학번 : %d, 학년 : %d, 학생정보 : %s"
#     % (studend3_name, studend3_number, studend3_grade, studend3_detail)
# )

# list 형태
student_name_list = ["KIM", "PARK", "CHOI"]
student_number_list = [1, 2, 3]
student_grade_list = [1, 2, 3]
student_detail_list = [
    [{"gender": "male"}, {"score1": 97}, {"score2": 88}],
    [{"gender": "female"}, {"score1": 87}, {"score2": 96}],
    [{"gender": "male"}, {"score1": 66}, {"score2": 78}],
]

del student_name_list[1]
del student_number_list[1]
del student_grade_list[1]
del student_detail_list[1]

for i in range(len(student_name_list)):
    print(student_name_list[i])
    print(student_number_list[i])
    print(student_grade_list[i])
    print(student_detail_list[i])

# class 생성
class Student:  # () 생략 가능 ( 상속의 경우 () 필요 )
    def __init__(self, name, number, grade, details):
        # __init__ : 생성자, self : this 와 같은 개념 ( 클래스를 만들 때 갖고 있는 Property 에 접근하기 위한 변수 )
        self.name = name
        self.number = number
        self.grade = grade
        self.details = details

    def __str__(self):  # toString() 과 같은 개념
        return "name : {}, number : {}, grade : {}, details : {}".format(
            self.name, self.number, self.grade, self.details
        )


student1 = Student("KIM", 1, 1, [{"gender": "male"}, {"score1": 97}, {"score2": 88}])
student2 = Student("PARK", 2, 2, [{"gender": "female"}, {"score1": 87}, {"score2": 96}])
student3 = Student("CHOI", 3, 3, [{"gender": "male"}, {"score1": 66}, {"score2": 78}])
# print(student1)  # <__main__.Student object at 0x000001F290377FD0>
# print(type(student1))  # <class '__main__.Student'>
# print(student1.name)
# print(student1.number)
# print(student1.grade)
# print(student1.details)

print(student1)
print(student2)
print(student3)
