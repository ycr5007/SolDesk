from django.shortcuts import get_object_or_404, redirect, render
from django.contrib.auth.decorators import login_required
from django.utils import timezone
from django.contrib import messages

from ..models import Question, Answer, Comment
from ..forms import CommentForm

# Comment
@login_required(login_url="common:login")
def comment_create_question(request, question_id):
    """
    질문 댓글 등록
    """
    question = get_object_or_404(Question, pk=question_id)

    if request.method == "POST":
        form = CommentForm(request.POST)
        if form.is_valid():
            comment = form.save(commit=False)
            comment.author = request.user
            comment.question = question
            comment.save()
            return redirect("board:detail", question_id=question_id)
    else:
        form = CommentForm()
    return render(request, "board/comment_form.html", {"form": form})


@login_required(login_url="common:login")
def comment_modify_question(request, comment_id):
    comment = get_object_or_404(Comment, pk=comment_id)

    if request.user != comment.author:
        messages.error(request, "수정할 권한이 없습니다.")
        return redirect("board:detail", question_id=comment.question.id)

    if request.method == "POST":
        form = CommentForm(request.POST, instance=comment)
        if form.is_valid():
            comment_form = form.save(commit=False)
            comment_form.modify_date = timezone.now()
            comment_form.save()
            return redirect("board:detail", question_id=comment.question.id)
    else:
        form = CommentForm(instance=comment)
    return render(request, "board/comment_form.html", {"form": form})


@login_required(login_url="common:login")
def comment_delete_question(request, comment_id):
    comment = get_object_or_404(Comment, pk=comment_id)

    if request.user != comment.author:
        messages.error(request, "삭제할 권한이 없습니다.")
        return redirect("board:detail", question_id=comment.question.id)

    comment.delete()
    return redirect("board:detail", question_id=comment.question.id)


@login_required(login_url="common:login")
def comment_create_answer(request, answer_id):
    """
    답변 댓글 등록
    """
    answer = get_object_or_404(Answer, pk=answer_id)

    if request.method == "POST":
        form = CommentForm(request.POST)
        if form.is_valid():
            comment = form.save(commit=False)
            comment.author = request.user
            comment.answer = answer
            comment.save()
            return redirect("board:detail", question_id=comment.answer.question.id)
    else:
        form = CommentForm()
    return render(request, "board/comment_form.html", {"form": form})


@login_required(login_url="common:login")
def comment_modify_answer(request, comment_id):
    """
    답변 댓글 수정
    """
    comment = get_object_or_404(Comment, pk=comment_id)

    if request.user != comment.author:
        messages.error(request, "수정할 권한이 없습니다.")
        return redirect("board:detail", question_id=comment.answer.question.id)

    if request.method == "POST":
        form = CommentForm(request.POST, instance=comment)
        if form.is_valid():
            comment_form = form.save(commit=False)
            comment_form.modify_date = timezone.now()
            comment_form.save()
            return redirect("board:detail", question_id=comment.answer.question.id)
    else:
        form = CommentForm(instance=comment)
    return render(request, "board/comment_form.html", {"form": form})


@login_required(login_url="common:login")
def comment_delete_answer(request, comment_id):
    """
    답변 댓글 삭제
    """
    comment = get_object_or_404(Comment, pk=comment_id)

    if request.user != comment.author:
        messages.error(request, "삭제할 권한이 없습니다.")
        return redirect("board:detail", question_id=comment.answer.question.id)

    comment.delete()
    return redirect("board:detail", question_id=comment.answer.question.id)
