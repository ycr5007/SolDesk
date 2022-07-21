"""config URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.0/topics/http/urls/
Examples:
① Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
② Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
③ Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from . import views
from django.urls import path

urlpatterns = [
    # APP 이 갖고 있는 views.py 의 폴더내 함수 지정
    # ① 번 방식
    path("", views.photo_list, name="photo_list"),  # 전체 리스트
    path("<int:pk>/", views.photo_detail, name="photo_detail"),
    # 게시물 상세 ( 각각의 PK 값으로 세부 페이지 )
    path("new/", views.photo_post, name="photo_post"),  # 새 글 작성
    path("<int:pk>/edit/", views.photo_edit, name="photo_edit"),  # 글 수정
    path("<int:pk>/remove/", views.photo_remove, name="photo_remove"),  # 글 수정
]
# <type:name>/ : type 과 매개변수로 쿼리스트링에 담을 name 값에 해당 type 을 지정해 받아온다
