from django.urls import path
from .views import *

# Create your models here.
urlpatterns = [
    path("cl/", TodosAPIView.as_view()),
    path("cl/<int:id>/", TodoAPIView.as_view()),
    path("cl/done/", DoneTodosAPIView.as_view()),
    path("cl/done/<int:id>", DoneTodoAPIView.as_view()),
]
