from django.shortcuts import get_object_or_404, redirect
from django.contrib.auth.decorators import login_required
from django.contrib import messages

from ..models import Question, Answer


@login_required(login_url="common:login")
def vote_question(request, question_id):
    """
    질문 추천
    """
    question = get_object_or_404(Question, pk=question_id)

    if question.author == request.user:
        messages.error(request, "본인글은 추천할 수 없습니다.")
    else:
        try:
            question.voter.get(id=request.user.id)
            messages.error(request, "이미 추천한 글은 추천할 수 없습니다.")
        except:
            question.voter.add(request.user)
            question.save()

    return redirect("board:detail", question_id=question_id)


@login_required(login_url="common:login")
def vote_answer(request, answer_id):
    """
    답변 추천
    """
    answer = get_object_or_404(Answer, pk=answer_id)

    if answer.author == request.user:
        messages.error(request, "본인글은 추천할 수 없습니다.")
    else:
        try:
            answer.voter.get(id=request.user.id)
            messages.error(request, "이미 추천한 글은 추천할 수 없습니다.")
        except:
            answer.voter.add(request.user)
            answer.save()

    return redirect("board:detail", question_id=answer.question.id)
