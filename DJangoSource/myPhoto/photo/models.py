from django.db import models

# Create your models here.

# Model : App 의 데이터와 관련된 부분을 다루는 클래스 ( DataBase )
#         데이터베이스에 저장될 데이터의 타입을 정의하고 설정
#         SQL 의 DML 과 관련된 작업

# models.Model 클래스 상속
# models : DJango 의 데이터베이스와 관련된 내용을 미리 작성해 놓은 Tool
#          사용자 정의 Model 작성시 models 모듈에서 제공해 주는 Model 을 상속받아 작성 가능

# models.py : 테이블 정의

#     ↓     > makemigrations : Model에 변경한 내용을 파일로 만들어 주는 작업(python manage.py makemigrations)
#                              APP_DIR/migrations/0001_initial.py 파일 생성
# migrate : 터미널 명령어 (python manage.py migrate)


class Photo(models.Model):

    # CharField : 문자열 ( 길이제한 필요 : max_length )
    # TextField : 문자열 ( 길지제한 X )
    # IntegerField : 정수형
    # DateField : 날짜
    # DateTimeField : 날짜 + 시간
    # FileField : 파일
    # ImageField : 이미지 파일
    #        :
    #        :

    # ForeignKey : 외래 키 지정
    #        :
    #        :

    # OneToOneField : 1:1 관계
    # ManyToManyField : N:M 관계
    #        :
    #        :

    title = models.CharField(max_length=50)
    author = models.CharField(max_length=50)
    image = models.CharField(max_length=200)
    description = models.TextField()
    price = models.IntegerField()

    # toString()
    def __str__(self) -> str:
        return self.title + " " + self.author + " " + self.image + "\n"
