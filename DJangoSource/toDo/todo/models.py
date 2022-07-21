from django.db import models
from django.forms import BooleanField

# Create your models here.

# 데이터베이스 테이블
"""
    todo Table
        title
        description
        created(작성날짜)
        completed(완료여부)
        important(중요도)
"""


class Todo(models.Model):
    title = models.CharField(max_length=50)
    description = models.TextField()
    created = models.DateTimeField(auto_now_add=True)
    completed = models.BooleanField(default=False)
    important = models.BooleanField(default=False)

    def __str__(self) -> str:
        return self.title + " \ " + self.description
