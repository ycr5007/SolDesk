from django.contrib import admin
from .models import Question

# Register your models here.

# Admin 페이지에서 Question 모델을 관리할 수 있도록 등록
admin.site.register(Question)
