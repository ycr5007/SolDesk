from .models import Question, Answer, Comment
from django import forms

# Model Form - 모델과 연결
# class Meta 가 반드시 필요


class QuestionForm(forms.ModelForm):
    class Meta:
        model = Question
        fields = ["subject", "content"]

        # Error 메세지 label 명 변경
        labels = {"subject": "제목", "content": "내용"}


class AnswerForm(forms.ModelForm):
    class Meta:
        model = Answer
        fields = ["content"]

        # Error 메세지 label 명 변경
        labels = {"content": "답변 내용"}


class CommentForm(forms.ModelForm):
    class Meta:
        model = Comment
        fields = ["content"]

        # Error 메세지 label 명 변경
        labels = {"content": "댓글 내용"}
