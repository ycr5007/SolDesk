from django.shortcuts import get_object_or_404, redirect, render
from django.contrib.auth.decorators import login_required
from django.utils import timezone
from django.contrib import messages

from ..models import Question
from ..forms import QuestionForm


@login_required(login_url="common:login")
def question_create(request):
    if request.method == "POST":
        form = QuestionForm(request.POST)
        if form.is_valid():
            question = form.save(commit=False)
            # 현재 로그인 사용자 ( 작성자 ) : request.user
            question.author_id = request.user.id
            question.save()
            return redirect("board:index")
    else:
        form = QuestionForm()
    return render(request, "board/question_form.html", {"form": form})


@login_required(login_url="common:login")
def question_modify(request, question_id):
    """
    질문 수정 ( 원본내용 보여준 후 수정 )
    """
    question = get_object_or_404(Question, pk=question_id)

    if request.user != question.author:
        # non_field_errors : mesaage 전달
        messages.error(request, "수정할 권한이 없습니다.")
        return redirect("board:detail", question_id=question_id)
    if request.method == "POST":
        form = QuestionForm(request.POST, instance=question)
        if form.is_valid():
            ques_form = form.save(commit=False)
            ques_form.modify_date = timezone.now()
            ques_form.save()
            return redirect("board:detail", question_id=question_id)
    else:
        form = QuestionForm(instance=question)
    return render(request, "board/question_form.html", {"form": form})


@login_required(login_url="common:login")
def question_delete(request, question_id):
    """
    질문 삭제
    """
    question = get_object_or_404(Question, pk=question_id)

    if request.user != question.author:
        messages.error(request, "삭제할 권한이 없습니다.")
        return redirect("board:detail", question_id=question_id)
    question.delete()
    return redirect("board:index")
