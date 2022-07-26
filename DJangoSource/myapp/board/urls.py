from django.urls import path
from .views import base_views, question_views, answer_views, comment_views

# NameSpace 지정
app_name = "board"

urlpatterns = [
    # Question
    path("", base_views.index, name="index"),
    path("<int:question_id>/", base_views.detail, name="detail"),
    path("question/create/", question_views.question_create, name="question_create"),
    path(
        "question/modify/<int:question_id>/",
        question_views.question_modify,
        name="question_modify",
    ),
    path(
        "question/delete/<int:question_id>/",
        question_views.question_delete,
        name="question_delete",
    ),
    # Answer
    path(
        "answer/create/<int:question_id>/",
        answer_views.answer_create,
        name="answer_create",
    ),
    path(
        "answer/modify/<int:answer_id>/",
        answer_views.answer_modify,
        name="answer_modify",
    ),
    path(
        "answer/delete/<int:answer_id>/",
        answer_views.answer_delete,
        name="answer_delete",
    ),
    # Comment
    path(
        "comment/create/<int:question_id>/",
        comment_views.comment_create_question,
        name="comment_create_question",
    ),
    path(
        "comment/modify/<int:comment_id>/",
        comment_views.comment_modify_question,
        name="comment_modify_question",
    ),
    path(
        "comment/delete/<int:comment_id>/",
        comment_views.comment_delete_question,
        name="comment_delete_question",
    ),
    # Reply Comment
    path(
        "comment/answer/create/<int:answer_id>/",
        comment_views.comment_create_answer,
        name="comment_create_answer",
    ),
    path(
        "comment/answer/modify/<int:comment_id>/",
        comment_views.comment_modify_answer,
        name="comment_modify_answer",
    ),
    path(
        "comment/answer/delete/<int:comment_id>/",
        comment_views.comment_delete_answer,
        name="comment_delete_answer",
    ),
]
