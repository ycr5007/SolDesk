from django.http import HttpResponse
from django.shortcuts import get_object_or_404, redirect, render
from django.core.paginator import Paginator
from django.contrib.auth.decorators import login_required
from django.utils import timezone
from django.contrib import messages

from .models import Question, Answer
from .forms import AnswerForm, QuestionForm

# Create your views here.


def index(request):
    """
    게시물 리스트
    """
    # q_list = Question.objects.all()

    page = request.GET.get("page", 1)  # http://127.0.0.1:8000/board/?page=1

    q_list = Question.objects.order_by("-create_date")
    paginator = Paginator(q_list, 10)  # Paginator 객체 생성 : Paginator(전체 리스트, amount)
    page_obj = paginator.get_page(page)
    return render(request, "board/question_list.html", {"question_list": page_obj})


def detail(request, question_id):
    """
    게시물 상세
    """
    # 없는 ID 를 요청했을 때 웹 페이지에 오류 메세지가 그대로 출력
    # q = Question.objects.get(id=question_id)

    q = get_object_or_404(Question, pk=question_id)
    return render(request, "board/question_detail.html", {"question": q})


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
            ques_form.update_date = timezone.now()
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
            return redirect("board:detail", question_id=q.id)
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
    pass
