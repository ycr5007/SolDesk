from django.db import models
from django.contrib.auth.models import User

# Create your models here.
class Question(models.Model):
    subject = models.CharField(max_length=200)
    content = models.TextField()
    create_date = models.DateTimeField(auto_now_add=True)
    # 작성자 추가
    author = models.ForeignKey(User, on_delete=models.CASCADE)
    # 수정시간 추가
    modify_date = models.DateTimeField(null=True, blank=True)
    # null=True >> not null : False
    # blank=True >> form.is_valid() 를 통한 유효성 검사 무시

    def __str__(self) -> str:
        return self.subject + " " + self.content


class Answer(models.Model):
    # Answer - Question 테이블 간의 외래키 제약조건 성립
    # on_delete : CASCADA 여부
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    content = models.TextField()
    create_date = models.DateTimeField(auto_now_add=True)
    # 작성자 추가
    author = models.ForeignKey(User, on_delete=models.CASCADE)

    def __str__(self) -> str:
        return str(self.question) + " " + self.content
