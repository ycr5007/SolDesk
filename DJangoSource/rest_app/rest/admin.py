from django.contrib import admin
from .models import Book

# Register your models here.

# Model 을 Admin 페이지에서 볼 때 보고싶은 필드 지정
class BookAdmin(admin.ModelAdmin):
    list_display = ("bid", "title", "author")


admin.site.register(Book, BookAdmin)
