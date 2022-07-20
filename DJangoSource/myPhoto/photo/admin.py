from django.contrib import admin
from .models import Photo  # 현재 APP 의 model 등록

# Register your models here.

admin.site.register(Photo)  # ADMIN 페이지에서 관리할 model 등록 ( 기본 CRUD 작업 가능 ) > DB 반영 可
