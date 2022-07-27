from tkinter import ANCHOR
from django.shortcuts import get_object_or_404, redirect, render, resolve_url
from django.contrib.auth.decorators import login_required
from django.utils import timezone
from django.contrib import messages

from ..models import Question, Answer
from ..forms import AnswerForm

# 로그인 여부 확인 Annotation
@login_required(login_url="common:login")
def answer_create(request, question_id):
    """
    답변 등록 작업
    """
    q = Question.objects.get(id=question_id)
    if request.method == "POST":
        form = AnswerForm(request.POST)
        if form.is_valid():
            answer = form.save(commit=False)
            answer.question = q
            # 현재 로그인 사용자 ( 작성자 ) : request.user
            answer.author_id = request.user.id
            answer.save()
            # return redirect("board:detail", question_id=q.id)

            # http://127.0.0.1:8000/board/305#answer_14
            # anchor 적용 : detail 에서 특정 영역 보여주기
            # resolve_url() : 실제 호출되는 URL 을 문자열로 반환
            return redirect(
                "{}#answer_{}".format(
                    resolve_url("board:detail", question_id=q.id), answer.id
                )
            )
    else:
        form = AnswerForm()
    context = {"question": q, "form": form}
    return render(request, "board/question_detail.html", context)
    # Model 폼 사용 X
    # a = Answer(question=q, content=request.POST.get("content"))
    # a.save()
    # return redirect("/board/{}".format(question_id), question_id=question_id)


@login_required(login_url="common:login")
def answer_modify(request, answer_id):
    """
    답변 수정 - 원본 내용 찾은 후 수정
    """
    answer = get_object_or_404(Answer, pk=answer_id)
    if request.user != answer.author:
        messages.error(request, "수정할 권한이 없습니다.")
        return redirect("board:detail", question_id=answer.question.id)

    if request.method == "POST":
        form = AnswerForm(request.POST, instance=answer)
        if form.is_valid():
            answer_form = form.save(commit=False)
            answer_form.modify_date = timezone.now()
            answer_form.save()
            # return redirect("board:detail", question_id=answer.question.id)

            return redirect(
                "{}#answer_{}".format(
                    resolve_url("board:detail", question_id=answer.question.id), answer.id
                )
            )
    else:
        form = AnswerForm(instance=answer)
    return render(request, "board/answer_form.html", {"form": form})


@login_required(login_url="common:login")
def answer_delete(request, answer_id):
    answer = get_object_or_404(Answer, pk=answer_id)

    if request.user != answer.author:
        messages.error(request, "삭제할 권한이 없습니다.")
        return redirect("board:detail", question_id=answer.question.id)
    answer.delete()
    return redirect("board:detail", question_id=answer.question.id)
