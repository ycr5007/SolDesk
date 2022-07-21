from django.db import models

# Create your models here.
class Question(models.Model):
    subject = models.CharField(max_length=200)
    content = models.TextField()
    create_date = models.DateTimeField(auto_now_add=True)

    def __str__(self) -> str:
        return self.subject + " " + self.content


class Answer(models.Model):
    # Answer - Question 테이블 간의 외래키 제약조건 성립
    # on_delete : CASCADA 여부
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    content = models.TextField()
    create_date = models.DateTimeField(auto_now_add=True)

    def __str__(self) -> str:
        return self.question + " " + self.content
