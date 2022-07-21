# config 안의 urls.py 를 통해 request 처리
# App 별로 urls.py 를 만들어, App 별로 나누어 reqeust 관리

from django.urls import path
from . import views

urlpatterns = [
    # Default Path : "Application Name"
    # http://127.0.0.1:8000/todo 로 요청이 들어오면 어느 views 로 연동시킬 함수 지정
    # name = : url 하드코딩 부분의 축소
    path("", views.todo_list, name="todo_list"),
    path("<int:pk>/", views.todo_detail, name="todo_detail"),
    path("new/", views.todo_register, name="todo_register"),
    path("<int:pk>/edit/", views.todo_edit, name="todo_edit"),
    path("<int:pk>/done/", views.todo_done, name="todo_done"),
    path("done/", views.done_list, name="done_list"),
]
