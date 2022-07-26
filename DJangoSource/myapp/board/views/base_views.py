from django.shortcuts import get_object_or_404, render
from django.core.paginator import Paginator

from ..models import Question


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
